<%@include file="header.jsp"%>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img
   {
      width: 60%;
      margin: auto;
  }
  </style>
</head>
<body>
<h2>Welcome</h2> ${info} 


<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
       <li data-target="#myCarousel" data-slide-to="4"></li>
        <li data-target="#myCarousel" data-slide-to="5"></li>
         <li data-target="#myCarousel" data-slide-to="6"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources/images/flower.jpg" alt="pic1" width="460" height="345">
      </div>

      <div class="item">
        <img src="resources/images/yellow.jpg" alt="yellow" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="resources/images/gift.jpg" alt="gift" width="460" height="345">
      </div>
       <div class="item">
      <img src="resources/images/pic2.jpg" alt="images" width="460" height="345">
      </div>
       <div class="item">
      <img src="resources/images/pic1.jpg" alt="url2" width="460" height="345">
      </div>
       <div class="item">
      <img src="resources/images/red.jpg" alt="others gift" width="460" height="345">
      </div>
      
          </div>
          <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<table>  
<tr><td><a href="agift" >
<img src= "resources/images/wedding.jpg"></img></a></td> 
<td><a href="agift" >
<img src= "resources/images/choco.jpg"></img></a></td>
<td><a href="agift" >
<img src= "resources/images/yellow.jpg"></img></a></td></tr>
</table>                                 
<%@include file="footer.jsp"%>


