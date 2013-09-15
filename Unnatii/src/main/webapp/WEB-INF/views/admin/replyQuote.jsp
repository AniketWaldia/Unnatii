<%@ include file="/WEB-INF/views/include/adminInclude.jsp" %>


<div style="padding-top: 30px;">
<script>
function validate(){
	//var varname=document.getElementById("txtname");
	var varemail=document.getElementById("txtemail2");
	var vartelephone=document.getElementById("txttelephone");
	var vardesc=document.getElementById("txtreplydescription");
	
	
	if (varemail.value==null || varemail.value=="")
	   {
	   alert("Please provide Email");
	    return false;
	   }
	
	if (vardesc.value==null || vardesc.value=="")
	   {
	   alert("Please provide Description");
	    return false;
	   }
	
	
	   var atpos=varemail.value.indexOf("@");
			
	   var dotpos=varemail.value.lastIndexOf(".");
	 	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=varemail.value.length)
	   {
	   alert("Please enter a valid e-mail address");
	   return false;
	   }
	 	
	 	/*if (vartelephone.value==null || vartelephone.value=="")
		   {
		   alert("Please provide Telephone No.");
		    return false;
		   }
	 	if (isNaN(vartelephone.value))
	 	{
	 		alert("Please enter a valid phone number");	
	 		 return false;
	 	}*/
	
}
</script>
<div class="main_wrapper">
<form:form id="specform" action="${pageContext.servletContext.contextPath}/admin/addQuoteReply" method="POST" onsubmit="return validate();">
<fieldset class="grey_bg">
 <legend><h2>Customer Details</h2></legend>

<table style= "border:10px;width:100%;">
          <tr>
          <td><label>Quote Id</label></td>
        <td><form:input type="text" id="Quoteid" path="id" readonly="true" style="background-color: #EBEAEA;"/></td>
          </tr>
          <tr>
        <td><label>First Name</label></td>
        <td><form:input type="text" id="first_name" path="firstname" disabled="true"/></td>
        <td><label>Last Name</label></td>
        <td><form:input type="text" id="last_name" disabled="true" path="lastname"/></td>
        <td><label>Company</label></td>
        <td><form:input id="company_name"  type="text" path="company" style="width:188px;" disabled="true"/></td>        
      </tr>
      <tr>
        <td><label>Phone</label></td>
        <td><div><form:input id="phone_work" type="text" path="phone" disabled="true"/>
        </div>
        </td>      
        <td><label>Email</label></td>
        <td><div><form:input id="email" type="text" path="email" disabled="true"/>
        </div>
        </td>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td><label>Address</label></td>
        <td colspan="5"><form:textarea id="primary_address_street" disabled="true" type="textarea" path="address" style="margin: 2px 0px;height: 44px;width: 841px;"/></td>
      </tr>
      <tr>
      	<td><label>City</label></td>
        <td><form:input id="primary_address_city" type="text" disabled="true" path="city"/></td>
        <td><label>State</label></td>
        <td><form:input id="primary_address_state" type="text" disabled="true" path="state"/></td>      
      	<td><label>Pin Code</label></td>
      	<td><form:input id="primary_address_postalcode" type="text" disabled="true" path="pincode" style="width:188px;"/></td>
      </tr>
					<tr>
		<td colspan="2"><label>How did you hear about us?</label> <form:input id="creative_source_c" disabled="true" style="width:135px;" type="text"  path="via"/></td>
		<td>	
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
	        <form:input id="dwJobtype" type="text" disabled="true" path="product"/>
	        </td>
   </tr>
	      <tr>
	        <td><label>Quantity</label></td>
	        <td><form:input  name="quantity" disabled="true"  type="text"  path="quantity" size="1"/></td>
	        <td rowspan="3" valign="top"><label>Requirement Details</label>
			<form:textarea name="description" disabled="true" path="reqDesc"  type="text" rows="6" cols="50"/>
		</td>
	      </tr>
	      <tr>
	        <td><label>Expected Date</label></td>
	        <td><form:input name="expectedDate" disabled="true" type="text" path="expectedby" size="3" /></td>
	      </tr>
	      <tr>
	        <td><label>Min. Budget(in INR)</label></td>
	        <td><form:input name="expectedBudget" disabled="true" type="text" path="budget" size="3" /></td>
	      </tr>
	     
	   </table>
	</div>
	  </fieldset>
<fieldset class="grey_bg">
 <legend><h2>Reply</h2></legend>
 <table style= "border:40px;width:100%;">
    
    <tr>
        <td><form:label class="label-Font" path="email">To</form:label></td>
        <td><form:input path="email" id="txtemail2" class="text-box" readonly="true" /></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="email">Subject</form:label></td>
        <td><form:input path="replyQuote.subject"  id="txtsubject" class="text-box" /></td>
    </tr>
     <tr>	
        <td><form:label class="label-Font" path="email">Description</form:label></td>
        <td><form:textarea path="replyQuote.description" id="txtreplydescription"  class="text-box" style="height:75px;" /></td>
    </tr>
   
    <tr style="text-align: center;">
        
      <td colspan="2">
            <input type="submit" value="Send" class="button"/>
                    
      </td>

    </tr>
</table> 
 </fieldset>
<!-- <div style="padding:10px 0"><input type="submit" class="save_btn" name="Save" value="Send Enquiry"/></div> -->




</form:form>
</div>
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>