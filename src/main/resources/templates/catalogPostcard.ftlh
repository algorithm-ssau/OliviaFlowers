<!DOCTYPE html>
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

        .product{
            margin-top: 2rem;
            max-width: 18rem; /* Максимальная ширина карточки */
        }

        .image img{
            height: 18rem;
            border-radius: 7px;
        }

        .image{
            margin-bottom: 10px;
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

        .sideMarginRight{
            padding-right: 3rem;
        }

        .verticalMargin{
            margin-top: 1rem;
            margin-bottom: 1rem;
        }


        .card-link {
            margin-bottom: .75rem; /* Отступ снизу */
            font-size: 1.25rem; /* Размер шрифта */
            font-weight: 500; /* Жирность шрифта */
            color: #333;
            text-decoration: none;
        }

        .card-link-name {
            font-size: 1.25rem; /* Размер шрифта */
            color: #333;
            text-decoration: none;
        }

        /* Для футера внизу страницы: html, body, wrapper*/
        html, body {
            height: 100%;
        }
        .wrapper {
            flex-grow: 1;
            display: flex;
            flex-direction: column;
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

        /* Стили для удаления кнопок увеличения и уменьшения в input type number */
        input[type=number]::-webkit-outer-spin-button,
        input[type=number]::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
        input[type=number] {
            -moz-appearance: textfield;
        }

        .info {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            margin-bottom: 10px;
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
            <div class="col-md-3 sideMarginRight">
                <h6 for="typeRecipient" class="form-label" style="margin-top: 0.5rem;">Категория:</h6>
                <div class="sideMargin" style="padding-top: 1rem;">
                    <p><a class="custom-link" aria-current="page" href="/catalog">Все букеты</a></p>
                    <p><a class="custom-link" href="#">Авторские букеты</a></p>
                    <p><a class="custom-link" href="#">Композиции в коробках и корзинах</a></p>
                    <p><a class="custom-link" href="#">Свадебный декор</a></p>
                    <p><a class="custom-link" href="#" style="text-decoration: underline;">Открытки</a></p>
                </div>
            </div>
            <div class="col-md-9">
                <h4>Открытки:</h4>
                <div class="row">
                    <#list allPostcards as postcard>
                        <div class="col-md-4">
                            <div class="product">
                                <a href="/postcard/${postcard.id}" class="image">
                                    <img src="/images/${postcard.image.id}" alt="Фото">
                                </a>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>
        <script src="https://unpkg.com/ionicons@4.1.2/dist/ionicons.js"></script>
    </div>
    <footer class="footer mt-auto">
        <#include "blocks/footer.ftlh">
    </footer>
</body>
</html>

