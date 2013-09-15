package com.unnatii.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT_US")
public class Contact {
	public Contact()
	{
		
	}
	public Contact(Integer id,String name,String email,String telephone,String description)
	{
	this.id=id;
	this.description=name;
	this.email=email;
	this.name=name;
	this.telephone=telephone;
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="Name")
	private String name;

	

	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEPHONE")
	private String telephone;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToOne
	private ReplyContact replyContact;

	public ReplyContact getReplyContact() {
		return replyContact;
	}
	public void setReplyContact(ReplyContact replyContact) {
		this.replyContact = replyContact;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
