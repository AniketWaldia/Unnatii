<%@ include file="/WEB-INF/views/include/adminInclude.jsp"%>


<script type="text/javascript">
    function validate(){
	var varname=document.getElementById("txtname");
	var varemail=document.getElementById("txtemail");
	var vartelephone=document.getElementById("txttelephone");
	var vardesc=document.getElementById("txtdesc");
	
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
	   alert("Please provide Telephone No.");
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
	 	if (isNaN(vartelephone.value))
	 	{
	 		alert("Please enter a valid phone number");	
	 		 return false;
	 	}
	
}
</script>

<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/tinymce/tinymce.min.js"></script>
<script type="text/javascript">
tinymce.init({
    selector: "textarea",
    plugins: [
        "advlist autolink lists link image charmap print preview anchor",
        "searchreplace visualblocks code fullscreen",
        "insertdatetime media table contextmenu paste "
    ],
    toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image"
});
</script>
<script language="JavaScript">
function Validate()
{
		var image =document.getElementById("fileData").value;
		if(fileData!=''){
		var checkimg = image.toLowerCase();
		if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)){
			alert("Please enter Image File Extensions .jpg,.png,.jpeg");
			document.getElementById("fileData").focus();
			return false;
		}
		}	
return true;
} 
</script>


<span style="padding-top: 30px; width: 50%;">
	<h2>Add Products</h2> 
	<form:form commandName="productCategory" method="POST"  action="${pageContext.servletContext.contextPath}/admin/addProductsCategory"  onSubmit="return Validate();" 	enctype="multipart/form-data"  >
		<table>
			<tr>
				<td>
					<table>
						<tr>
							<td><form:label class="label-Font" path="categoryName">Name<font
										color="red">*</font>
								</form:label></td>
							<td><form:input path="categoryName" id="txtname" class="text-box"
									placeholder="Product Name" />
									<form:input type="hidden" path="productCategoryId" id="txtid" class="text-box" />
									</td>
						</tr>
						<tr>
							<td><form:label class="label-Font" path="categoryStatus">Status</form:label></td>
							<td><form:checkbox id="chkStatus" path="categoryStatus" value="true" /></td>
						</tr>
						

						<tr style="text-align: center;">
							<td colspan="2"><input type="submit" value="Done"
								class="button" /> <input type="reset" value="Reset"
								class="button" /></td>


						</tr>
					</table>
				</td>
				<td></td>
			</tr>
		</table>
	</form:form>
</span>



<%@ include file="/WEB-INF/views/include/footer.jsp"%>