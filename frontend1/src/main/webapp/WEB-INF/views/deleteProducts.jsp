
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="POST" action="deleteProducts" commandName="product" >
   <table>
   
   <tr>
        <td><form:label path="prod_id">Product id</form:label></td>
        <td><form:input path="prod_id" /></td>
    </tr>
   
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