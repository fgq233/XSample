<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>

    <form method="post" action="${pageContext.request.contextPath}/login">

        <input type="text" name="username">
        <input type="text" name="password">
        <input type="checkbox" name="isRememberme">
        <input type="submit" value="登陆">
    </form>


</body>
</html>
