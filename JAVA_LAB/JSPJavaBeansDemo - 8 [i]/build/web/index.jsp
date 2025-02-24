<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<jsp:setProperty name="user" property="*" />

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Enter User Details</h2>
    <form action="welcome.jsp" method="post">
        Username: <input type="text" name="username"><br><br>
        Password: <input type="password" name="password"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
