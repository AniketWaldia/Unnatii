package com.unnatii.admin;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unnatii.in.HomeController;
import com.unnatii.in.model.ProductCategory;
import com.unnatii.in.services.ProductCategoryService;

@Controller
public class ProductCategoryController  {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ProductCategoryService productCategoryService;

	@RequestMapping(value = "/admin/productCategory")
	public String productCategory(Map<String, Object> map) {
		logger.info("In product form page -- to add product");
		
		ProductCategory productCategory=new ProductCategory();
		
		map.put("productCategory", new ProductCategory());
		map.put("listcategory", productCategoryService.listProductCategory());
		
		return "/admin/productCategory";
		
	}

	@RequestMapping(value = "/admin/addProductsCategory", method = RequestMethod.POST)
	public ModelAndView addProductCategory(@ModelAttribute("SpringWeb") ProductCategory productCategory,  ModelMap mode) {
		
				if(productCategory.getProductCategoryId()!=null)
	                {
        			 	productCategoryService.updateProductCategory(productCategory);
	                }
	                else
	                {
	                	productCategoryService.addProductCategory(productCategory);               
	                }
        		
        		return new ModelAndView("redirect:/admin/listProductCategory");	
	}


	@RequestMapping(value = "/admin/listProductCategory", method = RequestMethod.GET)
	public String GetProduct(Map<String, Object> map) {
		System.out.println("========= Inside listproduct=========");
		map.put("productCategory", new ProductCategory());
		map.put("productCategoryList", productCategoryService.listProductCategory());
		return "/admin/listProductCategory";

	}

	@RequestMapping("/admin/editProductCategory/{categoryId}")
	public String editProductDtls(@PathVariable("productId") Integer productId,Map<String, Object> map) {
		System.out.println("ID  " + productId);

		List<ProductCategory> listproductCategory = productCategoryService.listSpecificProductCategory(productId);
		System.out.println("contactname  " + listproductCategory.get(0).getCategoryName());
		System.out.println("ID    " + listproductCategory.get(0).getProductCategoryId());
		ProductCategory productCategogery = listproductCategory.get(0);

		map.put("productCategogery", productCategogery);
		map.put("listcategory", productCategoryService.listProductCategory());
		return "/admin/productCategory";
	}

	@RequestMapping("/admin/deleteProductCategory/{categoryId}")
	public String deleteContact(@PathVariable("contactId") Integer categoryId) {
		
		productCategoryService.removeProductCategory(categoryId);
		return "redirect:/admin/listProductCategory";

	}
}
