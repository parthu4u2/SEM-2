
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExamResult")
public class ExamResult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            int m1 = Integer.parseInt(request.getParameter("subj1"));
            int m2 = Integer.parseInt(request.getParameter("subj2"));
            int m3 = Integer.parseInt(request.getParameter("subj3"));
            int m4 = Integer.parseInt(request.getParameter("subj4"));
            int m5 = Integer.parseInt(request.getParameter("subj5"));
            int m6 = Integer.parseInt(request.getParameter("subj6"));

            float avg = (m1 + m2 + m3 + m4 + m5 + m6) / 6.0f;
            char grade = avg >= 90 ? 'A' : avg >= 70 ? 'B' : avg >= 60 ? 'C' : 'F';

            String name = "Unknown", id = "Unknown", dept = "Unknown";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("nm")) {
                        name = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                    }
                    if (cookie.getName().equals("id")) {
                        id = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                    }
                    if (cookie.getName().equals("dept")) {
                        dept = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                    }
                }
            }

            out.println("<html><body>");
            out.println("<h2>Exam Result</h2>");
            out.println("<p><b>Name:</b> " + name + "</p>");
            out.println("<p><b>ID:</b> " + id + "</p>");
            out.println("<p><b>Department:</b> " + dept + "</p>");
            out.println("<p><b>Average Marks:</b> " + avg + "</p>");
            out.println("<p><b>Grade:</b> " + grade + "</p>");
            out.println("</body></html>");
        }
    }
}
