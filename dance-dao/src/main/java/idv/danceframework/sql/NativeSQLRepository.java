package idv.danceframework.sql;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import idv.danceframework.lo.PageResult;
import idv.danceframework.qo.Order;
import idv.danceframework.vo.UserVO;

@Component
public class NativeSQLRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public PageResult query(PageQueryWrapper<?> wrapper) {

		// 計算總筆數
		long total = countNativeQuery(wrapper);

		if (total > 0) {
			// 加上order
			appendOrderBy(wrapper);

			Query query = getQuery(wrapper);

			// query.setMaxResults(request.getPageSize());
			// query.setFirstResult((request.getPageNumber()) *
			// request.getPageSize());

			query.setMaxResults(10);
			query.setFirstResult(0);

			List list = query.getResultList();

			if (list != null && list.size() > 0) {
				return new PageResult(list, wrapper.getRequest(), total);
			}
		}

		return new PageResult();

	}

	private Query getQuery(PageQueryWrapper<?> wrapper) {

		Query query = entityManager.createNativeQuery(wrapper.getCompleteSQL().toString(), wrapper.getQueryClass());

		return setParameterInQuery(query, wrapper);
	}

	private long countNativeQuery(PageQueryWrapper<?> wrapper) {
		String sql = " SELECT COUNT(1) FROM ( " + wrapper.getCompleteSQL() + " ) DAVIS ";

		Query query = setParameterInQuery(entityManager.createNativeQuery(sql), wrapper);

		Number total = (Number) query.getResultList().get(0);

		return total.longValue();
	}

	private Query setParameterInQuery(Query query, PageQueryWrapper<?> wrapper) {
		Map<String, Object> parameterMap = wrapper.getFactory().getSqlRepacementMap();

		if (!parameterMap.isEmpty()) {
			parameterMap.forEach((k, v) -> query.setParameter(k, v));
		}

		return query;
	}

	private void appendOrderBy(PageQueryWrapper<?> wrapper) {
		StringBuffer orderBy = new StringBuffer();

		try {

			if (wrapper.getRequest() != null && wrapper.getRequest().getSortList() != null) {
				List<Order> orderList = wrapper.getRequest().getSortList();

				if (orderList.size() > 0) {
					for (Iterator<Order> order = orderList.iterator(); order.hasNext();) {
						Order o = order.next();
						String columnName = wrapper.getFactory().getColumnName(o.getColumn());
						orderBy.append(columnName + " " + o.getDir());
						if (order.hasNext()) {
							orderBy.append(", ");
						} else {
							orderBy.append(" ");
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		StringBuffer complete = wrapper.getCompleteSQL();

		if (orderBy != null && orderBy.length() > 0) {
			complete.append(" ORDER BY " + orderBy);
		}

		wrapper.setCompleteSQL(complete);
	}
}
