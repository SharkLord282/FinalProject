<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 20.10.2023
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="menuBoard">
<form id="myForm" action="/saper/options" method="post">

    <label for="view">Wygląd</label>
    <select name="view" id="view">
        <option value="bright">Bright</option>
        <option value="dark">Dark</option>
        <option value="halloween">Halloween</option>
    </select>

</form>
    <a href="/saper"><button class="menuButton">Menu</button></a>
</div>

<script>
        const selectElement = document.getElementById("view");
        const formElement = document.getElementById("myForm");

        let link = "/static/css/" + "${viewModel}" + "/options.css"
        console.log(link)
        document.write('<link rel="stylesheet" type="text/css" href="'+link+'">');
        selectElement.value = "${viewModel}";

        selectElement.addEventListener("change", function() {
            formElement.submit();
        });

</script>
</body>
</html>
