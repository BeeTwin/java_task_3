package com.example.java_task3.servlet;

import com.example.java_task3.Consts;
import com.example.java_task3.accounts.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final String _nicknameStr = "nickname";
    private final String _passwordStr = "password";
    private final String _errorStr = "error";
    private final String _error = "try again";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        var nickName = req.getParameter(_nicknameStr);
        var password = req.getParameter(_passwordStr);

        var user = AccountService.tryGetUser(nickName, password);
        if (user == null) {
            req.setAttribute(_errorStr, _error);
        } else {
            resp.sendRedirect(Consts.Urls.homeOf(nickName));
        }
    }
}