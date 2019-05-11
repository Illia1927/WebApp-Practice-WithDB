<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 08.05.2019
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <title>add good page</title>
</head>
<body>
<div class="login">
    <form method="POST"
          action="${pageContext.request.contextPath}/getAllGood" modelattribute="userRegistrationInput">
        <input type="text" name="nameOfGood" placeholder="nameOfGood" required="required"/>
        <input type="text" name="description" placeholder="description" required="required"/>
        <input type="number" name="price" placeholder="price" required="required"/>
        <button type="submit" class="btn btn-primary btn-block btn-large">add good</button>
    </form>
</div>
<script src="js/index.js"></script>
</body>
</html>
