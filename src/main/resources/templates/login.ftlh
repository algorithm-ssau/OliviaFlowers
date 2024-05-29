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
            width: 70%;
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
        }
        .row-custom {
            border: 2px solid #f0eade;
            border-radius: 10px;
            width: 60rem;
            height: 35rem;
            margin: auto;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1), 0px 4px 8px rgba(0, 0, 0, 0.1); /* Добавляем тень со всех сторон */
            overflow: hidden; /* Скрыть выходящие за границы элементы */
            position: relative; /* Позиционирование относительно родительского элемента */
        }

        .image-container {
            width: 50%; /* Занимать половину ширины контейнера */
            height: 100%; /* Занимать всю высоту контейнера */
            position: absolute; /* Абсолютное позиционирование */
            top: 0; /* Расположить сверху */
            transition: transform 0.5s ease; /* Плавное изменение свойства transform */
        }

        .image-container img {
            width: 100%; /* Занимать всю ширину изображения */
            height: auto; /* Сохранить пропорции изображения */
            border-top-right-radius: 10px; /* Закругление верхнего правого угла */
            border-bottom-right-radius: 10px; /* Закругление нижнего правого угла */
        }

        .image-container-r {
            width: 50%; /* Занимать половину ширины контейнера */
            height: 100%; /* Занимать всю высоту контейнера */
            position: absolute; /* Абсолютное позиционирование */
            top: 0; /* Расположить сверху */
            transition: transform 0.5s ease; /* Плавное изменение свойства transform */
        }

        .image-container-r img {
            width: 100%; /* Занимать всю ширину изображения */
            height:  100%; /* Сохранить пропорции изображения */
            border-top-left-radius: 10px;
            border-bottom-left-radius: 10px;
        }

        .form-content {
            width: 50%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            position: absolute;

        }
        .form-content-r {
            width: 50%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            position: absolute;
        }

        .slide-out {
            transform: translateX(-100%); /* Сместить влево за пределы экрана */
        }

        .slide-in {
            transform: translateX(0); /* Вернуть на место */
        }
    </style>
</head>
<body class="d-flex flex-column h-100">
    <div class="wrapper flex-grow-1 d-flex flex-column align-items-center">
        <#if isAdmin?? && isAdmin == true>
            <#include "blocks/headerAdmin.ftlh">
        <#else>
            <#include "blocks/header.ftlh">
        </#if>
        <div class="row row-custom">
            <div class="col-md-6">
                <div class="form-content" id="loginFormContent"> <!-- Контент формы -->
                    <div class="form-container">
                        <h5 class="text-center">Авторизация</h5>
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
                        <div class="d-flex justify-content-between align-items-center">
                            <p class="mb-0 me-2">Еще нет аккаунта?</p>
                            <a href="#" class="btn custom-link text-end" onclick="slideToRegister()">Зарегистрироваться</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="image-container" id="loginImageContainer"> <!-- Изображение логина -->
                    <img src="../registration.jpg" alt="Login Image">
                </div>
            </div>

            <div class="col-md-6">
                <div class="image-container-r" id="registerImageContainer" style="transform: translateX(100%);"> <!-- Изображение регистрации -->
                    <img src="../registration.jpg" alt="Register Image">
                </div>
            </div>

                <div class="form-content-r" id="registerFormContent" style="transform: translateX(200%);"> <!-- Контент формы -->
                    <div class="form-container" >
                         <form action="/registration" method="post">
                            <h5 class="text-center">Регистрация</h5>
                             <div class="form-group">
                                 <label for="name">Имя:</label>
                                 <input type="text" class="form-control" id="name" name="name" required>
                             </div>
                             <div class="form-group">
                                 <label for="surname">Фамилия:</label>
                                 <input type="text" class="form-control" id="surname" name="surname" required>
                             </div>
                             <div class="form-group">
                                 <label for="email">Эл. почта:</label>
                                 <input type="email" class="form-control" id="email" name="email" required>
                             </div>
                             <div class="form-group">
                                 <label for="phoneNumber">Номер телефона:</label>
                                 <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required>
                             </div>
                             <script>
                                 $(document).ready(function(){
                                     Inputmask({"mask": "8 (999) 999-99-99"}).mask("#phoneNumber");
                                 });
                             </script>
                             <div class="form-group">
                                 <label for="password">Пароль:</label>
                                 <input type="password" class="form-control" id="password" name="password" required>
                             </div>
                             <div class="form-group">
                                 <label for="dateOfBirthday">Дата рождения:</label>
                                 <input type="date" class="form-control" id="dateOfBirthday" name="dateOfBirthday" required>
                             </div>
                             <button type="submit" class="btn btn-custom">Зарегистрироваться</button>
                         </form>
                         <div class="d-flex justify-content-between align-items-center">
                             <p class="mb-0 me-2">Уже есть аккаунт?</p>
                             <a href="#" class="btn custom-link text-end" onclick="slideToLogin()">Войти</a>
                         </div>
                     </div>
                 </div>
         </div>
    </div>
    <footer class="footer mt-auto">
        <#include "blocks/footer.ftlh">
    </footer>
    <script>
             function slideToRegister() {
                 document.getElementById("loginImageContainer").style.transform = "translateX(-105%)";
                 document.getElementById("registerImageContainer").style.transform = "translateX(-5%)";
                 document.getElementById("loginFormContent").style.transform = "translateX(-100%)";
                 document.getElementById("registerFormContent").style.transform = "translateX(100%)";
             }

             function slideToLogin() {
                 document.getElementById("loginImageContainer").style.transform = "translateX(0)";
                 document.getElementById("registerImageContainer").style.transform = "translateX(100%)";
                 document.getElementById("loginFormContent").style.transform = "translateX(0)";
                 document.getElementById("registerFormContent").style.transform = "translateX(-100%)";
             }

     </script>
 </body>
