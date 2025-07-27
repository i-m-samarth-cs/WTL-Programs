import java.io.*;
import jakarta.servlet.*;         // CORRECTED IMPORT
import jakarta.servlet.http.*;    // CORRECTED IMPORT
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQueryServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Insert Status</title></head>");
        out.println("<body>");

        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Modern JDBC Driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "Samarth2004@"); // Your credentials
            stmt = con.createStatement();

            String studName = request.getParameter("Sname");
            String studAddress = request.getParameter("Sadd");
            String studPhone = request.getParameter("Sph");

            if (studName != null && studAddress != null && studPhone != null && studName.length() > 0) {
                String sql = "INSERT INTO students_table(name, address, phone) VALUES('"
                           + studName + "','" + studAddress + "','" + studPhone + "')";
                int rowsAffected = stmt.executeUpdate(sql);
                if (rowsAffected > 0) {
                    out.println("<h2>Record Inserted Successfully!</h2>");
                } else {
                    out.println("<h2>Failed to Insert Record.</h2>");
                }
            } else {
                out.println("<h2>Please fill all fields to insert a record.</h2>");
            }

        } catch (SQLException e) {
            out.println("<h2>Database Error:</h2><p>" + e.getMessage() + "</p>");
            e.printStackTrace(out); // For debugging
        } catch (ClassNotFoundException e) {
            out.println("<h2>JDBC Driver Error:</h2><p>" + e.getMessage() + "</p>");
            e.printStackTrace(out); // For debugging
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace(out);
            }
        }
        out.println("<p><a href=\"javascript:history.back()\">Go Back</a></p>");
        out.println("<p><a href=\"DisplayRecordsServlet\" target=\"_self\">View All Records</a></p>");
        out.println("</body></html>");
        out.close();
    }
}