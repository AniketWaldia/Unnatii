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
import com.unnatii.in.common.MailServer;
import com.unnatii.in.model.Contact;
import com.unnatii.in.model.ReplyContact;
import com.unnatii.in.services.ContactService;
import com.unnatii.in.services.replyContactService;

@Controller
public class ContactUsController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private replyContactService rplycontactService;

	@Autowired
	MailServer mailService ;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact() {

		return new ModelAndView("contact", "command", new Contact());

	}

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("SpringWeb")Contact contact,  ModelMap model) {

		if(contact.getName() !="" && contact.getEmail() !="" && contact.getTelephone() !="" && contact.getDescription() !="")
		{
			contactService.addContact(contact);
			model.addAttribute("name", contact.getName());

			mailService.sendMail("unnatiigss@gmail.com", "unnatiigss@gmail.com", "Enquiry From Web - "+ contact.getId(), 
					"Name : "+ contact.getName() +"\n\nPhone Number : " + contact.getTelephone() +"\n\nDescription : " + contact.getDescription());


			System.out.println("Name : "+ contact.getName() +"\n\nPhone Number : " + contact.getTelephone() +"\n\nDescription : " + contact.getDescription());

			/*model.addAttribute("email", contact.getEmail());*/

			return new ModelAndView("thankyou");				  
		}		   
		else
		{
			
			return new ModelAndView("contact", "command", new Contact());
			
		}

	}

	/*@RequestMapping(value = "/admin/listContact", method = RequestMethod.GET)
	public ModelAndView GetDtls() {

		return new ModelAndView("/admin/GetContacts", "command", new Contact());

	}*/



	@RequestMapping(value = "/admin/listContact", method = RequestMethod.GET)
	public String  GetDetails(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());

		return "/admin/GetContacts";

	} 

	@RequestMapping("/admin/deleteContact/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		contactService.removeContact(contactId);
		return "/admin/GetContacts";

	}
	
	@RequestMapping("/admin/replyContact/{contactId}")
	public ModelAndView replyContacts(@PathVariable("contactId") Integer contactId,Map<String, Object> map) {
		System.out.println("ID  " + contactId);
		
		 List<Contact> listcontact = contactService.listSpecificContact(contactId);
		 System.out.println("contactname  " + listcontact.get(0).getName());
		 System.out.println("ID    " + listcontact.get(0).getId());
		map.put("contactSpecificList",listcontact );
		ReplyContact rply=new ReplyContact();
		
		Contact objContact=new Contact(listcontact.get(0).getId(),listcontact.get(0).getName(),listcontact.get(0).getEmail(),listcontact.get(0).getTelephone(),listcontact.get(0).getDescription());
		objContact.setReplyContact(rply);
		return new ModelAndView("/admin/replyContact", "command", objContact);

	}

	@RequestMapping(value = "/admin/addContactReply", method = RequestMethod.POST)
	public ModelAndView addReplyContact(@ModelAttribute("SpringWeb")Contact contact,  ModelMap model) {

		//if(contact.getName() !="" && contact.getEmail() !="" && contact.getTelephone() !="" && contact.getDescription() !="")
	//	{
		System.out.println("contactID  " + contact.getId());
		 
		
		 ReplyContact rly;
		 rly=contact.getReplyContact();
		 rly.setContact_id(contact.getId());
		 rly.setEmail(contact.getEmail());
		 
		 System.out.println("Rly    " + rly.getDescription());
		 System.out.println("Rly    " + rly.getEmail());
		 System.out.println("Rly    " + rly.getSubject());
		 System.out.println("Rly    " + rly.getContact_id());
		 System.out.println("Rly    " + rly.getId());
		 
		
		// contactService.addContact(contact);
		 
		 
		 rplycontactService.addContact(rly);
		 
			//model.addAttribute("name", "Admin");

			//mailService.sendMail(contact.getEmail(), "unnatiigss@gmail.com",contact.getReplyContact().getSubject() ,contact.getReplyContact().getDescription());

		 System.out.println("Suucessfully Inserted reply");
			//System.out.println("Name : "+ contact.getName() +"\n\nPhone Number : " + contact.getTelephone() +"\n\nDescription : " + contact.getDescription());

			/*model.addAttribute("email", contact.getEmail());*/
		   //  map.put("contact", new Contact());
			// map.put("contactList", contactService.listContact());
			 model.addAttribute("contact", new Contact());
			 model.addAttribute("contactList", contactService.listContact());
			//return "/admin/GetContacts";

			return new ModelAndView("/admin/GetContacts");				  
		//}		   
		//else
	//	{
			
		//	return new ModelAndView("replyContact", "command", new Contact());
			
		//}

	}

}
