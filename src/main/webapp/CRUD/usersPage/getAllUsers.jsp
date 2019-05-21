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
    <title>GetAll</title>
</head>
<body style="color: blueviolet">
<br>
    <table align="center" border="2">
        <tr>
            <td><a href="CRUD/usersPage/addUser.jsp">Add User</a></td>
        </tr>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Login</th>
            <th>Email</th>
            <th>Password</th>
            <th>Role</th>
            <th>Delete user</th>
            <th>Update user</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getUserId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getLogin()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getRole()}</td>
                <td><a href="${pageContext.request.contextPath}/deleteUser?userId=${user.getUserId()}">Delete user</a></td>
                <td><a href="${pageContext.request.contextPath}/CRUD/usersPage/updateUser.jsp?userId=${user.getUserId()}">Update User</a></td>
            </tr>
        </c:forEach>
    </table>
<br>
<p>
<div class="btn-large">
    <a href="${pageContext.request.contextPath}/admin/adminPage.jsp">
        <form method="GET"
              action="${pageContext.request.contextPath}/admin/adminPage.jsp">
            <button type="submit" class="btn btn-primary btn-block btn-large">Go back</button>
        </form>
    </a>
</div>
</p>
</body>
</html>
