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
        h1{
            text-align: center;
            font-size: 26pt;
        }
        p {
            font-size: 16pt;
            text-align: center;
        }
        form {
            font-size: 16pt;
            text-align: center;
        }
    </style>

</head>
<body>
    <h1>End game</h1>

    <p>Time: ${temp}</p>

    <form method="post" action"/end">
        <label>Name:</label>
        <input id="name" type="text"></input>
        <button type="submit">Save</button>
    </form>
</body>
</html>