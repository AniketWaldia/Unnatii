package com.unnatii.in.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unnatii.in.dao.ContactDAO;
import com.unnatii.in.model.Contact;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	
	@Required
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Required
	public List<Contact> listContact() {

		return contactDAO.listContact();
	}
	
	@Required
	public List<Contact> listSpecificContact(Integer contactId)
	{
		return contactDAO.listSpecificContact(contactId);
	}
	
	
	@Required
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}
}
