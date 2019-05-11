<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 06.05.2019
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: #670d10">Access Denied</h1>
<a href="${pageContext.request.contextPath}/user/helloPage.jsp">
    <form method="GET"
          action="${pageContext.request.contextPath}/user/helloPage.jsp">
        <button type="submit" class="btn btn-primary btn-block btn-large">Go back home</button>
    </form>
</a>
</body>
</html>
