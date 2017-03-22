<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/semantic.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/css/style.css"/>

    <style type="text/css">
        body {
            background-color: #DADADA;
        }
        .column {
            max-width: 450px;
        }
    </style>
</head>
<body>
    <div class="ui middle aligned center aligned grid">
        <div class="column">

            <h1>Login</h1>

            <form class="ui large form" name='f' action="perform_login" method='POST'>
                <security:csrfInput/>
                <div class="ui stacked segment">
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="user icon"></i>
                            <input type="text" name="username" placeholder="Username">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="lock icon"></i>
                            <input type="password" name="password" placeholder="Password">
                        </div>
                    </div>

                    <input name="submit" class="ui primary button fluid " type="submit" value="submit" />
                </div>

                <div class="ui error message"></div>

            </form>
        </div>
    </div>
</body>
</html>