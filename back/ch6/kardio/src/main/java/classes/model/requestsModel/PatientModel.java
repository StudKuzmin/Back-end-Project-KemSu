package classes.model.requestsModel;

import classes.controller.entity.EPatient;
import classes.controller.entity.EUser;
import classes.database.DBservice;
import classes.model.model.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatientModel {
    private DBservice dbservice;
    private Model model;
    public PatientModel(){
        dbservice = new DBservice(); // TODO DELETE DEPENDENCE
        model = new Model(); // TODO DELETE DEPENDENCE
    }

    public List<EPatient> getPatientList(){
        List<EPatient> patientListJSON = new ArrayList<>();
        List<ArrayList<String>> patientList;
        try{
            patientList = dbservice.getPatientsList();
            for(int i = 0; i < patientList.size(); i++){
                String id = patientList.get(i).get(0);
                String dateOfAdmission = patientList.get(i).get(0);
                String sex = patientList.get(i).get(0);
                String age = patientList.get(i).get(0);
                String urea = patientList.get(i).get(0);
                String creatinine = patientList.get(i).get(0);
                String AST = patientList.get(i).get(0);
                String ALT = patientList.get(i).get(0);
                String glucose = patientList.get(i).get(0);
                String leukocytes = patientList.get(i).get(0);
                String platelets = patientList.get(i).get(0);
                String neutrophils = patientList.get(i).get(0);
                String lymphocytes = patientList.get(i).get(0);
                String DminusDimer = patientList.get(i).get(0);
                String AG = patientList.get(i).get(0);
                String SD = patientList.get(i).get(0);
                String IBS = patientList.get(i).get(0);
                String HOBL = patientList.get(i).get(0);
                String HBP = patientList.get(i).get(0);
                String CRP = patientList.get(i).get(0);
                String SKF = patientList.get(i).get(0);
                String neutrophilMinusLymphocyteRatio = patientList.get(i).get(0);
                String cabsType = patientList.get(i).get(0);
                String BMI = patientList.get(i).get(0);
                String overweight = patientList.get(i).get(0);
                String smoking = patientList.get(i).get(0);
                String heredity = patientList.get(i).get(0);
                String dyslipidemia = patientList.get(i).get(0);
                String HOBLminusBA = patientList.get(i).get(0);
                String PIKS = patientList.get(i).get(0);
                String FP = patientList.get(i).get(0);
                String SU = patientList.get(i).get(0);
                String TH = patientList.get(i).get(0);
                String varicose = patientList.get(i).get(0);
                String cardiacLesions = patientList.get(i).get(0);
                String LLALesions = patientList.get(i).get(0);
                String FCAnginaPectoris = patientList.get(i).get(0);
                String FCCHF = patientList.get(i).get(0);
                String LVEF = patientList.get(i).get(0);
                String ISs = patientList.get(i).get(0);
                String EuroScore2 = patientList.get(i).get(0);
                String IK = patientList.get(i).get(0);
                String IKTime = patientList.get(i).get(0);
                String aorticClampTime = patientList.get(i).get(0);
                String TminusBodies = patientList.get(i).get(0);
                String numberOfCardioplegias = patientList.get(i).get(0);
                String VPminusLZ = patientList.get(i).get(0);
                String revascularizationIndex = patientList.get(i).get(0);
                String YminusTypeCOBS = patientList.get(i).get(0);
                String LIMAExcretion = patientList.get(i).get(0);
                String RIMAExcretion = patientList.get(i).get(0);
                String LAUsage = patientList.get(i).get(0);
                String AVUsage = patientList.get(i).get(0);
                String bloodLoss = patientList.get(i).get(0);
                String ALVTime = patientList.get(i).get(0);
                String inotropicSupport = patientList.get(i).get(0);
                String pneumonia = patientList.get(i).get(0);
                String SN = patientList.get(i).get(0);
                String FPminusTP = patientList.get(i).get(0);
                String pleuralEffusion = patientList.get(i).get(0);
                String hydropericardium = patientList.get(i).get(0);
                String pneumothorax = patientList.get(i).get(0);
                String sternalComplications = patientList.get(i).get(0);
                String AKK = patientList.get(i).get(0);
                String iAPF = patientList.get(i).get(0);
                String spironolactone = patientList.get(i).get(0);
                String diuretics = patientList.get(i).get(0);
                String cordaron = patientList.get(i).get(0);
                String hospitalizationDuration = patientList.get(i).get(0);
                String CEAfteer = patientList.get(i).get(0);
                String ANCOperationsAfter = patientList.get(i).get(0);
                String antiplateletAgentsAfter = patientList.get(i).get(0);
                String anticoagulants = patientList.get(i).get(0);
                String BABAfter = patientList.get(i).get(0);
                String AKKAfter = patientList.get(i).get(0);
                String iAPFAfter = patientList.get(i).get(0);
                String ARAAfter = patientList.get(i).get(0);
                String diureticsAfter = patientList.get(i).get(0);
                String statins = patientList.get(i).get(0);
                String heartAttack = patientList.get(i).get(0);
                String PCI = patientList.get(i).get(0);
                String insult = patientList.get(i).get(0);
                String death = patientList.get(i).get(0);

                patientListJSON.add(new EPatient(id,
                        dateOfAdmission,
                        sex,
                        age,
                        urea,
                        creatinine,
                        AST,
                        ALT,
                        glucose,
                        leukocytes,
                        platelets,
                        neutrophils,
                        lymphocytes,
                        DminusDimer,
                        AG,
                        SD,
                        IBS,
                        HOBL,
                        HBP,
                        CRP,
                        SKF,
                        neutrophilMinusLymphocyteRatio,
                        cabsType,
                        BMI,
                        overweight,
                        smoking,
                        heredity,
                        dyslipidemia,
                        HOBLminusBA,
                        PIKS,
                        FP,
                        SU,
                        TH,
                        varicose,
                        cardiacLesions,
                        LLALesions,
                        FCAnginaPectoris,
                        FCCHF,
                        LVEF,
                        ISs,
                        EuroScore2,
                        IK,
                        IKTime,
                        aorticClampTime,
                        TminusBodies,
                        numberOfCardioplegias,
                        VPminusLZ,
                        revascularizationIndex,
                        YminusTypeCOBS,
                        LIMAExcretion,
                        RIMAExcretion,
                        LAUsage,
                        AVUsage,
                        bloodLoss,
                        ALVTime,
                        inotropicSupport,
                        pneumonia,
                        SN,
                        FPminusTP,
                        pleuralEffusion,
                        hydropericardium,
                        pneumothorax,
                        sternalComplications,
                        AKK,
                        iAPF,
                        spironolactone,
                        diuretics,
                        cordaron,
                        hospitalizationDuration,
                        CEAfteer,
                        ANCOperationsAfter,
                        antiplateletAgentsAfter,
                        anticoagulants,
                        BABAfter,
                        AKKAfter,
                        iAPFAfter,
                        ARAAfter,
                        diureticsAfter,
                        statins,
                        heartAttack,
                        PCI,
                        insult,
                        death));
            }
        }
        catch(Exception ex){
            System.out.println("ERROR in PatientModel.getPatientList: " + ex);
        }
        return patientListJSON;
    }

    public boolean createPatient(EPatient epatient) throws Exception{
        try {
            boolean patientCreated = false;
            List<String> patientArray = model.toStringArray(epatient);

            patientCreated = dbservice.createPatient(patientArray);

            return patientCreated;
        }
        catch(Exception ex) {
            System.out.println("ERROR in UserModel.createPatient: " + ex);
            throw new Exception();
        }
    }

    public EPatient getOnePatient(String patientId) throws Exception{
        try{
            return dbservice.getOnePatient(patientId);
        }
        catch (Exception ex){
            System.out.println("ERROR in UserModel.getOneUser: " + ex);
            throw new Exception();
        }
    }
    public EPatient deleteOnePatient(String patientId) throws Exception{
        try{
            return dbservice.deleteOnePatient(patientId);
        }
        catch (Exception ex){
            System.out.println("ERROR in UserModel.deleteOneUser: " + ex);
            throw new Exception();
        }
    }
    public EPatient updateOnePatient(String patientId, EPatient newPatientData) throws Exception{
        try{
            //List<String> patientsArray = model.toStringArray(newPatientData);
            return dbservice.updateOnePatient(patientId, newPatientData);
        }
        catch (Exception ex){
            System.out.println("ERROR in UserModel.updateOneUser: " + ex);
            throw new Exception();
        }
    }
}
