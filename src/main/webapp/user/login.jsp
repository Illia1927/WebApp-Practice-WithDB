<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 22.04.2019
  Time: 23:43
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
    <h1>Login</h1>
    <form method="POST"
          action="${pageContext.request.contextPath}/login">
        <span class="fontawesome-user"></span>
        <input name="name" type="text" class="form-control" placeholder="name"/>
        <span class="fontawesome-lock"></span>
        <input name="password" type="password" class="form-control" placeholder="password"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <a href="${pageContext.request.contextPath}/login">
            <form method="GET"
                  action="${pageContext.request.contextPath}/login">
                <input type="submit" value=" Let me in ">
            </form>
        </a>
    </form>
    <a href="${pageContext.request.contextPath}/registration">
        <form method="GET"
              action="${pageContext.request.contextPath}/registration">
            <input type="submit" value=" Go to registration ">
        </form>
    </a>
</div>

<script src="js/index.js"></script>
</body>

</html>