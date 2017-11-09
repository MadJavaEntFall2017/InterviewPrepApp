package edu.matc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import edu.matc.persistence.GeneralDao;
import edu.matc.entity.*;

import java.util.List;

@Path("/{category}")

public class RestService {
    private String output;
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage(@PathParam("category") String category) {
        if(category.equals("categories")) {
            // Return Flashcards by class
            GeneralDao dao = new GeneralDao();
            List<Category> cata = dao.getAllCategories();
            output = "{ \"categories\":[";
            int index = 1;
            for (Category a : cata) {

                output += "\"" + a.getCategoryName() + "\"";
                if (cata.size() != index){
                    output += ",";
                }
                index++;
            }
            output += "]}";
        } else if (category.equals("jobs")){
            GeneralDao dao = new GeneralDao();
            List<Job> jobs = dao.getAllJobs();
            for (Job a : jobs) {
                output += a;
            }
        } else if (category.equals("flashCards")){
            GeneralDao dao = new GeneralDao();
            List<Flashcard> cards = dao.getAllFlashcards();
            int index = 1;
            output = "{ \"flashcards\":[";
            for (Flashcard a : cards) {

                output += "\"" + a.getAnswer() + "\"";
                if (cards.size() != index){
                    output += ",";
                }
                index++;
            }
            output += "]}";
        } else if (category.chars().allMatch(Character::isDigit)){
            GeneralDao dao = new GeneralDao();
            Category cata = dao.getCategory(Integer.parseInt(category) );
            List<Flashcard> cards = cata.getFlashcards();

            output += cata;
            for (Flashcard a : cards) {

                   output += a.getCategory();

            }
                } else {
            output = "you entered:" + category +"|"+ "enter jobs, categories, flashCards, or a number";
        }

        return Response.status(200).entity(output).build();
    }



}
