<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>Orders management</title>
    <style>
        <%@include file="/css/eShop_stylesheet.css"%>
    </style>
<body>

<div class="wrapper">

    <header class="header">
        <p class="text" align="left">You are logged in as <sec:authentication property="principal.username"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<c:url value="/logout"/>">Logout</a>
        </p>
    </header>

    <div class="middle">

        <div class="container">
            <main class="content">
                <c:if test="${!empty orderList}">
                    <br/>
                    <br/>

                    <h1>List of orders</h1>
                    <br>
                    <br>
                    <table class="tg">
                        <tr>
                            <th width="8%">ID</th>
                            <th width="23%">Date</th>
                            <th width="23%">Status</th>
                            <th width="23%">Cost</th>
                            <th width="23%">Edit</th>
                        </tr>
                        <c:forEach items="${orderList}" var="order">
                            <tr>
                                <td>${order.id}</td>
                                <td>${order.createdAt}</td>
                                <td>${order.status}</td>
                                <td>${order.totalCost/100}</td>
                                <td><a href="<c:url value='/admin/editOrder/${order.id}'/>">Edit</a></td>

                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <c:if test="${order.id != 0}">
                    <br>
                    <h1>Edit order status</h1>
                    <br>
                    <br>
                    <c:url var="addAction" value="/admin/orders/update"/>
                    <form:form action="${addAction}" modelAttribute="order">
                        <table>
                            <tr>
                                <td>
                                    <form:label path="id" cssClass="small-cell">
                                        <spring:message text="ID"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="id" readonly="true" size="8" disabled="true" cssClass="small-cell"/>
                                    <form:hidden path="id"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:hidden path="user.id"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:hidden path="totalCost"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="status" cssClass="small-cell">
                                        <spring:message text="Order status"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="status" cssClass="small-cell">
                                        <form:option value="NEW" label="NEW"/>
                                        <form:option value="SENT" label="SENT"/>
                                        <form:option value="FINISHED" label="FINISHED"/>
                                        <form:option value="CANCELLED" label="CANCELLED"/>
                                    </form:select>
                                </td>
                            </tr>

                            <tr>
                                <td align="left">
                                    <button class="button-min" type="submit">Edit status</button>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </c:if>
                <br>
                <p class="text">
                    This page realize editing the status of orders. When customer do checkout of order it get status
                    "NEW".
                    <br>
                    When order is sent it get status "SENT".
                    <br>
                    When customer get order - status is "FINISHED".
                    <br>
                    If order is cancelled - status is "CANCELLED"
                </p>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <ul class="main-menu">
                <li><a href="<c:url value="/admin/catalog"/>">Catalog</a></li>

                <li><a href="<c:url value="/admin/users"/>">Users</a></li>

                <li class="active"><a href="<c:url value="/admin/orders"/>">Orders</a></li>
            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>

