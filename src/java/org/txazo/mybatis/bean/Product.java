package org.txazo.mybatis.bean;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {

	private static final long serialVersionUID = 5547226943976600649L;

	private Long id;
	private String name;
	private double price;
	private Date createTime;

	public Product() {
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", createTime=" + createTime + "]";
	}

}
