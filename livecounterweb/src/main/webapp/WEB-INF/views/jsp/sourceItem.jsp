<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Источники</title>
</head>
<body>
    <a href="${contextPath}/sources">Назад</a>
    <h2>Источник ${source.name}</h2>
    <ul>
        <li>
            <span style="width: 450px; display: block;">${source.id}</span>
        </li>
        <li>
            <span style="width: 450px; display: block;">${source.name}</span>
        </li>
        <li>
            <span style="width: 450px; display: block;">${source.address}</span>
        </li>
    </ul>
</body>
</html>
