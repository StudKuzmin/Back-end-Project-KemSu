package classes.controller.requests;

import classes.controller.controller.interfaces.IPatientsController;
import classes.database.entity.EError;
import classes.database.entity.patient.EPatientPage;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Map;

@Path("/patients")
public class PatientsRequests {
    @Inject
    IPatientsController patientsController;

    @GET
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getPatients(@HeaderParam("accessToken") String accessToken) {
        try {
            List<EPatientPage> patientList = patientsController.getPatients(accessToken);
            return Response
                    .ok(patientList)
                    .status(200)
                    .build();
        }
        catch (Exception ex){
            return Response
                    .ok(new EError("Unauthorized", 401))
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
            Map<String, String> insertedPatientData = patientsController.postPatients(accessToken, patientDataJSON);

            return Response
                    .ok(insertedPatientData)
                    .status(200)
                    .build();
        }
        catch(Exception ex){
            return Response
                    .ok(new EError("Unauthorized", 401))
                    .status(401)
                    .build();
        }
    }
    @GET
    @Path("/{patientId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getPatientsPatientid(@HeaderParam("accessToken") String accessToken, @PathParam("patientId") String patientId) {
        try {
            Map<String, String> patientData = patientsController.getPatientsPatientid(accessToken, patientId);

            return Response
                    .ok(patientData)
                    .status(200)
                    .build();

        }
        catch(Exception ex){
            return Response
                    .ok(new EError("Unauthorized", 401))
                    .status(401)
                    .build();
        }
    }
    @DELETE
    @Path("/{patientId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deletePatientsPatientid(@HeaderParam("accessToken") String accessToken, @PathParam("patientId") String patientId) {
        try {
            patientsController.deletePatientsPatientid(accessToken, patientId);
            return Response
                    .ok(new EError("Patient deleted successfully", 200))
                    .status(200)
                    .build();
        }
        catch(Exception ex){
            return Response
                    .ok(new EError("Unauthorized", 401))
                    .status(401)
                    .build();
        }
    }
    @PATCH
    @Path("/{patientId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patchPatientsPatientid(@HeaderParam("accessToken") String accessToken, @PathParam("patientId") String patientId, String patientDataJSON) {
        try {
            Map<String, String> patientData = patientsController.patchPatientsPatientid(accessToken, patientId, patientDataJSON);

            return Response
                    .ok(patientData)
                    .status(200)
                    .build();
        }
        catch (Exception ex){
            return Response
                    .ok(new EError("Unauthorized", 401))
                    .status(401)
                    .build();
        }
    }
}