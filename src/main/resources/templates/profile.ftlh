<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="icon" href="icon_logo.png" type="image/x-icon">
    <title>Мой профиль</title>
    <style>
        body {
            background-color: #fff; /* Фоновый цвет */
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
            padding: 20px;
            border-left: 1px solid #ccc;
            margin-left: 220px;
            flex-grow: 1;
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
        .small-text {
            font-size: 0.8rem;
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
            <div class="small-text">Личная информация</div>
            <p>${currentUser.phoneNumber}</p>
            <p>${currentUser.email}</p>

            <div class="small-text">Другое</div>
            <div class="profile-buttons">
                <a href="/profile" class="btn btn-custom">Заказы</a>
                <a href="/favorite" class="btn btn-custom">Избранное</a>
                <form action="/logout" method="post">
                    <button type="submit" class="btn btn-custom">Выйти</button>
                </form>
            </div>
        </div>
        <div class="main-content">
            <h2>Вывод Заказов</h2>
            <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Дата оплаты</th>
                            <th>Сумма заказа</th>
                            <th>Статус</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list orders as order>
                            <tr>
                                <td>${order.datePayment.format('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>${order.sumOrder}</td>
                                <td>
                                    <#if order.active == 0>
                                        Доставлен
                                    <#else>
                                        Доставляется
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                    </tbody>
                </table>
        </div>
    </div>
    <div class="push"></div>
    <footer class="footer">
        <#include "blocks/footer.ftlh">
    </footer>
</div>
</body>
</html>
