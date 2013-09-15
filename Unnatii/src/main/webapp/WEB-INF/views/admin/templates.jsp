<%@ include file="/WEB-INF/views/include/adminInclude.jsp" %>
<script language="JavaScript">
function Validate()
{
		var image =document.getElementById("templateFile").value;
		if(templateFile!=''){
		var checkimg = image.toLowerCase();
		if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)){
			alert("Please enter Image File Extensions .jpg,.png,.jpeg");
			document.getElementById("templateFile").focus();
			return false;
		}
		}	
return true;
} 
</script>
<span style="padding-top: 30px; width:50%;">
<h2>Add Template</h2>

<form:form commandName="template" method="POST" action="${pageContext.servletContext.contextPath}/admin/addTemplates"  onSubmit="return Validate();"  enctype="multipart/form-data">
<table><tr>
  <td>
   <table>
    <tr>
        <td><form:label class="label-Font" path="name">Name<font color="red"></font></form:label></td>
        <td><form:input path="name" id="txtname" class="text-box" placeholder="Template Name"/>
        <form:input type="hidden" path="id" id="txtid" class="text-box" />
        </td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="product">Product<font color="red">*</font></form:label></td>
        <td>
        	<form:select path="productId" id="product" items="${productList}" itemValue="id" itemLabel="name"></form:select>   
        </td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="templateFile">Template Image<font color="red">*</font></form:label></td>
       <td><form:input type="file" path="templateFile" class="text-box"/>
       </td>
           </tr>
    <tr>
        <td><form:label class="label-Font" path="status">Status</form:label></td>
        <td><form:checkbox id="chkStatus" path="status" value="true"/> <form:label path="status" class="label-Font">Active</form:label></td>
    </tr>
    <tr style="text-align: center;">
        <td colspan="2">
            <input type="submit" value="Done" class="button"/>
            <input type="reset" value="Reset" class="button"/>
        </td>
    </tr>
</table> 
</td>
<td>

</td>
</tr></table>
</form:form>
</span >
<%@ include file="/WEB-INF/views/include/footer.jsp" %>