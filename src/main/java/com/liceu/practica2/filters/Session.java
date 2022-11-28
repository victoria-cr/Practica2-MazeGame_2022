package com.liceu.practica2.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/start", "/nav", "/getKey", "/getCoin", "/open", "/reset", "/endForm"})
public class Session extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session.getAttribute("player") == null) {
            res.sendRedirect("http://127.0.0.1:8080/start");
        }
        chain.doFilter(req, res);
    }
}
