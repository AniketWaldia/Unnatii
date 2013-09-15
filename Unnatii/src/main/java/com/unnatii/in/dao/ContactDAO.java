package com.unnatii.in.dao;

import java.util.List;

import com.unnatii.in.model.Contact;

public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
	public List<Contact> listSpecificContact(Integer contactId);
	
}