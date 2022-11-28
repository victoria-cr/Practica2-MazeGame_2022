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

@WebServlet("/nav")
public class Nav extends HttpServlet {
    MazeGame mazeGame = new MazeGame();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        mazeGame.json((Player) session.getAttribute("player"));
        String direction = req.getParameter("dir");

        mazeGame.go(player, mazeGame.askUser(direction));

        JSONObject jsonObject = mazeGame.json(player);
        req.setAttribute("json", jsonObject.toJSONString());

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/map1.jsp");
        dispatcher.forward(req, resp);
    }
}
