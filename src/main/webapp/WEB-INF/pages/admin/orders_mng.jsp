<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="utf-8" />
    <title>Orders management</title>
    <style>
        <%@include file="/css/eShop_stylesheet.css"%>
    </style>
 <body>

<div class="wrapper">

    <header class="header">
        <strong>You are logged in as <sec:authentication property="principal.username"/>
            <a href="<c:url value="/logout"/>">Logout</a>
        </strong>
    </header>

    <div class="middle">

        <div class="container">
            <main class="content">
                <c:if test="${true}">
                    <br/>
                    <br/>

                    <h1>List of orders</h1>
                    <br>
                    <br>
                    <table class="tg">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Date</th>
                            <th width="120">Status</th>
                            <th width="120">Cost</th>
                            <th width="120">Details</th>
                        </tr>
                        <c:forEach items="${listOrders}" var="order">
                            <tr>
                                <td>${order.id}</td>
                                <td>${order.createdAt}</td>
                                <td>${order.status}</td>
                                <td>${order.totalCost}</td>
                                <td><a href="<c:url value='orderDetails/${order.id}'/>">Details</a></td>

                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <ul class="main-menu">
                <li><a href="<c:url value="/admin/catalog"/>">Catalog</a></li>

                <li><a href="<c:url value="/admin/users"/>">Users</a></li>

                <li class="active"><a href="<c:url value="/admin/orders"/>">Orders</a></li>

                <li><a href="<c:url value="/logout"/>">Login</a></li>
            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>

