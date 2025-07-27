<html>
<head>
<title>Use of Bean with session scope</title>
</head>
<body>
<jsp:useBean id="bean_id" class="CounterDemo" scope="session" />
<%
    bean_id.setCount(bean_id.getCount() + 1);
%>
Your count is now <%= bean_id.getCount() %>
</body>
</html>
