
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExamInfo")
public class ExamInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String dept = request.getParameter("dept");

        // Encode cookie values to prevent illegal characters
        Cookie nameCookie = new Cookie("nm", URLEncoder.encode(name, StandardCharsets.UTF_8));
        Cookie idCookie = new Cookie("id", URLEncoder.encode(id, StandardCharsets.UTF_8));
        Cookie deptCookie = new Cookie("dept", URLEncoder.encode(dept, StandardCharsets.UTF_8));

        // Set expiry time
        nameCookie.setMaxAge(60 * 60); // 1 hour
        idCookie.setMaxAge(60 * 60);
        deptCookie.setMaxAge(60 * 60);

        // Add cookies to response
        response.addCookie(nameCookie);
        response.addCookie(idCookie);
        response.addCookie(deptCookie);

        // Redirect to the result page
        response.sendRedirect("result.html");
    }
}
