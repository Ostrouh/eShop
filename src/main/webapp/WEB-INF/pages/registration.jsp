<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script><![endif]-->
    <title>Registration</title>
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
                <h1>Fill in the blanks</h1>

                <c:url var="addAction" value="/sign-up"/>

                <form:form action="${addAction}" modelAttribute="user">
                    <table>
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
                                <form:label path="surname">
                                    <spring:message text="Surname"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="surname"/>
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
                            <td colspan="2">
                                    <input type="submit"
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

<footer class="footer">
    <br>
    <b>Project for EPAM java training</b>
</footer><!-- .footer -->

</body>
</html>

