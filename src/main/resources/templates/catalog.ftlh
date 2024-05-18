<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <title>Olivia Flowers</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style>
    /* Стили для фона */
    .container-fluid, .navbar-custom, .image-container{
      background-color: #f0eade;
    }

    .image-container{
      background-color: #f0eade;
      padding-bottom: 2rem;
    }

    /* Стили для заголовка для сезонных цветов */
    .p-custom {
      text-align: center;
      margin-top: 3rem;
      font-size: 21px;
    }

    /* Отступы карт */
    .row-custom-flower {
      margin-left: 14rem;
      margin-right: 14rem;
      margin-bottom: 2rem;
    }

    /* Стили для границы карты */
    .custom-card-flower {
      border: 2px solid #f0eade; /* Цвет границы */
      border-radius: 10px; /* Скругление углов */
      max-width: 250px; /* Максимальная ширина карточки */
      margin: auto; /* Центрирование карточки */
    }

    .custom-card-flower_img {
      border-radius: 10px; /* Скругление углов для изображения */
    }

    /* Фон у блока "О нас" */
    .background_color_about_us {
      background-color: #f0eade;
      padding-top: 2rem;          /* padding отступ внутри блока */
      padding-bottom: 1rem;
    }

    /* Отступы карт */
    .row-custom-delivery {
      margin-left: 22rem;
      margin-right: 22rem;
      margin-bottom: 4rem;
    }

    /* Стили для границы карты */
    .custom-card-delivery {
      border: 2px solid #f0eade; /* Цвет границы */
      border-radius: 10px; /* Скругление углов */
      max-width: 500px; /* Максимальная ширина карточки */
      margin: auto; /* Центрирование карточки */
    }

    /* Стили для заголовка для сезонных цветов */
    .p-custom-text {
      text-align: center;
      font-size: 16px;
      max-width: 800px;
      margin: auto;
      margin-bottom: 4rem;
    }

    .card-link {
        margin-bottom: .75rem; /* Отступ снизу */
        font-size: 1.25rem; /* Размер шрифта */
        font-weight: 500; /* Жирность шрифта */
        color: #333;
        text-decoration: none;
    }

    .p-text-center {
          text-align: center;
          margin: auto;
          margin-bottom: 4rem;
        }



  </style>
</head>
<body>
<#include "blocks/header.ftlh">


<!-- Вывод всех букетов  -->
<br> <br> <br>
<div id="section4" class="container">
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
<#include "blocks/footer.ftlh">
