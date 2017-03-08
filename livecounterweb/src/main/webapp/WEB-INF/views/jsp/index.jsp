<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
        <security:csrfInput/>
    </form>
    <input type="button" class="button" value="Logout" onclick="document.getElementById('logoutForm').submit();"/>
</body>
</html>
