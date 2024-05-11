<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>
        Мой профиль
    </title>
    <style>

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
          width: 30%;
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
    </style>
</head>
<body>
<#include "blocks/header.ftlh">


<!-- Вывод информационных сообщений  -->

<#if message??>
<script>
    showMessage("${message}");
</script>
</#if>


<!-- Вывод всех букетов  -->
<br> <br> <br>
<div class="container">
    <h4>Список букетов</h3>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Состав</th>
                <th>Цена</th>
                <th>Фото</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>
            <#list allBouquets as bouquet>
            <tr>
                <td>${bouquet.id}</td>
                <td>${bouquet.name}</td>
                <!-- Вывод состава букета в несколько строк -->
                <td>
                    <#list (bouquet.composition)?split("\n") as line>
                    ${line}<br>
                </#list>
                </td>
                <td>${bouquet.price}</td>
                <td>
                    <#if bouquet.images[0]?has_content && bouquet.images[0]?size gt 1>
                    <img src="/images/${bouquet.images[0].id}" alt="Фото" style="max-width: 100px; max-height: 100px;">
                    <#else>
                    <!-- Здесь можно вывести какое-то сообщение или заглушку для изображения отсутствует -->
                </#if>

                <#if bouquet.images[1]?has_content && bouquet.images[1]?size gt 1>
                <img src="/images/${bouquet.images[1].id}" alt="Фото"  style="max-width: 100px; max-height: 100px;">
                <#else>
                <!-- Здесь можно вывести какое-то сообщение или заглушку для изображения отсутствует -->
            </#if>

            <#if bouquet.images[2]?has_content && bouquet.images[2]?size gt 1>
            <img src="/images/${bouquet.images[2].id}" alt="Фото" style="max-width: 100px; max-height: 100px;">
            <#else>
            <!-- Здесь можно вывести какое-то сообщение или заглушку для изображения отсутствует -->
            </#if>

            </td>
            <td>
                <a href="/bouquet/${bouquet.id}" class="btn btn-primary">Просмотр</a>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
                <form action="/bouquet_delete/${bouquet.id}" method="post">
                    <button type="submit" class="btn btn-danger">Удалить</button>
                </form>
            </td>
            </tr>
        </#list>
        </tbody>
        </table>
</div>




</body>
</html>