package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githubers;
import fr.wildcodeschool.githubtracker.service.GithubUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
@InMemory
public class MemoryGithuberDAO implements GithuberDao{
    @Inject
    GithubUtils githubUtils;
    HashMap<String, Githubers> idGithubers = new HashMap<>(); //map Githubers with their login

    //@Override
    public List<Githubers> getGithubers() {

        return new ArrayList<Githubers>(idGithubers.values());
    }

    //@Override
    public void saveGithuber(Githubers githubers) {
        if(githubers != null) {
            idGithubers.put(githubers.getLogin(), githubers);
        }
    }

    @PostConstruct
    private void callParseGithuber(){
        String[] logins = {"christellsahli", "Gregbee", "sa mere en slip", "Lucilediague", "RomInno", "arnogc33", "jbourbo"};


        for(String login : logins) {
            try {
                saveGithuber(githubUtils.parseGithuber(login));
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

}
