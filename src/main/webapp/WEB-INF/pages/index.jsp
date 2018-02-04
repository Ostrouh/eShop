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
            <main class="content" >
                <p class="text">
                    <b>Online store</b> system.
                    <br>
                    The <b>administrator</b> supports the  catalog of <b>Products</b>.
                    <br>
                    The <b>customer</b> executes and pays for the <b>Order</b> for the <b>Products</b>.
                    <br>
                    The <b>administrator</b> can put the non-payers in the "black list".
                </p>

                <p class="text">

                <ul class="index-ul">
                <b>Used technologies:</b>
                <li>Spring MVC</li>
                <li>JSP</li>
                <li>MySQL</li>
                <li>Hibernate</li>
                <li>Spring Security</li>
                <li>JUnit</li>
                <li>Log4j</li>
                <li>Tomcat</li>
                </ul>
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
