<!DOCTYPE html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <title>
    Заказы
  </title>

  <script>
    function showMessage(message) {
      alert(message);
    }
  </script>

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

    .custom-link {
      width: 87%;
      margin-left: 5rem;
      margin-bottom: .75rem; /* Отступ снизу */
      font-size: 1.25rem; /* Размер шрифта */
      font-weight: 500; /* Жирность шрифта */
      color: #333;
      text-decoration: none;
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
<body>
<h4>Корзина</h4>

<!-- Вывод букета активного заказа  -->
<br><br><br>

<#if acBouquets??>
    <h4>Есть есть есть</h4>
    <#else>
        <h4>aaaaaaaaaaaaaaa</h4>

</#if>


</body>
<#include "blocks/footer.ftlh">
