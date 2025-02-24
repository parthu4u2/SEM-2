<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="beans.BankAccount" %>
<jsp:useBean id="account" class="beans.BankAccount" scope="session" />
<%
 String action = request.getParameter("action");

    if (action != null) {
        try {
            if ("Deposit".equals(action)) {
                String depositAmountStr = request.getParameter("depositAmount");
                if (depositAmountStr != null && !depositAmountStr.isEmpty()) {
                    double depositAmount = Double.parseDouble(depositAmountStr);
                    account.deposit(depositAmount);
                    out.println("<script>alert('Deposit successful!'); window.location='index.jsp';</script>");
                } else {
                    out.println("<script>alert('Please enter a valid deposit amount.'); window.location='index.jsp';</script>");
                }
            } else if ("Withdraw".equals(action)) {
                String withdrawAmountStr = request.getParameter("withdrawAmount");
                if (withdrawAmountStr != null && !withdrawAmountStr.isEmpty()) {
                    double withdrawAmount = Double.parseDouble(withdrawAmountStr);
                    if (!account.withdraw(withdrawAmount)) {
                        out.println("<script>alert('Insufficient Balance!'); window.location='index.jsp';</script>");
                    } else {
                        out.println("<script>alert('Withdrawal successful!'); window.location='index.jsp';</script>");
                    }
                } else {
                    out.println("<script>alert('Please enter a valid withdrawal amount.'); window.location='index.jsp';</script>");
                }
            }
        } catch (NumberFormatException e) {
            out.println("<script>alert('Invalid amount format! Please enter a valid number.'); window.location='index.jsp';</script>");
        }
    } else {
        response.sendRedirect("index.jsp");
    }
%>
