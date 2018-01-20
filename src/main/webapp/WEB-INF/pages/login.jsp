<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@include file="/css/bootstrap.min.css"%>
    <%@include file="/css/signin.min.css"%>
</style>
<body>

    <form class="form-signin" method="post" action="/login"/>
    <h2 class="form-signin-heading">Вход</h2>
    <input class="form-control" type="text" name="username" placeholder="Логин"/>
    <br/>
    <input id="loginPass" class="form-control" type="password" name="password" placeholder="Пароль"/>
    <br/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>

</body>

</html>
