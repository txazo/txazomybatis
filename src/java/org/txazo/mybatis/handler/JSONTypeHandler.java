package org.txazo.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import com.alibaba.fastjson.JSON;

@MappedTypes(Map.class)
@MappedJdbcTypes(value = { JdbcType.VARCHAR })
public class JSONTypeHandler implements TypeHandler<Map<String, Object>> {

	@Override
	public void setParameter(PreparedStatement ps, int i, Map<String, Object> parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, JSON.toJSONString(parameter));
	}

	@Override
	public Map<String, Object> getResult(ResultSet rs, String columnName) throws SQLException {
		return null;
	}

	@Override
	public Map<String, Object> getResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public Map<String, Object> getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}

}
