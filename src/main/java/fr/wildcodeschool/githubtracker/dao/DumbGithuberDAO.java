package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.wildcodeschool.githubtracker.model.Githubers;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class DumbGithuberDAO implements GithuberDao{

    private final static List<Githubers> githubers = new ArrayList<Githubers>(5);
    static {
        githubers.add(new Githubers(1L, "christellsahli", "christellsahli@gmail.com", "christellsahli", "https://avatars3.githubusercontent.com/u/38050036?s=88&v=4"));
        githubers.add(new Githubers(2L, "Gregbee", "backtopa@gmail.com", "Gregbee", "https://avatars1.githubusercontent.com/u/14792727?s=88&v=4"));
        githubers.add(new Githubers(3L, "Julien Bourbonnais", "jbourbo@gmail.com", "jbourbo", "https://avatars0.githubusercontent.com/u/5736082?s=88&v=4"));
        githubers.add(new Githubers(4L, "Lucilediague", "diaguelucile@gmail.com", "Lucilediague", "https://avatars3.githubusercontent.com/u/24568268?s=88&v=4"));
        githubers.add(new Githubers(5L, "arnogc33", "guillou.arnaud@gmail.com", "arnogc33", "https://avatars2.githubusercontent.com/u/35994942?s=88&v=4"));
    }

    public List<Githubers> getGithubers() {
        return githubers;
    }


    public void saveGithuber(Githubers githubers) throws UnsupportedOperationException{

    }

    public Githubers parseGithuber(String login) throws IOException {
        return null;
    }


}
