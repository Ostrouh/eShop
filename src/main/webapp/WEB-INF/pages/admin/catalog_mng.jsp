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

                <c:if test="${!empty listProducts}">
                    <br/>
                    <br/>

                    <h1>Product List</h1>
                    <br>
                    <br>
                    <table class="tg">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Name</th>
                            <th width="120">Category</th>
                            <th width="120">Quantity</th>
                            <th width="120">Price</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        <c:forEach items="${listProducts}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.category}</td>
                                <td>${product.quantity}</td>
                                <td>${product.price/100}</td>
                                <td><a href="<c:url value='editProduct/${product.id}'/>">Edit</a></td>
                                <td><a href="<c:url value='deleteProduct/${product.id}'/>">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <br>
                <h1>Add product</h1>
                <br>
                <br>

                <c:url var="addAction" value="/admin/catalog/add"/>

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
                            <td>
                                <form:errors path="name" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="category">
                                    <spring:message text="Category"/>
                                </form:label>
                            </td>
                            <td>
                                <form:select path="category">
                                    <form:option value="FIRST" label="First"/>
                                    <form:option value="SECOND" label="Second"/>
                                </form:select>
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
            <ul class="main-menu">
                <li class="active"><a href="<c:url value="/admin/catalog"/>">Catalog</a></li>

                <li><a href="<c:url value="/admin/users"/>">Users</a></li>

                <li><a href="<c:url value="/admin/orders"/>">Orders</a></li>

            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>