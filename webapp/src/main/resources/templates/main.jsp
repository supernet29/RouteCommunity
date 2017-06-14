<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/css/RouteCommunity.css"/>
    <title>RouteCommunity</title>
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
        <div class="document_list">
            <table>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>title</th>
                        <th>writer</th>
                    </tr>
                </thead>
                <tbody>
                    <tr th:each="document : ${documents}">
                        <td th:text="${document.id}">id</td>
                        <td ><a href="#" th:href="@{/document/{id}(id=${document.id})}" th:text="${document.title}">id</a></td>
                        <td th:text="${document.writer.name}">id</td>
                    </tr>
                </tbody>
            </table>
            <form action="/" method="post" class="search">
                <p>
                    <span class="label">Source latitude</span> <input type="text" name="source_latitude"/> <span class="label">Source longitude</span> <input type="text" name="source_longitude"/>
                </p>
                <p>
                    <span class="label">Destination latitude</span> <input type="text" name="destination_latitude"/> <span class="label">Destination longitude</span> <input type="text" name="destination_longitude"/>
                </p>
                <a href="/document">New Document</a> <input type="submit" value="search"/>
            </form>
        </div>
    </main>
</body>
</html>