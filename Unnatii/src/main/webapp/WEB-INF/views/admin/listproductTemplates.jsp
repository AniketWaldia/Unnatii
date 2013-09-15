<!-- Include header jsp-->
<!-- Include top-header jsp-->
<%@ include file="/WEB-INF/views/include/adminInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/style.css" rel="stylesheet"/>
</head>
<body>
<section class="mainBody">
	
		
	<section class="leftContainer">
		<section>Print</section>
		<ul>
			<li>Business Card
				<ul>
					<li>Business Card</li>
					<li>Letter Head</li>
					<li>Envelopes</li>
					<li>Business Card</li>
					<li>Letter Head</li>
					<li>Envelopes</li>
						
				</ul>
			</li>
			<li>Letter Head</li>
			<li>Envelopes</li>
			<li>Business Card
            	<ul>
					<li>Business Card</li>
					<li>Letter Head</li>
					<li>Envelopes</li>
					<li>Business Card</li>
					<li>Letter Head</li>
					<li>Envelopes</li>
						
				</ul>            
            </li>
			<li>Letter Head</li>
			<li>Envelopes</li>
				
		</ul>
		<section>Corporate/Gifts</section>
		<ul>
			<li>Business Card</li>
			<li>Letter Head</li>
			<li>Envelopes</li>
			<li>Business Card</li>
			<li>Letter Head</li>
			<li>Envelopes</li>
				
		</ul>
		<section>Branding</section>
		<ul>
			<li>Business Card</li>
			<li>Letter Head</li>
			<li>Envelopes</li>
			<li>Business Card</li>
			<li>Letter Head</li>
			<li>Envelopes</li>
				
		</ul>
		
		
	</section><!-- eo leftContainer -->
	
	<section class="rightContainer">
		<header>Business Cards</header>
		<section class="productList1" >
			<header>Single Sided</header>
			<c:forEach items="${SingleSided}" var="template">
			<section class="productDetail">
				<img alt="" title="" src="${pageContext.servletContext.contextPath}/resources/images/${template}" height="180px"/>
				<p>CREATE YOUR OWN</p>
				<p>Learn More</p>
			</section>
			</c:forEach>
			
		</section>
		<section class="productList2" >
		<header>Double Sided</header>
		<c:forEach items="${DoubleSided}" var="dblSd">
			<section class="productDetail">
				<img alt="" title="" src="${pageContext.servletContext.contextPath}/resources/images/${dblSd}" height="180px" />
				<p>CREATE YOUR OWN</p>
				<p>Learn More</p>
			</section>
			</c:forEach>
			</section>
		<section class="productList3" >
		<header>Premium Cards</header>
		<c:forEach items="${PremiumCards}" var="prmCds">
			<section class="productDetail">
				<img alt="" title="" src="${pageContext.servletContext.contextPath}/resources/images/${prmCds}" height="180px"/>
				<p>CREATE YOUR OWN</p>
				<p>Learn More</p>
			</section>
			</c:forEach>
			</section>	
	</section><!-- eo rightContainer -->
</section><!-- eo bodyContainer -->
<tr style="text-align: right;">
<td colspan="2">
<a href="${pageContext.servletContext.contextPath}/admin/setPrevIndexes/${index1}"><Font color="red"><U>Prev</U></Font></a>
<a href="${pageContext.servletContext.contextPath}/admin/listproductTemplates/${index1}"><Font color="red">${index1}</Font></a>
<a href="${pageContext.servletContext.contextPath}/admin/listproductTemplates/${index2}"><Font color="red">${index2}</Font></a>
<a href="${pageContext.servletContext.contextPath}/admin/listproductTemplates/${index3}"><Font color="red">${index3}</Font></a>
<a href="${pageContext.servletContext.contextPath}/admin/setNextIndexes/${index3}"><Font color="red"><U>Next</U></Font></a>
</td></tr>

<!-- Include footer jsp-->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>