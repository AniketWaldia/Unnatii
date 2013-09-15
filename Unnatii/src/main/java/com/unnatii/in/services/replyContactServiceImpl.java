package com.unnatii.in.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unnatii.in.dao.ReplyContactDAO;
import com.unnatii.in.model.ReplyContact;

@Service
@Transactional
public class replyContactServiceImpl implements replyContactService {

	@Autowired
	private ReplyContactDAO replycontactDAO;
	
	@Required
	public void addContact(ReplyContact reply) {
		replycontactDAO.addContact(reply);
	}

	
}
