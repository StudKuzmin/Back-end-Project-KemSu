package classes.controller.config;

import classes.controller.controllerLogic.IControllerLogic;
import classes.database.entity.getdatasets.EGetDatasetContentsResult;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.List;
import java.util.Map;

@ApplicationPath("api")
@ApplicationScoped
public class Config extends Application {
    @Inject
    IControllerLogic controllerLogic;

    @PostConstruct
    public void init(){
        System.out.println("STARTING APPLICATION............");

        try {
            List<EGetDatasetContentsResult> eGetDatasetContentsResult = controllerLogic.getDatasetList();
            int datasetCount = eGetDatasetContentsResult.size();

            if (datasetCount == 0){
                controllerLogic.createDatasetCovid();
                controllerLogic.createDatasetCabs();
                controllerLogic.fillDatasetCovid();
                controllerLogic.fillDatasetCabs();
            }

        }
        catch(Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }
    }
}
