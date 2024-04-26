<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Olivia Flowers</title>
</head>
<body>
<form action ="/logout" method = "post">
  <input type = "hidden" name = "_csrf" value="${_csrf.token}">
  <input type = "submit" value = "Выйти"/>
</form>
Order page
</body>
</html>