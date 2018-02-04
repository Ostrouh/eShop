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
        <strong>Welcome to EShop - Eugene's Ostroukh project for EPAM training</strong>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
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
