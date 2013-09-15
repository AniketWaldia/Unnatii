<%@ include file="/WEB-INF/views/include/adminInclude.jsp"%>

<div class="box-content" style="padding-top: 20px;">

	<h3
		style="font-size: 20px; color: #333; padding: 2px 0; margin: 0 auto;">Template
		Details</h3>
	
	<input type="button" value="Add Template" class="button"  style="float: right;margin-top: -20px;" onclick="javascript:window.location='${pageContext.servletContext.contextPath}/admin/template'"/>
	<c:if test="${!empty templateList}">
		<div style="width: 100%;">
			
			<table id="box-table-a"
				style="background-color: white; margin: 0px; margin: 2% 0; width: 100%">
				
				<thead>
				
					<tr>
						<th>ID</th>
						<th>Product Name</th>
						<th>Template Name</th>
						<th>Status</th>
						<th>Image</th>
						<th>Action</th>


						<!--  <th>Delete</th> -->
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${templateList}"  var="template">
						<tr>

							<td><a href="${pageContext.servletContext.contextPath}/admin/editTemplate/${template.id}"><Font color="red">${template.id}</Font></a></td>
							<td>${template.name}</td>
							<td>${template.name}</td>
							<td>${template.status}</td>
							<td><img src="${pageContext.servletContext.contextPath}/resources/uploadProduct/templateImage/${template.image}" width="200" /></td>
							
							<td>
							<a href="${pageContext.servletContext.contextPath}/admin/editTemplate/${template.id}"><img alt="delete" src="${pageContext.servletContext.contextPath}/resources/images/edit_icon.gif"/></a>
							&nbsp;<a href="${pageContext.servletContext.contextPath}/admin/deleteTemplate/${template.id}"><img alt="delete" src="${pageContext.servletContext.contextPath}/resources/images/delete_icon.gif"/></a>							
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