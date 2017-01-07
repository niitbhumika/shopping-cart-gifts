<%-- 	<html>
	<%@include file="header.jsp"%>

<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<style>
body {
	background-image: url("resources/images/aaa.jpg");
	
}
td {
	font-size: 20px;
}


</style>
<body>
<center>
<h4>Registration</h4>
<form:form method="POST" action="addUser" commandName ="userinfo">    
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
     <tr>
    
    <td><form:label path="emailid">Email id</form:label></td>
        <td><form:input path="emailid" /></td>
    </tr>
   
   
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input  type="password" path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="confirmpassword">Confirm Password</form:label></td>
        <td><form:input   type="password" path="confirmpassword" /></td>
    </tr>
    <tr>
    <td><form:label path="phno">Phone</form:label></td>
        <td><form:input path="phno" /></td>
    </tr>
    <tr>
    <td><form:label path="address">Phone</form:label></td>
        <td><form:input path="address" /></td>
    </tr>
    <tr>
    <td >
            <input type="submit" value="Submit"/>
        </td>
        <td colspan="2">
            <input type="reset" value="Cancel"/>
        </td>
    </tr>
</table>  
</form:form>
</center>
 </body>
</html>

 --%>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="C"%>
 --%><%--<html>
<head>
<title>Registration</title>
<style>
body {
	background: url('resources/images/regis.jpg');
	background-size: cover; /* to stretch image*/
	background-repeat: no-repeat;
}

table {
	margin-left: 750px;
	font-weight: bold;
}

tr {
	font-size: 20px;
}

td {
	font-size: 25;
	padding: 15px;
}
</style>

 --%>



<%@ include file="header.jsp"%>

 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<head>


    <title>Spring MVC Form Handling</title>
</head>

<body>

<h2><center>User Information</center></h2>
<center>
<h3>Registration</h3>
<p><b>ALREADY REGISTERED ? <a href= "login">SIGN IN</a></b></p>
<%-- <a href="${flowExecutionUrl}&_eventId_home">Home</a> --%>
<form:form commandName="us"  >
<style>
body{
background: url('resources/images/pink.jpg');
background-size:cover;/* //to stretch image */
background-repeat:no-repeat;
background-position:center;/* //image center */
} 
</style>
  
<table>
<tr><td>
<b>Name</td><td><form:input type="text" path="name" /></td></tr></b>
 <!-- to display validation messages -->
         <c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
 				<tr><td>
				

<tr><td>
<b>Enter Password</td><td><form:input type="password" path="password"  /></td></tr></b>
<!-- to display validation messages -->
				<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
				
<tr><td>
<b>Enter Confirmed Password</td><td><form:input type="password" path="confirmpassword"  /></td></tr></b>
<!-- to display validation messages -->
				<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('confirmpassword')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
				<tr><td>
<b>Email Id</td><td><form:input type="email" path="emailid" /></td></tr></b>
<!-- to display validation messages -->
				<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('emailid')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>

				

<tr><td>
<b>Phone no.</td><td><form:input type="text" path="phno" /></td></tr></b>
<!-- to display validation messages -->
				<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('phno')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>


<tr><td>
<b>City</td><td> <form:input type="text" path="address" /></td></tr></b>

<!-- to display validation messages -->
				<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>

<tr><td>
<input type="CHECKBOX" NAME="OFFER" CHECKED>I agree to receive information about exciting offers.
</td></tr>
</table>

<br /><br />

<div class="center">
<input type="submit" name="_eventId_submit" value="submit" ></div>

</form:form>
<br />
<%@ include file="footer.jsp" %>

