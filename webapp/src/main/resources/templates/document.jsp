<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/css/RouteCommunity.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Sub.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Document.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Map.css"/>
    <title th:text="@{Document : {name}(name=${document.title})}">Document : name</title>
    <script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=" th:attr="src=@{//apis.daum.net/maps/maps3.js?apikey={key}(key=#{map.key})}"></script>
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
                <p><span class="label">Title : </span> <span th:text="${document.title}">title</span></p>
                <div class="map">
                    <div id="map"></div>
                </div>
            </div>
            <div class="content">
                <p class="label">Content</p>
                <p class="content" th:text="${document.content}">abc</p>
            </div>
            <p><a href="#" th:href="@{/document/{id}/remove(id=${document.id})}">Remove</a></p>
            <p><a href="/">Goto Main</a></p>
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
    </main>
    <script th:inline="javascript">
    		var container = document.getElementById('map');
    		var options = {
    			center: new daum.maps.LatLng(33.450701, 126.570667),
    			level: 3
    		};
    		var map = new daum.maps.Map(container, options);

    		var sourceLat = [[${document.source.latitude}]];
    		var sourceLng = [[${document.source.longitude}]];
    		var destinationLat = [[${document.destination.latitude}]];
    		var destinationLng = [[${document.destination.longitude}]];

    		var sourceLatLng = new daum.maps.LatLng(sourceLat, sourceLng);
    		var destinationLatLng = new daum.maps.LatLng(destinationLat, destinationLng);

    		var sourceMarker = new daum.maps.Marker({
    		    map: map,
    		    position : sourceLatLng,
    		    title:"Source",
    		    clickable: true
    		});

    		var sourceInfo = new daum.maps.InfoWindow({
    		    map: map,
    		    position : sourceLatLng,
    		    content : "Source"
    		});

    		var destinationMarker = new daum.maps.Marker({
    		    map: map,
    		    position : destinationLatLng,
    		    title:"Destination",
    		    clickable: true
    		});

    		var destinationInfo = new daum.maps.InfoWindow({
    		    map: map,
    		    position : destinationLatLng,
    		    content : "Destination"
    		});
    </script>
</body>
</html>