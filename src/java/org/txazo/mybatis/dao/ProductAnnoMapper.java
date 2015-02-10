package org.txazo.mybatis.dao;

import org.apache.ibatis.annotations.Select;
import org.txazo.mybatis.bean.Product;

public interface ProductAnnoMapper {

	public void insertProduct(Product product);

	public void updateProduct(Product product);

	@Select("SELECT * FROM Product WHERE id = #{id}")
	public Product selectProduct(Long id);

}
