<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Cadastro de notas</title>
</head>
<body>
<div class="container">
    <br>
    <h2>Nota</h2>
    <h4>Atividade: (${e.codigo} - ${e.descricao})</h4>
    <br>
    <div class="row">
        <form method="POST" action="salvarNota">
            <div class="row">
                <div>
                    <label>
                        <input name="codigoAtv" readonly value="${e.codigo}">
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="input-field">
                    <c:choose>
                        <c:when test="${n.codigo == null}">
                            <input name="codigo" placeholder="Código" id="codigo" type="text" required="true"
                                   value="${n.codigo}">
                        </c:when>
                        <c:otherwise>
                            <input name="codigo" readonly placeholder="Código" id="codigo" type="text" required="true"
                                   value="${n.codigo}">
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="row">
                <div class="input-field">
                    <input name="descricao" placeholder="Descrição" id="descricao" type="text" required="true"
                           value="${n.descricaoNota}">
                </div>
            </div>
            <div class="row">
                <button class="waves-effect waves-light btn" href="notas"><i
                        class="material-icons left">keyboard_arrow_left</i>Voltar
                </button>
                <button class="waves-effect waves-light btn"><i class="material-icons left">save</i>Salvar
                    nota
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
