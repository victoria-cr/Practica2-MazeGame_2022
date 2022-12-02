package com.liceu.practica2.controllers;

import com.liceu.practica2.model.Maze;
import com.liceu.practica2.model.Player;
import com.liceu.practica2.services.MazeGame;
import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/open")
public class Open extends HttpServlet {
    MazeGame mazeGame = new MazeGame();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        mazeGame.json((Player) session.getAttribute("player"));

        Maze.Directions direction = mazeGame.askUser(req.getParameter("dir"));

        mazeGame.openDoor(player, direction);

        JSONObject jsonObject = mazeGame.json(player);
        req.setAttribute("json", jsonObject.toJSONString());

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/maps.jsp");
        dispatcher.forward(req, resp);
    }
}
