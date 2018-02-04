<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
    <style>
        <%@include file="/css/eShop_stylesheet.css"%>
    </style>
</head>

<body>

<div class="wrapper">

    <header class="header">
        <p class="text" align="left">You are logged in as <sec:authentication property="principal.username"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<c:url value="/logout"/>">Logout</a>
        </p>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
                <br/>
                <br/>
                <h1>My data</h1>
                <br>
                <br>
                <table class="tg">
                    <tr>
                        <th width="10%">ID</th>
                        <th width="15%">Name</th>
                        <th width="15%">Surname</th>
                        <th width="15%">Address</th>
                        <th width="15%">Phone</th>
                        <th width="15%">Email</th>
                        <th width="15%">Login</th>
                        <!--<th width="120">Edit</th>-->
                    </tr>
                    <tr>
                        <td>${currentUser.id}</td>
                        <td>${currentUser.name}</td>
                        <td>${currentUser.surname}</td>
                        <td>${currentUser.address}</td>
                        <td>${currentUser.phoneNumber}</td>
                        <td>${currentUser.credential.email}</td>
                        <td>${currentUser.credential.login}</td>
                        <!--<td><a href="<c:url value='/customer/cabinet/edit/${currentUser.id}'/>">Edit</a></td>-->
                    </tr>
                </table>
                <!-- <c:url var="addAction" value="/customer/cabinet/update"/>
                <form:form action="${addAction}" modelAttribute="currentUser">
                    <c:if test="${!empty currentUser.name}">
                        <br>
                        <h1>Edit my data</h1>
                        <br>
                        <br>
                        <table width="100%">
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
                                <td>
                                    <form:hidden path="credential.id"/>
                                </td>

                            </tr>
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
                                    <form:label path="surname">
                                        <spring:message text="Surname"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="surname"/>
                                </td>
                                <td>
                                    <form:errors path="surname" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="address">
                                        <spring:message text="Address"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="address"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="phoneNumber">
                                        <spring:message text="Phone"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="phoneNumber"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="credential.email">
                                        <spring:message text="Email"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="credential.email"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="credential.login">
                                        <spring:message text="Login"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="credential.login" readonly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="credential.password">
                                        <spring:message text="Password"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="credential.password" readonly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:hidden path="credential.role"/>
                                </td>
                            </tr>
                            <tr>

                                <td>
                                    <form:hidden path="credential.inBlackList"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit"
                                           value="<spring:message text="Edit my data"/>"/>
                                </td>
                            </tr>
                        </table>
                    </c:if>
                </form:form> -->
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <ul class="main-menu">
                <li><a href="<c:url value="/customer/catalog"/>">Catalog</a></li>

                <li><a href="<c:url value="/customer/orders"/>">My orders</a></li>

                <li class="active"><a href="<c:url value="/customer/cabinet"/>">My cabinet</a></li>

                <li><a href="<c:url value="/customer/cart"/>">Cart (${cart.itemsAmount})</a></li>

            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>
