import java.io.*;
import jakarta.servlet.*; // Changed from javax.servlet.*
import jakarta.servlet.http.*; // Changed from javax.servlet.http.*

public class my_choiceservlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String lang = req.getParameter("Language");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Language Selection</title></head>");
        out.println("<body>");
        out.println("<h1>The selected language is " + lang + "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}