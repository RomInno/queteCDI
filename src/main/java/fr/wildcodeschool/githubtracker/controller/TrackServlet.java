package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.GithuberDao;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.dao.MemoryGithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githubers;
import fr.wildcodeschool.githubtracker.service.GithubUtils;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TrackServlet", urlPatterns = "/track")
public class TrackServlet extends HttpServlet {
    @Inject
    private GithubersService githubersService;

    @Inject
    @InMemory
    GithuberDao memoryGithuberDAO;

    @Inject
    GithubUtils githubUtils;

    private String githuberSearchedLogin;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        githuberSearchedLogin = request.getParameter("githuberSearchedLogin");
        memoryGithuberDAO.saveGithuber(githubUtils.parseGithuber(githuberSearchedLogin));

        response.sendRedirect(request.getContextPath() + "/track");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("List",githubersService.getGithuber(githuberSearchedLogin));
        request.getRequestDispatcher("/githubers.jsp").forward(request, response);
    }
}
