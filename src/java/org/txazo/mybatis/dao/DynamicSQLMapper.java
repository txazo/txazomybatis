package org.txazo.mybatis.dao;

import java.util.List;

import org.txazo.mybatis.bean.Product;

public interface DynamicSQLMapper {

	public int getProductCountByIf(long id);

	public int getProductCountByChoose(long id);

	public int getProductCountByTrim(long id);

	public void updateProduct(Product product);

	public List<Product> getProduct(List<Long> ids);

}
