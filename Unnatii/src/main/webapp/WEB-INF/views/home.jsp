<%@ include file="/WEB-INF/views/include/tag-lib.jsp" %>
<%@ include file="/WEB-INF/views/include/top-header.jsp" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<%@ include file="/WEB-INF/views/include/slider.jsp" %>



<section class="mainBody">
	<section class="topBodyHome">
		<!-- <p class="topHeader"></p>
		<p class="topButtons"></p>
		<p class="topLine"></p>
	 -->
	</section>
	<section class="leftPanel">
		<article>
			<a href="#"><img src="${pageContext.servletContext.contextPath}/resources/images/box1.png" style="width:100%"  /></a>
		</article>
		<article>
			<a href="#"><img src="${pageContext.servletContext.contextPath}/resources/images/box2.png" style="width:100%" /></a>
		</article>
		<article>
			<a href="#"><img src="${pageContext.servletContext.contextPath}/resources/images/box3.png" style="width:100%"  /></a>
		</article>
		<article class="testimonial">
		
			<header>Customer Testimonial</header>
			<article>
				Unnatii is quick and reliable. I ordered diaries for my team and was pleasantly surprised with the quality. I hope to try your company for our business cards and letterheads next. Hope you keep up the quality online service, Unnatii! 
			</article>
	
		</article>
	
	</section><!-- End of leftPanel -->
	<section class="middlePanelHome">
		<header>Popular Products
			<aside class="qualText">99% QUALITY ASSURANCE</aside>
			<aside class="deliveryText">DELIVERY IN 48 <aside>HOURS</aside></aside>
		</header>
		<section>	
		<article><ul>		
			<c:forEach items="${SingleSided}" var="template">			
			<li><a href="${pageContext.servletContext.contextPath}/productTemplates/${template.id}">
				<img alt="" title="" src="${pageContext.servletContext.contextPath}/resources/uploadProduct/productImage/${template.image}" height="180px"/></a>
				<B>${template.productCode}<br/>
				${template.productTag}</B>
			</li>
			</c:forEach>		
		</ul></article>
		</section>
		<header>Corporate Gifts</header>
		<section>	
		<article><ul>		
			<c:forEach items="${DoubleSided}" var="dblSd">			
			<li><a href="${pageContext.servletContext.contextPath}/productTemplates/${dblSd.id}">
				<img alt="" title="" src="${pageContext.servletContext.contextPath}/resources/uploadProduct/productImage/${dblSd.image}" height="180px"/></a>
				<B>${dblSd.productCode}<br/>
				${dblSd.productTag}</B>
			</li>
			</c:forEach>		
		</ul></article>
		</section>
		<header>Personalized Products</header>
		<section>	
		<article><ul>		
			<c:forEach items="${PremiumCards}" var="prmCds">			
			<li><a href="${pageContext.servletContext.contextPath}/productTemplates/${prmCds.id}">
				<img alt="" title="" src="${pageContext.servletContext.contextPath}/resources/uploadProduct/productImage/${prmCds.image}" height="180px"/></a>
				<B>${prmCds.productCode}<br/>
				${prmCds.productTag}</B>
			</li>
			</c:forEach>		
		</ul></article>
		</section>
	
	
	</section><!-- End of middlePanel -->

</section><!-- End of mainBody -->







<%@ include file="/WEB-INF/views/include/footer.jsp" %>