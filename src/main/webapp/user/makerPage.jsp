<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 27.04.2019
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <title>maker page</title>
    <style>
        p {
            border: 10px solid green;
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="login">
    <a href="${pageContext.request.contextPath}/home">
        <form method="GET"
              action="${pageContext.request.contextPath}/home">
            <button type="submit" class="btn btn-primary btn-block btn-large">Go back home</button>
        </form>
    </a>
<p align="center" style="color: azure"><em><b>This is a href on instagram of author:</b></em>
    <br>
    <br>
    <a href="https://www.instagram.com/moroz_ilya_20/">
        <img src="instagram_PNG12.png" width="50"
             height="50" alt="Just press">
    </a>
</p>
<div align="center">
    <img src="original.jpg" width="1000" height="500" alt="MAU INTERNATIONAL">
</div>
</div>
<script src="js/index.js"></script>
</body>
</html>
