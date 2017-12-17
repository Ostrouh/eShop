<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
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
                <br/>
                <br/>

                <h1>Product List</h1>
                <br>
                <br>
                <c:if test="${!empty listProducts}">
                    <table class="tg">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Name</th>
                            <th width="120">Category</th>
                            <th width="120">Quantity</th>
                            <th width="120">Price</th>
                            <th width="60">Edit</th>
                        </tr>
                        <c:forEach items="${listProducts}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.category}</td>
                                <td>${product.quantity}</td>
                                <td>${product.price/100}</td>
                                <td><a href="<c:url value='/editProduct/${product.id}'/>">Edit</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <br>
                <h1>Add product</h1>
                <br>
                <br>

                <c:url var="addAction" value="/catalog/add"/>

                <form:form action="${addAction}" modelAttribute="product">
                    <table>
                        <c:if test="${!empty product.name}">
                            <tr>
                                <td>
                                    <form:label path="id">
                                        <spring:message text="ID"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                                    <form:hidden path="id"/>
                                </td>

                            </tr>
                        </c:if>
                        <tr>
                            <td>
                                <form:label path="name">
                                    <spring:message text="Name"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="name"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="category">
                                    <spring:message text="Category"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="category"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="quantity">
                                    <spring:message text="Quantity"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="quantity"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="price">
                                    <spring:message text="Price"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="price"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty product.name}">
                                    <input type="submit"
                                           value="<spring:message text="Edit product"/>"/>
                                </c:if>
                                <c:if test="${empty product.name}">
                                    <input type="submit"
                                           value="<spring:message text="Add product"/>"/>
                                </c:if>
                            </td>
                        </tr>
                    </table>
                </form:form>
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
