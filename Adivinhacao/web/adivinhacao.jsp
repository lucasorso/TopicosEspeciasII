<%--
  Created by IntelliJ IDEA.
  User: LucasOrso
  Date: 9/6/17
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Jogando</title>
</head>
<body>
<form action="ServletRiddle" method="post">
    <div align="center">
        <h1>Insira um numero de 1 a 100</h1>
        <p align="center">
            Numero de tentativas ${tentativas}.
        </p>
        <strong>Numero:</strong>
        <input name="numero">
        </br>
        <p align="center">
            Você ${acerto}
        </p>
        <button>
            Jogar
        </button>
    </div>
</form>
</body>
</html>
