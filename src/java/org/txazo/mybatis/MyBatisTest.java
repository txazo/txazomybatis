package org.txazo.mybatis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.txazo.mybatis.bean.MapParam;
import org.txazo.mybatis.bean.Product;
import org.txazo.mybatis.dao.JsonMapMapper;
import org.txazo.mybatis.dao.MapMapper;
import org.txazo.mybatis.dao.ProductAnnoMapper;
import org.txazo.mybatis.dao.ProductMapper;

@RunWith(JUnit4.class)
public class MyBatisTest {

	private SqlSession session;
	private ProductMapper productMapper;
	private ProductAnnoMapper productAnnoMapper;
	private MapMapper mapMapper;
	private JsonMapMapper jsonMapMapper;

	@Before
	public void before() throws IOException {
		String resource = "mybatis.xml";
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		session = factory.openSession();
		productMapper = session.getMapper(ProductMapper.class);
		productAnnoMapper = session.getMapper(ProductAnnoMapper.class);
		mapMapper = session.getMapper(MapMapper.class);
		jsonMapMapper = session.getMapper(JsonMapMapper.class);
	}

	@After
	public void close() {
		session.commit();
		session.close();
	}

	@Test
	public void test1() {
		Product product = new Product("zhenai", 32.5);
		productMapper.insertProduct(product);
	}

	@Test
	public void test2() {
		Product product = productMapper.selectProduct(1L);
		Assert.assertEquals("Apple", product.getName());
	}

	@Test
	public void test3() {
		Product product = session.selectOne("org.txazo.mybatis.dao.ProductMapper.selectProduct", 1L);
		Assert.assertEquals("Apple", product.getName());
	}

	@Test
	public void test4() {
		Product product = productAnnoMapper.selectProduct(1L);
		Assert.assertEquals("Apple", product.getName());
	}

	@Test
	public void test5() {
		Map<String, Object> product = productMapper.selectProductForMap(1L);
		Assert.assertEquals("Apple", (String) product.get("name"));
	}

	@Test
	public void test6() {
		MapParam mapParam = new MapParam("name", "price");
		Map<String, Object> map = mapMapper.getMap(mapParam);
		System.out.println(map);
	}

	@Test
	public void test7() {
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> map1 = new HashMap<String, Object>();
		//map1.put("name", "txazo");
		map.put("name", "txazo");
		jsonMapMapper.insertMap(map);
	}

}
