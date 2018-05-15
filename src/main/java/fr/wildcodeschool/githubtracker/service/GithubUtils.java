package fr.wildcodeschool.githubtracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githubers;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;

@Dependent
public class GithubUtils {
    private final static String URL = "https://api.github.com/users" ;
    @Inject
    private ObjectMapper om;
    public Githubers parseGithuber(String login)throws IOException {  //return the profile in a Json
        //ObjectMapper mapper = new ObjectMapper();
        URL githuberProfileUrl = null;
        try {
            githuberProfileUrl = new URL(URL + "/" + login);
            Githubers githubers = om.readValue(githuberProfileUrl, Githubers.class);
            return githubers;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
