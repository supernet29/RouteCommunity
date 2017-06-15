<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>Login</title>
</head>
<body>
    <main>
        <form action="/login" method="post">
            <ul>
                <li><span>name</span> <input type="text" name="name"/></li>
                <li><span>password</span> <input type="password" name="password"/></li>
            </ul>
            <input type="submit"/> <span><a href="/">Goto Main</a></span>
        </form>
    </main>
</body>
</html>