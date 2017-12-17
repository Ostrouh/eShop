<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script><![endif]-->
    <title>EShop</title>
    <style>
        <%@include file="/css/div-style.css"%>
    </style>
    <meta name="keywords" content="" />
    <meta name="description" content="" />

<body>

<div class="wrapper">

    <header class="header">
        <strong>Header:</strong>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
                <strong>Content:</strong>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">

            <br/>
            <a href="<c:url value="/catalog"/>">Catalog</a>
            <br/>
            <br/>
            <br/>
            <a href="<c:url value="/registration"/>">Registration</a>
            <br/>
            <br/>
            <br/>
            <a href="<c:url value="/users"/>">Users</a>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <br>
    <b>Project for EPAM java training</b>
</footer><!-- .footer -->

</body>
</html>
