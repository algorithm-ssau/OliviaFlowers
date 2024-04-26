<div class="container-fluid text-center">
  <nav class="navbar navbar-custom navbar-expand-sm ">
    <a class="navbar-brand" href="/">Olivia Flowers</a>

    <ul class="navbar-nav ms-auto">
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/admin">Страница Администратора(WIP)</a>
      </li>

      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/catalog">Каталог</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/order">Корзина</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/login">Войти</a>
      </li>
      <li class="nav-item">
        <form action="/logout" method="post">
          <input type="hidden" name="_csrf" value="${_csrf.token}">
          <input type="submit" value="Выйти"/>
        </form>
      </li>


    </ul>
  </nav>
</div>