<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EShop</title>
    <style>
        <%@include file="/css/eShop_stylesheet.css"%>
    </style>

<body>

<div class="wrapper">

    <header class="header">
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
                <br>
                <br>
                <form method="post" action="/login"/>
                <h1>Login</h1>
                <br>
                <input class="signin" type="text" name="username" placeholder="login"/>
                <br/>
                <input class="signin" id="loginPass" type="password" name="password" placeholder="password"/>
                <br/>
                <button class="button" type="submit">Login</button>
                </form>

                <p class="text">
                    The store has several users by default:
                    <br>
                    <br>
                <table class="tg">
                    <tr>
                        <th>Login</th>
                        <th>Password</th>
                        <th>Role</th>
                    </tr>
                    <tr>
                        <td>admin</td>
                        <td>admin</td>
                        <td>ADMIN</td>
                    </tr>
                    <tr>
                        <td>customer0</td>
                        <td>customer0</td>
                        <td>CUSTOMER</td>
                    </tr>
                    <tr>
                        <td>customer1</td>
                        <td>customer1</td>
                        <td>CUSTOMER</td>
                    </tr>
                </table>
                </p>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <ul class="main-menu">

                <li><a href="<c:url value="/registration"/>">Registration</a></li>

                <li><a href="<c:url value="/login"/>">Login</a></li>
            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>
