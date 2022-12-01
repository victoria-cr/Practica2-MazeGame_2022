<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Maze Game</title>
    <style>
        h1{
            text-align: center;
        }
        form {
            text-align: center;
        }
        select {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Maze Game</h1>

    <form method="post" action"/start">
        <label>Mapa:</label>
        <br>
        <select id="mapa" name="maps">
            <option value="blanc"> </option>
            <option value="map1" name="map1">Map 1</option>
            <option value="map2" name="map2">Map 2</option>
        </select>
        <button type="submit">Start</button>
    </form>
</body>
</html>