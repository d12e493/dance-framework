package idv.danceframework.sql;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpecificationFactory<T> {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	private Class<T> classType;

	private Map<String, Object> sqlRepacementMap = new HashMap<String, Object>();

	private int parameterCount = 1;

	protected final String completeDateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
	protected final SimpleDateFormat completeSdf = new SimpleDateFormat(completeDateFormat);

	public SpecificationFactory(Class<T> classType) {
		this.classType = classType;
	}

	public String getColumnName(String propertyName) {

		try {
			Field field = classType.getDeclaredField(propertyName);

			if (field.getName().equals(propertyName) && field.isAnnotationPresent(ColumnName.class)) {
				ColumnName columnName = field.getAnnotation(ColumnName.class);
				if (columnName == null) {
					throw new NullPointerException("propertyName : " + propertyName + " 沒有設定@ColumnName !!!");
				}
				return columnName.name();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private String setParameterMap(String name, Object value) {

		String key = name + "_" + parameterCount;

		sqlRepacementMap.put(key, value);

		LOG.debug("setParameterMap key：" + key + " , value：" + value);

		parameterCount++;

		return ":" + key;
	}

	/**
	 * 會把英母也模糊比對，皆轉成大寫
	 * 
	 * @author Davis
	 *
	 * @param propertyName
	 *            需要判斷like的欄位名稱
	 * @param propertyValue
	 *            要判斷的值
	 * @return
	 */
	public Condition stringLike(final String propertyName, final String propertyValue) {

		if (StringUtils.isNotBlank(propertyValue)) {

			return new Condition(" UPPER(" + getColumnName(propertyName) + ")" + " like "
					+ setParameterMap("stringLike", "%" + propertyValue.trim().toUpperCase() + "%") + " ");
		}

		return null;
	}

	/**
	 * @author Davis
	 * 
	 * @param propertyName
	 *            需要判斷like的欄位名稱
	 * @param propertyValue
	 *            要判斷的值
	 * @return
	 */
	public Condition numberLike(final String propertyName, final Number propertyValue) {
		if (propertyValue != null) {
			return new Condition(
					" instr(" + getColumnName(propertyName) + " , " + " " + propertyValue.toString() + ")>0 ");
		}

		return null;
	}

	/**
	 * @author Davis
	 *
	 * @param propertyName
	 *            需要判斷equals的欄位名稱
	 * @param propertyValue
	 *            要判斷的值
	 * @return
	 */
	public Condition equals(final String propertyName, final Object propertyValue) {
		if (propertyValue != null) {
			// 判斷是否為數字
			if (propertyValue instanceof Number) {
				return new Condition(" " + getColumnName(propertyName) + " = " + propertyValue.toString() + " ");
			} else if (propertyValue instanceof String && !StringUtils.isNotBlank(propertyValue.toString())) {
				return null;
			} else if (propertyValue instanceof String) {
				return new Condition(" " + getColumnName(propertyName) + " = "
						+ setParameterMap("equals", ((String) propertyValue).trim().toString()) + " ");
			} else if (propertyValue instanceof Boolean) {
				if (((Boolean) propertyValue).equals(Boolean.FALSE)) {
					return new Condition(" " + getColumnName(propertyName) + " = 0 ");
				} else {
					return new Condition(" " + getColumnName(propertyName) + " = 1 ");
				}
			} else {
				return new Condition(" " + getColumnName(propertyName) + " = "
						+ setParameterMap("equals", propertyValue.toString()) + " ");
			}
		}
		return null;
	}
	
	/**
	 * 根據一個欄位使用OR查詢多個值
	 * 
	 * @author Davis
	 *
	 * @param propertyName
	 * @param list
	 *            需要OR查詢的資料list
	 * @return
	 */
	public Condition equalsOr(final String propertyName, final List<Object> list) {

		if (list != null && list.size() > 0) {

			List<Condition> conditionList = new ArrayList<Condition>();

			for (Object obj : list) {
				conditionList.add(equals(propertyName, obj));
			}

			return or(conditionList);
		}

		return null;
	}

	/**
	 * 使用OR連接多個condition條件
	 * 
	 * @author Davis
	 *
	 * @param conditionList
	 * @return
	 */
	public Condition or(List<Condition> conditionList) {
		return appendConditions(Operator.OR, conditionList);
	}

	/**
	 * 使用AND連接多個condition條件
	 * 
	 * @author Davis
	 *
	 * @param conditionList
	 * @return
	 */
	public Condition and(List<Condition> conditionList) {
		return appendConditions(Operator.AND, conditionList);
	}

	/**
	 * @author Davis
	 *
	 * @param operator
	 *            條件組成 Or、And
	 * @param list
	 *            要組成的條件
	 * @return
	 */
	// 連接多個condition
	private Condition appendConditions(Operator operator, List<Condition> list) {
		if (list != null && list.size() > 0) {

			String sql = "";

			for (Iterator<Condition> iterator = (Iterator<Condition>) list.iterator(); iterator.hasNext();) {
				Condition c = iterator.next();
				sql += c.getSql();
				if (iterator.hasNext()) {
					sql += " " + operator.toString().toUpperCase() + " ";
				}
			}
			return new Condition(" ( " + sql + " ) ");
		}
		return null;
	}

	public Condition in(final String propertyName, final List<? extends Object> values) {

		if (StringUtils.isNotEmpty(propertyName) && values != null && values.size() > 0) {
			StringBuffer sb = new StringBuffer(" " + propertyName + " IN (");

			if (values.get(0) instanceof String) {
				/*
				 * 加上判斷StringUtils.isNotEmpty(values.get(0))的原因是
				 * jquery-tag-it的tag功能裡面，即使你沒有輸入任何值，他還是會帶一個empty
				 * string進來，故必須排除之。
				 */
				if (values.size() == 1 && StringUtils.isEmpty((String) values.get(0))) {
					return null;
				}

				Iterator<? extends Object> it = values.iterator();
				while (it.hasNext()) {
					String value = (String) it.next();
					sb.append("'").append(value).append("'");
					if (it.hasNext()) {
						sb.append(",");
					}
				}
				sb.append(") ");
				return new Condition(sb.toString());
			}

			if (values.get(0) instanceof Integer || values.get(0) instanceof BigDecimal
					|| values.get(0) instanceof Boolean || values.get(0) instanceof Long) {
				Iterator<? extends Object> it = values.iterator();
				while (it.hasNext()) {
					Object value = it.next();
					sb.append(value);
					if (it.hasNext()) {
						sb.append(",");
					}
				}
				sb.append(") ");
				return new Condition(sb.toString());
			}

		}
		return null;
	}
	
	public Condition notIn(final String propertyName, final List<? extends Object> values) {

		if (StringUtils.isNotEmpty(propertyName) && values != null && values.size() > 0) {
			StringBuffer sb = new StringBuffer(" " + getColumnName(propertyName) + " NOT IN (");

			if (values.get(0) instanceof String) {
				/*
				 * 加上判斷StringUtils.isNotEmpty(values.get(0))的原因是
				 * jquery-tag-it的tag功能裡面，即使你沒有輸入任何值，他還是會帶一個empty
				 * string進來，故必須排除之。
				 */
				if (values.size() == 1 && StringUtils.isEmpty((String) values.get(0))) {
					return null;
				}

				Iterator<? extends Object> it = values.iterator();
				while (it.hasNext()) {
					String value = (String) it.next();
					sb.append("'").append(value).append("'");
					if (it.hasNext()) {
						sb.append(",");
					}
				}
				sb.append(") ");
				return new Condition(sb.toString());
			}

			if (values.get(0) instanceof Integer || values.get(0) instanceof BigDecimal
					|| values.get(0) instanceof Boolean || values.get(0) instanceof Long) {
				Iterator<? extends Object> it = values.iterator();
				while (it.hasNext()) {
					Object value = it.next();
					sb.append(value);
					if (it.hasNext()) {
						sb.append(",");
					}
				}
				sb.append(") ");
				return new Condition(sb.toString());
			}

		}
		return null;
	}

	/**
	 * 大於
	 * 
	 * @author Davis
	 *
	 * @param propertyName
	 * @param obj
	 * @return
	 */
	public Condition greater(String propertyName, Object obj) {
		if (obj != null) {
			return new Condition(" ( " + getColumnName(propertyName) + " >" + obj.toString() + " ) ");
		} else {
			return null;
		}
	}

	/**
	 * 小於等於
	 * 
	 * @author Davis
	 *
	 * @param propertyName
	 * @param obj
	 * @return
	 */
	public Condition lessEquals(String propertyName, Object obj) {
		if (obj != null) {
			return new Condition(" ( " + getColumnName(propertyName) + " <=" + obj.toString() + " ) ");
		} else {
			return null;
		}
	}

	public Map<String, Object> getSqlRepacementMap() {
		return sqlRepacementMap;
	}

	public void setSqlRepacementMap(Map<String, Object> sqlRepacementMap) {
		this.sqlRepacementMap = sqlRepacementMap;
	}
}
