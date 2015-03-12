package org.txazo.mybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.txazo.mybatis.bean.JsonMap;
import org.txazo.mybatis.bean.MapParam;
import org.txazo.mybatis.bean.Product;
import org.txazo.mybatis.dao.DynamicSQLMapper;
import org.txazo.mybatis.dao.JsonMapMapper;
import org.txazo.mybatis.dao.MapMapper;
import org.txazo.mybatis.dao.PageMapper;
import org.txazo.mybatis.dao.ProductAnnoMapper;
import org.txazo.mybatis.dao.ProductMapper;
import org.txazo.mybatis.page.Page;

@RunWith(JUnit4.class)
public class MyBatisTest {

	private SqlSession session;
	private ProductMapper productMapper;
	private ProductAnnoMapper productAnnoMapper;
	private MapMapper mapMapper;
	private JsonMapMapper jsonMapMapper;
	private DynamicSQLMapper dynamicSQLMapper;
	private PageMapper pageMapper;

	@Before
	public void before() throws IOException {
		String resource = "mybatis.xml";
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		session = factory.openSession();
		productMapper = session.getMapper(ProductMapper.class);
		productAnnoMapper = session.getMapper(ProductAnnoMapper.class);
		mapMapper = session.getMapper(MapMapper.class);
		jsonMapMapper = session.getMapper(JsonMapMapper.class);
		dynamicSQLMapper = session.getMapper(DynamicSQLMapper.class);
		pageMapper = session.getMapper(PageMapper.class);
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
		map.put("name", "txazo");
		map.put("price", 10.5);
		map.put("createTime", new Date());
		jsonMapMapper.insertMap(new JsonMap(map));
	}

	@Test
	public void test8() {
		JsonMap jsonMap = jsonMapMapper.selectMap(15);
		System.out.println(jsonMap.getJson());
	}

	@Test
	public void test9() {
		System.out.println(dynamicSQLMapper.getProductCountByIf(-1));
		System.out.println(dynamicSQLMapper.getProductCountByIf(0));
		System.out.println(dynamicSQLMapper.getProductCountByIf(1));

		System.out.println(dynamicSQLMapper.getProductCountByChoose(-1));
		System.out.println(dynamicSQLMapper.getProductCountByChoose(0));
		System.out.println(dynamicSQLMapper.getProductCountByChoose(1));

		System.out.println(dynamicSQLMapper.getProductCountByTrim(-1));
		System.out.println(dynamicSQLMapper.getProductCountByTrim(0));
		System.out.println(dynamicSQLMapper.getProductCountByTrim(1));
	}

	@Test
	public void test10() {
		Product product = new Product();
		product.setId(1L);
		product.setPrice(12.5);
		dynamicSQLMapper.updateProduct(product);
	}

	@Test
	public void test11() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		ids.add(2L);
		ids.add(3L);
		List<Product> list = dynamicSQLMapper.getProduct(ids);
		System.out.println(list);
	}

	@Test
	public void test12() {
		List<Product> list = productMapper.selectProductLike("tx");
		System.out.println(list);
	}

	@Test
	public void test13() {
		productMapper.deleteProduct(7L);
	}

	@Test
	public void test14() {
		Product product = new Product("dp", 99);
		productAnnoMapper.insertProduct(product);
	}

	@Test
	public void test15() {
		Product product = productAnnoMapper.selectProduct(1L);
		product.setPrice(99.9);
		productAnnoMapper.updateProduct(product);
	}

	@Test
	public void test16() {
		Page<Product> page = new Page<Product>();
		page.setPage(1);
		page.setPageSize(3);
		List<Product> list = pageMapper.getProductByPage(page);
		System.out.println(list);
	}

}
