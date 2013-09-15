package com.unnatii.in.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unnatii.in.model.Template;

@Repository
public class TemplateDAOImpl implements TemplateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addTemplates(Template template) {
		sessionFactory.getCurrentSession().save(template);
		//sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
     public List<Template> listTemplate() {		
		Query qry;
		qry=sessionFactory.getCurrentSession().createQuery("from Template ORDER BY template_id DESC");
				return qry.list();
		
	}

     public void updateTemplates(Template template) {  
         sessionFactory.getCurrentSession().update(template);        
     }  
	

public List<Template> listSpecificTemplate(Integer templateId) {
		
		Query qry;
		qry=sessionFactory.getCurrentSession().createQuery("from Template where template_id =" + templateId );
		
		return qry.list();
		
	}

public List<String> listTemplateNames(int product_ID,int startIndex) {
	
	Query qry;
	qry=sessionFactory.getCurrentSession().createQuery("select image from Template where product_ID =" + product_ID);
	qry.setFirstResult(startIndex);
	qry.setMaxResults(3);
	
	return qry.list();
	
}

public List<Template> listTemplateForProduct(int product_ID) {
	
	Query qry;
	qry=sessionFactory.getCurrentSession().createQuery(" from Template where product_ID =" + product_ID);
	//qry.setFirstResult(startIndex);
	//qry.setMaxResults(3);
	
	return qry.list();
	
}
	
	public void removeTemplate(Integer id) {
		Template contact = (Template) sessionFactory.getCurrentSession().load(
				Template.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}
}
