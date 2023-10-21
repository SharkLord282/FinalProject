<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 16.10.2023
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/static/css/bright/menu.css">
</head>
<body>
<div class="menuBoard">
    <a href="/saper/easy"><button class="menuButton"> Łatwa Gra</button></a>
    <a href="/saper/normal"><button class="menuButton">Średnia Gra</button></a>
    <a href="/saper/hard"><button class="menuButton">Trudna Gra</button></a>
    <a href="/saper/options"><button class="menuButton">Opcje</button></a>
    <a href="/saper/scoreList"><button class="menuButton">Tablica Wyników</button></a>
</div>

<script>
    let link = "/static/css/" + "${viewModel}" + "/menu.css"
    document.write('<link rel="stylesheet" type="text/css" href="'+link+'">');
</script>
</body>
</html>
