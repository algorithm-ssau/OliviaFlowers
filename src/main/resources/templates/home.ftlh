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

<p class="p-custom">Вам могут понравиться наши сезонные букеты</p>

<div class="row row-cols-1 row-cols-md-3 g-1 row-custom-flower">
  <div class="col">
    <a class="nav-link active h-100" aria-current="page" href="/bouquet">
      <div class="card h-100 custom-card-flower">
          <img src="../test1.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Белая шляпная коробка</h5>
          <p class="card-text">Белая коробка с эустомой и розами - сочетание, которое никогда не останется
            без внимания любителей классики.</p>
        </div>
      </div>
    </a>
  </div>
  <div class="col">
    <a class="nav-link active h-100" aria-current="page" href="/bouquet">
      <div class="card h-100 custom-card-flower">
        <img src="../test2.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Букет тюльпанов</h5>
          <p class="card-text">Воплощение весны - это охапка ярких, ароматных, хрустящих тюльпанов в боксе.</p>
        </div>
      </div>
    </a>
  </div>
  <div class="col">
    <a class="nav-link active h-100" aria-current="page" href="/bouquet">
      <div class="card h-100 custom-card-flower">
        <img src="../test3.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Корзина из роз</h5>
          <p class="card-text">Корзинка с пиновидными розами малинового цвета и эвкалиптом остается бестселлером уже не первый год, очаровывая каждого.</p>
        </div>
      </div>
    </a>
  </div>
</div>


<div class="background_color_about_us text-center">
  <p class="p-custom">О нас</p>
  <h5>OLIVIA - это цветы, собранные с любовью.</h5>
  <p class="p-custom-text">Цветы сопровождают нас в самые радостные моменты жизни, и мы рады проживать их вместе с вами.<br>
    Наша команда занимается разработкой авторских букетов и композиций, декором свадеб и других мероприятий.<br>
  </p>
</div>


<p class="p-custom">Доставка</p>

<div class="row row-custom-delivery">
  <div class="col-sm-6">
    <div class="card h-100 custom-card-delivery">
      <div class="card-body">
        <h5 class="card-title">Бесплатная доставка</h5>
        <p class="card-text">-Самовывоз<br>
          -Курьером по городу заказе от 3000₽<br></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card h-100 custom-card-delivery">
      <div class="card-body">
        <h5 class="card-title">Доставка по городу</h5>
        <p class="card-text">-По городу 300₽<br>
          -Условия доставки в пригород уточняются при оформлении заказа </p>
      </div>
    </div>
  </div>
</div>

<#include "blocks/footer.ftlh">
