
package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githubers;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.util.List;

public interface GithuberDao {
    List<Githubers> getGithubers();

    void saveGithuber(Githubers githubers);
}

