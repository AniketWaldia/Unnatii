package com.unnatii.in.dao;

import java.util.List;
import java.util.Map;

import com.unnatii.in.model.Template;

public interface TemplateDAO {
	
	public void addTemplates(Template template);
	public List<Template> listTemplate();
	public void updateTemplates(Template template);
	public void removeTemplate(Integer id);
	public List<Template> listSpecificTemplate(Integer contactId);
	public List<String> listTemplateNames(int product_ID,int startIndex) ;
	public List<Template> listTemplateForProduct(int product_ID);
}