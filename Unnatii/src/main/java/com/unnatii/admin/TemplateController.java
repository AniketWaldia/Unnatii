package com.unnatii.admin;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.unnatii.in.HomeController;
import com.unnatii.in.model.Template;
import com.unnatii.in.services.ProductsService;
import com.unnatii.in.services.TemplateService;

@Controller
public class TemplateController  implements HandlerExceptionResolver{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private ProductsService productService;

	@RequestMapping(value = "/admin/template")
	public String templates(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map) {
		logger.info("In template form page -- to add template");
		map.put("template", new Template());
		map.put("productList", productService.listProduct());
		//return new ModelAndView("/admin/templates", "template", new Template());
		return "/admin/templates";
	}

	@RequestMapping(value = "/admin/addTemplates", method = RequestMethod.POST)
	public ModelAndView addTemplates( @ModelAttribute(value = "Template") Template template, BindingResult result, HttpSession session, Model model,HttpServletRequest req) {
		 System.out.println("inside add templates    " + template.getName());
		 String uploadedFile= template.getTemplateFile().getOriginalFilename();
		  Date date = new Date();
         System.out.println(date.getTime());
		 String temp [] = uploadedFile.split("\\.");
		
		 String uploadedFileName = temp[0]+ "_"+date.getTime()+"."+temp[1] ;
		 
         System.out.println("file name :"+uploadedFileName);
         System.out.println("productID:"+ template.getProductId());
        
         FileOutputStream outputStream = null;
		

			try {
										System.out.println("test 1");
						                InputStream ip = template.getTemplateFile().getInputStream();
						                OutputStream op = new FileOutputStream("/home/uploadDir/templateImages/"+uploadedFileName);                                          
						                int readBytes = 0;
						                byte[] buffer = new byte[8192];
						                while ((readBytes = ip.read(buffer, 0, 8192)) != -1) {
						                	System.out.println("======Uploading Temaplate file in backup directory======");
						                	op.write(buffer, 0, readBytes);
						                }
						                op.close();
						                ip.close();
						               
						               InputStream ip1 =template.getTemplateFile().getInputStream();
						                String newpath = "/opt/bitnami/apache-tomcat/webapps/ROOT/resources/uploadProduct/templateImage/";
						                System.out.println(newpath);
						                OutputStream op1 = new FileOutputStream(newpath+uploadedFileName);                                      
						                int readBytes1 = 0;
						                byte[] buffer1 = new byte[8192];
						                while ((readBytes1 = ip1.read(buffer1, 0, 8192)) != -1) {
						                	System.out.println("=====Uploading Template file in tomcat directory=====");
						                	op1.write(buffer1, 0, readBytes1);
						                }
						                op1.close();
						                ip1.close();
						                System.out.println("test 2");
						                System.out.println("File name :"+ uploadedFileName);
						                
						        		template.setImage(uploadedFileName);
						        		template.setImagePath(newpath);
						        		template.setTemplateFile(null);
						        		//template.setProd);

						        		 if(template.getId()!=null)
							                {
						        			 	templateService.updateTemplates(template);
							                }
							                else
							                {
							                	templateService.addTemplate(template);               
							                }
						        		
						        		return new ModelAndView("redirect:/admin/listTemplates");
					} 
			catch (Exception e) 
					{
										System.out.println("Error while saving file");
						                e.printStackTrace();
						                return new ModelAndView("redirect:/error/404");
					}
		
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		logger.info("In handeler part ");

		Map<Object, Object> model = new HashMap<Object, Object>();
		if (ex instanceof MaxUploadSizeExceededException) {
			model.put("errors", "File size should be less then "
					+ ((MaxUploadSizeExceededException) ex).getMaxUploadSize()
					+ " byte.");
		} else {
			model.put("errors", "Unexpected error: " + ex.getMessage());
		}
		model.put("template", new Template());
		return null;
	}

	@RequestMapping(value = "/admin/listTemplates", method = RequestMethod.GET)
	public String GetTemplate(Map<String, Object> map) {
		System.out.println("========= Inside listTemplate=========");
		map.put("template", new Template());
		map.put("templateList", templateService.listTemplate());
		return "/admin/listTemplates";

	}
	
	
	
