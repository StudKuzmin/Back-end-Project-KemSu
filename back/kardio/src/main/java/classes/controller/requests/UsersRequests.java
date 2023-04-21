package classes.controller.requests;

import classes.controller.controller.interfaces.IUsersController;
import classes.database.entity.EError;
import classes.database.entity.EPassword;
import classes.database.entity.EUser;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
public class UsersRequests {
    @Inject
    IUsersController usersController;

    @GET
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getUsers(@HeaderParam("accessToken") String accessToken) {
        try {
            List<EUser> userList = usersController.getUserList(accessToken);

            return Response
                    .ok(userList)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return Response
                .ok(new EError("authorization failed"))
                .status(401)
                .build();
    }

    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response postLogin(String userDataJSON) {
        try {
            String token = usersController.postUserLogin(userDataJSON);
            return Response
                    .ok(token)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }
        return Response
                .ok(new EError("unauthorized"))
                .status(401)
                .build();
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response postUsers(@HeaderParam("accessToken") String accessToken, String userDataJSON) {
        try {
            EUser euser = usersController.createUser(accessToken, userDataJSON);
            return Response
                    .ok(euser)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
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
            euser = usersController.getOneUser(accessToken, userId);
            return Response
                    .ok(euser)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
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
            EUser euser = usersController.deleteOneUser(accessToken, userId);

            return Response
                    .ok(euser)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
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
            EUser euser = usersController.updateOneUser(accessToken, userId, userDataJSON);
            return Response
                    .ok(euser)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return Response
                .ok(new EError("authorization failed"))
                .status(401)
                .build();
    }

    @POST
    @Path("/{id}/reset-password")
    @Consumes("application/json")
    @Produces("application/json")
    public Response postResetPassword(@HeaderParam("accessToken") String accessToken, @PathParam("id") String userId, String newPassword) {
        try {
            EPassword epassword = usersController.resetPassword(accessToken, userId, newPassword);
            return Response
                    .ok(epassword)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return Response
                .ok(new EError("authorization failed"))
                .status(401)
                .build();
    }
}