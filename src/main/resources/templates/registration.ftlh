<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h4>Регистрация</h4>
<form action="/registration" method="post">
    Имя: <input type="text" name="name"><br><br>
    Фамилия: <input type="text" name="surname"><br><br>
    Эл. почта: <input type="email" name="email"><br><br>
    Номер телефона: <input type="text" name="phoneNumber"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    Дата рождения: <input type="date" name ="dateOfBirth"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Зарегистрироваться"/>
</form>

</body>
</html>