<jsp:useBean id="e" scope="request" type="model.atividade.Atividade"/>
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
    <h4>Lista de Notas da Atividade: (${e.codigo} - ${e.descricao})</h4>
    <br>
    <table class="striped | centered | bordered">
        <thead>
        <tr>
            <th id="codigo">Código</th>
            <th id="descricao">Nota</th>
            <th id="dataCadastro">Data de cadastro</th>
            <th>Ações</th>
        <tr>
        </thead>
        <tbody>
        <c:forEach var="f" items="${e.notasList}">
            <tr>
                <td>${f.codigo}</td>
                <td>${f.descricaoNota}</td>
                <td>${f.dataCadastro}</td>
                <td>
                    <a href="editarNota?codigoAtv=${e.codigo}&codigo=${f.codigo}"
                       class="waves-effect waves-teal btn-flat">Editar</a>
                    <a href="excluirNota?codigoAtv=${e.codigo}&codigo=${f.codigo}"
                       class="waves-effect waves-teal btn-flat">Excluir</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <div class="row">
        <a class="waves-effect waves-light btn" href="listar"><i class="material-icons left">keyboard_arrow_left</i>Voltar</a>
        <a class="waves-effect waves-light btn" href="cadastroNota?codigoAtv=${e.codigo}"><i class="material-icons left">note_add</i>Nova nota</a>
    </div>
</div>
</body>
</html>
