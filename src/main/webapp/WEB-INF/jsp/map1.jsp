<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Maze Game</title>
</head>
<body>
    <canvas id="canvas" width="650" height="450" style="border:1px solid black;background-color: white;"></canvas>
    <script id="json" type="application/json">
        {
            "room": 1,

            "doors": {
                "N":"open",
                "E":"open",
                "S":"open",
                "W":"closed"
            },

            "inventory": {
                "keys": 0,
                "coins": 2
            }
        }
    </script>
    <script src="../js/canvas.js" type="module"></script>
</body>
</html>