<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="icon" href="icon_logo.png" type="image/x-icon">
    <title>Мой профиль</title>
    <style>
        body {
            background-color: #f0eade; /* Фоновый цвет */
        }
        .profile-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 40px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #fff;
            max-width: 200px;
            margin: 20px;
        }
        .profile-container img {
            border-radius: 50%;
            max-width: 100px;
            max-height: 100px;
            margin-bottom: 10px;
        }
        .profile-buttons a, .profile-buttons button {
            width: 100%;
            margin-bottom: 10px;
            background-color: #f0eade;
            border-color: #f0eade;
            color: #333;
        }
        .profile-buttons a:hover, .profile-buttons button:hover {
            background-color: #e0d8d0;
            border-color: #e0d8d0;
        }
        .main-content {
            margin-left: 220px;
            padding: 20px;
        }
        .footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            height: 50px;
            background-color: #f0eade;
            text-align: center;
            line-height: 50px;
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
    <div class="d-flex">
        <div class="profile-container">
            <img src="user.jpg" alt="Фото пользователя">
            <p>${currentUser.name} ${currentUser.surname}</p>
            <p>${currentUser.phoneNumber}</p>
            <p>${currentUser.email}</p>
            <div class="profile-buttons">
                <a href="/profile" class="btn btn-custom">Заказы</a>
                <a href="/favorite" class="btn btn-custom">Избранное</a>
                <form action="/logout" method="post">
                    <button type="submit" class="btn btn-custom">Выйти</button>
                </form>
            </div>
        </div>
        <div class="main-content">
            <h2>Избранные букеты</h2>
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
<div class="push"></div>
<footer class="footer">
    <#include "blocks/footer.ftlh">
</footer>
</div>
</body>
</html>
