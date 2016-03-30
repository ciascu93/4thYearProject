<%-- 
    Document   : canvas
    Created on : 10-Mar-2016, 19:39:45
    Author     : Lenovo
--%>



<%@page import="calculation.findAngle"%>
<%@page import="calculation.findCoords"%>
<%@page import="Dto.GPS"%>
<%@page import="calculation.haversineFormula"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Canvas Test</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <%

        haversineFormula h1 = new haversineFormula();
        findCoords f1 = new findCoords();
        findAngle a1 = new findAngle();
        //Pitch Coordinates
        GPS bottomLeft = new GPS(53.616262, -6.188280);
        GPS topLeft = new GPS(53.617005, -6.189024);
        GPS bottomRight = new GPS(53.616411, -6.187576);
        
        //Point to display on Canvas
        GPS pointToCheck = new GPS(53.61650333,-6.188365);

        //pitch height in metres
        double pitchHeight = h1.haversine(bottomLeft.getLatitude(), bottomLeft.getLongitude(), topLeft.getLatitude(), topLeft.getLongitude());
        //pitch width in metres
        double pitchWidth = h1.haversine(bottomLeft.getLatitude(), bottomLeft.getLongitude(), bottomRight.getLatitude(), bottomRight.getLongitude());

        //Calculate range of angle from bottom right corner
        //to top left corner
        //find degree of error then normalise point so that it is within 0 to 90 degrees
        double degreeError = a1.getAngle(bottomLeft.getLatitude(), bottomLeft.getLongitude(), bottomRight.getLatitude(), bottomRight.getLongitude());
        double angleAllPitch = a1.getAngle(bottomLeft.getLatitude(), bottomLeft.getLongitude(), topLeft.getLatitude(), topLeft.getLongitude()) - degreeError;
        double factorToNormalise = (90 / angleAllPitch);

        //Hypotenuese length in metres
        double hypotenuse = h1.haversine(bottomLeft.getLatitude(), bottomLeft.getLongitude(), pointToCheck.getLatitude(), pointToCheck.getLongitude());

        double angleToPoint = a1.getAngle(bottomLeft.getLatitude(), bottomLeft.getLongitude(), pointToCheck.getLatitude(), pointToCheck.getLongitude()) - degreeError;
        double normalisedDegree = angleToPoint * factorToNormalise;

        double x = f1.findX(normalisedDegree, hypotenuse);
        double y = f1.findY(normalisedDegree, hypotenuse);
        //Scale for display
        double widthScaled = pitchWidth * 5;
        double heightScaled = pitchHeight * 5;
        double scaledX = x * 5;
        double scaledY = y * 5;
    %>

    <body>
    <center>   <canvas id="myCanvas" width="<%=widthScaled%>" height="<%=heightScaled%>" style="border:3px solid black;">
            Your browser does not support the HTML5 canvas tag.
        </canvas></center>




    <script type="text/javascript">
        var c = document.getElementById("myCanvas");

        var ctx = c.getContext("2d");
        ctx.translate(0, c.height);
        ctx.scale(1, -1);

        ctx.beginPath();
              
        ctx.fillStyle="#FF0000"; 
        ctx.fillRect(<%=scaledX%>, <%=scaledY%>, 5, 5);

    </script>


    <h1>Degree Error: <%=degreeError%></h1>
    <h1>Pitch Width metres: <%=pitchWidth%></h1>
    <h1>Pitch Height metres: <%=pitchHeight%></h1>   
    <h1>Angle of point: <%=normalisedDegree%></h1>   
    <h1>X: <%=x%></h1>  
    <h1>Y: <%=y%></h1>  


</body>
</html>
