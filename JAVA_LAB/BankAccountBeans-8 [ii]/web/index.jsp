<%@ page language="java" import="beans.BankAccount" %>
<jsp:useBean id="account" class="beans.BankAccount" scope="session" />
<jsp:setProperty name="account" property="accountHolder" param="name" />
<html>
<head>
 <title>Bank Account</title>
</head>
<body>
 <h2>Welcome, <jsp:getProperty name="account" property="accountHolder" /></h2>
 <p>Current Balance: <jsp:getProperty name="account" property="balance" /></p>
 <form action="process.jsp" method="post">
 <label>Deposit Amount:</label>
 <input type="text" name="depositAmount">
 <input type="submit" name="action" value="Deposit">
 </form>
 <form action="process.jsp" method="post">
 <label>Withdraw Amount:</label>
 <input type="text" name="withdrawAmount">
 <input type="submit" name="action" value="Withdraw">
 </form>
</body>
</html>
