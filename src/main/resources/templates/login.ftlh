<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="icon_logo.png" type="image/x-icon">
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

        /* Дополнительные стили для формы */
        .form-container {
            max-width: 300px;
            margin: auto;
            padding: 20px;
            border: 2px solid #f0eade;
            border-radius: 10px;
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

        /* Для футера внизу страницы: html, body, wrapper*/
        html, body {
            height: 100%;
        }
        .wrapper {
            flex-grow: 1;
            padding-bottom: 3rem; /* Добавление отступа снизу */
        }
    </style>
</head>
<body class="d-flex flex-column h-100">
    <div class="wrapper flex-grow-1">
        <#if isAdmin?? && isAdmin == true>
            <#include "blocks/headerAdmin.ftlh">
        <#else>
            <#include "blocks/header.ftlh">
        </#if>

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
                    <button type="submit" class="btn btn-custom">Вход</button>
                </form>
                <a href="/registration" class="btn btn-link mt-3">Зарегистрироваться</a>
            </div>
        </div>
    </div>
    <footer class="footer mt-auto">
       <#include "blocks/footer.ftlh">
    </footer>
</body>
</html>
