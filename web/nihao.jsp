<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 27.04.2019
  Time: 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>

    <title>Login Form</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</head>
<body>
<div class="login">
<h1>Welcome, dear <%=request.getAttribute("name")%>!</h1>

<a href="${pageContext.request.contextPath}/login">
    <form method="GET"
          action="${pageContext.request.contextPath}/login">
        <input type="submit" value=" Go to login ">
    </form>
</a>
    <a href="${pageContext.request.contextPath}/goods">
        <form method="GET"
              action="${pageContext.request.contextPath}/goods">
            <input type="submit" value=" Goods page ">
        </form>
    </a>
    <a href="${pageContext.request.contextPath}/home">
        <form method="GET"
              action="${pageContext.request.contextPath}/home">
            <button type="submit" class="btn btn-primary btn-block btn-large">Go back home</button>
        </form>
    </a>
</div>
<script src="js/index.js"></script>
</body>
</html>
