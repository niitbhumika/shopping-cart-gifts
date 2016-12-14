<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
<h3> Supplier Information</h3>
<title>Spring MVC Form Handling</title>
<form:form method="POST" action="addsuppliers" commandName="supplier"><!-- changes here -->
   <table>

<tr>
        <td><form:label path="sup_id">Supplier Name</form:label></td>
        <td><form:input path="sup_id" /></td>
    </tr>
    
     <tr>
        <td><form:label path="sup_name">Description</form:label></td>
        <td><form:input path="sup_description" /></td>
        </tr>
         <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
        <td colspan="2">
            <input type="reset" value="Cancel"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>