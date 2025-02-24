<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Custom Tag Sorting</title>
</head>
<body>
    <h2>Enter 10 Numbers (comma separated)</h2>
    <form action="result.jsp" method="post">
        <label>Numbers:</label>
        <input type="text" name="numbers" required placeholder="e.g. 5, 2, 9, 1, 3, 8, 7, 4, 6, 0"/><br><br>
        
        <label>Sort Order:</label>
        <select name="order">
            <option value="asc">Ascending</option>
            <option value="desc">Descending</option>
        </select><br><br>

        <input type="submit" value="Sort Numbers"/>
    </form>
</body>
</html>
