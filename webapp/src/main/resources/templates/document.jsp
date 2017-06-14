<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/css/RouteCommunity.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Sub.css"/>
    <title th:text="@{Document : {name}(name=${document.title})}">Document : name</title>
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
            <div class="info">
                <p><span class="label">Title</span> <span th:text="${document.title}">title</span></p>
                <p><span class="label">Source Latitude</span> <span th:text="${document.source.latitude}">title</span> <span class="label">Source Longitude</span> <span th:text="${document.source.longitude}">title</span></p>
                <p><span class="label">Destination Latitude</span> <span th:text="${document.destination.latitude}">title</span> <span class="label">Destination Longitude</span> <span th:text="${document.destination.longitude}">title</span></p>
            </div>
            <div class="content">
                <p class="label">Content</p>
                <p class="content" th:text="${document.content}">abc</p>
            </div>
            <p><a href="#" th:href="@{/document/{id}/remove(id=${document.id})}">remove</a></p>
        </div>
        <div class="comments">
            <div class="comment" th:each="comment : ${comments}">
                <p class="writerInfo"> <span class="label">Writer</span> <span th:text="${comment.writer.name}">name</span> </p>
                <p class="content" th:text="${comment.content}">aa</p>
            </div>
        </div>
        <div class="commentWriter">
            <form th:attr="action=@{/document/{id}/comment(id=${document.id})}" method="post">
                <span class="label">Comment:</span>
                <input type="text" name="comment"/>
                <input type="submit" value="Submit"/>
            </form>
        </div>
        <p><a href="/">Goto Main</a></p>
    </main>
</body>
</html>