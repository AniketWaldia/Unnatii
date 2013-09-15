<%@ include file="/WEB-INF/views/include/tag-lib.jsp" %>
<%@ include file="/WEB-INF/views/include/top-header.jsp" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<link href="${pageContext.servletContext.contextPath}/resources/css/spec.css" rel="stylesheet"/>
<div style="padding-top: 30px;">
<script>
    function validate(){
	var varname=document.getElementById("first_name");
	var varemail=document.getElementById("email");
	var vartelephone=document.getElementById("phone_work");
	
	if (varname.value==null || varname.value=="")
	   {
	   alert("Please provide Name");
	    return false;
	   }
	if (varemail.value==null || varemail.value=="")
	   {
	   alert("Please provide Email");
	    return false;
	   }
	if (vartelephone.value==null || vartelephone.value=="")
	   {
	   alert("Please provide Phone No.");
	    return false;
	   }

		var atpos=varemail.value.indexOf("@");
			
	   var dotpos=varemail.value.lastIndexOf(".");
	 	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=varemail.value.length)
	   {
	   alert("Please enter a valid e-mail address");
	   return false;
	   }
	 	if (isNaN(vartelephone.value))
	 	{
	 		alert("Please enter a valid phone number");	
	 		 return false;
	 	}
}
</script>
<div class="main_wrapper">
<form:form id="specform" action="${pageContext.servletContext.contextPath}/addSpecSheet" method="POST" onsubmit="return validate();">
<fieldset class="grey_bg">
 <legend><h2>Customer</h2></legend>

<table style= "border:10px;width:100%;">
          <tr>
        <td><label>First Name</label><label><font color="red">*</font></label></td>
        <td><form:input type="text" id="first_name" path="firstname"/></td>
        <td><label>Last Name</label></td>
        <td><form:input type="text" id="last_name" path="lastname"/></td>
        <td><label>Company</label></td>
        <td><form:input id="company_name" type="text" path="company"/></td>        
      </tr>
      <tr>
        <td><label>Phone</label><label><font color="red">*</font></label></td>
        <td><div><form:input id="phone_work" type="text" path="phone"/>
        </div>
        </td>      
        <td><label>Email</label><label><font color="red">*</font></label></td>
        <td><div><form:input id="email" type="text" path="email"/>
        </div>
        </td>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td><label>Address</label></td>
        <td colspan="5"><form:textarea id="primary_address_street" type="textarea" path="address" style="margin: 2px 0px;height: 44px;width: 841px;"/></td>
      </tr>
      <tr>
      	<td><label>City</label></td>
        <td><form:input id="primary_address_city" type="text" path="city"/></td>
        <td><label>State</label></td>
        <td><form:input id="primary_address_state" type="text"  path="state"/></td>      
      	<td><label>Pin Code</label></td>
      	<td><form:input id="primary_address_postalcode" type="text"  path="pincode"/></td>
      </tr>
					<tr>
		<td colspan="2"><label>How did you hear about us?</label></td>
		<td>
			<form:select  id="creative_source_c" path="via">
<option value="0" id="0">-- Select --</option>
<option value="google_ad" id="1">Google Ad</option>
<option value="google_search" id="2">Google Search</option>
<option value="radio_ad" id="3">Radio Ad</option>
<option value="email" id="4">Email</option>
<option value="reference" id="5">Reference</option>
<option value="other" id="6">Other</option>
</form:select>

		</td>
		<td colspan="3"></td>
		</tr>
  </table>
</fieldset>




	
  <fieldset>
    <legend><h2>Requirement Details</h2></legend>
	
	 <div>    
	    	    <table style= "border:10px;width:100%;">
	      <tr>
	        <td width="10%"><label>Product</label></td>
	        <td width="20%">
	        <form:select  id="dwJobtype"  path="product">
					<option value="" selected="selected">Select Type Of Job</option>
					<option value="Corporate_Gifts">Corporate Gifts</option>
					<option value="Events_Management">Events Management</option>
					<option value="Letterheads">Letterheads</option>
					<option value="Calendars">Calendars</option>
					<option value="PIPS_Calendars">PIPS Calendars</option>
					<option value="Diaries">Diaries/Notebooks</option>
					<option value="Envelopes">Envelopes</option>
					<option value="Brochures">Brochures</option>
					<option value="Flyers">Flyers</option>
					<option value="Booklets">Booklets</option>
					<option value="Posters">Posters</option>
					<option value="Banners">Banners</option>
					<option value="Standees">Standees</option>
					<option value="Invitations">Invitations</option>
					<option value="ID_Cards">ID Cards</option>
					<option value="T_Shirts">Personalised T Shirts</option>
					<option value="Mugs">Personalised Mugs</option>
					<option value="Fotoart">Fotoart/Canvas Print</option>
					<option value="Framease">Photo frame/Framease</option>
					<option value="Greeting_Card">Greeting Card</option>
					<option value="Photo_print">Photo print</option>
					<option value="Other">Custom/other job</option>
			</form:select>
</td>
   </tr>
	      <tr>
	        <td><label>Quantity</label></td>
	        <td><form:input  name="quantity"  type="text"  path="quantity" size="1"/></td>
	        <td rowspan="3" valign="top"><label>Requirement Details</label>
			<form:textarea name="description" path="reqDesc"  type="text" rows="6" cols="50"/>
		</td>
	      </tr>
	      <tr>
	        <td><label>Expected Date</label></td>
	        <td><form:input name="expectedDate"  type="text" path="expectedby" size="3" /></td>
	      </tr>
	      <tr>
	        <td><label>Min. Budget(in INR)</label></td>
	        <td><form:input name="expectedBudget" type="text" path="budget" size="3" /></td>
	      </tr>
	     
	   </table>
	</div>
	  </fieldset>

<div style="padding:10px 0"><input type="submit" class="save_btn" name="Save" value="Send Enquiry"/></div>




</form:form>
</div>
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>