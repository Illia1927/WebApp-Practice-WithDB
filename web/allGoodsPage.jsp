<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 02.05.2019
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
<table align="center" border="2">
    <tr>
        <th>ID</th>
        <th>Name of good</th>
        <th>Description</th>
        <th>Price</th>
        <th>Buy</th>
    </tr>
    <c:forEach items="${goods}" var="good">
        <tr>
            <td>${good.id}</td>
            <td>${good.nameOfGood}</td>
            <td>${good.discription}</td>
            <td>${good.price}</td>
            <td><a href='buy?id=${good.id}'>Buy</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
