package org.txazo.mybatis.sourcecode;

/**
 * MyBatis Mapper‘≠¿Ì∑÷Œˆ
 */
public class MyBatisMapperExecute {

	/**
	 * <pre>
	 * 1) mybatis.xml --> <mappers> --> Mapper.class
	 * 2) Configuration.MapperRegistry.addMapper(Mapper.class)
	 * 3) Mapper.class --> MapperProxyFactory
	 * </pre>
	 */
	public void init() {
	}

	/**
	 * <pre>
	 * 1) SqlSession sqlSession = DefaultSqlSessionFactory.openSession()
	 * 2) Executor executor = Configuration.newExecutor(Transaction transaction, ExecutorType executorType)
	 * 3) executor = BaseExecutor(BatchExecutor ReuseExecutor SimpleExecutor)
	 * 4) executor = CachingExecutor(executor)
	 * 5) executor = (Executor) InterceptorChain.pluginAll(executor)
	 * 6) (Interceptor interceptor : interceptors) { executor = interceptor.plugin(executor); }
	 * 7) executor = Plugin.wrap(executor, interceptor)
	 * 8) executor = Proxy.newProxyInstance(executor.getClassLoader(), executor.getAllInterfaces(), new Plugin(executor, interceptor, signatureMap));
	 * </pre>
	 */
	public void createExecutor() {
	}

	/**
	 * <pre>
	 * 1) DefaultSqlSession.getMapper(Mapper.class)
	 * 2) Configuration.getMapper(Class<T> type, SqlSession sqlSession)
	 * 3) MapperRegistry.getMapper(Class<T> type, SqlSession sqlSession)
	 * 4) MapperProxyFactory.newInstance(SqlSession sqlSession)
	 * 5) myMapperProxy = Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, MapperProxy)
	 * </pre>
	 */
	public void getMapper() {
	}

	/**
	 * <pre>
	 * 1) myMapperProxy.query()
	 * 2) MapperProxy.invoke(Object proxy, Method method, Object[] args)
	 * 3) MapperMethod.execute(SqlSession sqlSession, Object[] args)
	 * 4) DefaultSqlSession.selectList(String statement, Object parameter, RowBounds rowBounds)
	 * 5) Executor.query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler)
	 * 6) Interceptor.intercept() --> Interceptor.intercept()
	 * 7) CachingExecutor.query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler)
	 * 8) BaseExecutor.query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler)
	 * 9) SimpleExecutor.doQuery(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql)
	 * 10) RoutingStatementHandler.query(Statement statement, ResultHandler resultHandler)
	 * 11) PreparedStatementHandler.query(Statement statement, ResultHandler resultHandler)
	 * 12) PreparedStatement.execute()
	 * 13) ResultSetHandler.handleResultSets(Statement stmt)
	 * </pre>
	 */
	public void query() {
	}

}
