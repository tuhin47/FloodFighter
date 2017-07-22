<%-- 
    Document   : Login
    Created on : Jul 21, 2017, 9:52:47 AM
    Author     : Joker
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!Doctype html>
<html>
    <head>
        <!-- shoaibcse13 -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- shoaibcse13 -->
        <title>Login page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/owl.carousel.css" rel="stylesheet">
        <link href="css/owl.transitions.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <style>
            body { 
                background: url(images/flood.jpg) no-repeat center center fixed; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }
        </style>
        <!-- shoaibcse13 -->
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-lock"></span>User Login</div>
                        <div class="panel-body">
                            <form class="form-horizontal" action="LoginServlet"  method="post" role="form">

                                <input type="hidden" name="tag" value="login"> 
                                <input type="hidden" name="userType" value="normal"> 
                                <div class="form-group">
                                    <label  for="inputEmail"  class="col-sm-3 control-label">
                                        Username</label>
                                    <div class="col-sm-9">
                                        <input type="text" name="userName" class="form-control" id="inputEmail" placeholder="Email Or Username" required>
                                    </div>
                                </div>
                                <!-- shoaibcse13 -->
                                <div class="form-group">
                                    <label for="inputPassword" class="col-sm-3 control-label">
                                        Password</label>
                                    <div class="col-sm-9">
                                        <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    
                            </div>
                            <!-- shoaibcse13 -->
                            <div class="form-group last">
                                <div class="col-sm-offset-3 col-sm-9">
                                    <button type="submit" class="btn btn-success btn-sm">
                                        <a><span style="color: #fff">Sign in</span></a>
                                    </button>
                                    <button type="reset" class="btn btn-default btn-sm">
                                        Reset
                                    </button>
                                </div>
                            </div>

                    </div>
                    </form>
                    <div class="panel-footer">
                        Not Registred? <a href="Register.jsp">Register here</a>
                    </div>
                </div>
            </div>
        </div>
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
