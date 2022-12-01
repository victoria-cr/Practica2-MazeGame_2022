<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Maze Game</title>
</head>
<body>
    <h1>Maze Game</h1>

    <p>Temps: ${temp}</p>

    <form method="post" action"/end">
        <label>Name:</label>
        <br>
        <input id="name" type="text"></input>
        <button type="submit">Save</button>
    </form>
</body>
</html>