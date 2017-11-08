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

@Path("/{category}/flashCards")

public class RestService {

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage(@PathParam("category") int category) {
        // Return Flashcards by class
        GeneralDao dao = new GeneralDao();
        Category cata = dao.getCategory(category);
        List<Flashcard> output = cata.flashcards;

        return Response.status(200).entity(cata).build();
    }
}
