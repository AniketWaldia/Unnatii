package com.unnatii.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
//import javax.persistence.OneToOne;

@Entity
@Table(name="Template")
public class Template {
	
	@Id
	@Column(name="template_id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="templateName")
	private String name;	

//	@Column(name="product_id")
//	private String productId;
	
	@Column(name="template_image")
	private String image;
	
	@Column(name="template_image_path")
	private String imagePath;

	@Column(name="Filedata", columnDefinition="TEXT")
	private CommonsMultipartFile templateFile;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name = "productID")
	private Integer productId;
	
	@OneToOne
	private Product product;
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

//	public String getProductId() {
//		return productId;
//	}
//
//	public void setProductId(String productId) {
//		this.productId = productId;
//	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public CommonsMultipartFile getTemplateFile() {
		return templateFile;
	}

	public void setTemplateFile(CommonsMultipartFile templateFile) {
		this.templateFile = templateFile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
