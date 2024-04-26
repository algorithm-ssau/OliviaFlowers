<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Olivia Flowers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        /* Стили для фона */
        .container-fluid, .navbar-custom {
            background-color: #f0eade;
        }

        /* Отступы карт */
        .mx-custom {
            margin-left: 10rem;
            margin-right: 10rem;
        }

        /* Стили для границы карты */
        .custom-card {
            border: 2px solid #f0eade; /* Цвет границы */
            border-radius: 10px; /* Скругление углов */
        }

        /* Дополнительные стили для формы */
        .form-container {
            max-width: 300px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        /* Стили для кнопки */
        .btn-custom {
            width: 100%;
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
<div class="container text-center">
    <h4 class="mt-4">Авторизация</h4>
    <div class="form-container">
        <form action="/login" method="post">
            <div class="form-group">
                <label for="email">Эл. почта:</label>
                <input type="email" class="form-control" id="email" name="username">
            </div>
            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-custom">Вход</button>
        </form>
        <a href="/registration" class="btn btn-link mt-3">Зарегистрироваться</a>
    </div>
</div>
</body>
</html>