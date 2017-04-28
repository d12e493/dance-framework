package idv.danceframework.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import idv.danceframework.exception.PropertyNullException;

public class ValidationUtils {

	/**
	 * 確認是否都有填值
	 * 
	 * @param object
	 * @param properties
	 * @return
	 * @throws PropertyNullException
	 */
	public static void checkRequireProperty(Object object, String... properties) throws PropertyNullException {

		if (object != null) {
			if (properties != null && properties.length > 0) {
				for (String p : properties) {
					Object property = null;
					try {
						property = PropertyUtils.getProperty(object, p);
					} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
						e.printStackTrace();
					}
					if (property != null && !"".equals(property.toString())) {
						continue;
					} else {
						throw new PropertyNullException(p);
					}
				}
			}
		}
	}
}
