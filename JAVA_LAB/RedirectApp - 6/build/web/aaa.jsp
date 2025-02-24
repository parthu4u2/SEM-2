<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirect Page</title>
    </head>
    <body>
        <%
          String u = request.getParameter("uu");
          if (u != null && (u.startsWith("http://") || u.startsWith("https://"))) {
              response.sendRedirect(u);
          } else {
        %>
            <h3 style="color: red;">Invalid URL! Please enter a valid URL with "http://" or "https://"</h3>
            <a href="index.html">Go Back</a>
        <%
          }
        %>
    </body>
</html>
