<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Student Information</h2>
   <table>
    <tr>
        <td>Name</td>
        <td>${name} </td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${email}</td>
    </tr>
    <tr>
        <td>Phone</td>
        <td>${phone}</td>
    </tr>
</table>  
</body>
</html>