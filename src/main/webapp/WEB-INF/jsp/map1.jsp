<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Maze Game</title>
</head>
<body>
    <canvas id="canvas" width="650" height="450" style="border:1px solid black;background-color: white;"></canvas>
    <br><br>
    <a href="http://localhost:8080/start">Reset</a>
    <script id="json" type="application/json">
        ${json}
    </script>
    <script src="../js/canvas.js" type="module"></script>
</body>
</html>