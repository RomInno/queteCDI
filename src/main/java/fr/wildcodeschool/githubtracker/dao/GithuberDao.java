package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githubers;
import java.util.List;

public interface GithuberDao {
    List<Githubers> getGithubers();
}
