
<!DOCTYPE html>
<html lang="en">
<head>
<style>
body{
background: url('resources/images/bg1.jpg');
background-size:cover;/* //to stretch image */
background-repeat:no-repeat;
background-position:center;/* //image center */
} 
</style>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Welcome Admin</h2>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">My Gifts</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Products <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="addProducts">Add Products</a></li>
            <li><a href="deleteProducts">Delete Products</a></li>
            <li><a href="#">Update Products</a></li>
             <li><a href="adminProducts">View Products</a></li>
          </ul>
        </li>
        <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="addCategories">Add Category</a></li>
            <li><a href="#">Delete Category</a></li>
            <li><a href="#">Update Category</a></li>
              <li><a href="#">View Category</a></li>
               </ul>
                </li>
                <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="addSuppliers">Add Supplier</a></li>
            <li><a href="#">Delete Supplier</a></li>
            <li><a href="#">Update Supplier</a></li>
              <li><a href="#">View Supplier</a></li>
               </ul>
                </li>

        
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <!--  <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
        <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- <div class="container">
  <h3>Collapsible Navbar</h3>
  <p>In this example, the navigation bar is hidden on small screens and replaced by a button in the top right corner (try to re-size this window).
  <p>Only when the button is clicked, the navigation bar will be displayed.</p>
</div>	 -->

</body>
</html>