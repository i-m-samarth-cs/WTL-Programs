import java.io.*;
import javax.servlet.*;

public class DynamicServletDemo extends GenericServlet {
    // implement service()
    public void service(ServletRequest req, ServletResponse res)
            throws IOException, ServletException {
        // set response content type
        res.setContentType("text/html");
        // get stream obj
        PrintWriter out = res.getWriter();
        java.util.Date date = new java.util.Date();
        out.println("<h2>" + "Current Date & Time: " + date.toString() + "</h2>");
        // close stream object
        out.close();
    }
}