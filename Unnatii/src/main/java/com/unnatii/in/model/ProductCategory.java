package com.unnatii.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ProductCategory")
public class ProductCategory {

	@Id
	@Column(name="CategoryId")
	private Integer productCategoryId;
	
	@Column(name="CategoryName")
	private String categoryName;
	
	@Column(name="CategoryStatus")
	private String categoryStatus;

	public Integer getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}



	


}
