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
import java.io.IOException;

@WebServlet("/start")
public class Start extends HttpServlet {
    MazeGame mazeGame = new MazeGame();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/start.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Player player = mazeGame.main();

        JSONObject jsonObject = MazeGame.json(player);

        System.out.println(jsonObject.toJSONString());
        req.setAttribute("json", jsonObject.toJSONString());

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/map1.jsp");
        dispatcher.forward(req, resp);
    }
}
