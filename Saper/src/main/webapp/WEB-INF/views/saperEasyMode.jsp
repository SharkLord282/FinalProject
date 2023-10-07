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


       .areaButton {
           width: 20px;
           height: 20px;
           background-color: rgb(128, 128, 128);
           float: left;
           margin: 1px;

       }



   </style>
</head>
<body>
<c:if test="${map.board ==null}">
    <div>
      <c:forEach var="row" begin="0" end="7">
            <div class="row">
                <c:forEach var="col" begin="0" end="7">
                    <form method="post">
                    <button  class="square emptyArea" data-y="${row}" data-x="${col}"></button>
                    <input type="hidden" id="hidden-x" name="x" value="${col}">
                    <input type="hidden" id="hidden-y" name="y" value="${row}">
                    </form>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
</c:if>


<c:if test="${map.board !=null}">
    <div>
    <c:forEach var="line" items="${map.board}">
        <div class="row">

        <c:forEach var="area" items="${line}" >

               <button type="button" data-x="${area.x}" data-y="${area.y}" class="areaButton ${area.name}"></button>
               <c:if test="${area.number > 0}">
                   <div class="square ${area.name}" data-x="${area.x}" data-y="${area.y}" style="display: none"><a>${area.number}</a></div>
               </c:if>
               <c:if test="${area.number == 0}">
                   <div class="square  ${area.name}" data-x="${area.x}" data-y="${area.y}" style="display: none"></div>
               </c:if>


        </c:forEach>
        </div>
    </c:forEach>

        </c:if>


</div>
<script src="/static/js/app.js"></script>
</body>
</html>
