<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
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