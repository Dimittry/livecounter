<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/semantic.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/js/main.js"></script>
</head>
<body>
    <div>
        <h1 class="clr">this is an index.</h1>
        <h2>test</h2>
        <form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
            <security:csrfInput/>
        </form>

        <input type="button" class="button" value="Logout" onclick="document.getElementById('logoutForm').submit();"/>
    </div>
</body>
</html>