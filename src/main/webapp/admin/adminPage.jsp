<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 02.05.2019
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class="login">
    <br>
    <p align="center" style="color: chartreuse">Hello, dear administrator : <c:out value="${sessionScope.user.name}"/>!</p>

    <a href="${pageContext.request.contextPath}/getAll">
        <form method="POST"
              action="${pageContext.request.contextPath}/getAll">
            <input type="submit" value=" Work with users ">
        </form>
    </a>
    <a href="${pageContext.request.contextPath}/goods">
        <form method="POST"
              action="${pageContext.request.contextPath}/goods">
            <input type="submit" value=" Work with good ">
        </form>
    </a>
    <a href="${pageContext.request.contextPath}/user/helloPage.jsp">
        <form method="POST"
              action="${pageContext.request.contextPath}/user/helloPage.jsp">
            <input type="submit" value=" Hello ">
        </form>
    </a>
</div>
<script src="js/index.js"></script>
</body>
</html>
