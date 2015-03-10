package org.txazo.mybatis.factory;

import java.util.List;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * MyBatis ObjectFactory
 */
public class MyBatisObjectFactory extends DefaultObjectFactory {

	private static final long serialVersionUID = 860183815253812346L;

	@Override
	public <T> T create(Class<T> type) {
		return create(type, null, null);
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		// System.out.println("----------MyBatisObjectFactory create " + type.getCanonicalName());
		return super.create(type, constructorArgTypes, constructorArgs);
	}

}
