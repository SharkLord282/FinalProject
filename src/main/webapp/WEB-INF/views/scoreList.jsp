<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 17.10.2023
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/static/css/bright/table.css">
    <%@ taglib prefix="co" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
<div class="table-container">
    <div class="score-table">
        <table>
            <tr><th colspan="3">Łatwy</th></tr>
            <tr>
                <th>Nr</th>
                <th>Nazwa</th>
                <th>Czas</th>
            </tr>
            <c:forEach varStatus="loop" begin="0" end="9">
                <c:choose>
                    <c:when test="${loop.index < fn:length(easyScors)}">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${easyScors[loop.index].nickName}</td>
                            <td><p class="time">${easyScors[loop.index].time}</p></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td></td>
                            <td></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </table>
    </div>

    <div class="score-table">
        <table>
            <tr><th colspan="3">Normalny</th></tr>
            <tr>
                <th>Nr</th>
                <th>Nazwa</th>
                <th>Czas</th>
            </tr>
            <c:forEach varStatus="loop" begin="0" end="9">
                <c:choose>
                    <c:when test="${loop.index < fn:length(normalScors)}">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${normalScors[loop.index].nickName}</td>
                            <td><p class="time">${normalScors[loop.index].time}</p></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td></td>
                            <td></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </table>
    </div>

    <div class="score-table">
        <table>
            <tr><th colspan="3">Tródny</th></tr>
            <tr>
                <th>Nr</th>
                <th>Nazwa</th>
                <th>Czas</th>
            </tr>
            <c:forEach varStatus="loop" begin="0" end="9">
                <c:choose>
                    <c:when test="${loop.index < fn:length(hardScors)}">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${hardScors[loop.index].nickName}</td>
                            <td><p class="time">${hardScors[loop.index].time}</p></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td></td>
                            <td></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </table>
    </div>
</div>

<a href="/saper"><button class="menuButton">Menu</button></a>

<script>
    const gameTime = document.getElementsByClassName('time')
    let link = "/static/css/" + "${viewModel}" + "/menu.css"
    document.write('<link rel="stylesheet" type="text/css" href="'+link+'">');

    Array.from(gameTime).forEach((time) => {
        const minutes = Math.floor(time.innerText / (60 * 1000));
        const seconds = Math.floor((time.innerText % (60 * 1000)) / 1000);

        time.innerText = minutes + ":" + seconds
    })
</script>
</body>

</html>
