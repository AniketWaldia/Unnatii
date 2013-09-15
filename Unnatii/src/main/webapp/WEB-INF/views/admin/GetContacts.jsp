<%@ include file="/WEB-INF/views/include/adminInclude.jsp" %>

<div class="box-content" style="height:300px;">

<h3 style="font-size: 20px;color: #333;padding: 2px 0;margin: 0 auto;">Contacts Details</h3>
<c:if  test="${!empty contactList}">
<div style="width:100%;height:250px;">
<table id="box-table-a" style="background-color:white;">
<thead>
<tr>
	<th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Description</th>
    
   <!--  <th>Delete</th> -->
</tr>
</thead>
<tbody>
<c:forEach items="${contactList}" var="contact">
    <tr>
    	<td><a href="${pageContext.servletContext.contextPath}/admin/replyContact/${contact.id}"><U><Font color="red">${contact.id}</Font></U></a></td>
        <td>${contact.name}</td>
        <td>${contact.email}</td>
        <td>${contact.telephone}</td>
        <td>${contact.description}</td> 
    </tr>
</c:forEach>
</tbody>
</table>

</div>
</c:if>

</div>

<br/>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>