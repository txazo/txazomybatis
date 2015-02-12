package org.txazo.mybatis.dao;

import java.util.Map;

import org.txazo.mybatis.bean.Product;

public interface ProductMapper {

	public void insertProduct(Product product);

	public void updateProduct(Product product);

	public Product selectProduct(Long id);

	public Map<String, Object> selectProductForMap(Long id);

}
