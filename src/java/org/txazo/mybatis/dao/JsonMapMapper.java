package org.txazo.mybatis.dao;

import org.txazo.mybatis.bean.JsonMap;

public interface JsonMapMapper {

	public void insertMap(JsonMap jsonMap);

	public JsonMap selectMap(long id);

}
