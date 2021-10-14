package com.example.java_task3.servlet;

import com.example.java_task3.Consts;
import com.example.java_task3.accounts.AccountService;
import com.example.java_task3.logic.model.DirectoryModel;
import com.example.java_task3.logic.model.FileModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    private final String _pathParam = "path";
    private final String _modelName = "directory";
    private final String _jspPage = "mypage.jsp";
    private final String _nicknameParam = "nickname";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        var nickname = req.getParameter(_nicknameParam);

        if (!AccountService.isAuthorized(nickname)) {
            resp.sendRedirect(Consts.Urls.LoginUrl);
        }

        var path = req.getParameter(_pathParam);
        if (path == null) {
            path = getRootDirectory();
        }

        var file = new File(path);

        if (file.isFile()) {
            try (OutputStream out = resp.getOutputStream()) {
                resp.addHeader("Content-Disposition", "attachment;filename=" + file.getName());
                resp.setContentType("application/octet-stream");
                var bytes = Files.readAllBytes(file.toPath());
                resp.addHeader("Content-Length", "" + bytes.length);
                out.write(bytes);
            }
            return;
        }

        var children = file.listFiles();

        // imagine this is automapper
        var childrenModels = new ArrayList<FileModel>();
        for (var child : children) {
            if (child.isDirectory() || child.isFile()) {
                childrenModels.add(new FileModel(
                        child.getName(),
                        changeSlashes(child.getAbsolutePath()),
                        child.length(),
                        new Date(child.lastModified()),
                        child.isFile()));
            }
        }

        var model = new DirectoryModel(
                changeSlashes(file.getParent()),
                changeSlashes(file.getAbsolutePath()),
                childrenModels);
        
        req.setAttribute(_modelName, model);
        req.setAttribute(_nicknameParam, nickname);
        req.getRequestDispatcher(_jspPage).forward(req, resp);
    }


    private String getRootDirectory() {
        return changeSlashes(new File(".").getAbsolutePath()).split("/")[0];
    }

    private String changeSlashes(String path) {
        if (path == null)
            return null;
        return path.replace('\\', '/');
    }
}