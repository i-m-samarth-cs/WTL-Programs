import java.io.*;
import jakarta.servlet.*;         // CORRECTED IMPORT
import jakarta.servlet.http.*;    // CORRECTED IMPORT
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQueryServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Delete Status</title></head>");
        out.println("<body>");

        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "Samarth2004@"); // Your credentials
            stmt = con.createStatement();

            String studRollStr = request.getParameter("SRoll");
            if (studRollStr != null && studRollStr.length() > 0) {
                try {
                    int rollNo = Integer.parseInt(studRollStr);
                    String sql = "DELETE FROM students_table WHERE Roll_no = " + rollNo;
                    int rowsAffected = stmt.executeUpdate(sql);
                    if (rowsAffected > 0) {
                        out.println("<h2>Record with Roll No. " + rollNo + " Deleted Successfully!</h2>");
                    } else {
                        out.println("<h2>No record found with Roll No. " + rollNo + ".</h2>");
                    }
                } catch (NumberFormatException e) {
                    out.println("<h2>Invalid Roll Number. Please enter a numeric value.</h2>");
                }
            } else {
                out.println("<h2>Please enter a Roll Number to delete.</h2>");
            }

        } catch (SQLException e) {
            out.println("<h2>Database Error:</h2><p>" + e.getMessage() + "</p>");
            e.printStackTrace(out);
        } catch (ClassNotFoundException e) {
            out.println("<h2>JDBC Driver Error:</h2><p>" + e.getMessage() + "</p>");
            e.printStackTrace(out);
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