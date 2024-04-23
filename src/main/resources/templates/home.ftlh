<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Olivia Flowers</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style>
     /* Стили для фона */
     .container-fluid, .navbar-custom {
         background-color: #f0eade;
     }

     /* Стили для фона под логотипом */
     .image-container {
         background-color: #f0eade; /* Цвет фона для изображения */
     }

     /* Стили для заголодка для сезонных цветов */
     .p-custom {
        text-align: center;
        margin-top: 3rem;
        font-size: 21px;
     }

     /* Отступы карт */
     .row-custom {
        margin-left: 14rem;
        margin-right: 14rem;
        margin-bottom: 2rem;
     }

     /* Стили для границы карты */
     .custom-card {
        border: 2px solid #f0eade; /* Цвет границы */
        border-radius: 10px; /* Скругление углов */
        max-width: 250px; /* Максимальная ширина карточки */
        margin: auto; /* Центрирование карточки */
     }

     /* Стили для заголодка для сезонных цветов */
        .p-custom-text {
           text-align: center;
           font-size: 16px;
           max-width: 800px;
           margin: auto;
           margin-bottom: 4rem;
        }

  </style>
</head>
<body>
<#include "blocks/header.ftlh">

<div class="image-container">
  <center><img src="../logo_mini.png" style="height: 130px;" alt="Logo"></center>
</div>

<p class="p-custom">Вам могут понравиться наши сезонные букеты:</p>

<div class="row row-cols-1 row-cols-md-3 g-1 row-custom">
  <div class="col">
    <div class="card h-100 custom-card ">
      <img src="../test1.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card h-100 custom-card">
      <img src="../test2.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">This is a short card.</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card h-100 custom-card">
      <img src="../test3.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
      </div>
    </div>
  </div>
</div>

<p class="p-custom">О нас</p>

<p class="p-custom-text">Вика скинь мне текст текст текст текст текст текст текст текст текст текст
текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст
текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст
текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст
текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст
текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст
текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст
текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст
текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст текст</p>


<#include "blocks/footer.ftlh">

