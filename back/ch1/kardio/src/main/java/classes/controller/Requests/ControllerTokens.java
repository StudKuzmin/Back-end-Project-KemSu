package classes.controller.Requests;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/tokens")
public class ControllerTokens {
    @POST
    @Path("/refresh")
    @Consumes("application/json")
    @Produces("application/json")
    public Response refreshPost(String userDataJSON) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS POST(/tokens/refresh)").build();
        }
        catch(Exception ex){
            return Response.ok("ERROR POST(/tokens/refresh)").build();
        }
    }

}
