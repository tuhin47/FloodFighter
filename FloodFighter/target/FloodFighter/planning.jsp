<%-- 
    Document   : planning
    Created on : Jul 21, 2017, 12:47:36 PM
    Author     : Joker
--%>

<%@page import="sust.gaia.dto.Thana"%>
<%@page import="java.util.List"%>
<%@page import="sust.gia.controller.AffectedPlaces"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Table</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBGQklpAo6MNOU3mWhxI9-uJQpMjL9kTmw&callback=getLocation"
        type="text/javascript"></script>
        <style>
            table, th, td {
                border: 1px solid black;
                text-align: center;
            }

            th, td {
                padding: 20px;
            }

            .table {

                width: 50%;
                margin: 10px auto;
                float: none;

            }

            .table-responsive{


            }

        </style>

    </head>
    <body>

        <%
            List<Thana> thanas = AffectedPlaces.sortedThanaList();
        %>


        <div class="table-responsive" >
            <table class="table table-striped" style="text-align: center;" >

                <tr>
                    <th>Places</th>

                    <th>Total Relief</th>
                    <th>Flood Fighter Ratio</th> 
                </tr>

                <%
                    Thana p = null;
                    for (Thana t : thanas) {

                        if (p == null) {
                            p = t;
                        }

                %>
                <tr>
                    <td><%=t.getThana_name()%></td>

                    <td><%= t.getCumulative()%></td>

                    <td><%=t.getRatio()%></td>

                </tr>
                <%}%> 


                <br><br>
            </table>
            <div  style="text-align: center;">
                <br>
                Current Location:<p id="demo"></p>
                <b>Our Suggestion is :<%=p.getThana_name()%></b>

            </div>

        </div>

    </body>
    <script>

        var lat;
        var long;

        var x = document.getElementById("demo");

        function getLocation()
        {
            if (navigator.geolocation)
            {
                navigator.geolocation.getCurrentPosition(showLocation);
            } else {
                x.innerHTML = "Geolocation not Available";
            }
        }

        function showLocation(position)
        {
            lat = position.coords.latitude;
            long = position.coords.longitude;

            reverseGeocoding(lat, long);
        }

        function reverseGeocoding(latt, llong)
        {
            var latlng = new google.maps.LatLng(latt, llong);

            var geocoder = new google.maps.Geocoder();

            geocoder.geocode({'latLng': latlng}, function (results, status) {

                if (status !== google.maps.GeocoderStatus.OK) {
                    alert(status);
                }

                if (status == google.maps.GeocoderStatus.OK) {
                    console.log(results);
                    var address = (results[0].formatted_address);
                    x.innerHTML = address;
                }
            });
        }
        getLocation();

    </script>
</html>

