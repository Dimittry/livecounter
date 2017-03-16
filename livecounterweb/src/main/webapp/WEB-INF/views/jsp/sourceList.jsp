<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Источники</title>
</head>
<style>
    .clear {
        clear: both;
    }
</style>
<body>
    <h2>Источники</h2>
    <c:if test="${not empty sources}">
        <ul>
            <c:forEach var="source" items="${sources}">
                <li>
                    <span style="width: 80px; display: block; float: left;">
                        <a href="${contextPath}/sources/${source.name}">${source.name}</a>
                    </span>
                    <span style="width: 450px; display: block; float: left;">${source.address}</span>
                    <div class="clear"/>
                </li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
