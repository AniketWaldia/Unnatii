package com.unnatii.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.persistence.OneToOne;

@Entity
@Table(name="Products")
public class Product {
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="PRODUCTCODE")
	private String productCode;
	
	@Column(name="PRODUCTTAG")
	private String productTag;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="IMAGEPATH")
	private String imagePath;
	
	@Column(name = "Category")
	private Integer Category;
	
	@OneToOne
	private ProductCategory productCategory;
	
	@Column(name="Filedata", columnDefinition="TEXT")
	private CommonsMultipartFile fileData;

	@Column(name="STATUS")
	private String status;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getCategory() {
		return Category;
	}

	public void setCategory(Integer category) {
		Category = category;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductTag() {
		return productTag;
	}

	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
	    this.fileData = fileData;
       // this.name = fileData.getOriginalFilename();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
