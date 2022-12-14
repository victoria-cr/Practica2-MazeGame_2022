package com.liceu.practica2.controllers;

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
import java.sql.Timestamp;

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
        HttpSession session = req.getSession();
        Player player = mazeGame.main(req.getParameter("map"));

        long time = System.currentTimeMillis();
        session.setAttribute("time", time);

        JSONObject jsonObject = mazeGame.json(player);
        req.setAttribute("json", jsonObject.toJSONString());

        session.setAttribute("player", player);

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/maps.jsp");
        dispatcher.forward(req, resp);
    }
}