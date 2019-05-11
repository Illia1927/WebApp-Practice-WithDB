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
    <title>Title</title>
</head>
<body>
<div>
    <form goodId="add_goods" action="${pageContext.request.contextPath}/getAllGood" method="post">
        Name of good <input type="text" name="nameOfGood">
        Description <input type="text" name="description">
        Price <input type="number" name="price">
    </form>
</div>
<div class="button">
    <input type="submit" form="add_goods" value="Add">
</div>
</body>
</html>
