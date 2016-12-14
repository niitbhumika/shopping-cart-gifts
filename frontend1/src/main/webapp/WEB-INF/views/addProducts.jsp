<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  --%>                       
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h3>Product Information</h3>
<form:form method="POST" action="addproduct" commandName="product" enctype="multipart/form-data">
   <table>
   
    <tr>
        <td><form:label path="prod_name">Product Name</form:label></td>
        <td><form:input path="prod_name" /></td>
    </tr>
    <tr>
        <td><form:label path="quantity">Quantity</form:label></td>
        <td><form:input path="quantity" /></td>
    </tr>
    <tr>
        <td><form:label path="prod_price">Price</form:label></td>
        <td><form:input path="prod_price" /></td>
        
        <tr>
    <td>Category</td>
    <td><form:select path="cat_id" items="${categoryList }"
             itemValue="cat_id" itemLabel="cat_id"></form:select></td>
             
             <tr>
    <td>Supplier</td>
    <td><form:select path="sup_id" items="${supplierList }"
             itemValue="sup_id" itemLabel="sup_id"></form:select></td> 
        
    </tr>
                   
    <tr><td>File to upload:</td><td><form:input type="file" path="image" /></td></tr>
    
    <tr>
    <td colspan="2">
            <input type="submit" value="Submit"/></td>
    <td colspan="2">
            <input type="reset" value="Cancel"/> </td>
    </tr>
</table>  
</form:form>
<!-- added today 5-12-2016 -->
<h4>Product List</h4> 
<c:if test="${!empty productList}">
<table>
<tr>
<th>Product ID</th>
<th>Product Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Category ID</th>
<th>supplier ID</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<c:forEach items="${productList}" var="product">
<tr>
    <td>${product.prod_id}</td>
    <td>${product.prod_name}</td>
    <td>${product.prod_price}</td>
    <td>${product.quantity}</td>
    <td>${product.cat_id}</td>
    <td>${product.sup_id}</td>
    <td><a href="<c:url value='editProducts${product.prod_id}'/>">Edit</a></td>
    <td><a href="<c:url value='deleteProducts${product.prod_id}'/>">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    </c:if>   
</body>
</html>
