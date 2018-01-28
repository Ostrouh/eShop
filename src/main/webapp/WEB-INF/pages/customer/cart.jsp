<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <strong>You are logged in as <sec:authentication property="principal.username"/>
            <a href="<c:url value="/logout"/>">Logout</a>
        </strong>
    </header>

    <div class="middle">

        <div class="container">
            <main class="content">

                <c:if test="${!empty listItems}">
                    <br/>
                    <br/>

                    <h1>Product List</h1>
                    <br>
                    <br>
                    <table class="tg">
                        <tr>
                            <th width="120">Name</th>
                            <th width="120">Category</th>
                            <th width="120">Quantity</th>
                            <th width="120">Price</th>
                        </tr>
                        <c:forEach items="${listItems}" var="cartItem">
                            <tr>
                                <td>${cartItem.product.name}</td>
                                <td>${cartItem.product.category}</td>
                                <td>${cartItem.quantity}</td>
                                <td>${(cartItem.product.price * cartItem.quantity)/100}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="2" align="center">Total cost</td>
                            <td colspan="2" align="center">${cart.totalCost}</td>
                        </tr>
                    </table>
                </c:if>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <ul class="main-menu">
                <li><a href="<c:url value="/customer/catalog"/>">Catalog</a></li>

                <li><a href="<c:url value="/customer/orders"/>">My orders</a></li>

                <li><a href="<c:url value="/customer/cabinet"/>">My cabinet</a></li>

                <li class="active"><a href="<c:url value="/customer/cart"/>">Cart</a></li>

            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>

