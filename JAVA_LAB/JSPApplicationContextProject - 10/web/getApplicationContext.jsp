<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Get application context
    ServletContext context = application;

    // Retrieve the stored attribute
    String university = (String) context.getAttribute("university");

    out.println("<h3>Retrieved Application Context Attribute:</h3>");
    out.println("<p>University Name: " + university + "</p>");
%>
<a href="index.jsp">Back to Home</a>
