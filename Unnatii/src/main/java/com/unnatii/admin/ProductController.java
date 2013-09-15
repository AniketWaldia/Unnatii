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
import com.unnatii.in.model.Product;
import com.unnatii.in.model.ProductCategory;
import com.unnatii.in.services.ProductsService;

@Controller
public class ProductController implements HandlerExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ProductsService productService;

	/*@RequestMapping(value = "/admin/product")
	public ModelAndView products(HttpServletRequest request, HttpServletResponse response) {
		logger.info("In product form page -- to add product");
		return new ModelAndView("/admin/products", "product", new Product());
	}*/
	
	
	@RequestMapping(value = "/admin/product")
	public String products(Map<String, Object> map) {
		logger.info("In product form page -- to add product");
		Product product=new Product();
		
		map.put("product", new Product());
		map.put("listcategory", productService.listcategory());
		
		return "/admin/products";
		
	}
	

	@RequestMapping(value = "/admin/addProducts", method = RequestMethod.POST)
	public ModelAndView addProducts( @ModelAttribute(value = "Product") Product product, BindingResult result, HttpSession session, Model model,HttpServletRequest req) {
		System.out.println("inside add products    " + product.getDescription());
		 String uploadedFile= product.getFileData().getOriginalFilename();
		  Date date = new Date();
         System.out.println(date.getTime());
		 String temp [] = uploadedFile.split("\\.");
		
		 String uploadedFileName = temp[0]+ "_"+date.getTime()+"."+temp[1] ;
		 
         System.out.println("file name :"+uploadedFileName);
        
         FileOutputStream outputStream = null;
		

			try {
										System.out.println("test 1");
						                InputStream ip = product.getFileData().getInputStream();
						                OutputStream op = new FileOutputStream("/home/uploadDir/productImages/"+uploadedFileName);                                          
						                int readBytes = 0;
						                byte[] buffer = new byte[8192];
						                while ((readBytes = ip.read(buffer, 0, 8192)) != -1) {
						                	System.out.println("======Uploading file in backup directory======");
						                	op.write(buffer, 0, readBytes);
						                }
						                op.close();
						                ip.close();
						               
						               InputStream ip1 =product.getFileData().getInputStream();
						                String newpath = "/opt/bitnami/apache-tomcat/webapps/ROOT/resources/uploadProduct/productImage/";
						                System.out.println(newpath);
						                OutputStream op1 = new FileOutputStream(newpath+uploadedFileName);                                      
						                int readBytes1 = 0;
						                byte[] buffer1 = new byte[8192];
						                while ((readBytes1 = ip1.read(buffer1, 0, 8192)) != -1) {
						                	System.out.println("=====Uploading file in tomcat directory=====");
						                	op1.write(buffer1, 0, readBytes1);
						                }
						                op1.close();
						                ip1.close();
						                System.out.println("test 2");
						                System.out.println("File name :"+ uploadedFileName);
						                
						        		product.setImage(uploadedFileName);
						        		product.setImagePath(newpath);
						        		product.setFileData(null);
						        		
						        		ProductCategory productCategory =new ProductCategory();
						        		productCategory.setProductCategoryId(product.getCategory());
						        		
						        		product.setProductCategory(productCategory);

						        		 if(product.getId()!=null)
							                {
						        			 	productService.updateProducts(product);
							                }
							                else
							                {
							                	productService.addProduct(product);               
							                }
						        		
						        		return new ModelAndView("redirect:/admin/listProducts");
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
		model.put("product", new Product());
		return null;
	}

	@RequestMapping(value = "/admin/listProducts", method = RequestMethod.GET)
	public String GetProduct(Map<String, Object> map) {
		System.out.println("========= Inside listproduct=========");
		map.put("product", new Product());
		map.put("productList", productService.listProduct());
		return "/admin/listProducts";

	}

	@RequestMapping("/admin/editProduct/{productId}")
	public String editProductDtls(
			@PathVariable("productId") Integer productId,
			Map<String, Object> map) {
		System.out.println("ID  " + productId);

		List<Product> listproduct = productService.listSpecificProduct(productId);
		System.out.println("contactname  " + listproduct.get(0).getName());
		System.out.println("ID    " + listproduct.get(0).getId());
		Product objProduct = listproduct.get(0);

		map.put("product", objProduct);
		map.put("listcategory", productService.listcategory());
	//	return new ModelAndView("/admin/products", "product", objProduct);
		return "/admin/products";
	}

	@RequestMapping("/admin/deleteProduct/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer productId) {

		productService.removeProduct(productId);
		return "redirect:/admin/listProducts";

	}
}
