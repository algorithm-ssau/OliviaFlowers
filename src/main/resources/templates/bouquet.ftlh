<head>
  <meta charset="UTF-8">
  <title>Olivia Flowers</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style>
    /* Стили для фона */
    .container-fluid, .navbar-custom, .image-container{
      background-color: #f0eade;
    }

    .row{
      border: 2px solid #f0eade; /* Цвет границы */
      border-radius: 10px; /* Скругление углов */
      max-width: 700px; /* Максимальная ширина карточки */
      margin-left: auto;
      margin-right: auto;
      margin-top: 4rem;
      margin-bottom: 4rem;
    }

    .image{
      border-radius: 10px; /* Скругление углов */
      max-width: 500px; /* Максимальная ширина карточки */
      margin: auto;
    }

    .card {
      border: 0px;
    }

    .text{
       margin-top: 2rem;
    }

    .btn-custom {
      width: 93%;
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
      width: 93%;
      margin-top: 10px;
      margin-bottom: 10px;
      background-color: #ffffff; /* Основной цвет кнопки */
      border-color: #e0d8d0; /* Цвет границы кнопки */
      color: #333; /* Цвет текста кнопки */
    }

    .btn-custom2:hover {
      color: #333; /* Цвет текста кнопки */
      background-color: #e0d8d0; /* Цвет кнопки при наведении */
      border-color: #e0d8d0; /* Цвет границы кнопки при наведении */
    }

    .carousel-item img {
      margin-top: auto;
      margin-bottom: auto;
      max-width: 100%;
    }

    .div_center {
      margin: auto;
    }


  </style>
</head>
<body>
<#include "blocks/header.ftlh">
<div class="border">
  <div class="row">
    <div class="col-md-6">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
      <div class="card h-100">
        <div id="carouselBouquet" class="carousel slide div_center">
            <div class="carousel-indicators">
                <#list bouquet.images as image>
                    <button type="button" data-bs-target="#carouselBouquet" data-bs-slide-to="${image_index}"<#if image_index == 0> class="active"</#if> aria-current="true" aria-label="Slide ${image_index + 1}"></button>
                </#list>
            </div>
            <div class="carousel-inner">
                <#list bouquet.images as image>
                    <div class="carousel-item<#if image_index == 0> active</#if>">
                        <img src="/images/${image.id}" class="d-block w-100 image" alt="Фото">
                    </div>
                </#list>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselBouquet" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselBouquet" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
      </div>
    </div>

    <div class="col-md-6">
      <div class="content">
        <h4 class="text">${bouquet.name}</h4>
        <h6 class="text">Состав:</h6>
        <p><#list (bouquet.composition)?split("\n") as line>
          ${line}<br>
        </#list></p>
        <h6 class="text">${bouquet.price} рублей</h6>
          <form action = "/bouquet_addcar/${bouquet.id}" method = "post">
              <button type="submit" class="btn btn-primary btn-custom">Добавить в корзину</button>
          </form>

        <button type="submit" class="btn btn-primary btn-custom2">Добавить в избранное</button>
      </div>
    </div>
  </div>
</div>
</body>
<#include "blocks/footer.ftlh">