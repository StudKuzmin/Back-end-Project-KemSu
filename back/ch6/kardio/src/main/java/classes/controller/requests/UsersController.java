package classes.controller.requests;

import classes.controller.controller.Controller;

import classes.controller.entity.EError;
import classes.controller.entity.EUser;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UsersController {
    private final Controller controller;

    public UsersController(){
        controller = new Controller(); // TODO DELETE DEPENDENCE
    }
    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response loginPost(String userDataJSON) {
        try {
            String token;

            token = controller.userLoginPost(userDataJSON);
            return Response
                    .ok(token)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.println("ERROR in UserController.loginPost: " + ex.getMessage());
        }

        return Response
                .ok("unauthorized")
                .status(401)
                .build();
    }

    @GET
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getUsers(@HeaderParam("accessToken") String accessToken) {
        List<EUser> userList;
        try {
            userList = controller.getUserList(accessToken);
            return Response
                    .ok(userList)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.println("ERROR in UsersController.getUsers: " + ex);
        }

        return Response
                .ok("authorization failed")
                .status(401)
                .build();
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response postUsers(@HeaderParam("accessToken") String accessToken, String userDataJSON) {
        try {

            EUser euser = controller.createUser(accessToken, userDataJSON);

            return Response
                    .ok(euser)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.println("ERROR in UsersController.postUsers: " + ex);
        }

        return Response
                .ok(new EError("authorization failed"))
                .status(401)
                .build();
    }

    @GET
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getOneUser(@HeaderParam("accessToken") String accessToken, @PathParam("id") String userId) {
        try {
            EUser euser;
            euser = controller.getOneUser(accessToken, userId);

            return Response
                    .ok(euser)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.println("ERROR in UsersController.getOneUser: " + ex);
        }

        return Response
                .ok(new EError("authorization failed"))
                .status(401)
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteOneUser(@HeaderParam("accessToken") String accessToken, @PathParam("id") String userId) {
        try {
            EUser euser;
            euser = controller.deleteOneUser(accessToken, userId);

            return Response
                    .ok(euser)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.println("ERROR in UsersController.deleteOneUser: " + ex);
        }

        return Response
                .ok(new EError("authorization failed"))
                .status(401)
                .build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateOneUser(@HeaderParam("accessToken") String accessToken, @PathParam("id") String userId, String userDataJSON) {
        try {
            EUser euser;
            euser = controller.updateOneUser(accessToken, userId, userDataJSON);

            return Response
                    .ok(euser)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.println("ERROR in UsersController.updateOneUser: " + ex);
        }

        return Response
                .ok(new EError("authorization failed"))
                .status(401)
                .build();
    }
}