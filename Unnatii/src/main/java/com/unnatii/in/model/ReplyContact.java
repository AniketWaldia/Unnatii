package com.unnatii.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reply_Contact")
public class ReplyContact {
	
	
	@Id
	@Column(name="ID")	
	@GeneratedValue
	private Integer id;
	
	@Column(name="ContactID")
	private Integer contact_id;
	

	

	@Column(name="EMAIL")
	private String email;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="DESCRIPTION")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getContact_id() {
		return contact_id;
	}

	public void setContact_id(Integer contact_id) {
		this.contact_id = contact_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
