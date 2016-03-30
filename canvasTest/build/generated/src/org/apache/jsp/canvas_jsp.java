package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import calculation.findAngle;
import calculation.findCoords;
import Dto.GPS;
import calculation.haversineFormula;

public final class canvas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Canvas Test</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    ");


        haversineFormula h1 = new haversineFormula();
        findCoords f1 = new findCoords();
        findAngle a1 = new findAngle();

        GPS bottomLeft = new GPS(53.616262, -6.188280);
        GPS topLeft = new GPS(53.617005, -6.189024);
        GPS bottomRight = new GPS(53.616411, -6.187576);

        GPS pointToCheck = new GPS(53.616758, -6.188260);

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
    
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("    <center>   <canvas id=\"myCanvas\" width=\"");
      out.print(widthScaled);
      out.write("\" height=\"");
      out.print(heightScaled);
      out.write("\" style=\"border:3px solid black;\">\n");
      out.write("            Your browser does not support the HTML5 canvas tag.\n");
      out.write("        </canvas></center>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        var c = document.getElementById(\"myCanvas\");\n");
      out.write("\n");
      out.write("        var ctx = c.getContext(\"2d\");\n");
      out.write("        ctx.translate(0, c.height);\n");
      out.write("        ctx.scale(1, -1);\n");
      out.write("\n");
      out.write("        ctx.beginPath();\n");
      out.write("              \n");
      out.write("        ctx.fillStyle=\"#FF0000\"; \n");
      out.write("        ctx.fillRect(");
      out.print(scaledX);
      out.write(',');
      out.write(' ');
      out.print(scaledY);
      out.write(", 5, 5);\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <h1>Degree Error: ");
      out.print(degreeError);
      out.write("</h1>\n");
      out.write("    <h1>Pitch Width m/s: ");
      out.print(pitchWidth);
      out.write("</h1>\n");
      out.write("    <h1>Pitch Height m/s: ");
      out.print(pitchHeight);
      out.write("</h1>   \n");
      out.write("    <h1>Angle of point: ");
      out.print(normalisedDegree);
      out.write("</h1>   \n");
      out.write("    <h1>X: ");
      out.print(x);
      out.write("</h1>  \n");
      out.write("    <h1>Y: ");
      out.print(y);
      out.write("</h1>  \n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
