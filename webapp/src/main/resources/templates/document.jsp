<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
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
                <textarea name="comment"></textarea>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    </main>
    <nav>
        <p><a href="/">Goto Main</a></p>
    </nav>
</body>
</html>