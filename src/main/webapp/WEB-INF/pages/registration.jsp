<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />

    <title>Registration</title>
    <style>
        <%@include file="/css/eShop_stylesheet.css"%>
    </style>
<body>

<div class="wrapper">

    <header class="header">
        <strong>Fill in all the blanks, please</strong>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">


                <c:url var="addAction" value="/registration"/>

                <form:form action="${addAction}" modelAttribute="user">
                    <table>
                        <tr>
                            <td>
                                <form:label path="name"  cssClass="signin">
                                    <spring:message text="Name"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="name" cssClass="signin"/>
                            </td>
                            <td>
                                <form:errors path="name" cssClass="error"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <form:label path="surname" cssClass="signin">
                                    <spring:message text="Surname"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="surname" cssClass="signin"/>
                            </td>
                            <td>
                                <form:errors path="surname" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="address" cssClass="signin">
                                    <spring:message text="Address"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="address" cssClass="signin"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="phoneNumber" cssClass="signin">
                                    <spring:message text="Phone"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="phoneNumber" cssClass="signin"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="credential.email" cssClass="signin">
                                    <spring:message text="Email"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="credential.email" cssClass="signin"/>
                            </td>
                            <td>
                                <form:errors path="credential.email" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="credential.login" cssClass="signin">
                                    <spring:message text="Login"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="credential.login" cssClass="signin"/>
                            </td>
                            <td>
                                <form:errors path="credential.login" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="credential.password" cssClass="signin">
                                    <spring:message text="Password"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input type="password" path="credential.password" cssClass="signin" />
                            </td>
                            <td>
                                <form:errors path="credential.password" cssClass="error"/>
                            </td>
                        </tr>

                        <tr>
                            <td align="left">
                                    <input class="button" type="submit"
                                           value="<spring:message text="sign-up"/>"/>
                            </td>
                        </tr>
                    </table>
                </form:form>


            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <ul class="main-menu">

            </ul>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

</body>
</html>

