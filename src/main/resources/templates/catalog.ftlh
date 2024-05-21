<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <link rel="icon" href="icon_logo.png" type="image/x-icon">
  <title>Olivia Flowers</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

  <style>
    /* Стили для фона */
    .container-fluid, .navbar-custom{
      background-color: #f0eade;
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

    /* Стили для границы карты */
    .custom-card-delivery {
      border: 2px solid #f0eade; /* Цвет границы */
      border-radius: 10px; /* Скругление углов */
      max-width: 500px; /* Максимальная ширина карточки */
      margin: auto; /* Центрирование карточки */
    }
    .product{
      margin-top: 3rem;
      margin-bottom: 30px;
    }

    .image{
      margin-bottom: 10px;
    }
    .image img{
      height: 20rem;
      border-radius: 7px;
    }
    .h3{
      font-size: 10 px;
    }
    .info-price{
      display: flex;
      flex-flow: row nowrap;
      justify-content: space-between;
      align-items: center;
    }
    .price{
      font-size: 22px;
    }
    .btn-custom2 {
      width: 30%;
      margin-top: 10px;
      margin-bottom: 10px;
      background-color: #ffffff; /* Основной цвет кнопки */
      border-color: #e0d8d0; /* Цвет границы кнопки */
      color: #333; /* Цвет текста кнопки */
    }

    .custom-link {
        font-size: 1.05rem; /* Размер шрифта */
        color: #333;
        text-decoration: none;
    }

    .container{
        margin-top: 4rem;
        margin-bottom: 4rem;
    }

    .sideMargin{
        margin-left: 2rem;
        margin-right: 2rem;
    }

    .verticalMargin{
        margin-top: 1rem;
        margin-bottom: 1rem;
    }

    .btn-custom2:hover {
      color: #333; /* Цвет текста кнопки */
      background-color: #e0d8d0; /* Цвет кнопки при наведении */
      border-color: #e0d8d0; /* Цвет границы кнопки при наведении */
    }

    .card-link {
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

    .price-filter {
        border: 1px solid #e0e0e0;
        padding: 20px;
        border-radius: 8px;
    }
    .price-filter h5 {
        font-weight: bold;
    }
    .price-filter .input-group {
        margin-bottom: 1rem;
    }
    .price-filter .form-check-label {
        font-weight: normal;
    }
    .price-filter .form-check-input:checked ~ .form-check-label {
        color: #007bff;
    }

  </style>
</head>

<body class="d-flex flex-column h-100">
<div class="wrapper flex-grow-1">
  <#if isAdmin?? && isAdmin == true>
  <#include "blocks/headerAdmin.ftlh">
  <#else>
  <#include "blocks/header.ftlh">
</#if>

<div class="container">
  <div class="row">
    <div class="col-md-3">
      <h6 for="typeRecipient" class="form-label">Категория:</h6>
      <div class="sideMargin">
        <p><a class="custom-link" href="/lookAll">Смотреть все</a></p>
        <p><a class="custom-link" href="/authorBouquet">Авторские композиции</a></p>
        <p><a class="custom-link" href="/boxBouquet">Композиции в коробках и корзинах</a></p>
        <p><a class="custom-link" href="/weddingBouquet">Свадебный декор</a></p>
        <p><a class="custom-link" href="/postcards">Открытки</a></p>
      </div>
      <br>
      <form action="/filterBouquets" method="get">
        <h6 for="typeRecipient" class="form-label">Сортировка:</h6>
        <select name="sort" id="typeRecipient" class="form-control">
          <option value="0">По умолчанию</option>
          <option value="1">По возрастанию цены</option>
          <option value="2">По убыванию цены</option>
        </select>
        <br>
        <div class="input-group mb-3">
          <input type="number" name="minPrice" class="form-control" placeholder="от min_prise">
          <input type="number" name="maxPrice" class="form-control" placeholder="до max_prise">
        </div>
        <div class="form-check sideMargin verticalMargin">
          <input class="form-check-input" type="radio" name="priceRange" id="price1" value="0-2000">
          <label class="form-check-label" for="price1">до 2000 ₽</label>
        </div>
        <div class="form-check sideMargin verticalMargin">
          <input class="form-check-input" type="radio" name="priceRange" id="price2" value="2000-4000">
          <label class="form-check-label" for="price2">2000–4000 ₽</label>
        </div>
        <div class="form-check sideMargin verticalMargin">
          <input class="form-check-input" type="radio" name="priceRange" id="price3" value="4000-999999999">
          <label class="form-check-label" for="price3">От 4000 ₽</label>
        </div>
        <button type="submit" class="btn btn-primary mt-3">Применить</button>
      </form>
    </div>
    <div class="col-md-9">
      <h4>Каталог всех букетов:</h4>
      <br>
      <div class="row">
        <#list allBouquets as bouquet>
        <div class="col-md-4">
          <div class="product">
            <div class="image">
              <img src="/images/${bouquet.images[0].id}" alt="Фото">
            </div>
            <div class="info">
              <div class="card-link">${bouquet.name}</div>
              <div class="info-price">
                <span class="price">${bouquet.price}&#8381</span>
                <a href="/bouquet/${bouquet.id}" class="btn btn-primary btn-custom2">К товару <ion-icon name="search"></ion-icon></a>
              </div>
            </div>
          </div>
        </div>
      </#list>
    </div>
  </div>
</div>
</div>
<footer class="footer mt-auto">
  <#include "blocks/footer.ftlh">
</footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9gybBogGz5oCJ6pFYQ4IHg8DUi4zxtqDShTZ7H25QpYaetFG8D" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-rbXLa4/nQpf7Ht9DPOOaKM5rvn0lV4k5nj24S0oM4rXIqVqnO6z0ZdK+2L9CSpz+" crossorigin="anonymous"></script>
</body>
</html>
