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

</head>
<body >
    <div style="display: none" id="dificulty" dificulty="${map.difficulty}"></div>
    <div style="display: none;" id="viewMode" viewMode="${map.vievMode}"></div>
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
                    <c:forEach var="row" begin="0" end="${map.xSize}">
                        <div class="row">
                            <c:forEach var="col" begin="0" end="${map.ySize}">
                                <div>
                                    <button class="square button" data-y="${col}" data-x="${row}"></button>
                                </div>
                             </c:forEach>
                        </div>
                    </c:forEach>
                 </div>
            </div>
        </div>
    </div>
        <div id="winBoard" class="menuBoard" style="display: none">
            <form method="post" action="scoreList" class="winForm">
                <a>Gratulację</a>
                <a id="winText">Twój czas to </a>
                <a>Wprowadź swój nick</a>
                <input type="text" name="nickName"/>
                <input type="number" name="gameTime"   id="gameTime" value="" style="display: none;" />
                <input type="text" name="dificulty" value="${map.difficulty}" style="display: none;"/>
                <button type="submit" id="saveResult" class="menuButton">Zapisz Wynik</button>
            </form>

            <a href="https://www.youtube.com/watch?v=BBJa32lCaaY&autoplay=1" id="fakeSaveResult" style="display: none"><button class="menuButton" >Zapisz Wynik</button></a>
            <a  href="easy"  ><button class="menuButton">Nowa Gra</button></a>
            <a  href="/saper" ><button class="menuButton">Menu</button></a>

        </div>
    <div id="lossBoard" class="menuBoard" style="display: none">
        <a  href="easy" ><button class="menuButton">Nowa Gra</button></a>
        <button id="repeatGame" class="menuButton">Powtórz Rozgrywkę</button>
        <a  href="/saper" ><button class="menuButton">Menu</button></a>
    </div>

<script src="/static/js/app.js"></script>
</body>
</html>
