<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Login</title>
</head>
<body>
    <h1>欢迎登录</h1>
    <form action="/loginUser" method="post">
        <input type="text" name="username" />
        <input type="password" name="password" />
        <input type="submit" value="提交">
    </form>
</body>
</html>