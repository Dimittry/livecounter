<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Источники</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/vendor/css/semantic.css"/>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/vendor/css/docs.css"/>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/vendor/css/style.css"/>
</head>
<style>
    .clear {
        clear: both;
    }
</style>
<body id="example">
    <div class="pusher">
        <div class="full height">
                <div class="toc"></div>
                <div class="article">
                    <div class="ui masthead vertical segment">
                        <div class="ui container">
                            <h2 class="ui header">Источники</h2>
                            <div class="ui button">
                                <a href="${contextPath}/sources/add">Добавить</a>
                            </div>
                        </div>
                    </div>
                    <div class="ui intro ">
                        <c:if test="${not empty sources}">
                            <div class="no example">
                                <div class="ui items divided ">
                                    <c:forEach var="source" items="${sources}">
                                        <div class="item">
                                            <div class="content">
                                                <div class="header">
                                                    <a href="${contextPath}/sources/${source.name}">${source.name}</a>
                                                </div>
                                                <%--<div class="meta">--%>
                                                    <%--<span class="price">$1200</span>--%>
                                                    <%--<span class="stay">1 Month</span>--%>
                                                <%--</div>--%>
                                                <div class="description">
                                                    <p>${source.address}</p>
                                                </div>
                                                <div class="extra">
                                                    <div class="ui right floated button">
                                                        <a href="${contextPath}/sources/${source.name}">Редактировать</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
        </div>
    </div>
</body>
</html>
