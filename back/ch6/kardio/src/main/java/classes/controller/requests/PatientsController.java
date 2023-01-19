package classes.controller.requests;

import classes.controller.controller.Controller;
import classes.controller.entity.EError;
import classes.controller.entity.EPatient;
import classes.controller.entity.EUser;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/patients")
public class PatientsController {
    private final Controller controller;

    public PatientsController(){
        controller = new Controller(); // TODO DELETE DEPENDENCE
    }
    @GET
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getPatients(@HeaderParam("accessToken") String accessToken) {
        List<EPatient> patientList;
        try {
            patientList = controller.getPatientList(accessToken);
            return Response
                    .ok(patientList)
                    .status(200)
                    .build();
        }
        catch (Exception ex){
            return Response
                    .ok(new EError("authorization failed"))
                    .status(401)
                    .build();
        }
    }
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response postPatients(@HeaderParam("accessToken") String accessToken, String patientDataJSON) {
        try {
            EPatient epatient = controller.createPatient(accessToken, patientDataJSON);
            return Response
                    .ok(epatient)
                    .status(201)
                    .build();
        }
        catch(Exception ex){
            return Response
                    .ok(new EError("authorization failed"))
                    .status(401)
                    .build();
        }
    }
    @GET
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getOnePatient(@HeaderParam("accessToken") String accessToken, @PathParam("id") String patientId) {
        try {
            EPatient epatient;
            epatient = controller.getOnePatient(accessToken, patientId);

            return Response
                    .ok(epatient)
                    .status(200)
                    .build();

        }
        catch(Exception ex){
            return Response
                    .ok(new EError("authorization failed"))
                    .status(401)
                    .build();
        }
    }
    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteOnePatient(@HeaderParam("accessToken") String accessToken, @PathParam("id") String patientId) {
        try {
            EPatient epatient;
            epatient = controller.deleteOnePatient(accessToken, patientId);
            return Response
                    .ok(epatient)
                    .status(200)
                    .build();
        }
        catch(Exception ex){
            return Response
                    .ok(new EError("authorization failed"))
                    .status(401)
                    .build();
        }
    }
    @PATCH
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateOnePatient(@HeaderParam("accessToken") String accessToken, @PathParam("id") String patientId, String patientDataJSON) {
        try {
            EPatient epatient;
            epatient = controller.updateOnePatient(accessToken, patientId, patientDataJSON);

            return Response
                    .ok(epatient)
                    .status(200)
                    .build();
        }
        catch (Exception ex){
            return Response
                    .ok(new EError("authorization failed"))
                    .status(401)
                    .build();
        }
    }
}