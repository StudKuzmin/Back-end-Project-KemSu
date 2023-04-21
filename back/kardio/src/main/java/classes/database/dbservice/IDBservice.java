package classes.database.dbservice;

import classes.database.entity.EPatient;
import classes.database.entity.EUser;

import java.util.List;

public interface IDBservice {
    public boolean insert(Object entity);
    public List<EUser> selectUsers() throws Exception;
    public List<EPatient> selectPatients() throws Exception;
    public boolean delete(String entity, String entityId);
    public boolean update(String entity, String oldId, Object newEntityData);
}
