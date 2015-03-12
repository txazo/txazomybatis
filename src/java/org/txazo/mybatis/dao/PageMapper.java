package org.txazo.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.txazo.mybatis.bean.Product;
import org.txazo.mybatis.page.Page;

public interface PageMapper {

	@Select("select * from Product")
	public List<Product> getProductByPage(Page<Product> page);

}
