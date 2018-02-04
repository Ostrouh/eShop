<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>EShop</title>
    <style>
        <%@include file="/css/eShop_stylesheet.css"%>
    </style>
<body>

<div class="wrapper">

    <header class="header">
        <strong>Header:</strong>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
                <br>
                <br>
                <h2>Welcome <sec:authentication property="principal.username" />!</h2>

                <br>
                <br>
                <h3>
                    Now You can manage the catalog, the list of users and the list of orders.
                </h3>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <ul class="main-menu">
                <li><a href="<c:url value="admin/catalog"/>">Catalog</a></li>

                <li><a href="<c:url value="admin/users"/>">Users</a></li>

                <li><a href="<c:url value="/admin/orders"/>">Orders</a></li>

                <li><a href="<c:url value="/logout"/>">Logout</a></li>
            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>


