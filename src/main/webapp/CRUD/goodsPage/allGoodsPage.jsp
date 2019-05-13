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
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <title>all goods page</title>
</head>
<body>
<div>
    <br>
    <br>
    <br>
<table align="center" border="2" style="color: salmon">
    <tr>
        <td><a href="CRUD/goodsPage/addGoodPage.jsp" style="color: green">Add Good</a></td>
    </tr>
    <tr>
        <th>ID</th>
        <th>Name of good</th>
        <th>Description</th>
        <th>Price</th>
        <th>Buy</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach items="${goods}" var="good">
        <tr>
            <td>${good.goodId}</td>
            <td>${good.nameOfGood}</td>
            <td>${good.discription}</td>
            <td>${good.price}</td>
            <td><a href='buy?goodId=${good.goodId}' style="color: green">Buy</a></td>
            <td><a href="${pageContext.request.contextPath}/deleteGood?goodId=${good.getGoodId()}">Delete good</a></td>
            <td><a href="CRUD/goodsPage/updateGoods.jsp?goodId=${good.goodId}" style="color: green">Update goods</a></td>
        </tr>
    </c:forEach>
</table>
</div>
<script src="js/index.js"></script>
</body>
</html>
