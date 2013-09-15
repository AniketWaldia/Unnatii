package com.unnatii.in.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unnatii.in.dao.TemplateDAO;
import com.unnatii.in.model.Template;

@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TemplateDAO templatesDAO;
	
	@Required
	public void addTemplate(Template template) {
		templatesDAO.addTemplates(template);
	}
	
	@Required
	public List<Template> listTemplate() {

		return templatesDAO.listTemplate();
	}

	@Required
	public void updateTemplates(Template template) {  
        templatesDAO.updateTemplates(template);        
    }  
	
	@Required
	public List<Template> listSpecificTemplate(Integer templateId)
	{
		return templatesDAO.listSpecificTemplate(templateId);
	}
	
	
	@Required
	public void removeTemplate(Integer id) {
		templatesDAO.removeTemplate(id);
	}
	@Required
	public List<String> listTemplateNames(int product_ID,int startIndex)
	{
		return templatesDAO.listTemplateNames(product_ID,startIndex);
	}
	@Required
	public List<Template> listTemplateForProduct(int product_ID)
	{
		return templatesDAO.listTemplateForProduct(product_ID);
	}
	
}
