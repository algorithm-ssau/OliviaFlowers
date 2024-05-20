<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="icon" href="icon_logo.png" type="image/x-icon">
    <title>Мой профиль</title>
    <style>

        .container-fluid, .navbar-custom, .image-container {
            background-color: #f0eade; /* Также устанавливаем фоновый цвет для других контейнеров или элементов при необходимости */
        }
        .border {
            border: 2px solid #f0eade;
            border-radius: 10px;
            max-width: 500px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 4rem;
            margin-bottom: 4rem;
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
            padding-top: 2rem;
            padding-bottom: 1rem;
        }
        .image {
            border-radius: 10px;
            margin: auto;
        }
        .text {
            margin-top: 2rem;
        }
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
        .btn-custom2 {
            width: 94%;
            margin-top: 10px;
            background-color: #f0eade;
            border-color: #f0eade;
            color: #333;
        }
        .btn-custom2:hover {
            color: #333;
            background-color: #e0d8d0;
            border-color: #e0d8d0;
        }
        .mt-4 {
            margin-top: 1.5rem; /* 4 * 0.25rem (base spacing unit) */
        }
        table th, table td {
            text-align: center;
        }

    </style>
</head>

<body>
    <div class="wrapper">
        <#if isAdmin?? && isAdmin == true>
            <#include "blocks/headerAdmin.ftlh">
        <#else>
            <#include "blocks/header.ftlh">
        </#if>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3 d-flex flex-column align-items-center">
                    <img src="user.jpg" alt="Фото пользователя" class="img-thumbnail mb-3" style="max-width: 100px; max-height: 100px;">
                    <h3 class="mb-3">${currentUser.name} ${currentUser.surname}</h3>
                    <nav class="nav flex-column">
                        <a href="/info" class="btn btn-custom2">Информация о пользователе</a>
                        <a href="/profile" class="btn btn-custom2">Избранные букеты</a>
                        <form action="/logout" method="post">
                        <button type="submit" class="btn btn-custom2">Выйти</button>
                        </form>
                    </nav>
                </div>
                <div class="col-md-9 mt-4">
                    <h4>Избранные букеты</h4>
                    <#if favoriteBouquets?has_content>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Название</th>
                            <th>Состав</th>
                            <th>Цена</th>
                            <th>Фото</th>
                            <th>Действия</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list favoriteBouquets as bouquet>
                        <tr>
                            <td>${bouquet.name}</td>
                            <td>
                                <#list (bouquet.composition)?split("\n") as line>
                                ${line}<br>
                            </#list>
                            </td>
                            <td>${bouquet.price}</td>
                            <td>
                                <#if bouquet.images?has_content && bouquet.images?size gt 0>
                                <img src="/images/${bouquet.images[0].id}" alt="Фото" style="max-width: 100px; max-height: 100px;">
                            </#if>
                            </td>
                            <td>
                                <a href="/bouquet/${bouquet.id}" class="btn btn-custom">Просмотр</a>
                                <form action="/remove_from_favorites" method="post" style="display: inline;">
                                    <input type="hidden" name="bouquetId" value="${bouquet.id}">
                                    <input type="hidden" name="userId" value="${currentUser.id}">
                                    <button type="submit" class="btn btn-custom">Удалить из избранного</button>
                                </form>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                    <#else>
                    <p>Нет избранных букетов</p>
                </#if>
            </div>
        </div>
    </div>
    <footer class="footer mt-auto">
       <#include "blocks/footer.ftlh">
    </footer>
</body>
</html>


