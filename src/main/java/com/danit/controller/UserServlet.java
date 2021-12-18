package com.danit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;


public class UserServlet extends HttpServlet {
    private TemplateEngine templateEngine;

    public UserServlet(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        templateEngine.render("users.ftl", new HashMap<>(), resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        templateEngine.render("users.ftl", new HashMap<>(), resp);
    }
}
