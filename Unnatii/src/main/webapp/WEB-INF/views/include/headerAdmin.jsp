<div class="container">
	<div style="padding-left: 75%; padding-top: 1%;"></div>
	<div class="header">
		<a href="${pageContext.servletContext.contextPath}/admin/dashboard">
			<img
			src="${pageContext.servletContext.contextPath}/resources/images/logo.png"
			class="logo" alt="Unnatii - Global Solutions"
			name="Unnatii - Global Solutions" width="190px" height="60px" />
		</a>

		<!-- end .header -->
	</div>
	<div class="main_menu">
		<ul>
			<li><a
				href="${pageContext.servletContext.contextPath}/admin/dashboard">Dashboard</a></li>
			<li><a
				href="${pageContext.servletContext.contextPath}/admin/listContact">Feedbacks</a></li>
			<li><a
				href="${pageContext.servletContext.contextPath}/admin/listQuotes">Enquiry</a></li>
			<li><a href="#">Products</a>
				<ul>
					<li><a href="${pageContext.servletContext.contextPath}/admin/listProducts">Products</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/admin/listTemplates">Templates</a></li>
					<!-- <li><a href="#">Price</a></li>
       					<li><a href="#">Addon</a></li> -->
				</ul></li>
			<!--   <li> <a href="#">Services</a></li> -->
			<li><a href="${pageContext.servletContext.contextPath}/admin/listproductTemplates">Users</a></li>
			<!-- <li> <a href="#">Static Data</a></li> -->
			<li><a href="#">My Account</a>
				<ul>
					<li><a href="#">Change Password</a></li>
				<!-- 	<li><a href="#">Profile</a></li> -->
					<li><a
						href="${pageContext.servletContext.contextPath}/<c:url value="j_spring_security_logout" />">Logout</a></li>
				</ul></li>
		</ul>
	</div>

	<div class="content">