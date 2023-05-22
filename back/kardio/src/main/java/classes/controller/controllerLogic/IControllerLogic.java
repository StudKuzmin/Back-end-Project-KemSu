package classes.controller.controllerLogic;

import classes.database.entity.*;
import classes.database.entity.getdatasets.EGetDatasetContentsResult;
import classes.database.entity.patient.EPatientCovid;
import classes.database.entity.user.EUser;

import java.util.List;
import java.util.Map;

public interface IControllerLogic {
    public Map<String, String> toMap(String dataJson) throws Exception;
    public EUser getUserDataWithToken(String token, String userId) throws Exception;
    public boolean checkToken(String token, String issuer);
    public EToken getUserToken(String userId, String role) throws Exception;
    public EPatientCovid fromPatientJson(String patientDataJSON);
    public EUser fromUserJson(String userDataJSON);
    public EPassword fromPasswordJson(String passwordDataJSON);
    public EToken fromTokenJson(String tokenDataJSON);
    public void createDatasetCovid();
    public void createDatasetCabs();
    public List<EGetDatasetContentsResult> getDatasetList() throws Exception;
    public void fillDatasetCovid() throws Exception;
    public void fillDatasetCabs() throws Exception;
    public String predictCovid(String patientCovidData) throws Exception;
    public Map<String, String> predictCabs(String patientCabsData) throws Exception;
}
