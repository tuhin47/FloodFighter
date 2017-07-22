<%-- 
    Document   : register
    Created on : Jul 21, 2017, 10:18:32 AM
    Author     : Joker
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content=""> 
        <title>Registration Form</title>
        <link rel="stylesheet" type="text/css" href="reg.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/owl.carousel.css" rel="stylesheet">
        <link href="css/owl.transitions.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body class="sack">
        <div class="container">
            <form class="move" action="RegisterServlet" method="POST">
                <input type="hidden" name="tag" value="register"> 
                <input type="hidden" name="userType" value="normal"> 
                <div class="form-group">
                    <label for="name">User Name:</label>
                    <input required type="name" class="form" id="username" placeholder="Enter name" name="userName">
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form" id="email" placeholder="Enter email" name="email">
                </div>

                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form" id="pwd" placeholder="Enter password" name="password">
                </div>

                <div class="form-group">
                    <label for="pwd">Confirm Password:</label>
                    <input type="password" class="form" id="pwd" placeholder="Enter password" name="pwd">
                </div>

                <div class="form-group">
                    <label for="email">Contact:</label>
                    <input type="text" class="form" id="contact" placeholder="Enter number" name="contact">
                </div>

                <!--			    <div class="checkbox">
                                              <label><input type="checkbox" name="remember"> Remember me</label>
                                            </div>-->

                <button type="submit" class="btn btn-success">Submit</button>
            </form>
        </div>
    </body>

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/mousescroll.js"></script>
    <script src="js/smoothscroll.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/jquery.isotope.min.js"></script>
    <script src="js/jquery.inview.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/scrolling-nav.js"></script>
    <!-- shoaibcse13 -->
</html>
