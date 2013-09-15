package com.unnatii.in.dao;

//import java.util.List;

import com.unnatii.in.model.ReplyContact;

//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyContactDAOImpl implements ReplyContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(ReplyContact reply) {
		sessionFactory.getCurrentSession().save(reply);
	//	sessionFactory.getCurrentSession().getTransaction().commit();
	}

	/* public List<Contact> listContact() {
		
		Query qry;
		qry=sessionFactory.getCurrentSession().createQuery("from Contact ORDER BY ID DESC");
		//qry.setFirstResult(startPoint);
		//qry.setMaxResults();
		return qry.list();
		//return sessionFactory.getCurrentSession().createQuery("from Contact")
			//	.list();
		
				//return sessionFactory.getCurrentSession().createQuery("").list();
	}

public List<Contact> listSpecificContact(Integer contactId) {
		
		Query qry;
		qry=sessionFactory.getCurrentSession().createQuery("from Contact where ID =" + contactId );
		//qry.setFirstResult(startPoint);
		//qry.setMaxResults();
		return qry.list();
		//return sessionFactory.getCurrentSession().createQuery("from Contact")
			//	.list();
		
				//return sessionFactory.getCurrentSession().createQuery("").list();
	}
	
	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}

*/
}