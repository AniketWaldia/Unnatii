package com.unnatii.in;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

import com.unnatii.in.model.Product;
import com.unnatii.in.model.Template;
import com.unnatii.in.services.ProductsService;
import com.unnatii.in.services.TemplateService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private ProductsService productService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(Locale locale, Model model,Map<String, Object> map) {
		logger.info("home page loading start");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		List<Product>  sSided = productService.categoryWiseProducts(1);
		List<Product>  dSided = productService.categoryWiseProducts(2);
		List<Product>  prmCards = productService.categoryWiseProducts(3);
		 
		//List<String>  sSided = templateService.listTemplateNames(1,0);
		//List<String>  dSided = templateService.listTemplateNames(2,0);
		//List<String>  prmCards = templateService.listTemplateNames(3,0);
		map.put("SingleSided", sSided);
		map.put("DoubleSided", dSided);
		map.put("PremiumCards", prmCards);
		
		
		
		//for (String x:sSided)
		//{
		//	System.out.println("Number of records " + x);	
		//}
		
		
		return "home";
	}
	
	@RequestMapping(value = "/productTemplates/{id}", method = RequestMethod.GET)
	public String getproductTemplates(@PathVariable("id") Integer id,Locale locale, Model model,Map<String, Object> map) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		System.out.println("ID for image " + id);
		
		List<Template>  sSided = templateService.listTemplateForProduct(id);
		map.put("SingleSided", sSided);
		map.put("productId", id);
		return "productTemplates";
	}
	
	@RequestMapping(value = "/templateOrder/${productId}/${templateId}", method = RequestMethod.GET)
	public String TemplateOrder(@PathVariable("productId") Integer pid,@PathVariable("templateId") Integer tid,Locale locale, Model model,Map<String, Object> map) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		System.out.println("PID for image " + pid);
		System.out.println("T ID" + tid);
		
		//List<Template>  sSided = templateService.listTemplateForProduct(id);
		//map.put("SingleSided", sSided);
		//map.put("productId", id);
		return "productTemplates";
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
        
		return "about";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String product(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "products";
	}
	
	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public String service(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "services";
	}
	
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public String feedback(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "contact";
	}
}
