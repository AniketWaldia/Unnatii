<%@ include file="/WEB-INF/views/include/adminInclude.jsp" %>
<div class="box-content" style="height:300px;">

<h3 style="font-size: 20px;color: #333;padding: 2px 0;margin: 0 auto;">Quote Details</h3>
<c:if  test="${!empty specList}">
<div style="width:100%;overflow-y:auto;">
<table  id="box-table-a" >
<thead>
<tr >
	<th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Company</th>
    <th>Product</th>
</tr>
</thead>
<tbody>
<c:forEach items="${specList}" var="spec">
    <tr>
    	 <td><a href="${pageContext.servletContext.contextPath}/admin/replyQuote/${spec.id}"><U><Font color="red">${spec.id}</Font></U></a></td>
    	<td>${spec.firstname} &nbsp; ${spec.lastname}</td>
		<td>${spec.email}</td>
        <td>${spec.phone}</td>
        <td>${spec.company}</td>
        <td>${spec.product}</td>

    </tr>
</c:forEach>
</tbody>
</table>
</div>
</c:if>
	
</div>

<br/>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>