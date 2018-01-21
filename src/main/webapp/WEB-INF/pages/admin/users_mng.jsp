<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Users management</title>
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

                <c:if test="${!empty listUsers}">
                    <br/>
                    <br/>

                    <h1>List of users</h1>
                    <br>
                    <br>
                    <table class="tg">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Name</th>
                            <th width="120">Surname</th>
                            <th width="120">Address</th>
                            <th width="120">Phone</th>
                            <th width="120">Email</th>
                            <th width="120">Login</th>
                            <th width="120">Role</th>
                            <th width="120">Status</th>
                            <th width="60">Edit</th>
                        </tr>
                        <c:forEach items="${listUsers}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.surname}</td>
                                <td>${user.address}</td>
                                <td>${user.phoneNumber}</td>
                                <td>${user.credential.email}</td>
                                <td>${user.credential.login}</td>
                                <td>${user.credential.role.toString()}</td>
                                <td>${user.credential.inBlackList ? "In black list" : "Not in black list"}</td>
                                <td><a href="<c:url value='editUser/${user.id}'/>">Edit</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>

                <c:url var="addAction" value="/admin/users/update"/>

                <form:form action="${addAction}" modelAttribute="user">
                    <c:if test="${!empty user.name}">
                        <br>
                        <h1>Edit user</h1>
                        <br>
                        <br>
                        <table>
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
                                    <form:input path="credential.email" readonly="true"/>
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
                                    <form:label path="credential.role">
                                        <spring:message text="Role"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="credential.role">
                                        <form:option value="CUSTOMER" label="CUSTOMER"/>
                                        <form:option value="ADMIN" label="ADMIN"/>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="credential.inBlackList">
                                        <spring:message text="Status"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="credential.inBlackList">
                                        <form:option value="false" label="Not in BL"/>
                                        <form:option value="true" label="In BL"/>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit"
                                           value="<spring:message text="Edit user"/>"/>
                                </td>
                            </tr>
                        </table>
                    </c:if>
                </form:form>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <ul class="main-menu">
                <li><a href="<c:url value="/admin/catalog"/>">Catalog</a></li>

                <li class="active"><a href="<c:url value="/admin/users"/>">Users</a></li>

                <li><a href="<c:url value="/admin/orders"/>">Orders</a></li>

                <li><a href="<c:url value="/logout"/>">Logout</a></li>
            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>
