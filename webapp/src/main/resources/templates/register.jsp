<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Register User</title>
</head>
<body>
    <main>
        <form action="/register" method="post" enctype="multipart/form-data">
            <ul>
                <li><span>name</span><input type="text" name="name"/></li>
                <li><span>password</span><input type="text" name="password"/></li>
                <li><span>email</span><input type="text" name="email"/></li>
                <li><span>user picture</span><input type="file" name="image"/></li>
            </ul>
            <input type="submit" value="submit"/>
        </form>
    </main>
</body>
</html>