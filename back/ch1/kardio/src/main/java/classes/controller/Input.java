package classes.controller;

import classes.model.SModel;
import jakarta.ws.rs.Path;

@Path("/")
public class Input {
    private Input(){
        SController.getInstance();
        SModel.getInstance();
    }
}
