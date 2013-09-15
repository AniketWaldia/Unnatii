package com.unnatii.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="QuoteRequest")
public class SpecSheet {
	
	/*public SpecSheet()
	{
		
	}
	
	public SpecSheet(Integer id,String firstname,String lastname,String company,String phone,String email,String address,String pincode,String city,String state,String via,String product,String quantity,String expectedby,String budget,String reqDesc)
	{
		this.address=address;
		this.budget=budget;
		this.city=city;
		this.company=company;
		this.email=email;
		this.expectedby=expectedby;
		this.firstname=firstname;
		this.id=id;
		this.lastname=lastname;
		this.phone=phone;
		this.pincode=pincode;
		this.product=product;
		this.quantity=quantity;
		this.reqDesc=reqDesc;
		this.state=state;
		this.via=via;
	}*/
	
	

	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
//kore ebo.d	sala eta kadd i baal field kichu onno r data variable r kichu??
	
	@OneToOne
	private ReplyQuote replyQuote;
	
	
	
	
	@Column(name="FirstName")
	private String firstname;

	@Column(name="LastName")
	private String lastname;
	

	@Column(name="Company")
	private String company;
	
	
	@Column(name="Phone")
	private String phone;
	
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="Address")	
	private String address;
		
	
	@Column(name="Pincode")	
	private String pincode;
	
	@Column(name="City")	
	private String city;
	
	@Column(name="State")	
	private String state;
	
	@Column(name="Via")
	private String via;
	
	@Column(name="Product")
	private String product;
	
	@Column(name="Quantity")
	private String quantity;
	
	@Column(name="ExpectedBy")
	private String expectedby;
	
	@Column(name="Budget")
	private String budget;
	
	@Column(name="ReqDesc")
	private String reqDesc;
	
	
	public ReplyQuote getReplyQuote() {
		return replyQuote;
	}

	public void setReplyQuote(ReplyQuote replyQuote) {
		this.replyQuote = replyQuote;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCompany() {
		return company;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getExpectedby() {
		return expectedby;
	}

	public void setExpectedby(String expectedby) {
		this.expectedby = expectedby;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getReqDesc() {
		return reqDesc;
	}

	public void setReqDesc(String reqDesc) {
		this.reqDesc = reqDesc;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	
	
}
