<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 29.04.2019
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit page</title>
</head>
<h3>Edit user</h3>

<a href="${pageContext.request.contextPath}/getAll">
    <form method="GET"
          action="${pageContext.request.contextPath}/getAll">
        <input type="submit" value=" get all users ">
    </form>
</a>
<a href="${pageContext.request.contextPath}/home">
    <form method="GET"
          action="${pageContext.request.contextPath}/home">
        <button type="submit" class="btn btn-primary btn-block btn-large">Go back home</button>
    </form>
</a>
</body>
</html>
