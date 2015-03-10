package org.txazo.mybatis.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.txazo.mybatis.bean.MapParam;

public interface MapMapper {

	@Select("SELECT name, price FROM Product")
	public Map<String, Object> getMap(MapParam mapParam);

}
