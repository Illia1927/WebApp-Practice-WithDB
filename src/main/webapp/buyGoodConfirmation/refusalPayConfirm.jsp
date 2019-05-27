<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 10.05.2019
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>refusal confirm</title>
</head>
<body>
<h>payment is declined, please check your one-time code in Email</h>
<div>
    <a href="${pageContext.request.contextPath}/buyGoodConfirmation/buyConfirmation.jsp">
        <form method="POST"
              action="${pageContext.request.contextPath}/buyGoodConfirmation/buyConfirmation.jsp">
            <input type="submit" value=" Try again ">
        </form>
    </a>
</div>
</body>
</html>
