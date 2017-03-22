<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Источники</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/vendor/css/semantic.css"/>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/vendor/css/style.css"/>
</head>
<style>
    .clear {
        clear: both;
    }
</style>
<body>
    <div class="ui container">
        <h2>Источники</h2>
        <c:if test="${not empty sources}">
            <div class="ui segments">
                <c:forEach var="source" items="${sources}">
                    <div class="ui segment">
                        <div class="left floated column">
                            <a href="${contextPath}/sources/${source.name}">${source.name}</a>
                        </div>
                        <div class="right floated column">
                            ${source.address}
                        </div>
                    </div>

                </c:forEach>
            </div>
        </c:if>


    </div>

</body>
</html>
