package classes.controller.Requests;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/covid")
public class ControllerCovid {
    @GET
    @Path("/patients")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patientsGet(String userDataJSON) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS GET(/covid/patients)").build();
        }
        catch (Exception ex){
            return Response.ok("ERROR GET(/covid/patients)").build();
        }
    }
    @POST
    @Path("/patients")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patientsPost(String userDataJSON) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS POST(/covid/patients)").build();
        }
        catch(Exception ex){
            return Response.ok("ERROR POST(/covid/patients)").build();
        }
    }
    @GET
    @Path("/patients/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patientsGetPathId(@PathParam("id") String id) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS GET(/covid/patients/{" + id + "})").build();
        }
        catch(Exception ex){
            return Response.ok("ERROR GET(/covid/patients/{" + id + "})").build();
        }
    }
    @DELETE
    @Path("/patients/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patientsDeletePathId(@PathParam("id") String id) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS DELETE(/covid/patients/{" + id + "})").build();
        }
        catch(Exception ex){
            return Response.ok("ERROR DELETE(/covid/patients/{" + id + "})").build();
        }
    }
    @PATCH
    @Path("/patients/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patientsPatchPathId(@PathParam("id") String id) {
        try {
            Boolean dataIsOk = false;
            return Response.ok("SUCCESS PATCH(/covid/patients/{" + id + "})").build();
        }
        catch (Exception ex){
            return Response.ok("ERROR PATCH(/covid/patients/{" + id + "})").build();
        }
    }
}