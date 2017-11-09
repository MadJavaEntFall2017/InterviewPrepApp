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
    public Response getMessage(@PathParam("category") String category,@PathParam("card") String card) {
        if(category.equals("categories")) {
            // Return Flashcards by class
            GeneralDao dao = new GeneralDao();
            List<Category> cata = dao.getAllCategories();
            for (Category a : cata) {
                output += a;
            }
        } else if (category.equals("jobs")){
            GeneralDao dao = new GeneralDao();
            List<Job> jobs = dao.getAllJobs();
            for (Job a : jobs) {
                output += a;
            }
        } else if (category.equals("flashCards")){
            GeneralDao dao = new GeneralDao();
            List<Flashcard> cards = dao.getAllFlashcards();
            for (Flashcard a : cards) {
                output += a;
            }
        } else if (category.chars().allMatch(Character::isDigit)){
            GeneralDao dao = new GeneralDao();
            Category cata = dao.getCategory(Integer.parseInt(category) );
            List<Flashcard> cards = dao.getAllFlashcards();

            output += cata;
            for (Flashcard a : cards) {
                if (Integer.parseInt(category) == a.getCategory().getCategoryID()) {
                    output += a.getAnswer();
                }
            }
                } else {
            output = "you entered:" + category +"|"+ "enter jobs, categories, flashCards, or a number";
        }

        return Response.status(200).entity(output).build();
    }



}
