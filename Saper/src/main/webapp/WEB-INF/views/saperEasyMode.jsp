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
           margin: 1px;
       }



       .row {
           clear: both;
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
<script src="/static/js/app.js"></script>
</body>
</html>
