package com.unnatii.in;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.unnatii.in.model.ReplyQuote;
import com.unnatii.in.model.SpecSheet;
import com.unnatii.in.services.SpecService;


@Controller
public class SpecSheetController {

		@Autowired
		private SpecService specService;
		
	
	
	   @RequestMapping(value = "/enquiry", method = RequestMethod.GET)
	   public ModelAndView specsheet() {
	      return new ModelAndView("SpecSheet", "command", new SpecSheet());
	   }
	   
	   @RequestMapping(value = "/addSpecSheet", method = RequestMethod.POST)
	   public ModelAndView addspecsheet(@ModelAttribute("SpringWeb")SpecSheet spec, 
	   ModelMap model) {
		  System.out.println("Spec Name "+ spec.getFirstname());
		   if(spec.getFirstname() !="" && spec.getEmail() !="" && spec.getPhone() !="")
		   {
				specService.addSpec(spec);
				model.addAttribute("name", spec.getFirstname());
				return new ModelAndView("thankyou");
		   }		   
		   else
		   {
			   return new ModelAndView("SpecSheet", "command", new SpecSheet());  
		   }
	   }
	

	  /* @RequestMapping(value = "/admin/listQuotes", method = RequestMethod.GET)
	   public ModelAndView GetDtls() {
	      return new ModelAndView("/admin/GetQuotes", "comman", new SpecSheet());
	   }*/
	   
	   @RequestMapping(value = "/admin/listQuotes", method = RequestMethod.GET)
	   public String  GetDetails(Map<String, Object> map) {
		 
		    map.put("spec", new SpecSheet());
	        map.put("specList", specService.listSpecSheet());

		
	        return "/admin/GetQuotes";
	   }
	   
	   @RequestMapping("/admin/deleteQuote/{specId}")
	    public String deleteContact(@PathVariable("specId") Integer specId,Map<String, Object> map) {
	 
		   specService.removeSpec(specId);
	 
	        return "redirect:/admin/GetQts";
	    }
	   
	   @RequestMapping("/admin/replyQuote/{specId}")
	   public ModelAndView replyQuoteDtls(@PathVariable("specId") Integer specId,Map<String, Object> map) {
		   System.out.println("Spec ID "+ specId);
		   
		   List<SpecSheet> listSpecSheet = specService.listSpecificSpecSheet(specId);
			 System.out.println("contactname  " + listSpecSheet.get(0).getFirstname());
			 System.out.println("ID    " + listSpecSheet.get(0).getId());
			 map.put("specSpecificList",listSpecSheet );
			 ReplyQuote objReplyQuote =new ReplyQuote();
			 SpecSheet objspec=listSpecSheet.get(0);
			 objspec.setReplyQuote(objReplyQuote);
		   return new ModelAndView("/admin/replyQuote", "command",objspec);
	   }
	   
	   @RequestMapping(value = "/admin/addQuoteReply", method = RequestMethod.POST)
		public ModelAndView addReplyQuote(@ModelAttribute("SpringWeb")SpecSheet spec,  ModelMap model) {

			
			System.out.println("SpecsID  " + spec.getId());
			 
			
			ReplyQuote rly;
			 rly=spec.getReplyQuote();
			 rly.setQuote_id(spec.getId());
			 rly.setEmail(spec.getEmail());
			 
			 System.out.println("Rly    " + rly.getDescription());
			 System.out.println("Rly    " + rly.getEmail());
			 System.out.println("Rly    " + rly.getSubject());
			 System.out.println("Rly    " + rly.getQuote_id());
			 System.out.println("Rly    " + rly.getId());
			  
			 
			 specService.addReplyQuote(rly);
			 
			 System.out.println("Suucessfully Inserted replyQuote");
				
				 model.addAttribute("spec", new SpecSheet());
				 model.addAttribute("specList", specService.listSpecSheet());
				
				return new ModelAndView("/admin/GetQuotes");				  
			

		}

}
