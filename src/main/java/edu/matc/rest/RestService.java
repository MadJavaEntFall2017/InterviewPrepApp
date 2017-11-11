package edu.matc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import edu.matc.persistence.GeneralDao;
import edu.matc.entity.*;

import java.util.*;


@Path("/{category}")

public class RestService {
    private String output;

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage(@PathParam("category") String category) {
        if (category.equals("categories")) {
            // Return Flashcards by class
            GeneralDao dao = new GeneralDao();
            Set<Category> cata = new HashSet(dao.getAllCategories());
            output = "{ \"categories\":[";
            int index = 1;

            Map sort = createCategoryMap(cata);
            Iterator it = sort.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                output += "{";
                output += "\"Id\":\"" + pair.getKey() + "\", ";
                output += "\"name\":\"" + pair.getValue() + "\"";
                output += "}";

                if (cata.size() != index) {
                    output += ",";
                }
                index++;
            }
            output += "]}";
            //create jobs json
        } else if (category.equals("jobs")) {
            GeneralDao dao = new GeneralDao();
            List<Job> jobs = dao.getAllJobs();
            output = "{\"jobs\": [";
            int jobIndex = 1;
            for (Job a : jobs) {
                int index = 1;
                output += "{\"Id\":\"" + a.getJobID() + "\", ";
                output += "\"name\":\"" + a.getJobName() + "\",";
                Map sort = createCategoryMap(new HashSet(a.getCategories()));
                Iterator it = sort.entrySet().iterator();
                output += "\"catagories\":[";

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    output += "\"" + pair.getValue() + "\"";
                    if (sort.size() != index) {
                        output += ",";
                    }
                    index++;
                }

                output += "]}";
                if (jobs.size() != jobIndex) {
                    output += ",";
                }
                jobIndex++;
            }
            output += "]}";

        } else if (category.equals("flashCards")) {
            GeneralDao dao = new GeneralDao();
            List<Flashcard> cards = dao.getAllFlashcards();
            int index = 1;
            output = "{ \"flashcards\":[";
            for (Flashcard a : cards) {

                output += "\"" + a.getAnswer() + "\"";
                if (cards.size() != index) {
                    output += ",";
                }
                index++;
            }
            output += "]}";
        } else if (category.chars().allMatch(Character::isDigit)) {
            GeneralDao dao = new GeneralDao();
            Category cata = dao.getCategory(Integer.parseInt(category));
            List<Flashcard> cards;
            cards = cata.getFlashcards();

            output += cata;
            for (Flashcard a : cards) {

                output += a.getCategory();

            }
        } else {
            output = "you entered:" + category + "|" + "enter jobs, categories, flashCards, or a number";
        }

        return Response.status(200).entity(output).build();
    }

    private Map createCategoryMap(Set<Category> cata) {

        Map sort = new HashMap<>();
        for (Category a : cata) {
            sort.put(a.getCategoryID(), a.getCategoryName());
        }
        return sort;
    }
}
