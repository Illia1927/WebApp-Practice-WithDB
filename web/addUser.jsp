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
    <title>addUser</title>
</head>
<body>
<div>
    <form method="POST"
          action="${pageContext.request.contextPath}/registration" modelattribute="userRegistrationInput">
        <input type="text" name="name" placeholder="name" required="required"/>

        <input type="text" name="login" placeholder="login" required="required"/>

        <input type="text" name="email" placeholder="email" required="required"/>

        <input type="password" name="password" placeholder="password" required="required"/>

        <button type="submit" class="btn btn-primary btn-block btn-large">add user</button>
    </form>

</div>
</body>
</html>
