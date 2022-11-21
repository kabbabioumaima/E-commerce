package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entities.Produit;
import service.ProduitService;
import java.util.List;

public final class catalogue_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"http://nicesnippets.com/demo/jsCarousel-2.0.0.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"custom.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                font-family: 'Raleway', sans-serif;\n");
      out.write("                background-color:#87CEEB;\n");
      out.write("                margin: 0px;\n");
      out.write("            }\n");
      out.write("            body h1.title{\n");
      out.write("                text-align: center;\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("            .visible{\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            .hidden{\n");
      out.write("                display: none;\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("            .product-box{\n");
      out.write("                background-color: #f1f1f1;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .product-desc{\n");
      out.write("                font-weight: bold;\n");
      out.write("                padding: 10px 0px;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .product-desc h5{\n");
      out.write("                margin: 0;\n");
      out.write("                color: #446AAF;\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("            .product-desc p{\n");
      out.write("                color: #3C3F39;\n");
      out.write("                margin: 10px 0px 8px;\n");
      out.write("            }\n");
      out.write("            .product-desc button{\n");
      out.write("                padding: 5px 15px;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                border: 1px solid #c1c1c1;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: #2868AF;\n");
      out.write("                background: linear-gradient(#FAFDFF, #E8E8E8);\n");
      out.write("                background: -moz-linear-gradient(#FAFDFF, #E8E8E8);\n");
      out.write("                background: -webkit-linear-gradient(#FAFDFF, #E8E8E8);\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-family: 'Raleway', sans-serif;\n");
      out.write("            }\n");
      out.write("            .jscarousal-horizontal{\n");
      out.write("                width: 90%;\n");
      out.write("                overflow: hidden;\n");
      out.write("                height: 400px;\n");
      out.write("                padding: 30px 30px;\n");
      out.write("                position: absolute;\n");
      out.write("                left: 50%;\n");
      out.write("                top: 60%;\n");
      out.write("                transform: translate(-50%, -50%);\n");
      out.write("            }\n");
      out.write("            .jscarousal-horizontal-back, .jscarousal-horizontal-forward{\n");
      out.write("                float: left;\n");
      out.write("                width: 23px;\n");
      out.write("                position: relative;\n");
      out.write("                top: 50px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                color: #5D5D5D;\n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("            .jscarousal-horizontal-forward{\n");
      out.write("                float: right;\n");
      out.write("            }\n");
      out.write("            .jscarousal-horizontal-back:before, .jscarousal-horizontal-forward:before{\n");
      out.write("                font-family: FontAwesome;\n");
      out.write("            }\n");
      out.write("            .jscarousal-horizontal-back:before{\n");
      out.write("                content: \"\\f053\";\n");
      out.write("            }\n");
      out.write("            .jscarousal-horizontal-forward:before{\n");
      out.write("                content: \"\\f054\";\n");
      out.write("            }\n");
      out.write("            .jscarousal-contents-horizontal{\n");
      out.write("                width: calc(100% - 50px);\n");
      out.write("                height: 100%;\n");
      out.write("                float: left;\n");
      out.write("                position: relative;\n");
      out.write("                overflow: hidden;\n");
      out.write("            }\n");
      out.write("            .jscarousal-contents-horizontal > .visible{\n");
      out.write("                position: absolute;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            .jscarousal-contents-horizontal > .visible > .product-box{\n");
      out.write("                float: left;\n");
      out.write("                margin: 0px 1%;\n");
      out.write("                width: 18%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .jscarousal-contents-horizontal img{\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            body {\n");
      out.write("  margin: 0;\n");
      out.write("  font-family: Arial, Helvetica, sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".topnav {\n");
      out.write("  overflow: hidden;\n");
      out.write("  background-color:  #000000;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".topnav a {\n");
      out.write("  float: left;\n");
      out.write("  color: #f2f2f2;\n");
      out.write("  text-align: center;\n");
      out.write("  padding: 14px 16px;\n");
      out.write("  text-decoration: none;\n");
      out.write("  font-size: 17px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".topnav a:hover {\n");
      out.write("  background-color: #B0C4DE;\n");
      out.write("  color: black;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".topnav a.active {\n");
      out.write("  background-color:#B0C4DE;\n");
      out.write("  color: white;\n");
      out.write("}\n");
      out.write("body {\n");
      out.write("  background-image: url('bluess.jpg');\n");
      out.write("  background-repeat: no-repeat;\n");
      out.write("  background-attachment: fixed;  \n");
      out.write("  background-size: cover;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"topnav\">\n");
      out.write("  <a class=\"active\" href=\"#home\">Home</a>\n");
      out.write("  <a href=\"#news\">News</a>\n");
      out.write("  <a href=\"#contact\">Contact</a>\n");
      out.write("  <a href=\"#about\">About</a>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div style=\"padding-left:16px\">\n");
      out.write("    \n");
      out.write("  <h2 style=\"font-size:30px; color:white; margin:10px;\">Our products</h2>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("        \n");
      out.write("        <br><br>\n");
      out.write("     \n");
      out.write("        <div id=\"product-slider\">");

            ProduitService ui = new ProduitService();
            List<Produit> pr = ui.findAll();
            for (int i = 0; i < pr.size(); i++) {
        
      out.write("\n");
      out.write("       \n");
      out.write("            <div class=\"product-box\">\n");
      out.write("               <img src=\"");
      out.print("images\\" + pr.get(i).getImage());
      out.write("\" alt=\"");
      out.print( pr.get(i).getNom());
      out.write("\" />\n");
      out.write("                <div class=\"product-desc\">\n");
      out.write("                    <h5>");
      out.print( pr.get(i).getNom());
      out.write("</h5>\n");
      out.write("                    <h5>");
      out.print(pr.get(i).getDescription() );
      out.write("</h5>\n");
      out.write("                    <h5>");
      out.print(pr.get(i).getPrix());
      out.write(" </h5>\n");
      out.write("                    <button>ADD TO CART</button>\n");
      out.write("                \n");
      out.write("                </div>\n");
      out.write("            </div>");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("     \n");
      out.write("</body>\n");
      out.write("</html>");
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
