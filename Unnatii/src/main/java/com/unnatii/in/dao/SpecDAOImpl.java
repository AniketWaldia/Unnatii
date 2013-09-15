package com.unnatii.in.dao;

import java.util.List;

import com.unnatii.in.model.Contact;
import com.unnatii.in.model.ReplyQuote;
import com.unnatii.in.model.SpecSheet;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpecDAOImpl implements SpecDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addSpec(SpecSheet specsheet) {
		
		sessionFactory.getCurrentSession().save(specsheet);
	}

	@SuppressWarnings("unchecked")
	public List<SpecSheet> listSpecSheet() {
		return sessionFactory.getCurrentSession().createQuery("from SpecSheet ORDER BY ID DESC").list();
	}

	
     @SuppressWarnings("unchecked")
	public List<SpecSheet> listSpecificSpecSheet(Integer specId) {
		
		Query qry;
		qry=sessionFactory.getCurrentSession().createQuery("from SpecSheet where ID =" + specId );		
		return qry.list();
		}

	public void removeSpec(Integer id) {
		SpecSheet specsheet = (SpecSheet) sessionFactory.getCurrentSession().load(
				SpecSheet.class, id);
		if (null != specsheet) {
			sessionFactory.getCurrentSession().delete(specsheet);
		}

	}
	
public void addReplyQuote(ReplyQuote replyquote) {
		
		sessionFactory.getCurrentSession().save(replyquote);
	}
}
