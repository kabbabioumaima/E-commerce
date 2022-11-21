package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class page_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Home page</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("    <style>\n");
      out.write("        nav \n");
      out.write("{\n");
      out.write("    margin: 100px auto;\n");
      out.write("    width: 50%;\n");
      out.write("    height: 150px;\n");
      out.write("  \n");
      out.write("}\n");
      out.write(" \n");
      out.write("nav .main_pages \n");
      out.write("{\n");
      out.write("    display: flex;\n");
      out.write("    justify-content: space-around;\n");
      out.write("    align-items: center;\n");
      out.write("}\n");
      out.write(" \n");
      out.write("nav .main_pages a \n");
      out.write("{\n");
      out.write("    width: 50%;\n");
      out.write("    display: flex;\n");
      out.write("    align-items: center;\n");
      out.write("    justify-content: center;\n");
      out.write("    height: 100px;\n");
      out.write("    text-decoration: none;\n");
      out.write("    font-family: Trebuchet MS;\n");
      out.write("    font-size: xx-large;\n");
      out.write("    color: white;\n");
      out.write("    font-weight: 300;\n");
      out.write("}\n");
      out.write(" body {\n");
      out.write("     background-image: url(\"logos.jpg\");\n");
      out.write("     }\n");
      out.write("nav a:hover \n");
      out.write("{\n");
      out.write("    background: #000000;\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <nav>\n");
      out.write("        <div class=\"main_pages\">\n");
      out.write("          \n");
      out.write("            <a href=login.jsp>Admin login</a>\n");
      out.write("            <a href=\"loginClient.jsp\">Client login </a>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
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
