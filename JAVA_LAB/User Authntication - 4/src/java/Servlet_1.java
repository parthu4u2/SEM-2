import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_1")
public class Servlet_1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet_1() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("uid");
        String passWord = request.getParameter("pwd");

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM credit WHERE username = ? AND password = ?")) {

            pst.setString(1, userName);
            pst.setString(2, passWord);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                out.println("<h3>Login Successful!</h3>");
            } else {
                out.println("<h3>Invalid Username or Password</h3>");
            }
            rs.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
