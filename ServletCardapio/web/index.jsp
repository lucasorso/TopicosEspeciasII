<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<H1>Escolha seu cardápio</h1>
<form action="ServletCardapio" method="post">
    <table>
        <tr>
            <td><input type="checkbox" name="opcao" value="20"> Pizza </td>
            <td> R$20,00 </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="opcao" value="5"> Xis salada </td>
            <td> R$5,00 </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="opcao" value="2"> Refri 600ml </td>
            <td> R$2,00 </td>
        </tr>
        <tr>
            <td><input type="checkbox" name="opcao" value="3"> Cerveja </td>
            <td> R$3,00 </td>
        </tr>
        <tr>
            <td><input type="submit" value="Pedir"></td>
        </tr>
    </table>
</form>
</body>
</html>

