<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
        <sf:form class="ui large form" name='f' modelAttribute="source" action="perform_save_item" method='POST'>
            <security:csrfInput/>
            <div class="field">
                <div class="ui input fluid">
                    <sf:input type="text" path="id" readonly="true"/>
                </div>
            </div>
            <div class="field">
                <div class="ui input fluid">
                    <sf:input path="name" type="text" />
                </div>
            </div>
            <div class="field">
                <div class="ui input fluid">
                    <sf:input path="address" type="text" />
                </div>
            </div>
            <input name="submit" class="ui primary button fluid " type="submit" value="submit" />
        </sf:form>
    </div>
</body>
</html>
