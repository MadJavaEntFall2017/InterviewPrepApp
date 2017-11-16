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
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    //This creates category buttons.
    public Response getJobHtmlMessage(@PathParam("category") String category) {
        if (category.equals("job")) {
            output = "<div><ul>";
            GeneralDao dao = new GeneralDao();
            List<Job> theJob = dao.getAllJobs();
            Map sort = new HashMap<>();
            for (Job a : theJob) {
                sort.put(a.getJobID(), a.getJobName());
            }

            Iterator it = sort.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                output += "<li><a target = 'categoryLink' href = \"http://localhost:8080/" + pair.getValue()
                        +".jsp \">" + pair.getValue() + "</a></li>";

                //output += "<li><a href = \"http://localhost:8080/>" + pair.getValue() +".jsp\">" + pair.getValue() + "</a></li>";

               // output += "<li><a href = /cards/categories/0/html target = 'catlinks'>" + pair.getValue() + "</a></li>";

            }
            output += "</ul></div>";
        }

        return Response.status(200).entity(output).build();
    }
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type
    @Path("/{number}/html")
    @Produces(MediaType.TEXT_HTML)
    //This creates categories buttons or flashcard divs.
    public Response getHtmlMessage(@PathParam("number") int num ,@PathParam("category") String category) {
        if (category.equals("categories")) {
            output = "<div id = \"categoryNavBar\"><ul>";
            GeneralDao dao = new GeneralDao();
            Job theJob = dao.getAllJobs().get(num);
            Map sort = createCategoryMap(new HashSet(theJob.getCategories()));
            Iterator it = sort.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                output += "<li class = \"category\"><a target= 'flashcard' href =\"http://localhost:8080/cards/flashcards/" + pair.getKey()
                        +"/html \">" + pair.getValue() + "</a></li>";

            }
            output += "</ul></div>";
        } else if (category.equals("flashcards")) {
            GeneralDao dao = new GeneralDao();
            List<Category> cata = dao.getAllCategories();
            Map sort = new HashMap();
            for (Category a : cata) {
                sort.put(a.getCategoryID(), a);
            }
            Category list = (Category) sort.get(num);
            List<Flashcard> cards = list.getFlashcards();
            output = "<div class = 'flashcard_container'>";
            for (Flashcard a : cards) {
                output += "<div class=\"flashcard\">";
                output += "<div class=\"question\">" + "Question: " + a.getQuestion() + "</div><br>";
                output += "<div class=\"answer\">" + "Answer: " + a.getAnswer() + "</div>";
                output += "</div>";
            }
            output += "</div>";
        }

        return Response.status(200).entity(output).build();
    }



    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    //creates the json output based on if jobs, categories, or flashcards is entered.
    public Response getMessage(@PathParam("category") String category) {
        if (category.equals("categories")) {
            // Return categories json
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
            // Return Flashcards json
        } else if (category.equals("flashcards")) {
            GeneralDao dao = new GeneralDao();
            List<Flashcard> cards = dao.getAllFlashcards();
            int index = 1;
            output = "{ \"flashcards\":[";
            for (Flashcard a : cards) {
                output += "{\"Category\":\"" + a.getCategory().getCategoryName() + "\",";
                output += "\"Question\":\"" + a.getQuestion() + "\",";
                output += "\"Answer\":\"" + a.getAnswer() + "\"}";

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
