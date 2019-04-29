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
    <title>UpdateUser</title>
</head>
<body>
<div>
<form action="/updateUser" method="POST">
    Id<input type="hidden" name="users_id" value="${users_id}"> <br>
    Name <input type="text" name="name"> <br>
    login <input type="text" name="login"> <br>
    Email <input type="text" name="email"> <br>
    Password <input type="text" name="password"> <br>
    <input type="submit" value="Update">
</form>
</div>
</body>
</html>
