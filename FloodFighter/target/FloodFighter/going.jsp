<%-- 
    Document   : going
    Created on : Jul 21, 2017, 10:42:24 AM
    Author     : Joker
--%>

<%@page import="sust.gaia.dto.ThanaDetails"%>
<%@page import="sust.gia.controller.AffectedPlaces"%>
<%@page import="sust.gaia.dto.AffectedDist"%>
<%@page import="sust.gaia.dto.Thana"%>
<%@page import="sust.gaia.dto.Thana"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sust.gaia.dto.District"%>
<%@page import="java.util.List"%>
<%@page import="sust.gia.controller.GetDistrictInfo"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Going For a Relief</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/owl.carousel.css" rel="stylesheet">
        <link href="css/owl.transitions.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="relief.css">
        <link rel="stylesheet" type="text/css" href="going.css">
    </head>
    <body class="back">



        <%
            List<District> dist = GetDistrictInfo.getAllDistrictName();
        %>
        <div class="col-md-12" style="padding-left: 400px; padding-top: 200px">
            <div class="container hack">                                          
                <form action="GoingForRelief" method="get">
                    <label style="padding-right: 10px; color: #fff;">District</label>

                    <select  class="jack" name="distName">
                        <%
                            for (District d : dist) {%>

                        <option    value="<%=d.getDistName()%>"><%=d.getDistName()%></option>

                        <%
                            }
                        %>
                    </select>
                    <!--<input type="submit" value="Submit">-->
                    <%
                        List<ThanaDetails> thanas = GetDistrictInfo.getAllThana();

                    %>
                    <br>

                    <br>
                    <label style="padding-right: 10px; color: #fff;">Thana</label>
                    <select class="jack" name="thanaName">
                        <%for (ThanaDetails t : thanas) {%>
                        <option value="<%=t.getThana_name()%>"><%=t.getThana_name()%></option>
                        <%}%> 
                    </select>



                    <br>



                    <br>

                    <div class="amount">
                        <label style="padding-right: 10px; color: #fff;">Amount</label>
                        <input name="relief" type="number" style="min-width: 127px; " min="0">
                    </div>
                    <br>
                    
                    <button type="submit" class="mack btn btn-success">Submit</button>

                </form>
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

