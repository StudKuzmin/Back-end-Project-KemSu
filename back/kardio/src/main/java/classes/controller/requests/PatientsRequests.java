package classes.controller.requests;


import classes.controller.controller.PatientsController;
import classes.database.entity.EError;
import classes.database.entity.EPatient;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/patients")
public class PatientsRequests {
    @Inject
    PatientsController patientsController;

    @GET
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getPatients(@HeaderParam("accessToken") String accessToken) {
        List<EPatient> patientList;
        try {
            patientList = patientsController.getPatientList(accessToken);
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
            EPatient epatient = patientsController.createPatient(accessToken, patientDataJSON);
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
            EPatient epatient = patientsController.getOnePatient(accessToken, patientId);

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
            epatient = patientsController.deleteOnePatient(accessToken, patientId);
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
            epatient = patientsController.updateOnePatient(accessToken, patientId, patientDataJSON);

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