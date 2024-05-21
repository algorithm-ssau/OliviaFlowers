<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="icon" href="icon_logo.png" type="image/x-icon">

    <title>
        Администратор
    </title>

    <script>
        function showMessage(message) {
            alert(message);
        }
    </script>

    <script>
        function request (id){

        }

    </script>

    <style>

        .main-content {
            padding: 20px;
            border-left: 1px solid #ccc;
            margin-left: 100px;
            flex-grow: 1;
        }

        .container-fluid, .navbar-custom, .image-container{
            background-color: #f0eade;
        }
        .border{
            border: 2px solid #f0eade; /* Цвет границы */
            border-radius: 10px; /* Скругление углов */
            max-width: 500px; /* Максимальная ширина карточки */
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
            padding-top: 2rem;          /* padding отступ внутри блока */
            padding-bottom: 1rem;
        }


        .image{
            border-radius: 10px; /* Скругление углов */
            margin: auto;
        }

        .text{
            margin-top: 2rem;
        }

        .btn-custom {
            width: 80%;
            margin-top: 10px;
            background-color: #f0eade; /* Основной цвет кнопки */
            border-color: #f0eade; /* Цвет границы кнопки */
            color: #333; /* Цвет текста кнопки */
        }

        .btn-custom:hover {
            color: #333; /* Цвет текста кнопки */
            background-color: #e0d8d0; /* Цвет кнопки при наведении */
            border-color: #e0d8d0; /* Цвет границы кнопки при наведении */
        }

        .btn-custom2 {
            width: 94%;
            margin-top: 10px;
            background-color: #f0eade; /* Основной цвет кнопки */
            border-color: #f0eade; /* Цвет границы кнопки */
            color: #333; /* Цвет текста кнопки */
        }

        .btn-custom2:hover {
            color: #333; /* Цвет текста кнопки */
            background-color: #e0d8d0; /* Цвет кнопки при наведении */
            border-color: #e0d8d0; /* Цвет границы кнопки при наведении */
        }

        .custom-link {
            width: 87%;
            margin-left: 5rem;
            margin-bottom: .75rem; /* Отступ снизу */
            font-size: 1.25rem; /* Размер шрифта */
            font-weight: 500; /* Жирность шрифта */
            color: #333;
            text-decoration: none;
        }

        /* Для футера внизу страницы: html, body, wrapper*/
        html, body {
            height: 100%;
        }
        .wrapper {
            flex-grow: 1;
            padding-bottom: 3rem; /* Добавление отступа снизу */
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
        .profile-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 40px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #fff;
            max-width: 600px;
            margin: 20px;
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
            <h3>Админ</h3>
            <a href="/admin" class="btn btn-custom">Список букетов</a>
            <a href="/adminaddbouquet" class="btn btn-custom">Добавить букет</a>
            <a href="/adminchoicebouquet" class="btn btn-custom">Выбор букета на главный экран</a>
            <a href="/adminpostcard" class="btn btn-custom">Работа с карточками</a>
            <a href="/adminorderlist" class="btn btn-custom">Заказы к доставке</a>
        </div>
        <div class="main-content">
            <h2>Открытки</h2>
            <br></br>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
            <h4>Добавление открытки:</h4>
            <form action="/add_postcard" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="file" class="form-label">Фото:</label>
                    <input type="file" class="form-control" id="file" name="file">
                </div>
                <button type="submit" class="btn btn-custom">Добавить открытку</button>
            </form>
            <br>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Фото</th>
                </tr>
                </thead>
                <tbody>
                <#list allPostcards as postcard>
                    <tr>
                        <td>${postcard.id}</td>
                        <td>
                            <#if postcard.image?has_content>
                                <img src="/images/${postcard.image.id}" alt="Фото" style="max-width: 100px;">
                            <#else>
                                <!-- Здесь можно вывести какое-то сообщение или заглушку для изображения отсутствует -->
                            </#if>
                        </td>
                        <td>
                            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
                            <form action="/postcard_delete/${postcard.id}" method="post">
                                <button type="submit" class="btn btn-danger">Удалить</button>
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>



        </div>
    </div>
    <div class="push"></div>
    <footer class="footer mt-auto">
        <#include "blocks/footer.ftlh">
        <br>
    </footer>
</div>
</body>