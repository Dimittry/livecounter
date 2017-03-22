<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Источники</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/vendor/css/semantic.css"/>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/vendor/css/style.css"/>
</head>
<body>
    <div class="ui container">
        <a href="${contextPath}/sources">Назад</a>
        <h2>Источник ${source.name}</h2>
        <form class="ui large form" name='f' action="perform_save_item" method='POST'>
            <security:csrfInput/>
            <div class="field">
                <div class="ui input fluid">
                    <input type="text" value="${source.id}">
                </div>
            </div>
            <div class="field">
                <div class="ui input fluid">
                    <input type="text" value="${source.name}">
                </div>
            </div>
            <div class="field">
                <div class="ui input fluid">
                    <input type="text" value="${source.address}">
                </div>
            </div>
            <input name="submit" class="ui primary button fluid " type="submit" value="submit" />

        </form>
    </div>
</body>
</html>
