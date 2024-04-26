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

    .border{
      border: 2px solid #f0eade; /* Цвет границы */
      border-radius: 10px; /* Скругление углов */
      max-width: 700px; /* Максимальная ширина карточки */
      margin-left: auto;
      margin-right: auto;
      margin-top: 4rem;
      margin-bottom: 4rem;
      position: relative; /* Добавляем относительное позиционирование */

    }

    .image{
      border-radius: 10px; /* Скругление углов */
      max-width: 500px; /* Максимальная ширина карточки */
      margin: auto;
    }

    .text{
       margin-top: 2rem;
    }

    .btn-custom {
      width: 45%;
      margin-bottom: 10px;
      background-color: #f0eade; /* Основной цвет кнопки */
      border-color: #f0eade; /* Цвет границы кнопки */
      color: #333; /* Цвет текста кнопки */
      position: absolute; /* Добавляем абсолютное позиционирование */
      bottom: 10px; /* Отступ от нижней границы */
    }

    .btn-custom:hover {
      background-color: #e0d8d0; /* Цвет кнопки при наведении */
      border-color: #e0d8d0; /* Цвет границы кнопки при наведении */
    }
  </style>
</head>
<body>
<#include "blocks/header.ftlh">
<div class="border">
  <div class="row">
    <div class="col-md-6">
      <img src="../test1.jpg" class="card-img-top image" alt="...">
    </div>
    <div class="col-md-6">
      <div class="content">
        <h4 class="text">Заголовок</h4>
        <p class="text">Состав:</p>
        <p>Текст</p>
        <p class="text">*Цена*</p>
        <button type="submit" class="btn btn-primary btn-custom">Добавить в корзину</button>
      </div>
    </div>
  </div>
</div>
</body>
<#include "blocks/footer.ftlh">
