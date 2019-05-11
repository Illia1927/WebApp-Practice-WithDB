<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 11.05.2019
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <title>update goods</title>
</head>
<body>
<div class="login">
    <form action="<c:url value="/updateGood"/>" method="POST">
        <input type="hidden" name="goodId" value="${param.goodId}">
        <input type="text" name="nameOfGood" placeholder="Name of good">
        <input type="text" name="description" placeholder="Description">
        <input type="number" name="price" placeholder="Price">
        <input type="submit" value="Update">
    </form>
</div>
<script src="js/index.js"></script>
</body>
</html>
