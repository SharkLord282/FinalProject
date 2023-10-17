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
</head>
<body>
<div>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <table>
        <tr>
            <th>Nr</th>
            <th>Nazwa</th>
            <th>Czas</th>
        </tr>
        <c:forEach items="${scors}" var="score" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${score.nickName}</td>
                <td><p class="time">${score.time}</p></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
    const gameTime = document.getElementsByClassName('time')

    Array.from(gameTime).forEach((time) => {
        const minutes = Math.floor(time.innerText / (60 * 1000));
        const seconds = Math.floor((time.innerText % (60 * 1000)) / 1000);

        time.innerText= minutes + ":" + seconds
    })



</script>
</body>
</html>
