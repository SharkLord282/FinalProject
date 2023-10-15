<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 03.10.2023
  Time: 00:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/static/css/mapView.css">
</head>
<body >
    <div style="display: none" id="dificulty" dificulty="easyMap"></div>

    <div class="boardWrapper2">
        <div id="boardBody" class="boardBody">
            <div class="infoWarper">
                <div class="boardInfo">
                    <div    class="boardWrapper">
                    <div id="bombCounter" class="textInfo">010</div>
                    </div>
                    <div    class="boardWrapper">
                    <div id="timer" class="textInfo">000</div>
                    </div>
                </div>
            </div>
            <div class="boardWrapper">
                <div  class="boardBack">
                    <c:forEach var="row" begin="0" end="7">
                        <div class="row">
                            <c:forEach var="col" begin="0" end="7">
                                <div>
                                    <button class="square button" data-y="${row}" data-x="${col}"></button>
                                </div>
                             </c:forEach>
                        </div>
                    </c:forEach>
                 </div>
            </div>
        </div>
    </div>
        <div id="winBoard" class="winBoard" style="display: none">
            <a  href="easyMap" ><button class="menuButton">Nowa Gra</button></a>
            <button class="menuButton">Zapisz Wynik</button>
            <button class="menuButton">Menu</button>
        </div>

<script src="/static/js/app.js"></script>
</body>
</html>
