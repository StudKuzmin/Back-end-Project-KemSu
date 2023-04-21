package classes.model.modelLogic;

import classes.database.entity.EPatient;
import classes.database.entity.EUser;

import java.util.List;

public interface IModelLogic {
    public EUser getEncryptedUser(EUser euser);
    public EUser getDecryptedUser(EUser euser);
    public List<EUser> getEncryptedUserList(List<EUser> userList) throws Exception;
    public List<EUser> getDecryptedUserList(List<EUser> userList) throws Exception;
    public EPatient getEncryptedPatient(EPatient patient);
    public EPatient getDecryptedPatient(EPatient patient);
    public List<EPatient> getEncryptedPatientList(List<EPatient> patientList) throws Exception;
    public List<EPatient> getDecryptedPatientList(List<EPatient> patientList) throws Exception;

}
