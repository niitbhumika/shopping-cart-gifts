<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background: url('resources/images/bg1.jpg');
background-size:cover;/* //to stretch image */
background-repeat:no-repeat;
background-position:center;/* //image center */
} 
</style>
</head>
<body>
<form action="perform_login" method="POST">
<h4><table>
<tr><td>Email Id</td><td><input type="email" name="username"/></td></tr>
<tr><td>Password</td><td><input type="password" name="password"/></td></tr>
<tr><td><input type="submit" value="submit"/></td></tr></h4>

<tr><td><input type="reset" value="cancel"/></td></tr>
</table>                               
</form>
${info}user
</body>
</html>

	