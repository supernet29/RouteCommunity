<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/css/RouteCommunity.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Sub.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Map.css"/>
    <title> Write Document </title>
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
            <form action = "/document" method="post">
                <div class="title">
                    <p><span class="label">Title</span> <input type="text" name="title"/></p>
                    <div class="map">
                        <div id="map"></div>
                        <div class="pollSelector">
                            <span id="btn_source" onclick="selectSource()">출발지</span>
                            <span id="btn_destination" onclick="selectDestination()">도착지</span>
                        </div>
                    </div>
                    <input id="source_latitude" type="hidden" name="source_latitude"/>
                    <input id="source_longitude" type="hidden" name="source_longitude"/>
                    <input id="destination_latitude" type="hidden" name="destination_latitude"/>
                    <input id="destination_longitude" type="hidden" name="destination_longitude"/>
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
    <script>
    		var container = document.getElementById('map');
    		var options = {
    			center: new daum.maps.LatLng(33.450701, 126.570667),
    			level: 3
    		};

    		var map = new daum.maps.Map(container, options);
    		var source = new daum.maps.Marker({
    		    map: map,
    		    position : map.getCenter(),
    		    title: "Source"
    		});

    		var destination = new daum.maps.Marker({
    		    map: map,
    		    position : map.getCenter(),
    		    title: "Destination"
    		});

    		var currentMarker = source;

    		daum.maps.event.addListener(map, 'click', function(mouseEvent){
    		    var latLng = mouseEvent.latLng;
    		    currentMarker.setPosition(latLng);
    		    applyValue();
    		});

    		function applyValue(){
    		    var sourceLatLng = source.getPosition();
    		    var destinationLatLng = destination.getPosition();

    		    var source_latitude = document.getElementById("source_latitude");
    		    var source_longitude = document.getElementById("source_longitude");
    		    var destination_latitude = document.getElementById("destination_latitude");
    		    var destination_longitude = document.getElementById("destination_longitude");

    		    source_latitude.value = sourceLatLng.getLat();
    		    source_longitude.value = sourceLatLng.getLng();
    		    destination_latitude.value = destinationLatLng.getLat();
    		    destination_longitude.value = destinationLatLng.getLng();
    		}

    		function selectSource(){
    		    currentMarker = source;
    		}
    		function selectDestination(){
    		    currentMarker = destination;
    		}
    </script>
</body>
</html>