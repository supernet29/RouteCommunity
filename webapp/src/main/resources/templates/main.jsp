<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>RouteCommunity</title>
</head>
<body>
    <header>
        <h1>Route Community</h1>
    </header>
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
                        <td th:text="${document.title}">id</td>
                        <td th:text="${document.writer.name}">id</td>
                    </tr>
                </tbody>
            </table>
            <p><a href="/write">New Document</a></p>
        </div>
    </main>
    <sub>
        <div class = "userinfo">
            <img src="/귤.jpeg" th:attr="src=${user.imageUrl}" />
            <p class="name" th:text="${user.name}">Please login.</p>
        </div>
        <div class="navigation">
            <ul>
                <li><a href="/login">Login</a></li>
                <li><a href="/">Community</a></li>
            </ul>
        </div>
    </sub>
</body>
</html>