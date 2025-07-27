import javax.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class LifeCycle extends GenericServlet {
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter out = response.getWriter();
        out.println("Twinkle Twinkle Little Stars.");
        out.print("How I wonder what you are.");
    }

    public void destroy() {
        System.out.println("destroy");
    }
}