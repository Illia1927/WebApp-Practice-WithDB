<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 29.04.2019
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <title>UpdateUser</title>
</head>
<body>
<div class="login">
    <form action="<c:url value="/updateUser"/>" method="POST">
        <input type="hidden" name="userId" value="${param.userId}">
        <input type="text" name="name" placeholder="Name">
        <input type="text" name="login" placeholder="Login">
        <input type="text" name="email" placeholder="Email">
        <input type="password" name="password" placeholder="Password">
        <input type="text" name="role" placeholder="Role">
    <input type="submit" value="Update">
</form>
</div>
<script src="js/index.js"></script>
</body>
</html>
