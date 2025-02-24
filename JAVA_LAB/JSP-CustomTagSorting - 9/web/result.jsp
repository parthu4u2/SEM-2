<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" uri="/WEB-INF/tlds/customtags.tld" %>

<% 
    String numbers = request.getParameter("numbers");
    String order = request.getParameter("order");
%>

<html>
<head>
    <title>Sorted Numbers</title>
</head>
<body>
    <h2>Sorted Numbers Result</h2>

    <ct:sortNumbers numbers="<%= numbers %>" order="<%= order %>"/>
    
    <br><br>
    <a href="index.jsp">Go Back</a>
</body>
</html>
