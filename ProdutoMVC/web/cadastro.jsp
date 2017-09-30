<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <title>Cadastro de atividades</title>
</head>
<body>
<div class="container | center"><br><br>
    <h2>Atividade</h2>
    <div class="row">
        <form method="POST" action="salvar">
            <div class="row">
                <div class="input-field">
                    <c:choose>
                        <c:when test="${e.codigo == null}">
                            <input name="codigo" placeholder="Código" id="codigo"
                                   value="${e.codigo}">
                        </c:when>
                        <c:otherwise>
                            <input name="codigo" readonly placeholder="Código" id="codigo"
                                   value="${e.codigo}">
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="row">
                <div class="input-field">
                    <input class="validate" name="descricao" placeholder="Descrição" id="descricao" type="text"
                           required="true"
                           value="${e.descricao}">
                </div>
            </div>
            <div class="row">
                <div class="input-field">
                    <input name="estagio" placeholder="Estágio" id="estagio" type="text" required="true"
                           value="${e.estagio}">
                </div>
            </div>
            <button class="btn">Salvar</button>
        </form>
    </div>
    <br/>
</div>
</body>
</html>
