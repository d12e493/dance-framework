package idv.danceframework.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

public class DancePropertyUtils extends org.apache.commons.beanutils.PropertyUtils {

	public static boolean hasProperty(Object obj, String propertyName) {
		boolean flag = false;

		try {
			Object property = getProperty(obj, propertyName);
			if (property != null) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public static void setProperty(Object obj, String propertyName, Object value) {
		try {
			BeanUtilsBean.getInstance().setProperty(obj, propertyName, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void copyProperties(Object source, Object target, String... peopertyNames) {
		for (String propertyName : peopertyNames) {
			try {
				BeanUtilsBean.getInstance().copyProperty(target, propertyName, getProperty(source, propertyName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
