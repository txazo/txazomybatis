package org.txazo.mybatis.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.txazo.mybatis.bean.Product;

public interface ProductAnnoMapper {

	@Insert("INSERT INTO Product(name, price, createTime) VALUES (#{name}, #{price}, now())")
	public void insertProduct(Product product);

	@Update("UPDATE Product SET price = #{price} WHERE id = #{id}")
	public void updateProduct(Product product);

	@Select("SELECT * FROM Product WHERE id = #{id}")
	public Product selectProduct(Long id);

}
