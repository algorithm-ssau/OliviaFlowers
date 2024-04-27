<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>
        админская страница
    </title>
    <style>

        .container-fluid, .navbar-custom, .image-container{
            background-color: #f0eade;
        }

        .form-container {
            max-width: 300px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .background_color_pw {
            background-color: #f0eade;
            padding-top: 2rem;          /* padding отступ внутри блока */
            padding-bottom: 1rem;
        }

        .btn-custom {
            width: 25%;
            margin-top: 10px;
            background-color: #f0eade; /* Основной цвет кнопки */
            border-color: #f0eade; /* Цвет границы кнопки */
            color: #333; /* Цвет текста кнопки */
        }

        .btn-custom:hover {
            background-color: #e0d8d0; /* Цвет кнопки при наведении */
            border-color: #e0d8d0; /* Цвет границы кнопки при наведении */
        }
    </style>
</head>
<body>
<#include "blocks/header.ftlh">


<br>
<div class="container text-center">
    <h3>Поиск и вывод букетов</h3>
    <form action = "/abouquet" method = "get">
        Поиск: <input type = "text" name = "name"><br>
        <button type="submit" class="btn btn-custom">Найти</button>
    </form>
</div>

<br>
<div class="background_color_pw text-center">
    <#if admin??>
        <#list admin as bouquet>

            <div>
                ${(bouquet.id)!"id"} <p>${(bouquet.name)!"букет"}</p> ${(bouquet.price)!"цена"} руб.
            </div>
        <#else>
            <h3>Букетов нет</h3>
        </#list>
    <#else>
        <h3>Букетов нет</h3>
    </#if>
</div>
<br>
<div class="container text-center">
    <h3>Добавление букета:</h3>
    <form action = "bouquet/create" method = post>
        <Input type ="text" name = "name"/><br><br>
        <Input type ="text" name = "photo"/><br><br>
        <Input type ="number" name = "price"/><br><br>
        <button type="submit" class="btn btn-custom">Добавить</button>
    </form>

</div>










</body>
</html>