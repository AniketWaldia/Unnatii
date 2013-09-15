<%@ include file="/WEB-INF/views/include/adminInclude.jsp"%>

<div class="box-content" style="padding-top: 20px;">

	<h3
		style="font-size: 20px; color: #333; padding: 2px 0; margin: 0 auto;">Product
		Details</h3>
	
	<input type="button" value="Add Product" class="button"  style="float: right;margin-top: -20px;" onclick="javascript:window.location='${pageContext.servletContext.contextPath}/admin/product'"/>
	<c:if test="${!empty productList}">
		<div style="width: 100%;">
			
			<table id="box-table-a"
				style="background-color: white; margin: 0px; margin: 2% 0; width: 100%">
				
				<thead>
				
					<tr>
						<th>ID</th>
						<th>Product Name</th>
						<th>Code</th>
						<th>Tag</th>
						<th>Image</th>
						<th>Delete</th>


						<!--  <th>Delete</th> -->
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${productList}" var="product">
						<tr>

							<td><a href="${pageContext.servletContext.contextPath}/admin/editProduct/${product.id}"><Font color="red">${product.id}</Font></a></td>
							<td>${product.name}</td>
							<td>${product.productCode}</td>
							<td>${product.productTag}</td>
							<td><img src="${pageContext.servletContext.contextPath}/resources/uploadProduct/productImage/${product.image}" width="200" /></td>
							
							<td>
							<a href="${pageContext.servletContext.contextPath}/admin/editProduct/${product.id}"><img alt="delete" src="${pageContext.servletContext.contextPath}/resources/images/edit_icon.gif"/></a>
							&nbsp;<a href="${pageContext.servletContext.contextPath}/admin/deleteProduct/${product.id}"><img alt="delete" src="${pageContext.servletContext.contextPath}/resources/images/delete_icon.gif"/></a>							
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</c:if>

</div>

<br />


<%@ include file="/WEB-INF/views/include/footer.jsp"%>