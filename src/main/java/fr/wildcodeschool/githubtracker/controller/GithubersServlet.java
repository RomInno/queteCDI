package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.DumbGithuberDAO;
import fr.wildcodeschool.githubtracker.dao.GithuberDao;
import fr.wildcodeschool.githubtracker.model.Githubers;

import javax.naming.Name;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GithubersServlet", urlPatterns = "/githubers")
public class GithubersServlet extends HttpServlet {

    GithuberDao githuberDao;
    public  GithubersServlet(){
        githuberDao=new DumbGithuberDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("List", githuberDao.getGithubers());
        request.getRequestDispatcher("/githubers.jsp").forward(request, response);


    }
}
