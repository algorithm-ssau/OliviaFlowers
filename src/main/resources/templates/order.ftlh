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

    function showpostcardtext() {
      if(document.getElementById("nopostcard").selected){
        document.getElementById("posttext").style.display = "none"
      } else{
        document.getElementById("posttext").style.display = "block"
      }




    }
    function showaddress() {
        if (document.getElementById("nodelivery").selected) {
            document.getElementById("address").style.display = "none"
        } else {
            document.getElementById("address").style.display = "block"
        }
    }
  </script>

  <script>

  </script>

  <style>
    h5{text-align:right;}

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
      width: 75%;
      margin-top: 10px;
      background-color: #f0eade; /* Основной цвет кнопки */
      border-color: #f0eade; /* Цвет границы кнопки */
      color: #333; /* Цвет текста кнопки */
    }
    .btn-custom3 {
        width: 100%;
        margin-top: 10px;
        background-color: #f0eade; /* Основной цвет кнопки */
        border-color: #f0eade; /* Цвет границы кнопки */
        color: #333; /* Цвет текста кнопки */
    }

    .btn-custom3:hover {
        color: #333; /* Цвет текста кнопки */
        background-color: #e0d8d0; /* Цвет кнопки при наведении */
        border-color: #e0d8d0; /* Цвет границы кнопки при наведении */
    }

    .btn-custom:hover {
      color: #333; /* Цвет текста кнопки */
      background-color: #e0d8d0; /* Цвет кнопки при наведении */
      border-color: #e0d8d0; /* Цвет границы кнопки при наведении */
    }

    .btn-custom2 {
      width: 50%;
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

<div class="list-group">
  <a class="list-group-item list-group-item-action custom-link" href="#section4">Активный заказ</a>
  <a class="list-group-item list-group-item-action custom-link" href="#section3">Оформление заказа</a>
  <a class="list-group-item list-group-item-action custom-link" href="#section3">История заказов</a>
</div>
<body>
<br><br><br>
<!-- Вывод букета активного заказа  -->
<div id="section4" class="container">
  <#if acBouquets?size = 0>
    <center><h4>Активного заказа нет.</h4></center>

  <#else>
    <#assign x = 0>

    <h4>Активный заказ:</h4>
    <table class="table">
      <thead>
      <tr>
        <th>Название</th>
        <th>Цена</th>
        <th>Фото</th>
        <th>Количество</th>
        <th>Действия</th>
      </tr>
      </thead>
      <tbody>
      <#list acBouquets as bouquet>
        <tr>
          <td>${bouquet.name}</td>
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
            <br>
            <form action = "/order_amountchange/${bouquet.id}" method = "post">
              <input type="number" id="count" name="count" min = "1" max = "20" value=${acAmounts[x]}>
              <br>
              <button type="submit" class="btn btn-custom2">Обновить</button>
            </form>
          </td>
          <td>
            <a href="/bouquet/${bouquet.id}" class="btn btn-custom">Просмотр</a>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
            <form action="/order_delete/${bouquet.id}" method="post">
              <button type="submit" class="btn btn-custom">Удалить</button>
            </form>
          </td>
        </tr>
        <#assign x++>
      </#list>
      </tbody>
    </table>

    <h5>Стоимость всего заказа - ${acOrder.sumOrderl} руб.</h5>

  </#if>
</div>
<div id="section3" class="container">
  <#if acBouquets?size != 0>
    <br>
    <h4>Оформление заказа:</h4>
    <form action = "/order_checkout" method = "post">
        <div class="mb-3">
            <label for="typepostcard" class="form-label">Тип открытки:</label>
            <select onchange = "showpostcardtext()" name = "typepostcard" id = "typepostcard" class = "form-control">
                <option id = "nopostcard" value = "0">Без открытки</option>
                <option value = "1">Открытка</option>
                <option value = "2">Записка</option>
            </select>
        </div>
        <div id = "posttext" class ="mb-3" style = "display:none">
            <label for="textpostcard" class="form-label">Текст открытки:</label>
            <input type="text" class="form-control" id="textpostcard" name="textpostcard">
        </div>
        <div class="mb-3">
            <label for="toDeliver" class="form-label">Самовывоз или доставка:</label>
            <select onchange = "showaddress()" name = "toDeliver" id = "toDeliver" class = "form-control">
                <option id = "nodelivery" value = "0">Самовывоз</option>
                <option value = "1">Доставка</option>
            </select>
        </div>
        <div id = "address" class ="mb-3" style = "display:none">
            <label for="address" class="form-label">Адрес доставки:</label>
            <input type="text" class="form-control" id="address" name="address">

        </div>
        <button type="submit" class="btn btn-custom3">Оформление заказа</button>
    </form>

  </#if>
<br><br><br>
</div>




</body>
<#include "blocks/footer.ftlh">
