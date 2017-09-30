<%-- 
    Document   : listagem
    Created on : 27/09/2017, 19:49:19
    Author     : Lucas Orso
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head id="header_listagem">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Listagem</title>
</head>
<body>
<div class="container" align="center">
    <br>
    <h4>Lista de Atividades</h4>
    <br>
    <table id="table" class="striped | centered | bordered">
        <thead>
        <tr>
            <th id="codigo">Código</th>
            <th id="descricao">Descrição</th>
            <th id="estagio">Estágio</th>
            <th id="dataCadastro">Data de cadastro</th>
            <th class="col s12">Ações</th>
        <tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${lista}">
            <tr>
                <td>${e.codigo}</td>
                <td>${e.descricao}</td>
                <td>${e.estagio}%</td>
                <td>${e.dataCadastro}</td>
                <td class="row | centered">
                    <div class="col s6"><a class="waves-effect waves-teal btn-flat" href="editar?codigo=${e.codigo}">Editar</a>
                    </div>
                    <div class="col s6"><a class="waves-effect waves-teal btn-flat" href="remover?codigo=${e.codigo}">Excluir</a>
                    </div>
                    <div class="col s6"><a class="waves-effect waves-teal btn-flat" href="concluir?codigo=${e.codigo}">Concluir</a>
                    </div>
                    <div class="col s6"><a class="waves-effect waves-teal btn-flat" href="notas?codigo=${e.codigo}">Notas</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <div align="right">
        <a href="novo" class="btn-floating btn-large waves-effect waves-light"><i class="material-icons">add</i></a>
    </div>
    <br>
</div>
</body>
</html>
