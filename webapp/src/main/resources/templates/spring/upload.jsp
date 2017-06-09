<html>
<body>
<h1>File Upload</h1>
<form action="/spring/upload" method="POST" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit"/>
</form>
<p th:text="${url}">url</p>
<img src = "url" th:attr="src=@{${url}}"/>

</body>
</html>
