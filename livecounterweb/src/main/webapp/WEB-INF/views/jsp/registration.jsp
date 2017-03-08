<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="false"%>
<html xmlns:spring="http://www.w3.org/1999/XSL/Transform" xmlns:form="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title><spring:message code="form.title"></spring:message></title>
</head>
<body>
Это круто
    <h1><spring:message code="form.title"></spring:message></h1>
    <form:form modelAttribute="user" action="/user/registration" method="POST" enctype="utf8">
        <br>
        <tr>
            <td>
                <label><spring:message code="user.firstName"></spring:message></label>
            </td>
            <td><form:input path="firstName" value=""/></td>
            <form:errors path="firstName" element="div"/>
        </tr>
        <tr>
            <td>
                <label><spring:message code="user.lastName"></spring:message></label>
            </td>
            <td><form:input path="lastName" value=""/></td>
            <form:errors path="lastName" element="div"/>
        </tr>
        <tr>
            <td>
                <label><spring:message code="user.email"></spring:message></label>
            </td>
            <td><form:input path="email" value=""/></td>
            <form:errors path="email" element="div"/>
        </tr>
        <tr>
            <td>
                <label><spring:message code="user.password"></spring:message></label>
            </td>
            <td><form:input path="password" value="" type="password"/></td>
            <form:errors path="password" element="div"/>
        </tr>
        <tr>
            <td>
                <label><spring:message code="user.confirmPass"></spring:message></label>
            </td>
            <td><form:input path="matchingPassword" value="" type="password"/></td>
            <form:errors element="div"/>
        </tr>
        <button type="submit"><spring:message code="form.submit"></spring:message></button>
    </form:form>
    <br>
    <%--<a href="<c:url value='login.html'/>">--%>
    <a href="">
        <spring:message code="form.loginLink"></spring:message>
    </a>
</body>
</html>