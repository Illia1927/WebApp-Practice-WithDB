<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 29.04.2019
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <title>addUser</title>
</head>
<body>
<div>
    <form method="POST" class="login"
          action="${pageContext.request.contextPath}/addUser" modelattribute="userRegistrationInput">
        <input type="text" name="name" placeholder="name" required="required"/>
        <input type="text" name="login" placeholder="login" required="required"/>
        <input type="text" name="email" placeholder="email" required="required"/>
        <input type="password" name="password" placeholder="password" required="required"/>
        <input type="text" name="role" placeholder="role" required="required"/>
        <button type="submit" class="btn btn-primary btn-block btn-large">add user</button>
    </form>
</div>
<script src="js/index.js"></script>
</body>
</html>
