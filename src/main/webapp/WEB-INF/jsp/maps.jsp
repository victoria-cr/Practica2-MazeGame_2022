<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Maze Game</title>
    <style>
        html {
            font-family: 'Josefin Sans', sans-serif;
        }
        h1 {
            text-align: center;
            font-size: 26pt;
        }
        canvas {
            margin-left: auto;
            margin-right: auto;
            display: block;
        }
        div {
            text-align: center;
        }
        a {
            color: #000;
            text-decoration: none;
            cursor: pointer;
            font-size: 16pt;
        }
    </style>
</head>
<body>
    <h1>Maze Game</h1>
    <canvas id="canvas" width="650" height="450" style="border:1px solid black;background-color: white;"></canvas>
    <br>
    <div><a href="http://127.0.0.1:8080/reset">Reset</a></div>
    <script id="json" type="application/json">
        ${json}
    </script>
    <script src="../js/canvas.js" type="module"></script>
</body>
</html>