package org.txazo.mybatis.plugin;

import java.util.Properties;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * MyBatis Interceptor
 * 
 * <pre>
 * 1. org.apache.ibatis.executor.Executor
 * 2. org.apache.ibatis.executor.parameter.ParameterHandler
 * 3. org.apache.ibatis.executor.resultset.ResultSetHandler
 * 4. org.apache.ibatis.executor.statement.StatementHandler
 * </pre>
 */
@Intercepts(value = { @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class }) })
public class ExecutorInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		if (args != null && args.length >= 2 && args[0] instanceof MappedStatement) {
			MappedStatement statement = (MappedStatement) args[0];
			BoundSql boundSql = statement.getBoundSql(args[1]);
			String sql = boundSql.getSql().replaceAll("\\s+", " ");
			System.out.println("[sql] " + sql);
		}

		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
