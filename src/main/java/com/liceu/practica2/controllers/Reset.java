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

@WebServlet("/reset")
public class Reset extends HttpServlet {
    MazeGame mazeGame = new MazeGame();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = mazeGame.main(req.getParameter("maps"));
        session.setAttribute("player", player);

        System.out.println(player.getCurrentRoom().getNumber());

        JSONObject jsonObject = mazeGame.json((Player) session.getAttribute("player"));
        req.setAttribute("json", jsonObject.toJSONString());

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/maps.jsp");
        dispatcher.forward(req, resp);
    }
}
