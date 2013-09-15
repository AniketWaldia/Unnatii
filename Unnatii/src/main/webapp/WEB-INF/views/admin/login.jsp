<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath}/resources/images/fav.png" rel="shortcut icon" type="image/png">
<title>Unnatii - Corporate Gifting, Gifting, Best printing,Best price,Business cards,premium business cards,postcards,folded cards,greeting cards,holiday folded cards,Brochures</title>
<!-- <link rel="stylesheet" type="text/css" href="css/style.css" /> -->
<!-- <link rel="stylesheet" href="<spring:url value="css/style.css" htmlEscape="true" />" type="text/css"/> -->
<meta name="google-site-verification" content="67_DVako5kAx84oYw6GJ-iBP8mNpk6AWa0vMQRvDaJg" />
<meta name="keywords" content="print,best printing,best price,free business cards,premium business cards,postcards,folded cards,greeting cards,holiday folded cards,brochures,flyers,newsletters,sales,data sheets,presentation folders,stationery,stationary,letterhead,address labels,custom label,return address labels,powerpoint templates,magnets,business card magnets,invitations,invitation,birth announcements,baby announcements,thank you notes,holiday items,caricature address labels,caricature contact cards,note cards,printing gift certificates,refer a friend printing,press kit,cards,online printing,label,order printing online,low priced printing, Event management, online printing india,Business Card Printing, Brochure Printing,letterhead printing,poster printing,Diary printing, customized printing,personalised calendar printing,customised Mug printing, send gifts to india,Offset Printing, digital printing,canvas printing,flyer printing services,Brochures &amp; Flyers,Large posters,photo printing,double side cards,corporate brochures">
<meta http-equiv="copyright" content="Copyright 2012-2013 Unnatii">
<meta name="robots" content="noodp, noydir, index, follow, archive">


<link href="${pageContext.servletContext.contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>

<body>
	<div class="header_top">

		<div >
			<span style="padding-left: 11%; width: 80%; padding-top: 3px;">
			<img src="${pageContext.servletContext.contextPath}/resources/images/flag.png" />&nbsp; <font color="#FFFFFF" size="-1" title="May I HELP YOU !! ">
				Get Instance Quote : Call +91 900 887 7223</font>
			</span>
			
		</div>

	</div>
	<div class="container">
<div style="padding-left: 75%;padding-top: 1%;" >
  				
               
                 
  </div>
	<div class="header">
				<a href="${pageContext.servletContext.contextPath}/home">
				<img src="${pageContext.servletContext.contextPath}/resources/images/logo.png" class="logo" alt="Unnatii - Global Solutions" name="Unnatii - Global Solutions" width="190px" height="60px"/>
				</a> 
		 	

		<!-- end .header -->
	</div>


	<div class="content">



<body onload='document.f.j_username.focus();'>

<div class="box-content" style="height:300px; width: 300px;padding-left: 10%;">
	<h3 style="font-size: 20px;color: #333;padding: 2px 0;margin: 0 auto;">EXISTING USER? LOGIN</h3>
 
	<c:if test="${not empty error}">
		<div class="err">
			Invalid Details<br /> 
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
 
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
 
		<div class="err"></div>
			
				<label>User Name </label><br/>
				<input type='text' name='j_username' value=''>
				<div class="err"></div>
				
				<label>Password</label><br/>
				<input type='password' name='j_password' />
				<div class="err"></div>
				<div style="padding-left: 25px;">
				<input name="submit" type="submit" value="LOGIN"  class="btn" />
				</div>
	</form>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>