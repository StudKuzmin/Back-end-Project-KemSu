package classes.controller.Requests;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/cabs")
public class CabsController {
    @GET
    @Path("/patients")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patientsGet(String userDataJSON) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS GET(/cabs/patients)").build();
        }
        catch(Exception ex) {
            return Response.ok("ERROR GET(/cabs/patients)").build();
        }
    }
    @POST
    @Path("/patients")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patientsPost(String userDataJSON) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS POST(/cabs/patients)").build();
        }
        catch(Exception ex) {
            return Response.ok("ERROR POST(/cabs/patients)").build();
        }
    }
    @GET
    @Path("/patients/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patientsGetPathId(@PathParam("id") String id) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS GET(/cabs/patients/{" + id + "})").build();
        }
        catch(Exception ex){
            return Response.ok("ERROR GET(/cabs/patients/{" + id + "})").build();
        }
    }
    @DELETE
    @Path("/patients/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patientsDeletePathId(@PathParam("id") String id) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS DELETE(/cabs/patients/{" + id + "})").build();
        }
        catch (Exception ex){
            return Response.ok("ERROR DELETE(/cabs/patients/{" + id + "})").build();
        }
    }
    @PATCH
    @Path("/patients/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patientsPatchPathId(@PathParam("id") String id) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS PATCH(/cabs/patients/{" + id + "})").build();
        }
        catch(Exception ex){
            return Response.ok("ERROR PATCH(/cabs/patients/{" + id + "})").build();
        }
    }

}

