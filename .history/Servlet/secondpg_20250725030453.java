import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class secondpg extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user_name");
        out.println("<h3>Welcome " + user + " to main page!!!</h3>");
    }
}