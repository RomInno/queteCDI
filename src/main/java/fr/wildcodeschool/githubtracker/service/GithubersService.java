package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDao;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.model.Githubers;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
public class GithubersService  {
    public GithuberDao githuberDao;

    @Inject
    public GithubersService(@InMemory GithuberDao githuberDao) {
        this.githuberDao = githuberDao;
    }

    public List<Githubers> getAllGithubers(){
        //githuberDao = new DumbGithuberDAO();

        List<Githubers> allGithubers = githuberDao.getGithubers();
        return allGithubers;
    }

    public Githubers getGithuber(String login){
       Githubers githuberSearched = getAllGithubers().stream()
               .filter(x ->login.equals(x.getLogin()))
               .findAny()
               .orElse(null);
        return githuberSearched;
    }

    public void track(String login){
        //TODO
    }
}
