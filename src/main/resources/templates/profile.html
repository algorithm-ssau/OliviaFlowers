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
<#if favoriteBouquets?has_content>
<h4>Избранные букеты</h4>
<table class="table">
    <!-- Заголовки таблицы -->
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
    <!-- Тело таблицы -->
    <tbody>
    <#list favoriteBouquets as bouquet>
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
        <!-- Вывод фото букета -->
        <td>
            <#if bouquet.images?has_content && bouquet.images?size gt 0>
            <img src="/images/${bouquet.images[0].id}" alt="Фото" style="max-width: 100px; max-height: 100px;">
        </#if>
        </td>
        <!-- Действия с букетом (например, просмотр и удаление) -->
        <td>
            <a href="/bouquet/${bouquet.id}" class="btn btn-primary">Просмотр</a>
            <form action="/remove_from_favorites" method="post">
                <input type="hidden" name="bouquetId" value="${bouquet.id}">
                <input type="hidden" name="userId" value="${currentUser.id}">
                <button type="submit" class="btn btn-danger">Удалить из избранного</button>
            </form>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
<#else>
<p>Нет избранных букетов</p>
</#if>


</body>
</html>