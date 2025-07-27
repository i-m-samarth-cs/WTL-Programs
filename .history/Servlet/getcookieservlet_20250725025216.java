import java.io.*;
import jakarta.servlet.*; // Changed from javax.servlet.*
import jakarta.servlet.http.*; // Changed from javax.servlet.http.*

public class getcookieServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Cookie[] my_cookies = req.getCookies();
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Get Cookie</title></head>");
        out.println("<body>");
        out.println("<h1>Cookies Found:</h1>");
        out.println("<ul>"); // Use unordered list for better formatting

        if (my_cookies != null) {
            for (int i = 0; i < my_cookies.length; i++) {
                String name = my_cookies[i].getName();
                String value = my_cookies[i].getValue();
                out.println("<li><b>Name:</b> " + name + ", <b>Value:</b> " + value + "</li>");
            }
        } else {
            out.println("<li>No cookies found!</li>");
        }
        out.println("</ul>");
        out.println("<p><a href=\"index.html\">Go back to set cookie</a></p>"); // Link back to the form
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}