<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 10.05.2019
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pay confirm</title>
</head>
<body>
<h1>Payment successfully completed</h1>
<div>
<a href="${pageContext.request.contextPath}/user/helloPage.jsp">
    <form method="POST"
          action="${pageContext.request.contextPath}/user/helloPage.jsp">
        <input type="submit" value=" back to home page ">
    </form>
</a>
</div>
</body>
</html>
