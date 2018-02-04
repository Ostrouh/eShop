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
        <br>
        <strong>You are logged in as <sec:authentication property="principal.username"/>
            <a href="<c:url value="/logout"/>">Logout</a>
        </strong>
        <br>
        Goods in the cart is ${cart.itemsAmount}
    </header>

    <div class="middle">

        <div class="container">
            <main class="content">

                <c:if test="${!empty listProducts}">
                    <br/>
                    <br/>

                    <h1>Product List</h1>
                    <br>
                    <br>
                    <table class="tg">
                        <tr>
                            <th width="10%">ID</th>
                            <th width="20%">Name</th>
                            <th width="20%">Category</th>
                            <th width="20%">Quantity</th>
                            <th width="20%">Price</th>
                            <th width="10%"></th>
                        </tr>
                        <c:forEach items="${listProducts}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.category}</td>
                                <td>${product.quantity}</td>
                                <td>${product.price/100}</td>
                                <td><a href="<c:url value='addProductToCart/${product.id}'/>">Add to cart</a></td>

                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <ul class="main-menu">
                <li class="active"><a href="<c:url value="/customer/catalog"/>">Catalog</a></li>

                <li><a href="<c:url value="/customer/orders"/>">My orders</a></li>

                <li><a href="<c:url value="/customer/cabinet"/>">My cabinet</a></li>

                <li><a href="<c:url value="/customer/cart"/>">Cart</a></li>

            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>
