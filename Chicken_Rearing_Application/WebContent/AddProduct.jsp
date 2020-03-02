<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Chicken Rearing Application</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/blog-home.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Chicken Rearing App</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="#">Manage Chicken</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#">Product
              <span class="sr-only">(current)</span>
            </a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="#">Account Settings</a>
          </li>
         
        </ul>
      </div>
    </div>
  </nav>
  <div class="container">

    <div class="row">

      <!-- Blog Entries Column -->
      <div class="col-md-8">

        <h1 class="my-4">Product
          
        </h1>

        <!-- Blog Post -->
        <div class="card mb-4">
        <!--   
        <img class="card-img-top" src="http://placehold.it/750x300" alt="product image"> -->
          <div class="card-body">
            <h2 class="card-title">Add product</h2>
            <form action="" method="POST" style="display: -ms-inline-grid;">
                <div class="form-group">

                <div class="form-group">
                    <label for="breed">Select Product:</label>
                    <select class="form-control" id="breed">
                      <option>Eggs</option>
                      <option>Chicks</option>
                      <option>Layers</option>
                      <option>Broilers</option>
                      <option>Chicken Feed</option>
                      <option>Medication</option>  
                    </select>
                  </div>
                  <label for="productQuantity">Quantity:</label>
                  <input type="number" class="form-control" min="1" id="productQuantity">
                </div>

                <div class="form-group">
                    <label for="productDescription">Description:</label>
                    <textarea name="productDescription" id="productDescription" cols="30" rows="4"></textarea>
                  </div>
                 

                  <div class="form-group">
                      <label for="productPrice">Price</label>
                      <input type="number" class="form-control" id="flock-age" min="0"  placeholder="productPriced">

                  </div>

              
                </div>
                
           <input type="submit" class=" btn btn-primary">
            
            
          </div>
          
        </div>
        

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">
  
          <!-- Search Widget -->
          <div class="card my-4">
            <h5 class="card-header">Search</h5>
            <div class="card-body">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Search for...">
                <span class="input-group-btn">
                  <button class="btn btn-secondary" type="button">Go!</button>
                </span>
              </div>
            </div>
          </div>
          <div class="card my-4">
            <h5 class="card-header">Side Widget</h5>
            <div class="card-body">
             <a href="productlanding.jsp"> View Products</a>
            </div>
          </div>
  
          <!-- Categories Widget -->
          
          <!-- Side Widget -->
         
  
        </div>
  
      </div>
      <!-- /.row -->
  
    </div>
    <!-- /.container -->
  
    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
      </div>
      <!-- /.container -->
    </footer>
  
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  
  </body>
  
  </html>
  
    