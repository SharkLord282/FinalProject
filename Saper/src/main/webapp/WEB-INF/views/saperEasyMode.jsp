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
   <style>

       .square {
           width: 20px;
           height: 20px;
           background-color: rgb(128, 128, 128);
           float: left;
           margin: 2px; /* Dodaj marginesy dla odstępu między kwadratami */
       }

       .row {
           clear: both; /* Wykorzystaj clear, aby nowy rząd zaczynał się od nowej linii */
       }

       .bomb {
           background-color: black;

       }

       .number {
           background-color: yellow;
       }

   </style>
</head>
<body>


    <div>
    <c:forEach var="line" items="${map.board}">
        <div class="row">

        <c:forEach var="area" items="${line}">

            <c:if test="${area.number > 0}">
                <div class="square ${area.name}"><a>${area.number}</a></div>
            </c:if>
            <c:if test="${area.number == 0}">
                <div class="square ${area.name}"></div>
            </c:if>

        </c:forEach>
        </div>
    </c:forEach>
</div>

</body>
</html>
