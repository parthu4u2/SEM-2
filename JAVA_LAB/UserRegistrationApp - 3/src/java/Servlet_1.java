import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_1")
public class Servlet_1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String birthDate = request.getParameter("birthDate");
        String emailId = request.getParameter("emailId");
        String contactNo = request.getParameter("contactNo");

        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO user (name, birthdate, email, contact) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, userName);
                pst.setString(2, birthDate);
                pst.setString(3, emailId);
                pst.setString(4, contactNo);

                int rows = pst.executeUpdate();
                if (rows > 0) {
                    response.sendRedirect("/UserRegistrationApp/Servlet_2");
                } else {
                    out.println("<font color='red'>Unable to insert data</font>");
                }
            }
        } catch (SQLException e) {
            out.println("<font color='red'>Error: " + e.getMessage() + "</font>");
        }
    }
}
