<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include/tag-lib.jsp" %>
<!DOCTYPE html>

<html lang="en">

<head>
<link href="${pageContext.servletContext.contextPath}/resources/images/fav.png" rel="shortcut icon" type="image/png">
<meta charset="utf-8">
  <meta name="viewport" content="initial-scale=1, minimum-scale=1, width=device-width">
  <title>Unnatii - Under Construction Page</title>
  <style>
    *{margin:0;padding:0}
	html,code{font:15px/22px arial,sans-serif}
	html{background:#fff;color:#222;padding:15px}
	body{margin:7% auto 0;max-width:390px;min-height:180px;padding:30px 0 15px}
	
	p{margin:11px 0 22px;overflow:hidden}
	ins{color:#777;text-decoration:none}
	a img{border:0}@media screen and (max-width:772px){body{background:none;margin-top:0;max-width:none;padding-right:0}}
  </style>
  
  </head>
  <body>
  <a href="//www.unnatii.com/">
  <img src="${pageContext.servletContext.contextPath}/resources/images/logo.png" alt="Unnatii"></a>
  <p>
  <b>Under Construction Page</b> <ins></ins>
  </p>
  <p>The requested URL <code>   ${requestScope['javax.servlet.forward.request_uri']} </code> is under construction. We will be back soon, <ins>Sorry for the inconvenience!</ins>

</p>
</body>

</html>