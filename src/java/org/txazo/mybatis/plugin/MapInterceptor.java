package org.txazo.mybatis.plugin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.txazo.mybatis.bean.MapParam;
import org.txazo.mybatis.util.ReflectUtil;

@Intercepts(value = { @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class MapInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object target = invocation.getTarget();
		if (target instanceof DefaultResultSetHandler) {
			DefaultResultSetHandler resultSetHandler = (DefaultResultSetHandler) target;
			ParameterHandler parameterHandler = (ParameterHandler) ReflectUtil.getFieldValue(resultSetHandler, "parameterHandler");
			if (parameterHandler != null) {
				Object parameterObj = parameterHandler.getParameterObject();
				if (parameterObj instanceof MapParam) {
					MapParam mapParam = (MapParam) parameterObj;
					Statement stmt = (Statement) invocation.getArgs()[0];
					return handleResultSet(stmt.getResultSet(), mapParam);
				}
			}
		}
		return invocation.proceed();
	}

	private Object handleResultSet(ResultSet resultSet, MapParam mapParam) {
		if (resultSet != null) {
			String keyField = (String) mapParam.get(MapParam.KEY_FIELD);
			String valueField = (String) mapParam.get(MapParam.VALUE_FIELD);
			List<Object> resultList = new ArrayList<Object>();
			Map<Object, Object> map = new HashMap<Object, Object>();
			try {
				while (resultSet.next()) {
					Object key = resultSet.getObject(keyField);
					Object value = resultSet.getObject(valueField);
					map.put(key, value);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeResultSet(resultSet);
			}
			resultList.add(map);
			return resultList;
		}
		return null;
	}

	private void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
		}
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
