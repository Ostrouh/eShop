<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
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

                <br/>
                <br/>

                <h1>List of goods in the cart</h1>
                <br>
                <br>
                <c:if test="${!empty listItems}">

                    <table class="tg">
                        <tr>
                            <th width="20%">Name</th>
                            <th width="20%">Category</th>
                            <th width="20%">Quantity</th>
                            <th width="20%">Price</th>
                            <th width="20%">Remove</th>
                        </tr>
                        <c:forEach items="${listItems}" var="cartItem">
                            <tr>
                                <td>${cartItem.product.name}</td>
                                <td>${cartItem.product.category}</td>
                                <td>${cartItem.quantity}</td>
                                <td>${(cartItem.product.price * cartItem.quantity)/100}</td>
                                <td><a href="<c:url value='cart/removeFromCart/${cartItem.id}'/>">Remove from cart</a></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="4" align="center">Total cost</td>
                            <td colspan="1" align="center">${cart.totalCost/100}</td>
                        </tr>
                    </table>
                    <form method="post" action="/customer/checkout"/>
                    <button type="submit">Checkout of order</button>
                    </form>
                </c:if>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <ul class="main-menu">
                <li><a href="<c:url value="/customer/catalog"/>">Catalog</a></li>

                <li><a href="<c:url value="/customer/orders"/>">My orders</a></li>

                <li><a href="<c:url value="/customer/cabinet"/>">My cabinet</a></li>

                <li class="active"><a href="<c:url value="/customer/cart"/>">Cart (${cart.itemsAmount})</a></li>

            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>

