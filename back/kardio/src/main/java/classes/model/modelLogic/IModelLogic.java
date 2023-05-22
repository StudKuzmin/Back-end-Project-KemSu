package classes.model.modelLogic;

import classes.database.entity.patient.EPatientCabs;
import classes.database.entity.patient.EPatientCovid;
import classes.database.entity.patient.EPatientCovidProperties;
import classes.database.entity.user.EUser;

import java.util.List;
import java.util.Map;

public interface IModelLogic {
    public EUser getEncryptedUser(EUser euser);
    public EUser getDecryptedUser(EUser euser);
    public List<EUser> getEncryptedUserList(List<EUser> userList) throws Exception;
    public List<EUser> getDecryptedUserList(List<EUser> userList) throws Exception;
    public EPatientCovid getEncryptedPatientCovid(EPatientCovid ePatientCovid);
    public EPatientCabs getEncryptedPatientCabs(EPatientCabs ePatientCabs);
    public List<EPatientCovid> getDecryptedPatientCovidList(List<EPatientCovid> patientList) throws Exception;
    public List<EPatientCabs> getDecryptedPatientCabsList(List<EPatientCabs> patientCabsList) throws Exception;

}
