<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 06.05.2019
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Input the code</h2>
<form method="POST">
    <input hidden type="text" name="goodId" value="<c:out value="${goodId}"/>">
    <input type="password" title="сode" name="code"/>
    <input type="submit"/>
</form>
</body>
</html>
