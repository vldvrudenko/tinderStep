package com.danit.controller;

import com.danit.dao.User;
import com.danit.dao.UserDao;
import com.danit.dao.UserJdbcDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

//@WebServlet(urlPatterns = "/")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;
    private TemplateEngine templateEngine;

    public LoginServlet(UserDao userDao, TemplateEngine templateEngine) {
        this.userDao = userDao;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession() != null) {
            request.getRequestDispatcher("/").forward(request, response);
        }

       String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userDao.findByLoginPass(login, password);

        if(user==null) {
            templateEngine.render("index.ftl", new HashMap<>(), response);
            //request.getRequestDispatcher("/index.ftl").forward(request, response);
        }else{
            request.setAttribute("user", user.getLogin());
            HttpSession session = request.getSession(true);
            session.setAttribute("login", user.getLogin());
//            response.sendRedirect("/hello");
            request.getRequestDispatcher("/").forward(request, response);
        }

    }
}
