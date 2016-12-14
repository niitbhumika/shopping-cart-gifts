<%@include file="header.jsp" %> 
<table class="table table-stripped">
 <tr>
 <th>Id</th>
 <th>Product Name</th>
 <th>Product Price</th>
 <th>Quantity</th>
 <th>Product Image</th>
 </tr>
       <tr>
           <td>${product.prod_id}</td>
           <td>${product.prod_name}</td>
           <td>${product.prod_price}</td>
           <td>${product.quantity}</td>
           <td><img src="resources/images/${product.prod_name}.jpg"style=height:100px;widht:100px;"/></td>
               <td><a href="Cart">Add to Cart</a></td>            
               </tr>
               </table>
        s
<%@include file="footer.jsp" %>




