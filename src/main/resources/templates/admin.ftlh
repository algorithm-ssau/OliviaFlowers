<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>
        Администратор
    </title>

    <script>
        function showMessage(message) {
            alert(message);
        }
    </script>

    <script>
        function request (id){

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

<br> <br> <br>

<div class="list-group">
    <a class="list-group-item list-group-item-action custom-link" href="#section1">Добавление букета</a>
    <a class="list-group-item list-group-item-action custom-link" href="#section2">Выбор букетов для главного экрана</a>
    <a class="list-group-item list-group-item-action custom-link" href="#section3">Поиск букета по названию</a>
    <a class="list-group-item list-group-item-action custom-link" href="#section4">Вывод всех букетов</a>
    <a class="list-group-item list-group-item-action custom-link" href="#section5">Добавление открыток</a>
    <a class="list-group-item list-group-item-action custom-link" href="#section6">Вывод всех открыток</a>

    </div>
        <a class="list-group-item list-group-item-action custom-link" href="#section7">Заказы к доставка</a>
</div>


<!-- Добавление букета  -->
<br> <br> <br>
<div id="section1" class="container">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <h4>Добавление букета:</h4>
    <form action="/bouquet_create" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="name" class="form-label">Название:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="file1" class="form-label">Первое фото:</label>
            <input type="file" class="form-control" id="file1" name="file1">
        </div>
        <div class="mb-3">
            <label for="file2" class="form-label">Второе фото:</label>
            <input type="file" class="form-control" id="file2" name="file2">
        </div>
        <div class="mb-3">
            <label for="file3" class="form-label">Третье фото:</label>
            <input type="file" class="form-control" id="file3" name="file3">
        </div>
        <div class="mb-3">
            <label for="composition" class="form-label">Состав:</label>
            <textarea class="form-control" id="composition" name="composition" rows="4"></textarea>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Цена:</label>
            <input type="number" class="form-control" id="price" name="price">
        </div>
        <button type="submit" class="btn btn-custom">Добавить</button>
    </form>
</div>


<!-- Выбор букетов для главного экрана  -->
<br> <br> <br>
<div id="section2" class="container">
    <h4>Выбор букетов для главного экрана</h4>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <form action="/add_bouquets_to_homepage" method="post">
        <div class="mb-3">
            <label for="bouquet1" class="form-label">ID букета 1:</label>
            <input type="text" class="form-control" id="bouquet1" name="bouquet1">
            <label for="description1" class="form-label">Описание букета:</label>
            <textarea class="form-control" id="description1" name="description1" style="height: auto"></textarea>

        </div>
        <div class="mb-3">
            <label for="bouquet2" class="form-label">ID букета 2:</label>
            <input type="text" class="form-control" id="bouquet2" name="bouquet2">
            <label for="description2" class="form-label">Описание букета:</label>
            <textarea class="form-control" id="description2" name="description2" style="height: auto"></textarea>

        </div>
        <div class="mb-3">
            <label for="bouquet3" class="form-label">ID букета 3:</label>
            <input type="text" class="form-control" id="bouquet3" name="bouquet3">
            <label for="description3" class="form-label">Описание букета:</label>
            <textarea class="form-control" id="description3" name="description3" style="height: auto"></textarea>

        </div>
        <button type="submit" class="btn btn-custom">Добавить на главный экран</button>
    </form>
</div>

<!-- Выбор букетов для каталога  -->
<br> <br> <br>
<div id="section5" class="container">
    <h4>Выбор букетов для каталога</h4>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <form action="/add_bouquets_to_catalog" method="post">
        <div class="mb-3">
            <label for="bouquet11" class="form-label">ID букета 1:</label>
            <input type="text" class="form-control" id="bouquet11" name="bouquet11">
            <label for="description11" class="form-label">Описание букета:</label>
            <textarea class="form-control" id="description11" name="description11" style="height: auto"></textarea>

        </div>
        <div class="mb-3">
            <label for="bouquet22" class="form-label">ID букета 2:</label>
            <input type="text" class="form-control" id="bouquet22" name="bouquet22">
            <label for="description22" class="form-label">Описание букета:</label>
            <textarea class="form-control" id="description22" name="description22" style="height: auto"></textarea>

        </div>
        <div class="mb-33">
            <label for="bouquet33" class="form-label">ID букета 3:</label>
            <input type="text" class="form-control" id="bouquet33" name="bouquet33">
            <label for="description33" class="form-label">Описание букета:</label>
            <textarea class="form-control" id="description33" name="description33" style="height: auto"></textarea>

        </div>
        <button type="submit" class="btn btn-custom">Добавить на каталог/button>
    </form>
</div>


<!-- Поиск букета по названию  -->
<br> <br> <br>
<div id="section3" class="container">
    <h4>Поиск и вывод букетов</h4>
    <form action = "/find_bouquet_by_name" method = "get">
        Поиск: <input type = "text" name = "name"><br>
        <button type="submit" class="btn btn-custom">Найти</button>
    </form>
</div>

<br> <br> <br>
<#if foundBouquetsByName??>
<div class="container">
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
        <#list foundBouquetsByName as bouquet>
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
<#else>
<h4 class="text-center">Букетов нет</h4>
</#if>


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


    <br><br><br>
    <div id ="section7" class = "container">
        <h4>Список заказов, которые нужно доставить</h4>
        <br>
        <#assign x = 0>
        <#list toDeliverOrders as order>

            <h3>Заказ №${order.id}</h3>
            <h5>Адрес: ${order.address}</h5>

            <h5>Дата оплаты: ${order.datePayment.format('yyyy-MM-dd HH:mm:ss')}</h5>
            <h5>Желаемая дата доставки: ${order.dateTimeDelivery.format('yyyy-MM-dd HH:mm:ss')!'Не указана'}</h5>
            <h5>Текст карточки: ${order.textPostcard!'Не выбрана карточка'}</h5>
            <br>
            <h4>Букеты в заказе:</h4>
            <table class = "table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Название</th>
                        <th>Состав</th>
                        <th>Фото</th>
                        <th>Количество</th>
                    </tr>
                </thead>
                <tbody>
                    <#assign y = 0>
                    <#list toDeliverBouquets[x] as bouquet>
                        <tr>
                            <td>${bouquet.id}</td>
                            <td>${bouquet.name}</td>
                            <!-- Вывод состава букета в несколько строк -->
                            <td>
                                <#list (bouquet.composition)?split("\n") as line>
                                    ${line}<br>
                                </#list>
                            </td>
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
                                ${toDeliverAmounts[x][y]}
                            </td>


                        </tr>
                        <#assign y++>


                    </#list>
                </tbody>
            </table>

            <form action = "deliver_order/${order.id}" method="post">
                <button type="submit" class="btn btn-custom">Отметить доставленным</button>
            </form>
            <form action = "cancel_order/${order.id}" method="post">
                <button type="submit" class="btn btn-custom">Отменить заказ</button>
            </form>
            <br>

            <#assign x++>

        </#list>
    </div>


<!-- Добавление открыток -->
    <br> <br> <br>
    <div id="section5" class="container">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <h4>Добавление открытки:</h4>
        <form action="/add_postcard" method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="file" class="form-label">Фото:</label>
                <input type="file" class="form-control" id="file" name="file">
            </div>
            <button type="submit" class="btn btn-custom">Добавить открытку</button>
        </form>
    </div>

<!-- Вывод открыток в таблице -->
    <br> <br> <br>
    <div id="section6" class="container">
        <h4>Список открыток:</h4>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Фото</th>
                </tr>
            </thead>
            <tbody>
                <#list allPostcards as postcard>
                    <tr>
                        <td>${postcard.id}</td>
                        <td>
                            <#if postcard.image?has_content>
                                <img src="/images/${postcard.image.id}" alt="Фото" style="max-width: 100px;">
                            <#else>
                                <!-- Здесь можно вывести какое-то сообщение или заглушку для изображения отсутствует -->
                            </#if>
                        </td>
                        <td>
                            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
                            <form action="/postcard_delete/${postcard.id}" method="post">
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