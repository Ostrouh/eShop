}<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog management</title>
    <style>
        <%@include file="/css/eShop_stylesheet.css"%>
    </style>
<body>

<div class="wrapper">

    <header class="header">
        <strong>You are logged in as <sec:authentication property="principal.username"/></strong>
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
                            <th width="120">Date</th>
                            <th width="120">Status</th>
                            <th width="120">Cost</th>
                            <th width="120">Details</th>
                        </tr>
                        <c:forEach items="${listOrders}" var="order">
                            <tr>
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
                <li><a href="<c:url value="/customer/catalog"/>">Catalog</a></li>

                <li class="active"><a href="<c:url value="/customer/orders"/>">My orders</a></li>

                <li><a href="<c:url value="/customer/cabinet"/>">My cabinet</a></li>

                <li><a href="<c:url value="/logout"/>">Logout</a></li>
            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>

