<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Get application context
    ServletContext context = application;

    // Set an attribute in application scope
    context.setAttribute("university", "Parul University");

    out.println("<h3>Application Context Attribute Set Successfully!</h3>");
%>
<a href="getApplicationContext.jsp">Go to Get Page</a>
