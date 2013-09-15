<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include/tag-lib.jsp" %>
<!DOCTYPE html>

<html lang="en">

<head>
<link href="${pageContext.servletContext.contextPath}/resources/images/fav.png" rel="shortcut icon" type="image/png">
<meta charset="utf-8">
  <meta name="viewport" content="initial-scale=1, minimum-scale=1, width=device-width">
  <title>Unnatii - Error 404 (Not Found)!!</title>
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
  <b>404.</b> <ins>That's an error.</ins>
  </p>
  <p>The requested URL <code>   ${requestScope['javax.servlet.forward.request_uri']} </code> was not found on this server.<ins>That's all we know.</ins>

</p>
</body>

</html>