	@RequestMapping(value = "/admin/listproductTemplates", method = RequestMethod.GET)
	public String GetTemplateNames(Map<String, Object> map) {
		System.out.println("========= Inside listTemplate=========");
	//	map.put("template", new Template());
		
		
		//System.out.println("Number of records " + mpp.size());
		List<String>  sSided = templateService.listTemplateNames(1,0);
		List<String>  dSided = templateService.listTemplateNames(2,0);
		List<String>  prmCards = templateService.listTemplateNames(3,0);
		map.put("SingleSided", sSided);
		map.put("DoubleSided", dSided);
		map.put("PremiumCards", prmCards);
		map.put("index1", 1);
		map.put("index2", 2);
		map.put("index3", 3);
		
		
		for (String x:sSided)
		{
			System.out.println("Number of records " + x);	
		}
		
		return "/admin/listproductTemplates";

	}
	
	
	@RequestMapping(value = "/admin/listproductTemplates/{index}", method = RequestMethod.GET)
	public String GetTemplateNamesbyIndex(@PathVariable("index") Integer index,Map<String, Object> map) {
		System.out.println("========= Inside listTemplate=========");
	//	map.put("template", new Template());
		
		
		System.out.println("index " + index);
		
		int idx= (index*3)-3;
		
		List<String>  sSided = templateService.listTemplateNames(1,idx);
		List<String>  dSided = templateService.listTemplateNames(2,idx);
		List<String>  prmCards = templateService.listTemplateNames(1,idx);
		map.put("SingleSided", sSided);
		map.put("DoubleSided", dSided);
		map.put("PremiumCards", prmCards);
		map.put("index1", 1);
		map.put("index2", 2);
		map.put("index3", 3);
		
		
		for (String x:sSided)
		{
			System.out.println("Number of records " + x);	
		}
		
		return "/admin/listproductTemplates";

	}
	
	
	@RequestMapping(value = "/admin/setNextIndexes/{index}", method = RequestMethod.GET)
	public String setNextIndexes(@PathVariable("index") Integer index,Map<String, Object> map) {
		System.out.println("========= Inside setIndexes=========");
	
		index=index + 1;
		int index1=index;
		int index2=index + 1;
		int index3=index + 2;
		
		
		System.out.println("index " + index);
		
		int idx= (index*3)-3;
		
		List<String>  sSided = templateService.listTemplateNames(1,idx);
		List<String>  dSided = templateService.listTemplateNames(2,idx);
		List<String>  prmCards = templateService.listTemplateNames(1,idx);
		map.put("SingleSided", sSided);
		map.put("DoubleSided", dSided);
		map.put("PremiumCards", prmCards);
		map.put("index1", index1);
		map.put("index2", index2);
		map.put("index3", index3);
		
		
		for (String x:sSided)
		{
			System.out.println("Number of records " + x);	
		}
		
		return "/admin/listproductTemplates";

	}
	
	
	@RequestMapping(value = "/admin/setPrevIndexes/{index}", method = RequestMethod.GET)
	public String setPrevIndexes(@PathVariable("index") Integer index,Map<String, Object> map) {
		System.out.println("========= Inside setPrevIndexes=========");
	//	map.put("template", new Template());
		
		if(index != 1)
		{
			index=index-3;	
		}
		
		
		
		System.out.println("index " + index);
		
		int idx= (index*3)-3;
		
		List<String>  sSided = templateService.listTemplateNames(1,idx);
		List<String>  dSided = templateService.listTemplateNames(2,idx);
		List<String>  prmCards = templateService.listTemplateNames(1,idx);
		map.put("SingleSided", sSided);
		map.put("DoubleSided", dSided);
		map.put("PremiumCards", prmCards);
		map.put("index1", 1);
		map.put("index2", 2);
		map.put("index3", 3);
		
		
		for (String x:sSided)
		{
			System.out.println("Number of records " + x);	
		}
		
		return "/admin/listproductTemplates";

	}
	

	@RequestMapping("/admin/editTemplate/{templateId}")
	public ModelAndView editTemplateDtls(
			@PathVariable("templateId") Integer templateId,
			Map<String, Object> map) {
		System.out.println("ID  " + templateId);

		List<Template> listtemplate = templateService
				.listSpecificTemplate(templateId);
		System.out.println("contactname  " + listtemplate.get(0).getName());
		System.out.println("ID    " + listtemplate.get(0).getId());
		Template objTemplate = listtemplate.get(0);

		return new ModelAndView("/admin/templates", "template", objTemplate);
	}

	@RequestMapping("/admin/deleteTemplate/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer templateId) {

		templateService.removeTemplate(templateId);
		return "redirect:/admin/listTemplates";

	}
}
