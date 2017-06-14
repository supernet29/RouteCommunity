<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/css/RouteCommunity.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Sub.css"/>
    <title> Write Document </title>
</head>
<body>
    <header>
        <h1>Route Community</h1>
    </header>
    <sub>
        <div class = "userinfo">
            <img src="/귤.jpeg" th:attr="src=@{/userpicture/{url}(url=${user.imageUrl})}" />
            <p class="name" th:text="${user.name}">Please login.</p>
        </div>
        <div class="navigation">
            <ul>
                <li><a href="/login" th:href="${accountUrl}" th:text="${accountText}">Login</a></li>
                <li><a href="/">Main</a></li>
                <li><a href="/register">Register</a></li>
            </ul>
        </div>
    </sub>
    <main>
        <div class="document">
            <form action = "/document" method="post">
                <div class="title">
                    <p><span class="label">Title</span> <input type="text" name="title"/></p>
                    <p><span class="label">Source Latitude</span> <input type="text" name="source_latitude"/> <span class="label">Source Longitude</span> <input type="text" name="source_longitude"/> </p>
                    <p><span class="label">Destination Latitude</span> <input type="text" name="destination_latitude"/> <span class="label">Destination Longitude</span> <input type="text" name="destination_longitude"/> </p>
                </div>
                <div class="content">
                    <p class="label">Content</p>
                    <textarea name="content"></textarea>
                </div>
                <input type="submit" value="Submit"/>
                <span class="back"><a href="/">Goto Main</a></span>
            </form>
        </div>
    </main>
</body>
</html>