package classes.database.dbservice;

import classes.database.entity.patient.EPatientCabs;
import classes.database.entity.patient.EPatientCovid;
import classes.database.entity.patient.EPatientCovidProperties;
import classes.database.entity.user.EUser;

import java.util.List;
import java.util.Map;

public interface IDBservice {
    public boolean insert(Object entity);
    public List<EUser> selectUsers() throws Exception;
    public boolean delete(String entity, String entityId);
    public boolean updateUserInfo(EUser newUserData);
    public boolean updateUserPassword(EUser newUserData);
    public EUser selectUserById(String userId) throws Exception;
    public List<EPatientCovid> selectPatientsCovid() throws Exception;
    public List<EPatientCabs> selectPatientsCabs() throws Exception;
    public boolean updatePatientCovid(EPatientCovid ePatientCovid);
    public boolean updatePatientCabs(EPatientCabs ePatientCabs);
}
