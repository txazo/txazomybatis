package org.txazo.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.txazo.mybatis.bean.Product;

public interface ProductMapper {

	public void insertProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Long id);

	public Product selectProduct(Long id);

	public Map<String, Object> selectProductForMap(Long id);

	public List<Product> selectProductLike(String name);

}
