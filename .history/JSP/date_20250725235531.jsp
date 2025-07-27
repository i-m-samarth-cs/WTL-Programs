<%@page language="java" contentType="text/html"%>
<html>
<head>
    <title>Date Display</title>
</head>
<body>
    <h1>Current Date and Time</h1>
    <p>
        <%
            out.print("Today's date is: " + new Date());
        %>
    </p>
</body>
</html>