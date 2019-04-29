<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 28.04.2019
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <title>GetAll</title>
    <style type="text/css">
        table {
            background: maroon;
            color: white;
        }
        td {
            background: navy;
        }
    </style>
</head>
<p>
<div>
    <br>

    <form method="POST">
    <table align="center" border="2">
        <a href="addUser.jsp">Add User</a>
        <a href="updateUser.jsp">Update User</a>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.users_id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.login}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><a href="/deleteUser?users_id=${user.users_id}">Delete user</a></td>
            </tr>
        </c:forEach>
    </table>
    </form>
</div>
<br>
<br>
<br>
<p>
<div class="btn-large">
    <a href="${pageContext.request.contextPath}/home">
        <form method="GET"
              action="${pageContext.request.contextPath}/home">
            <button type="submit" class="btn btn-primary btn-block btn-large">Go back home</button>
        </form>
    </a>
</div>
</p>
<script src="js/index.js"></script>
</body>
</html>
