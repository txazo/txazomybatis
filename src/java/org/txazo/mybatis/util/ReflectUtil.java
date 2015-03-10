package org.txazo.mybatis.util;

import java.lang.reflect.Field;

public class ReflectUtil {

	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Object obj, String fieldName) throws Exception {
		Object result = null;
		if (obj != null) {
			Class<?> clazz = obj.getClass();
			Field field = clazz.getDeclaredField(fieldName);
			if (field != null) {
				field.setAccessible(true);
				result = field.get(obj);
			}
		}
		return (T) result;
	}

}
