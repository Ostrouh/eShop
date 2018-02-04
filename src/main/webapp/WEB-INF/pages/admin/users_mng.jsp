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
        <p class="text" align="left">You are logged in as <sec:authentication property="principal.username"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<c:url value="/logout"/>">Logout</a>
        </p>
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
                            <th width="5%">ID</th>
                            <th width="10%">Name</th>
                            <th width="10%">Surname</th>
                            <th width="15%">Address</th>
                            <th width="15%">Phone</th>
                            <th width="10%">Email</th>
                            <th width="10%">Login</th>
                            <th width="10%">Role</th>
                            <th width="10%">Status</th>
                            <th width="5%">Edit</th>
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
                                <td><a href="<c:url value='/admin/editUser/${user.id}'/>">Edit</a></td>
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
                        <table width="50%">
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
                                <td>
                                    <form:hidden path="credential.id"/>
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <form:label path="name" cssClass="small-cell">
                                        <spring:message text="Name"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="name" cssClass="small-cell"/>
                                </td>
                                <td>
                                    <form:errors path="name" cssClass="error"/>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <form:label path="surname" cssClass="small-cell">
                                        <spring:message text="Surname"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="surname" cssClass="small-cell"/>
                                </td>
                                <td>
                                    <form:errors path="surname" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="address" cssClass="small-cell">
                                        <spring:message text="Address"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="address" cssClass="small-cell"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="phoneNumber" cssClass="small-cell">
                                        <spring:message text="Phone"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="phoneNumber" cssClass="small-cell"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="credential.email" cssClass="small-cell">
                                        <spring:message text="Email"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="credential.email" readonly="true" cssClass="small-cell"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="credential.login" cssClass="small-cell">
                                        <spring:message text="Login"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="credential.login" readonly="true" cssClass="small-cell"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="credential.password" cssClass="small-cell">
                                        <spring:message text="Password"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:hidden path="credential.password" readonly="true" cssClass="small-cell"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="credential.role" cssClass="small-cell">
                                        <spring:message text="Role"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="credential.role" cssClass="small-cell">
                                        <form:option value="ROLE_CUSTOMER" label="CUSTOMER"/>
                                        <form:option value="ROLE_ADMIN" label="ADMIN"/>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="credential.inBlackList" cssClass="small-cell">
                                        <spring:message text="Status"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="credential.inBlackList" cssClass="small-cell">
                                        <form:option value="false" label="Not in BL"/>
                                        <form:option value="true" label="In BL"/>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td align="left">
                                    <input class="button-min" type="submit"
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

            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>
