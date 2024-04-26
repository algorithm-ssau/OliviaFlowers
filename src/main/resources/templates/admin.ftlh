<!DOCTYPE html>
<html>
<head>
    <title>
        админская страница
    </title>
</head>
<body>
<h1>Админская страница</h1>
<h4>Букеты</h4>

<form action = "/abouquet" method = "get">
    Поиск: <input type = "text" name = "name"><br>
    <input type = "submit" value="Поиск"/>
</form>

<#if admin??>
    <#list admin as bouquet>

        <div>
            ${(bouquet.id)!"id"} <p>${(bouquet.name)!"букет"}</p> ${(bouquet.price)!"цена"} руб.
        </div>
        <#else>
        <h3>Букетов нет</h3>
    </#list>
</#if>







<hr>
<h3>Добавить букет:</h3>
<form action = "bouquet/create" method = post>
        <Input type ="text" name = "name"/><br><br>
        <Input type ="text" name = "photo"/><br><br>
        <Input type ="number" name = "price"/><br><br>
    <input type = "submit" value = "Добавить"/>
</form>

</body>
</html>