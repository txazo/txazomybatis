package org.txazo.mybatis.sourcecode;

import org.apache.ibatis.plugin.InterceptorChain;

/**
 * MyBatis Interceptor
 * 
 * <pre>
 * 1) Executor - Configuration.newExecutor()
 * 2) ParameterHandler - Configuration.newParameterHandler
 * 3) ResultSetHandler - Configuration.newResultSetHandler
 * 4) StatementHandler - Configuration.newStatementHandler
 * </pre>
 */
public class MyBatisInterceptor {

	public void interceptorProxy() {
		InterceptorChain interceptorChain = new InterceptorChain();
		Object target = new Object();
		target = interceptorChain.pluginAll(target);
	}

}
