<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome Page</title>
</head>
<body>
    <%
        String un = (String) session.getAttribute("un");
        if (un == null) {
            response.sendRedirect("index.html");
        } else {
    %>
        <h2>Welcome, <%= un %>!</h2>
        <form action="logout" method="post">
            <input type="submit" value="Logout">
        </form>
    <% } %>
</body>
</html>
