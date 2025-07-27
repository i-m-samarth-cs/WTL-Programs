
import java.io.*;
import jakarta.servlet.*; // Changed from javax.servlet.*
import jakarta.servlet.http.*; // Changed from javax.servlet.http.*

public class mycookieservlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String txt_data = req.getParameter("txt_data");
        // Create cookie.
        Cookie cookie = new Cookie("My_Cookie", txt_data);
        // Adding cookie to HTTP response.
        res.addCookie(cookie);

        // Write friendly output to browser.
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Cookie Set</title></head>");
        out.println("<body>");
        out.println("<h2>MyCookie has been set to : ");
        out.println(txt_data);
        out.println("</h2>"); // Close h2 tag
        out.println("<br><br>"); // Use <br> for HTML line breaks
        out.println("This page shows that the cookie has been added");
        out.println("<p><a href=\"get_cookie\">Click here to get the cookie</a></p>"); // Link to getcookieservlet
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}