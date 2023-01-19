package classes.database;

import classes.controller.entity.EPatient;
import classes.controller.entity.EUser;

import java.lang.reflect.Field;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBservice {
    private Connection con;
    private EPatient epatient;

    public DBservice(){
        try
        {
            String url = "jdbc:mysql://localhost/kardioCenter?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "3572";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) { System.out.println("ERROR in DBservice.DBservice: " + ex); }
    }

    public boolean checkUserData(String login, String password){
        try
        {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while(rs.next())
            {
                if (rs.getString("login").equals(login) && rs.getString("password").equals(password))
                    return true;
            }

            rs.close();
            stmt.close();
        }
        catch (Exception ex) {
            System.out.println("ERROR in DBservice.checkUserData: " + ex.getMessage());
            return false;
        }
        return false;
    }
    public List<ArrayList<String>> getUserList(){
        List<ArrayList<String>> userList = new ArrayList<>();

        try
        {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            ResultSetMetaData mt = rs.getMetaData();

            for(int i = 0; rs.next(); i++){
                userList.add(new ArrayList<>());
                for(int j = 1; j <= mt.getColumnCount(); j++) {
                    userList.get(i).add(rs.getString(j));
                }
            }

            rs.close();
            stmt.close();
        }
        catch (Exception ex) {
            System.out.println("ERROR in DBservice.getUserList: " + ex.getMessage());
        }

        return userList;
    }
    public EUser getOneUser(String userId) throws Exception{
        EUser euser = new EUser(); // TODO DELETE DEPENDENCE
        try
        {
            PreparedStatement st = con.prepareStatement("SELECT * FROM users where id = ?");
            st.setInt(1, Integer.parseInt(userId));
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                euser.setId(rs.getInt("id"));
                euser.setStatus(rs.getInt("status"));
                euser.setLogin(rs.getString("login"));
                euser.setPassword(rs.getString("password"));
                euser.setFullName(rs.getString("fullName"));
                euser.setRole(rs.getString("role"));
                euser.setRegistrationDate(rs.getDate("registrationDate"));
                euser.setDeletionDate(rs.getDate("deletionDate"));
            }
            if (euser.getId().equals("null"))
                throw new Exception("ID not found");

            rs.close();
            st.close();
        }
        catch (Exception ex) {
            System.out.println("ERROR in DBservice.getOneUser: " + ex);
            throw new Exception();
        }

        return euser;
    }

    public EUser deleteOneUser(String userId) throws Exception{
        EUser euser = new EUser(); // TODO DELETE DEPENDENCE
        try
        {
            PreparedStatement st = con.prepareStatement("SELECT * FROM users where id = ?");
            st.setInt(1, Integer.parseInt(userId));
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                euser.setId(rs.getInt("id"));
                euser.setStatus(rs.getInt("status"));
                euser.setLogin(rs.getString("login"));
                euser.setPassword(rs.getString("password"));
                euser.setFullName(rs.getString("fullName"));
                euser.setRole(rs.getString("role"));
                euser.setRegistrationDate(rs.getDate("registrationDate"));
                euser.setDeletionDate(rs.getDate("deletionDate"));
            }
            if (euser.getId().equals("null"))
                throw new Exception("ID not found");

            int deletedRows = st.executeUpdate("DELETE FROM users WHERE Id = " + userId );

            rs.close();
            st.close();
        }
        catch (Exception ex) {
            System.out.println("ERROR in DBservice.deleteOneUser: " + ex);
            throw new Exception();
        }

        return euser;
    }
    public EUser updateOneUser(String userId, EUser newDataUser) throws Exception{
        EUser euser = new EUser(); // TODO DELETE DEPENDENCE
        try
        {
            PreparedStatement st = con.prepareStatement("SELECT * FROM users where id = ?");
            st.setInt(1, Integer.parseInt(userId));
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                euser.setId(rs.getInt("id"));
                euser.setStatus(rs.getInt("status"));
                euser.setLogin(rs.getString("login"));
                euser.setPassword(rs.getString("password"));
                euser.setFullName(rs.getString("fullName"));
                euser.setRole(rs.getString("role"));
                euser.setRegistrationDate(rs.getDate("registrationDate"));
                euser.setDeletionDate(rs.getDate("deletionDate"));
            }
            if (euser.getId().equals("null"))
                throw new Exception("ID not found");

            st.executeUpdate(String.format("UPDATE users SET id = %s,", newDataUser.getId())
                    + String.format("registrationDate = %s,", newDataUser.getRegistrationDate().equals("null")?"null" : "'"+newDataUser.getRegistrationDate()+"'")
                    + String.format("login = %s,", newDataUser.getLogin().equals("null")?"null" : "'"+newDataUser.getLogin()+"'")
                    + String.format("password = %s,", newDataUser.getPassword().equals("null")?"null" : "'"+newDataUser.getPassword()+"'")
                    + String.format("role = %s,", newDataUser.getRole().equals("null")?"null" : "'"+newDataUser.getRole()+"'")
                    + String.format("status = %s,", newDataUser.getStatus())
                    + String.format("deletionDate = %s,", newDataUser.getDeletionDate().equals("null")?"null" : "'"+newDataUser.getDeletionDate()+"'")
                    + String.format("fullName = %s", newDataUser.getFullName().equals("null")?"null" : "'"+newDataUser.getFullName()+"'")
                    + String.format(" WHERE id = %s", userId));

            rs.close();
            st.close();
        }
        catch (Exception ex) {
            System.out.println("ERROR in DBservice.updateOneUser: " + ex);
            throw new Exception();
        }

        return euser;
    }
    public boolean createUser(List<String> usersArray){
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            ResultSetMetaData mt = rs.getMetaData();

            String query = "INSERT INTO users(id, " +
                    "registrationDate, " +
                    "fullName, " +
                    "login, " +
                    "password, " +
                    "role, " +
                    "status, " +
                    "deletionDate) " +
                    "VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(query);

            for(int i = 0; i < mt.getColumnCount(); i++){
                if(usersArray.get(i).equals("null"))
                    st.setNull(i+1, mt.getColumnType(i+1));

                else if(mt.getColumnType(i+1) == Types.INTEGER)
                    st.setInt(i+1, Integer.parseInt(usersArray.get(i)));

                else if(mt.getColumnType(i+1) == Types.DATE)
                    st.setDate(i+1, Date.valueOf(usersArray.get(i)));

                else if(mt.getColumnType(i+1) == Types.BIT)
                    st.setBoolean(i+1, Boolean.parseBoolean(usersArray.get(i)));

                else if(mt.getColumnType(i+1) == Types.CHAR)
                    st.setString(i+1, usersArray.get(i));
            }


            st.execute();

            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("ERROR in DBservice.createUser: " + ex);
            return false;
        }

        return true;
    }

    public boolean createPatient(List<String> patientsArray){
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM patients");
            ResultSetMetaData mt = rs.getMetaData();

            String query = "INSERT INTO patients(" +
                    "id, " +
                    "dateOfAdmission, " +
                    "sex, " +
                    "age, " +
                    "urea, " +
                    "creatinine, " +
                    "AST, " +
                    "ALT," +
                    "glucose," +
                    "leukocytes," +
                    "platelets," +
                    "neutrophils," +
                    "lymphocytes," +
                    "DminusDimer," +
                    "AG," +
                    "SD," +
                    "IBS," +
                    "HOBL," +
                    "HBP," +
                    "CRP," +
                    "SKF," +
                    "neutrophilMinusLymphocyteRatio," +
                    "cabsType," +
                    "BMI," +
                    "overweight," +
                    "smoking," +
                    "heredity," +
                    "dyslipidemia," +
                    "HOBLminusBA," +
                    "PIKS," +
                    "FP," +
                    "SU," +
                    "TH," +
                    "varicose," +
                    "cardiacLesions," +
                    "LLALesions," +
                    "FCAnginaPectoris," +
                    "FCCHF," +
                    "LVEF," +
                    "ISs," +
                    "EuroScore2," +
                    "IK," +
                    "IKTime," +
                    "aorticClampTime," +
                    "TminusBodies," +
                    "numberOfCardioplegias," +
                    "VPminusLZ," +
                    "revascularizationIndex," +
                    "YminusTypeCOBS," +
                    "LIMAExcretion," +
                    "RIMAExcretion," +
                    "LAUsage," +
                    "AVUsage," +
                    "bloodLoss," +
                    "ALVTime," +
                    "inotropicSupport," +
                    "pneumonia," +
                    "SN," +
                    "FPminusTP," +
                    "pleuralEffusion," +
                    "hydropericardium," +
                    "pneumothorax," +
                    "sternalComplications," +
                    "AKK," +
                    "iAPF," +
                    "spironolactone," +
                    "diuretics," +
                    "cordaron," +
                    "hospitalizationDuration," +
                    "CEAfteer," +
                    "ANCOperationsAfter," +
                    "antiplateletAgentsAfter," +
                    "anticoagulants," +
                    "BABAfter," +
                    "AKKAfter," +
                    "iAPFAfter," +
                    "ARAAfter," +
                    "diureticsAfter," +
                    "statins," +
                    "heartAttack," +
                    "PCI," +
                    "insult," +
                    "death) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


            PreparedStatement st = con.prepareStatement(query);

            for(int i = 0; i < mt.getColumnCount(); i++){
                if(patientsArray.get(i).equals("null"))
                    st.setNull(i+1, mt.getColumnType(i+1));
                else if(mt.getColumnType(i+1) == Types.INTEGER)
                    st.setInt(i+1, Integer.parseInt(patientsArray.get(i)));
                else if(mt.getColumnType(i+1) == Types.DATE)
                    st.setDate(i+1, Date.valueOf(patientsArray.get(i)));
                else if(mt.getColumnType(i+1) == Types.BIT)
                    st.setBoolean(i+1, Boolean.parseBoolean(patientsArray.get(i)));
            }

            st.execute();

            st.close();
        } catch (Exception ex) {
            System.out.println("ERROR in DBservice.createPatient: " + ex);
            return false;
        }

        return true;
    }

    public List<ArrayList<String>> getPatientsList(){
        List<ArrayList<String>> patientsList = new ArrayList<>();

        try
        {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM patients");
            ResultSetMetaData mt = rs.getMetaData();

            for(int i = 0; rs.next(); i++){
                patientsList.add(new ArrayList<>());
                for(int j = 1; j <= mt.getColumnCount(); j++) {
                    patientsList.get(i).add(rs.getString(j));
                }
            }


            rs.close();
            stmt.close();
        }
        catch (Exception ex) {
            System.out.println("ERROR in DBservice.getUserList: " + ex.getMessage());
        }

        return patientsList;
    }

    public EPatient getOnePatient(String patientId) throws Exception{
        EPatient epatient;
        try
        {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM patients WHERE id = " + patientId);
            ResultSetMetaData mt = rs.getMetaData();

            List<String> props = new ArrayList<>();
            while(rs.next()){
                for(int i = 1; i <= mt.getColumnCount(); i++) {
                    props.add(rs.getString(i));
                }
            }
            if (props.get(0).equals("null"))
                throw new Exception("ID not found");

            epatient = new EPatient(props);

            rs.close();
            st.close();
        }
        catch (Exception ex) {
            System.out.println("ERROR in DBservice.getOneUser: " + ex);
            throw new Exception();
        }

        return epatient;
    }

    public EPatient deleteOnePatient(String patientId) throws Exception{
        EPatient epatient;
        try
        {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM patients WHERE id = " + patientId);
            ResultSetMetaData mt = rs.getMetaData();

           List<String> props = new ArrayList<>();
            while(rs.next()){
                for(int i = 1; i <= mt.getColumnCount(); i++) {
                    props.add(rs.getString(i));
                }
            }
            if (props.get(0).equals("null"))
                throw new Exception("ID not found");

            epatient = new EPatient(props);

            int deletedRows = st.executeUpdate("DELETE FROM patients WHERE Id = " + patientId );

            rs.close();
            st.close();
        }
        catch (Exception ex) {
            System.out.println("ERROR in DBservice.deleteOneUser: " + ex);
            throw new Exception();
        }

        return epatient;
    }

    public EPatient updateOnePatient(String patientId, EPatient newPatientData) throws Exception{
        EPatient epatient;
        try
        {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM patients WHERE id = " + patientId);
            ResultSetMetaData mt = rs.getMetaData();

            List<String> props = new ArrayList<>();
            while(rs.next()){
                for(int i = 1; i <= mt.getColumnCount(); i++) {
                    props.add(rs.getString(i));
                }
            }
            if (props.get(0).equals("null"))
                throw new Exception("ID not found");

            epatient = new EPatient(props);

            st.executeUpdate(String.format("UPDATE patients SET id = %s,", newPatientData.getId())
                    + String.format("dateOfAdmission = %s,", newPatientData.getDateOfAdmission().equals("null")?"null": "'"+newPatientData.getDateOfAdmission()+"'")
                    + String.format("sex = %s,", newPatientData.getSex())
                    + String.format("age = %s,", newPatientData.getAge())
                    + String.format("urea = %s,", newPatientData.getUrea())
                    + String.format("creatinine = %s,", newPatientData.getCreatinine())
                    + String.format("AST = %s,", newPatientData.getAST())
                    + String.format("ALT = %s,", newPatientData.getALT())
                    + String.format("glucose = %s,", newPatientData.getGlucose())
                    + String.format("leukocytes = %s,", newPatientData.getLeukocytes())
                    + String.format("platelets = %s,", newPatientData.getPlatelets())
                    + String.format("neutrophils = %s,", newPatientData.getNeutrophils())
                    + String.format("lymphocytes = %s,", newPatientData.getLymphocytes())
                    + String.format("DminusDimer = %s,", newPatientData.getDminusDimer())
                    + String.format("AG = %s,", newPatientData.getAG())
                    + String.format("SD = %s,", newPatientData.getSD())
                    + String.format("IBS = %s,", newPatientData.getIBS())
                    + String.format("HOBL = %s,", newPatientData.getHOBL())
                    + String.format("HBP = %s,", newPatientData.getHBP())
                    + String.format("CRP = %s,", newPatientData.getCRP())
                    + String.format("SKF = %s,", newPatientData.getSKF())
                    + String.format("neutrophilMinusLymphocyteRatio = %s,", newPatientData.getNeutrophilMinusLymphocyteRatio())
                    + String.format("cabsType = %s,", newPatientData.getCabsType())
                    + String.format("BMI = %s,", newPatientData.getBMI())
                    + String.format("overweight = %s,", newPatientData.getOverweight())
                    + String.format("smoking = %s,", newPatientData.getSmoking())
                    + String.format("heredity = %s,", newPatientData.getHeredity())
                    + String.format("dyslipidemia = %s,", newPatientData.getDyslipidemia())
                    + String.format("HOBLminusBA = %s,", newPatientData.getHOBLminusBA())
                    + String.format("PIKS = %s,", newPatientData.getPIKS())
                    + String.format("FP = %s,", newPatientData.getFP())
                    + String.format("SU = %s,", newPatientData.getSU())
                    + String.format("TH = %s,", newPatientData.getTH())
                    + String.format("varicose = %s,", newPatientData.getVaricose())
                    + String.format("cardiacLesions = %s,", newPatientData.getCardiacLesions())
                    + String.format("LLALesions = %s,", newPatientData.getLLALesions())
                    + String.format("FCAnginaPectoris = %s,", newPatientData.getFCAnginaPectoris())
                    + String.format("FCCHF = %s,", newPatientData.getFCCHF())
                    + String.format("LVEF = %s,", newPatientData.getLVEF())
                    + String.format("ISs = %s,", newPatientData.getISs())
                    + String.format("EuroScore2 = %s,", newPatientData.getEuroScore2())
                    + String.format("IK = %s,", newPatientData.getIK())
                    + String.format("IKTime = %s,", newPatientData.getIKTime())
                    + String.format("aorticClampTime = %s,", newPatientData.getAorticClampTime())
                    + String.format("TminusBodies = %s,", newPatientData.getTminusBodies())
                    + String.format("numberOfCardioplegias = %s,", newPatientData.getNumberOfCardioplegias())
                    + String.format("VPminusLZ = %s,", newPatientData.getVPminusLZ())
                    + String.format("revascularizationIndex = %s,", newPatientData.getRevascularizationIndex())
                    + String.format("YminusTypeCOBS = %s,", newPatientData.getYminusTypeCOBS())
                    + String.format("LIMAExcretion = %s,", newPatientData.getLIMAExcretion())
                    + String.format("RIMAExcretion = %s,", newPatientData.getRIMAExcretion())
                    + String.format("LAUsage = %s,", newPatientData.getLAUsage())
                    + String.format("AVUsage = %s,", newPatientData.getAVUsage())
                    + String.format("bloodLoss = %s,", newPatientData.getBloodLoss())
                    + String.format("ALVTime = %s,", newPatientData.getALVTime())
                    + String.format("inotropicSupport = %s,", newPatientData.getInotropicSupport())
                    + String.format("pneumonia = %s,", newPatientData.getPneumonia())
                    + String.format("SN = %s,", newPatientData.getSN())
                    + String.format("FPminusTP = %s,", newPatientData.getFPminusTP())
                    + String.format("pleuralEffusion = %s,", newPatientData.getPleuralEffusion())
                    + String.format("hydropericardium = %s,", newPatientData.getHydropericardium())
                    + String.format("pneumothorax = %s,", newPatientData.getPneumothorax())
                    + String.format("sternalComplications = %s,", newPatientData.getSternalComplications())
                    + String.format("AKK = %s,", newPatientData.getAKK())
                    + String.format("iAPF = %s,", newPatientData.getiAPF())
                    + String.format("spironolactone = %s,", newPatientData.getSpironolactone())
                    + String.format("diuretics = %s,", newPatientData.getDiuretics())
                    + String.format("cordaron = %s,", newPatientData.getCordaron())
                    + String.format("hospitalizationDuration = %s,", newPatientData.getHospitalizationDuration())
                    + String.format("CEAfteer = %s,", newPatientData.getCEAfteer())
                    + String.format("ANCOperationsAfter = %s,", newPatientData.getANCOperationsAfter())
                    + String.format("antiplateletAgentsAfter = %s,", newPatientData.getAntiplateletAgentsAfter())
                    + String.format("anticoagulants = %s,", newPatientData.getAnticoagulants())
                    + String.format("BABAfter = %s,", newPatientData.getBABAfter())
                    + String.format("AKKAfter = %s,", newPatientData.getAKKAfter())
                    + String.format("iAPFAfter = %s,", newPatientData.getiAPFAfter())
                    + String.format("ARAAfter = %s,", newPatientData.getARAAfter())
                    + String.format("diureticsAfter = %s,", newPatientData.getDiureticsAfter())
                    + String.format("statins = %s,", newPatientData.getStatins())
                    + String.format("heartAttack = %s,", newPatientData.getHeartAttack())
                    + String.format("PCI = %s,", newPatientData.getPCI())
                    + String.format("insult = %s,", newPatientData.getInsult())
                    + String.format("death = %s", newPatientData.getDeath())
                    + String.format(" WHERE id = %s", patientId));

            rs.close();
            st.close();
        }
        catch (Exception ex) {
            System.out.println("ERROR in DBservice.updateOnePatient: " + ex);
            throw new Exception();
        }

        return epatient;
    }
}
