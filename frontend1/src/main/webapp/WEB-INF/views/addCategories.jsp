	<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
<h3> Category Information</h3>
<title>Spring MVC Form Handling</title>
<form:form method="POST" action="addcategory" commandName="category">
   <table>

<tr>
        <td><form:label path="cat_name">Category Name</form:label></td>
        <td><form:input path="cat_name" /></td>
    </tr>
    
     <tr>
        <td><form:label path="cat_description">Description</form:label></td>
        <td><form:input path="cat_description" /></td>
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