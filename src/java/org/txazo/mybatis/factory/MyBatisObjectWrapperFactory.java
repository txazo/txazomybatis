package org.txazo.mybatis.factory;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

/**
 * MyBatis ObjectWrapperFactory
 * 
 * <pre>
 * org.apache.ibatis.reflection.MetaObject
 * </pre>
 */
public class MyBatisObjectWrapperFactory implements ObjectWrapperFactory {

	@Override
	public boolean hasWrapperFor(Object object) {
		return false;
	}

	@Override
	public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
		return null;
	}

}
