package classes.model.modelLogic;
import classes.database.entity.EPatient;
import classes.database.entity.EUser;
import classes.model.security.ICrypto;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class ModelLogic implements IModelLogic {
    @Inject
    ICrypto crypto;

//    public Object getEncryptedEntity(Object object, String entity) {
//        switch (entity){
//            case "users":
//                try {
//                    EUser euser = (EUser)object;
//                    // Чтобы не менять исходный объект, создаём новый, т.к. ссылка на исходный осталась, а копировать я не хочу
//                    EUser copiedEncryptedEuser = new EUser();
//                    euser.clone(copiedEncryptedEuser);
//
//                    copiedEncryptedEuser.fullName = crypto.encrypt(euser.fullName);
//                    copiedEncryptedEuser.login = crypto.encrypt(euser.login);
//                    copiedEncryptedEuser.password = crypto.encrypt(euser.password);
//                    copiedEncryptedEuser.role = crypto.encrypt(euser.role);
//                    copiedEncryptedEuser.status = crypto.encrypt(euser.status);
//
//                    return copiedEncryptedEuser;
//                }
//                catch (Exception ex) {
//                    System.out.printf("ERROR in %s.%s: %s%n",
//                            this.getClass(),
//                            new Throwable().getStackTrace()[0].getMethodName(),
//                            ex.getMessage());
//                    return null;
//                }
//            default:
//                return null;
//        }
//    }
//
//    public Object getDecryptedEntity(Object object, String entity) {
//        switch (entity){
//            case "users":
//                try {
//                    EUser euser = (EUser) object;
//                    // Чтобы не менять исходный объект, создаём новый, т.к. ссылка на исходный осталась, а копировать я не хочу
//                    EUser copiedDecryptedEuser = new EUser();
//                    euser.clone(copiedDecryptedEuser);
//
//                    copiedDecryptedEuser.fullName = crypto.decrypt(euser.fullName);
//                    copiedDecryptedEuser.login = crypto.decrypt(euser.login);
//                    copiedDecryptedEuser.password = crypto.decrypt(euser.password);
//                    copiedDecryptedEuser.role = crypto.decrypt(euser.role);
//                    copiedDecryptedEuser.status = crypto.decrypt(euser.status);
//
//                    return copiedDecryptedEuser;
//                }
//                catch (Exception ex) {
//                    System.out.printf("ERROR in %s.%s: %s%n",
//                            this.getClass(),
//                            new Throwable().getStackTrace()[0].getMethodName(),
//                            ex.getMessage());
//                    return null;
//                }
//            default:
//                return null;
//        }
//    }
//
//    public List<Object> getEncryptedEntityList(List<Object> objectList, String entity) throws Exception {
//        try {
//            switch (entity) {
//                case "users":
//                    List<EUser> userList = objectList.stream()
//                            .map(element -> (EUser) element).toList();
//                    for (EUser euser : userList) {
//                        euser.fullName = crypto.encrypt(euser.fullName);
//                        euser.login = crypto.encrypt(euser.login);
//                        euser.password = crypto.encrypt(euser.password);
//                        euser.role = crypto.encrypt(euser.role);
//                        euser.status = crypto.encrypt(euser.status);
//                    }
//
//                    return new ArrayList<>(userList);
//                default:
//                    throw new Exception("no such entity");
//            }
//        }
//        catch (Exception ex){
//            System.out.printf("ERROR in %s.%s: %s%n",
//                    this.getClass(),
//                    new Throwable().getStackTrace()[0].getMethodName(),
//                    ex.getMessage());
//            throw new Exception(ex.getMessage());
//        }
//    }
//
//    public List<Object> getDecryptedEntityList(List<Object> objectList, String entity) throws Exception {
//        try {
//            switch (entity) {
//                case "users":
//                    List<EUser> userList = objectList.stream()
//                            .map(element -> (EUser) element).toList();
//                    for (EUser euser : userList) {
//                        euser.fullName = crypto.decrypt(euser.fullName);
//                        euser.login = crypto.decrypt(euser.login);
//                        euser.password = crypto.decrypt(euser.password);
//                        euser.role = crypto.decrypt(euser.role);
//                        euser.status = crypto.decrypt(euser.status);
//                    }
//
//                    return new ArrayList<>(userList);
//                default:
//                    throw new Exception("no such entity");
//            }
//        }
//        catch (Exception ex){
//            System.out.printf("ERROR in %s.%s: %s%n",
//                    this.getClass(),
//                    new Throwable().getStackTrace()[0].getMethodName(),
//                    ex.getMessage());
//            throw new Exception(ex.getMessage());
//        }
//    }


    public EUser getEncryptedUser(EUser euser) {
        try {
            EUser copiedEncryptedEuser = new EUser();
            euser.clone(copiedEncryptedEuser);

            copiedEncryptedEuser.fullName = crypto.encrypt(euser.fullName);
            copiedEncryptedEuser.login = crypto.encrypt(euser.login);
            copiedEncryptedEuser.password = crypto.encrypt(euser.password);
            copiedEncryptedEuser.role = crypto.encrypt(euser.role);
            copiedEncryptedEuser.status = crypto.encrypt(euser.status);

            return copiedEncryptedEuser;
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return null;
        }
    }

    public EUser getDecryptedUser(EUser euser) {
        try {
            EUser copiedDecryptedEuser = new EUser();
            euser.clone(copiedDecryptedEuser);

            copiedDecryptedEuser.fullName = crypto.decrypt(euser.fullName);
            copiedDecryptedEuser.login = crypto.decrypt(euser.login);
            copiedDecryptedEuser.password = crypto.decrypt(euser.password);
            copiedDecryptedEuser.role = crypto.decrypt(euser.role);
            copiedDecryptedEuser.status = crypto.decrypt(euser.status);

            return copiedDecryptedEuser;
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return null;
        }
    }

    public List<EUser> getEncryptedUserList(List<EUser> userList) throws Exception {
        try {
            List<EUser> copiedEncryptedUserList = new ArrayList<>();
            // копирование
            for (int i = 0; i < userList.size(); i++) {
                copiedEncryptedUserList.add(new EUser());
                userList.get(i).clone(copiedEncryptedUserList.get(i));
                copiedEncryptedUserList.get(i).fullName = crypto.encrypt(userList.get(i).fullName);
                copiedEncryptedUserList.get(i).login = crypto.encrypt(userList.get(i).login);
                copiedEncryptedUserList.get(i).password = crypto.encrypt(userList.get(i).password);
                copiedEncryptedUserList.get(i).role = crypto.encrypt(userList.get(i).role);
                copiedEncryptedUserList.get(i).status = crypto.encrypt(userList.get(i).status);
            }
            return copiedEncryptedUserList;
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    public List<EUser> getDecryptedUserList(List<EUser> userList) throws Exception {
        try {
            List<EUser> copiedEncryptedUserList = new ArrayList<>();
            // Всратое копирование
            for (int i = 0; i < userList.size(); i++) {
                copiedEncryptedUserList.add(new EUser());
                userList.get(i).clone(copiedEncryptedUserList.get(i));
                copiedEncryptedUserList.get(i).fullName = crypto.decrypt(userList.get(i).fullName);
                copiedEncryptedUserList.get(i).login = crypto.decrypt(userList.get(i).login);
                copiedEncryptedUserList.get(i).password = crypto.decrypt(userList.get(i).password);
                copiedEncryptedUserList.get(i).role = crypto.decrypt(userList.get(i).role);
                copiedEncryptedUserList.get(i).status = crypto.decrypt(userList.get(i).status);
            }
            return copiedEncryptedUserList;
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    /////////////////////////////////////////

    public EPatient getEncryptedPatient(EPatient patient) {
        try {
            EPatient copiedEncryptedPatient = new EPatient();
            patient.clone(copiedEncryptedPatient);

            copiedEncryptedPatient.sex = crypto.encrypt(patient.sex);
            copiedEncryptedPatient.age = crypto.encrypt(patient.age);
            copiedEncryptedPatient.urea = crypto.encrypt(patient.urea);
            copiedEncryptedPatient.creatinine = crypto.encrypt(patient.creatinine);
            copiedEncryptedPatient.AST = crypto.encrypt(patient.AST);
            copiedEncryptedPatient.ALT = crypto.encrypt(patient.ALT);
            copiedEncryptedPatient.glucose = crypto.encrypt(patient.glucose);
            copiedEncryptedPatient.leukocytes = crypto.encrypt(patient.leukocytes);
            copiedEncryptedPatient.platelets = crypto.encrypt(patient.platelets);
            copiedEncryptedPatient.neutrophils = crypto.encrypt(patient.neutrophils);
            copiedEncryptedPatient.lymphocytes = crypto.encrypt(patient.lymphocytes);
            copiedEncryptedPatient.DminusDimer = crypto.encrypt(patient.DminusDimer);
            copiedEncryptedPatient.AG = crypto.encrypt(patient.AG);
            copiedEncryptedPatient.SD = crypto.encrypt(patient.SD);
            copiedEncryptedPatient.IBS = crypto.encrypt(patient.IBS);
            copiedEncryptedPatient.HOBL = crypto.encrypt(patient.HOBL);
            copiedEncryptedPatient.HBP = crypto.encrypt(patient.HBP);
            copiedEncryptedPatient.CRP = crypto.encrypt(patient.CRP);
            copiedEncryptedPatient.SKF = crypto.encrypt(patient.SKF);
            copiedEncryptedPatient.neutrophilMinusLymphocyteRatio = crypto.encrypt(patient.neutrophilMinusLymphocyteRatio);
            copiedEncryptedPatient.cabsType = crypto.encrypt(patient.cabsType);
            copiedEncryptedPatient.BMI = crypto.encrypt(patient.BMI);
            copiedEncryptedPatient.overweight = crypto.encrypt(patient.overweight);
            copiedEncryptedPatient.smoking = crypto.encrypt(patient.smoking);
            copiedEncryptedPatient.heredity = crypto.encrypt(patient.heredity);
            copiedEncryptedPatient.dyslipidemia = crypto.encrypt(patient.dyslipidemia);
            copiedEncryptedPatient.HOBLminusBA = crypto.encrypt(patient.HOBLminusBA);
            copiedEncryptedPatient.PIKS = crypto.encrypt(patient.PIKS);
            copiedEncryptedPatient.FP = crypto.encrypt(patient.FP);
            copiedEncryptedPatient.SU = crypto.encrypt(patient.SU);
            copiedEncryptedPatient.TH = crypto.encrypt(patient.TH);
            copiedEncryptedPatient.varicose = crypto.encrypt(patient.varicose);
            copiedEncryptedPatient.cardiacLesions = crypto.encrypt(patient.cardiacLesions);
            copiedEncryptedPatient.LLALesions = crypto.encrypt(patient.LLALesions);
            copiedEncryptedPatient.FCAnginaPectoris = crypto.encrypt(patient.FCAnginaPectoris);
            copiedEncryptedPatient.FCCHF = crypto.encrypt(patient.FCCHF);
            copiedEncryptedPatient.LVEF = crypto.encrypt(patient.LVEF);
            copiedEncryptedPatient.ISs = crypto.encrypt(patient.ISs);
            copiedEncryptedPatient.EuroScore2 = crypto.encrypt(patient.EuroScore2);
            copiedEncryptedPatient.IK = crypto.encrypt(patient.IK);
            copiedEncryptedPatient.IKTime = crypto.encrypt(patient.IKTime);
            copiedEncryptedPatient.aorticClampTime = crypto.encrypt(patient.aorticClampTime);
            copiedEncryptedPatient.TminusBodies = crypto.encrypt(patient.TminusBodies);
            copiedEncryptedPatient.numberOfCardioplegias = crypto.encrypt(patient.numberOfCardioplegias);
            copiedEncryptedPatient.VPminusLZ = crypto.encrypt(patient.VPminusLZ);
            copiedEncryptedPatient.revascularizationIndex = crypto.encrypt(patient.revascularizationIndex);
            copiedEncryptedPatient.YminusTypeCOBS = crypto.encrypt(patient.YminusTypeCOBS);
            copiedEncryptedPatient.LIMAExcretion = crypto.encrypt(patient.LIMAExcretion);
            copiedEncryptedPatient.RIMAExcretion = crypto.encrypt(patient.RIMAExcretion);
            copiedEncryptedPatient.LAUsage = crypto.encrypt(patient.LAUsage);
            copiedEncryptedPatient.AVUsage = crypto.encrypt(patient.AVUsage);
            copiedEncryptedPatient.bloodLoss = crypto.encrypt(patient.bloodLoss);
            copiedEncryptedPatient.ALVTime = crypto.encrypt(patient.ALVTime);
            copiedEncryptedPatient.inotropicSupport = crypto.encrypt(patient.inotropicSupport);
            copiedEncryptedPatient.pneumonia = crypto.encrypt(patient.pneumonia);
            copiedEncryptedPatient.SN = crypto.encrypt(patient.SN);
            copiedEncryptedPatient.FPminusTP = crypto.encrypt(patient.FPminusTP);
            copiedEncryptedPatient.pleuralEffusion = crypto.encrypt(patient.pleuralEffusion);
            copiedEncryptedPatient.hydropericardium = crypto.encrypt(patient.hydropericardium);
            copiedEncryptedPatient.pneumothorax = crypto.encrypt(patient.pneumothorax);
            copiedEncryptedPatient.sternalComplications = crypto.encrypt(patient.sternalComplications);
            copiedEncryptedPatient.AKK = crypto.encrypt(patient.AKK);
            copiedEncryptedPatient.iAPF = crypto.encrypt(patient.iAPF);
            copiedEncryptedPatient.spironolactone = crypto.encrypt(patient.spironolactone);
            copiedEncryptedPatient.diuretics = crypto.encrypt(patient.diuretics);
            copiedEncryptedPatient.cordaron = crypto.encrypt(patient.cordaron);
            copiedEncryptedPatient.hospitalizationDuration = crypto.encrypt(patient.hospitalizationDuration);
            copiedEncryptedPatient.CEAfteer = crypto.encrypt(patient.CEAfteer);
            copiedEncryptedPatient.ANCOperationsAfter = crypto.encrypt(patient.ANCOperationsAfter);
            copiedEncryptedPatient.antiplateletAgentsAfter = crypto.encrypt(patient.antiplateletAgentsAfter);
            copiedEncryptedPatient.anticoagulants = crypto.encrypt(patient.anticoagulants);
            copiedEncryptedPatient.BABAfter = crypto.encrypt(patient.BABAfter);
            copiedEncryptedPatient.AKKAfter = crypto.encrypt(patient.AKKAfter);
            copiedEncryptedPatient.iAPFAfter = crypto.encrypt(patient.iAPFAfter);
            copiedEncryptedPatient.ARAAfter = crypto.encrypt(patient.ARAAfter);
            copiedEncryptedPatient.diureticsAfter = crypto.encrypt(patient.diureticsAfter);
            copiedEncryptedPatient.statins = crypto.encrypt(patient.statins);
            copiedEncryptedPatient.heartAttack = crypto.encrypt(patient.heartAttack);
            copiedEncryptedPatient.PCI = crypto.encrypt(patient.PCI);
            copiedEncryptedPatient.insult = crypto.encrypt(patient.insult);
            copiedEncryptedPatient.death = crypto.encrypt(patient.death);

            return copiedEncryptedPatient;
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return null;
        }
    }

    public EPatient getDecryptedPatient(EPatient patient) {
        try {
            EPatient copiedDecryptedPatient = new EPatient();
            patient.clone(copiedDecryptedPatient);

            copiedDecryptedPatient.sex = crypto.decrypt(patient.sex);
            copiedDecryptedPatient.age = crypto.decrypt(patient.age);
            copiedDecryptedPatient.urea = crypto.decrypt(patient.urea);
            copiedDecryptedPatient.creatinine = crypto.decrypt(patient.creatinine);
            copiedDecryptedPatient.AST = crypto.decrypt(patient.AST);
            copiedDecryptedPatient.ALT = crypto.decrypt(patient.ALT);
            copiedDecryptedPatient.glucose = crypto.decrypt(patient.glucose);
            copiedDecryptedPatient.leukocytes = crypto.decrypt(patient.leukocytes);
            copiedDecryptedPatient.platelets = crypto.decrypt(patient.platelets);
            copiedDecryptedPatient.neutrophils = crypto.decrypt(patient.neutrophils);
            copiedDecryptedPatient.lymphocytes = crypto.decrypt(patient.lymphocytes);
            copiedDecryptedPatient.DminusDimer = crypto.decrypt(patient.DminusDimer);
            copiedDecryptedPatient.AG = crypto.decrypt(patient.AG);
            copiedDecryptedPatient.SD = crypto.decrypt(patient.SD);
            copiedDecryptedPatient.IBS = crypto.decrypt(patient.IBS);
            copiedDecryptedPatient.HOBL = crypto.decrypt(patient.HOBL);
            copiedDecryptedPatient.HBP = crypto.decrypt(patient.HBP);
            copiedDecryptedPatient.CRP = crypto.decrypt(patient.CRP);
            copiedDecryptedPatient.SKF = crypto.decrypt(patient.SKF);
            copiedDecryptedPatient.neutrophilMinusLymphocyteRatio = crypto.decrypt(patient.neutrophilMinusLymphocyteRatio);
            copiedDecryptedPatient.cabsType = crypto.decrypt(patient.cabsType);
            copiedDecryptedPatient.BMI = crypto.decrypt(patient.BMI);
            copiedDecryptedPatient.overweight = crypto.decrypt(patient.overweight);
            copiedDecryptedPatient.smoking = crypto.decrypt(patient.smoking);
            copiedDecryptedPatient.heredity = crypto.decrypt(patient.heredity);
            copiedDecryptedPatient.dyslipidemia = crypto.decrypt(patient.dyslipidemia);
            copiedDecryptedPatient.HOBLminusBA = crypto.decrypt(patient.HOBLminusBA);
            copiedDecryptedPatient.PIKS = crypto.decrypt(patient.PIKS);
            copiedDecryptedPatient.FP = crypto.decrypt(patient.FP);
            copiedDecryptedPatient.SU = crypto.decrypt(patient.SU);
            copiedDecryptedPatient.TH = crypto.decrypt(patient.TH);
            copiedDecryptedPatient.varicose = crypto.decrypt(patient.varicose);
            copiedDecryptedPatient.cardiacLesions = crypto.decrypt(patient.cardiacLesions);
            copiedDecryptedPatient.LLALesions = crypto.decrypt(patient.LLALesions);
            copiedDecryptedPatient.FCAnginaPectoris = crypto.decrypt(patient.FCAnginaPectoris);
            copiedDecryptedPatient.FCCHF = crypto.decrypt(patient.FCCHF);
            copiedDecryptedPatient.LVEF = crypto.decrypt(patient.LVEF);
            copiedDecryptedPatient.ISs = crypto.decrypt(patient.ISs);
            copiedDecryptedPatient.EuroScore2 = crypto.decrypt(patient.EuroScore2);
            copiedDecryptedPatient.IK = crypto.decrypt(patient.IK);
            copiedDecryptedPatient.IKTime = crypto.decrypt(patient.IKTime);
            copiedDecryptedPatient.aorticClampTime = crypto.decrypt(patient.aorticClampTime);
            copiedDecryptedPatient.TminusBodies = crypto.decrypt(patient.TminusBodies);
            copiedDecryptedPatient.numberOfCardioplegias = crypto.decrypt(patient.numberOfCardioplegias);
            copiedDecryptedPatient.VPminusLZ = crypto.decrypt(patient.VPminusLZ);
            copiedDecryptedPatient.revascularizationIndex = crypto.decrypt(patient.revascularizationIndex);
            copiedDecryptedPatient.YminusTypeCOBS = crypto.decrypt(patient.YminusTypeCOBS);
            copiedDecryptedPatient.LIMAExcretion = crypto.decrypt(patient.LIMAExcretion);
            copiedDecryptedPatient.RIMAExcretion = crypto.decrypt(patient.RIMAExcretion);
            copiedDecryptedPatient.LAUsage = crypto.decrypt(patient.LAUsage);
            copiedDecryptedPatient.AVUsage = crypto.decrypt(patient.AVUsage);
            copiedDecryptedPatient.bloodLoss = crypto.decrypt(patient.bloodLoss);
            copiedDecryptedPatient.ALVTime = crypto.decrypt(patient.ALVTime);
            copiedDecryptedPatient.inotropicSupport = crypto.decrypt(patient.inotropicSupport);
            copiedDecryptedPatient.pneumonia = crypto.decrypt(patient.pneumonia);
            copiedDecryptedPatient.SN = crypto.decrypt(patient.SN);
            copiedDecryptedPatient.FPminusTP = crypto.decrypt(patient.FPminusTP);
            copiedDecryptedPatient.pleuralEffusion = crypto.decrypt(patient.pleuralEffusion);
            copiedDecryptedPatient.hydropericardium = crypto.decrypt(patient.hydropericardium);
            copiedDecryptedPatient.pneumothorax = crypto.decrypt(patient.pneumothorax);
            copiedDecryptedPatient.sternalComplications = crypto.decrypt(patient.sternalComplications);
            copiedDecryptedPatient.AKK = crypto.decrypt(patient.AKK);
            copiedDecryptedPatient.iAPF = crypto.decrypt(patient.iAPF);
            copiedDecryptedPatient.spironolactone = crypto.decrypt(patient.spironolactone);
            copiedDecryptedPatient.diuretics = crypto.decrypt(patient.diuretics);
            copiedDecryptedPatient.cordaron = crypto.decrypt(patient.cordaron);
            copiedDecryptedPatient.hospitalizationDuration = crypto.decrypt(patient.hospitalizationDuration);
            copiedDecryptedPatient.CEAfteer = crypto.decrypt(patient.CEAfteer);
            copiedDecryptedPatient.ANCOperationsAfter = crypto.decrypt(patient.ANCOperationsAfter);
            copiedDecryptedPatient.antiplateletAgentsAfter = crypto.decrypt(patient.antiplateletAgentsAfter);
            copiedDecryptedPatient.anticoagulants = crypto.decrypt(patient.anticoagulants);
            copiedDecryptedPatient.BABAfter = crypto.decrypt(patient.BABAfter);
            copiedDecryptedPatient.AKKAfter = crypto.decrypt(patient.AKKAfter);
            copiedDecryptedPatient.iAPFAfter = crypto.decrypt(patient.iAPFAfter);
            copiedDecryptedPatient.ARAAfter = crypto.decrypt(patient.ARAAfter);
            copiedDecryptedPatient.diureticsAfter = crypto.decrypt(patient.diureticsAfter);
            copiedDecryptedPatient.statins = crypto.decrypt(patient.statins);
            copiedDecryptedPatient.heartAttack = crypto.decrypt(patient.heartAttack);
            copiedDecryptedPatient.PCI = crypto.decrypt(patient.PCI);
            copiedDecryptedPatient.insult = crypto.decrypt(patient.insult);
            copiedDecryptedPatient.death = crypto.decrypt(patient.death);

            return copiedDecryptedPatient;
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return null;
        }
    }

    public List<EPatient> getEncryptedPatientList(List<EPatient> patientList) throws Exception {
        try {
            List<EPatient> copiedEncryptedPatientList = new ArrayList<>();
            // Всратое копирование
            for (int i = 0; i < patientList.size(); i++) {
                copiedEncryptedPatientList.add(new EPatient());
                patientList.get(i).clone(copiedEncryptedPatientList.get(i));

                copiedEncryptedPatientList.get(i).sex = crypto.encrypt(patientList.get(i).sex);
                copiedEncryptedPatientList.get(i).age = crypto.encrypt(patientList.get(i).age);
                copiedEncryptedPatientList.get(i).urea = crypto.encrypt(patientList.get(i).urea);
                copiedEncryptedPatientList.get(i).creatinine = crypto.encrypt(patientList.get(i).creatinine);
                copiedEncryptedPatientList.get(i).AST = crypto.encrypt(patientList.get(i).AST);
                copiedEncryptedPatientList.get(i).ALT = crypto.encrypt(patientList.get(i).ALT);
                copiedEncryptedPatientList.get(i).glucose = crypto.encrypt(patientList.get(i).glucose);
                copiedEncryptedPatientList.get(i).leukocytes = crypto.encrypt(patientList.get(i).leukocytes);
                copiedEncryptedPatientList.get(i).platelets = crypto.encrypt(patientList.get(i).platelets);
                copiedEncryptedPatientList.get(i).neutrophils = crypto.encrypt(patientList.get(i).neutrophils);
                copiedEncryptedPatientList.get(i).lymphocytes = crypto.encrypt(patientList.get(i).lymphocytes);
                copiedEncryptedPatientList.get(i).DminusDimer = crypto.encrypt(patientList.get(i).DminusDimer);
                copiedEncryptedPatientList.get(i).AG = crypto.encrypt(patientList.get(i).AG);
                copiedEncryptedPatientList.get(i).SD = crypto.encrypt(patientList.get(i).SD);
                copiedEncryptedPatientList.get(i).IBS = crypto.encrypt(patientList.get(i).IBS);
                copiedEncryptedPatientList.get(i).HOBL = crypto.encrypt(patientList.get(i).HOBL);
                copiedEncryptedPatientList.get(i).HBP = crypto.encrypt(patientList.get(i).HBP);
                copiedEncryptedPatientList.get(i).CRP = crypto.encrypt(patientList.get(i).CRP);
                copiedEncryptedPatientList.get(i).SKF = crypto.encrypt(patientList.get(i).SKF);
                copiedEncryptedPatientList.get(i).neutrophilMinusLymphocyteRatio = crypto.encrypt(patientList.get(i).neutrophilMinusLymphocyteRatio);
                copiedEncryptedPatientList.get(i).cabsType = crypto.encrypt(patientList.get(i).cabsType);
                copiedEncryptedPatientList.get(i).BMI = crypto.encrypt(patientList.get(i).BMI);
                copiedEncryptedPatientList.get(i).overweight = crypto.encrypt(patientList.get(i).overweight);
                copiedEncryptedPatientList.get(i).smoking = crypto.encrypt(patientList.get(i).smoking);
                copiedEncryptedPatientList.get(i).heredity = crypto.encrypt(patientList.get(i).heredity);
                copiedEncryptedPatientList.get(i).dyslipidemia = crypto.encrypt(patientList.get(i).dyslipidemia);
                copiedEncryptedPatientList.get(i).HOBLminusBA = crypto.encrypt(patientList.get(i).HOBLminusBA);
                copiedEncryptedPatientList.get(i).PIKS = crypto.encrypt(patientList.get(i).PIKS);
                copiedEncryptedPatientList.get(i).FP = crypto.encrypt(patientList.get(i).FP);
                copiedEncryptedPatientList.get(i).SU = crypto.encrypt(patientList.get(i).SU);
                copiedEncryptedPatientList.get(i).TH = crypto.encrypt(patientList.get(i).TH);
                copiedEncryptedPatientList.get(i).varicose = crypto.encrypt(patientList.get(i).varicose);
                copiedEncryptedPatientList.get(i).cardiacLesions = crypto.encrypt(patientList.get(i).cardiacLesions);
                copiedEncryptedPatientList.get(i).LLALesions = crypto.encrypt(patientList.get(i).LLALesions);
                copiedEncryptedPatientList.get(i).FCAnginaPectoris = crypto.encrypt(patientList.get(i).FCAnginaPectoris);
                copiedEncryptedPatientList.get(i).FCCHF = crypto.encrypt(patientList.get(i).FCCHF);
                copiedEncryptedPatientList.get(i).LVEF = crypto.encrypt(patientList.get(i).LVEF);
                copiedEncryptedPatientList.get(i).ISs = crypto.encrypt(patientList.get(i).ISs);
                copiedEncryptedPatientList.get(i).EuroScore2 = crypto.encrypt(patientList.get(i).EuroScore2);
                copiedEncryptedPatientList.get(i).IK = crypto.encrypt(patientList.get(i).IK);
                copiedEncryptedPatientList.get(i).IKTime = crypto.encrypt(patientList.get(i).IKTime);
                copiedEncryptedPatientList.get(i).aorticClampTime = crypto.encrypt(patientList.get(i).aorticClampTime);
                copiedEncryptedPatientList.get(i).TminusBodies = crypto.encrypt(patientList.get(i).TminusBodies);
                copiedEncryptedPatientList.get(i).numberOfCardioplegias = crypto.encrypt(patientList.get(i).numberOfCardioplegias);
                copiedEncryptedPatientList.get(i).VPminusLZ = crypto.encrypt(patientList.get(i).VPminusLZ);
                copiedEncryptedPatientList.get(i).revascularizationIndex = crypto.encrypt(patientList.get(i).revascularizationIndex);
                copiedEncryptedPatientList.get(i).YminusTypeCOBS = crypto.encrypt(patientList.get(i).YminusTypeCOBS);
                copiedEncryptedPatientList.get(i).LIMAExcretion = crypto.encrypt(patientList.get(i).LIMAExcretion);
                copiedEncryptedPatientList.get(i).RIMAExcretion = crypto.encrypt(patientList.get(i).RIMAExcretion);
                copiedEncryptedPatientList.get(i).LAUsage = crypto.encrypt(patientList.get(i).LAUsage);
                copiedEncryptedPatientList.get(i).AVUsage = crypto.encrypt(patientList.get(i).AVUsage);
                copiedEncryptedPatientList.get(i).bloodLoss = crypto.encrypt(patientList.get(i).bloodLoss);
                copiedEncryptedPatientList.get(i).ALVTime = crypto.encrypt(patientList.get(i).ALVTime);
                copiedEncryptedPatientList.get(i).inotropicSupport = crypto.encrypt(patientList.get(i).inotropicSupport);
                copiedEncryptedPatientList.get(i).pneumonia = crypto.encrypt(patientList.get(i).pneumonia);
                copiedEncryptedPatientList.get(i).SN = crypto.encrypt(patientList.get(i).SN);
                copiedEncryptedPatientList.get(i).FPminusTP = crypto.encrypt(patientList.get(i).FPminusTP);
                copiedEncryptedPatientList.get(i).pleuralEffusion = crypto.encrypt(patientList.get(i).pleuralEffusion);
                copiedEncryptedPatientList.get(i).hydropericardium = crypto.encrypt(patientList.get(i).hydropericardium);
                copiedEncryptedPatientList.get(i).pneumothorax = crypto.encrypt(patientList.get(i).pneumothorax);
                copiedEncryptedPatientList.get(i).sternalComplications = crypto.encrypt(patientList.get(i).sternalComplications);
                copiedEncryptedPatientList.get(i).AKK = crypto.encrypt(patientList.get(i).AKK);
                copiedEncryptedPatientList.get(i).iAPF = crypto.encrypt(patientList.get(i).iAPF);
                copiedEncryptedPatientList.get(i).spironolactone = crypto.encrypt(patientList.get(i).spironolactone);
                copiedEncryptedPatientList.get(i).diuretics = crypto.encrypt(patientList.get(i).diuretics);
                copiedEncryptedPatientList.get(i).cordaron = crypto.encrypt(patientList.get(i).cordaron);
                copiedEncryptedPatientList.get(i).hospitalizationDuration = crypto.encrypt(patientList.get(i).hospitalizationDuration);
                copiedEncryptedPatientList.get(i).CEAfteer = crypto.encrypt(patientList.get(i).CEAfteer);
                copiedEncryptedPatientList.get(i).ANCOperationsAfter = crypto.encrypt(patientList.get(i).ANCOperationsAfter);
                copiedEncryptedPatientList.get(i).antiplateletAgentsAfter = crypto.encrypt(patientList.get(i).antiplateletAgentsAfter);
                copiedEncryptedPatientList.get(i).anticoagulants = crypto.encrypt(patientList.get(i).anticoagulants);
                copiedEncryptedPatientList.get(i).BABAfter = crypto.encrypt(patientList.get(i).BABAfter);
                copiedEncryptedPatientList.get(i).AKKAfter = crypto.encrypt(patientList.get(i).AKKAfter);
                copiedEncryptedPatientList.get(i).iAPFAfter = crypto.encrypt(patientList.get(i).iAPFAfter);
                copiedEncryptedPatientList.get(i).ARAAfter = crypto.encrypt(patientList.get(i).ARAAfter);
                copiedEncryptedPatientList.get(i).diureticsAfter = crypto.encrypt(patientList.get(i).diureticsAfter);
                copiedEncryptedPatientList.get(i).statins = crypto.encrypt(patientList.get(i).statins);
                copiedEncryptedPatientList.get(i).heartAttack = crypto.encrypt(patientList.get(i).heartAttack);
                copiedEncryptedPatientList.get(i).PCI = crypto.encrypt(patientList.get(i).PCI);
                copiedEncryptedPatientList.get(i).insult = crypto.encrypt(patientList.get(i).insult);
                copiedEncryptedPatientList.get(i).death = crypto.encrypt(patientList.get(i).death);
            }
            return copiedEncryptedPatientList;
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    public List<EPatient> getDecryptedPatientList(List<EPatient> patientList) throws Exception {
        try {
            List<EPatient> copiedDecryptedPatientList = new ArrayList<>();
            // Всратое копирование
            for (int i = 0; i < patientList.size(); i++) {
                copiedDecryptedPatientList.add(new EPatient());
                patientList.get(i).clone(copiedDecryptedPatientList.get(i));

                copiedDecryptedPatientList.get(i).sex = crypto.decrypt(patientList.get(i).sex);
                copiedDecryptedPatientList.get(i).age = crypto.decrypt(patientList.get(i).age);
                copiedDecryptedPatientList.get(i).urea = crypto.decrypt(patientList.get(i).urea);
                copiedDecryptedPatientList.get(i).creatinine = crypto.decrypt(patientList.get(i).creatinine);
                copiedDecryptedPatientList.get(i).AST = crypto.decrypt(patientList.get(i).AST);
                copiedDecryptedPatientList.get(i).ALT = crypto.decrypt(patientList.get(i).ALT);
                copiedDecryptedPatientList.get(i).glucose = crypto.decrypt(patientList.get(i).glucose);
                copiedDecryptedPatientList.get(i).leukocytes = crypto.decrypt(patientList.get(i).leukocytes);
                copiedDecryptedPatientList.get(i).platelets = crypto.decrypt(patientList.get(i).platelets);
                copiedDecryptedPatientList.get(i).neutrophils = crypto.decrypt(patientList.get(i).neutrophils);
                copiedDecryptedPatientList.get(i).lymphocytes = crypto.decrypt(patientList.get(i).lymphocytes);
                copiedDecryptedPatientList.get(i).DminusDimer = crypto.decrypt(patientList.get(i).DminusDimer);
                copiedDecryptedPatientList.get(i).AG = crypto.decrypt(patientList.get(i).AG);
                copiedDecryptedPatientList.get(i).SD = crypto.decrypt(patientList.get(i).SD);
                copiedDecryptedPatientList.get(i).IBS = crypto.decrypt(patientList.get(i).IBS);
                copiedDecryptedPatientList.get(i).HOBL = crypto.decrypt(patientList.get(i).HOBL);
                copiedDecryptedPatientList.get(i).HBP = crypto.decrypt(patientList.get(i).HBP);
                copiedDecryptedPatientList.get(i).CRP = crypto.decrypt(patientList.get(i).CRP);
                copiedDecryptedPatientList.get(i).SKF = crypto.decrypt(patientList.get(i).SKF);
                copiedDecryptedPatientList.get(i).neutrophilMinusLymphocyteRatio = crypto.decrypt(patientList.get(i).neutrophilMinusLymphocyteRatio);
                copiedDecryptedPatientList.get(i).cabsType = crypto.decrypt(patientList.get(i).cabsType);
                copiedDecryptedPatientList.get(i).BMI = crypto.decrypt(patientList.get(i).BMI);
                copiedDecryptedPatientList.get(i).overweight = crypto.decrypt(patientList.get(i).overweight);
                copiedDecryptedPatientList.get(i).smoking = crypto.decrypt(patientList.get(i).smoking);
                copiedDecryptedPatientList.get(i).heredity = crypto.decrypt(patientList.get(i).heredity);
                copiedDecryptedPatientList.get(i).dyslipidemia = crypto.decrypt(patientList.get(i).dyslipidemia);
                copiedDecryptedPatientList.get(i).HOBLminusBA = crypto.decrypt(patientList.get(i).HOBLminusBA);
                copiedDecryptedPatientList.get(i).PIKS = crypto.decrypt(patientList.get(i).PIKS);
                copiedDecryptedPatientList.get(i).FP = crypto.decrypt(patientList.get(i).FP);
                copiedDecryptedPatientList.get(i).SU = crypto.decrypt(patientList.get(i).SU);
                copiedDecryptedPatientList.get(i).TH = crypto.decrypt(patientList.get(i).TH);
                copiedDecryptedPatientList.get(i).varicose = crypto.decrypt(patientList.get(i).varicose);
                copiedDecryptedPatientList.get(i).cardiacLesions = crypto.decrypt(patientList.get(i).cardiacLesions);
                copiedDecryptedPatientList.get(i).LLALesions = crypto.decrypt(patientList.get(i).LLALesions);
                copiedDecryptedPatientList.get(i).FCAnginaPectoris = crypto.decrypt(patientList.get(i).FCAnginaPectoris);
                copiedDecryptedPatientList.get(i).FCCHF = crypto.decrypt(patientList.get(i).FCCHF);
                copiedDecryptedPatientList.get(i).LVEF = crypto.decrypt(patientList.get(i).LVEF);
                copiedDecryptedPatientList.get(i).ISs = crypto.decrypt(patientList.get(i).ISs);
                copiedDecryptedPatientList.get(i).EuroScore2 = crypto.decrypt(patientList.get(i).EuroScore2);
                copiedDecryptedPatientList.get(i).IK = crypto.decrypt(patientList.get(i).IK);
                copiedDecryptedPatientList.get(i).IKTime = crypto.decrypt(patientList.get(i).IKTime);
                copiedDecryptedPatientList.get(i).aorticClampTime = crypto.decrypt(patientList.get(i).aorticClampTime);
                copiedDecryptedPatientList.get(i).TminusBodies = crypto.decrypt(patientList.get(i).TminusBodies);
                copiedDecryptedPatientList.get(i).numberOfCardioplegias = crypto.decrypt(patientList.get(i).numberOfCardioplegias);
                copiedDecryptedPatientList.get(i).VPminusLZ = crypto.decrypt(patientList.get(i).VPminusLZ);
                copiedDecryptedPatientList.get(i).revascularizationIndex = crypto.decrypt(patientList.get(i).revascularizationIndex);
                copiedDecryptedPatientList.get(i).YminusTypeCOBS = crypto.decrypt(patientList.get(i).YminusTypeCOBS);
                copiedDecryptedPatientList.get(i).LIMAExcretion = crypto.decrypt(patientList.get(i).LIMAExcretion);
                copiedDecryptedPatientList.get(i).RIMAExcretion = crypto.decrypt(patientList.get(i).RIMAExcretion);
                copiedDecryptedPatientList.get(i).LAUsage = crypto.decrypt(patientList.get(i).LAUsage);
                copiedDecryptedPatientList.get(i).AVUsage = crypto.decrypt(patientList.get(i).AVUsage);
                copiedDecryptedPatientList.get(i).bloodLoss = crypto.decrypt(patientList.get(i).bloodLoss);
                copiedDecryptedPatientList.get(i).ALVTime = crypto.decrypt(patientList.get(i).ALVTime);
                copiedDecryptedPatientList.get(i).inotropicSupport = crypto.decrypt(patientList.get(i).inotropicSupport);
                copiedDecryptedPatientList.get(i).pneumonia = crypto.decrypt(patientList.get(i).pneumonia);
                copiedDecryptedPatientList.get(i).SN = crypto.decrypt(patientList.get(i).SN);
                copiedDecryptedPatientList.get(i).FPminusTP = crypto.decrypt(patientList.get(i).FPminusTP);
                copiedDecryptedPatientList.get(i).pleuralEffusion = crypto.decrypt(patientList.get(i).pleuralEffusion);
                copiedDecryptedPatientList.get(i).hydropericardium = crypto.decrypt(patientList.get(i).hydropericardium);
                copiedDecryptedPatientList.get(i).pneumothorax = crypto.decrypt(patientList.get(i).pneumothorax);
                copiedDecryptedPatientList.get(i).sternalComplications = crypto.decrypt(patientList.get(i).sternalComplications);
                copiedDecryptedPatientList.get(i).AKK = crypto.decrypt(patientList.get(i).AKK);
                copiedDecryptedPatientList.get(i).iAPF = crypto.decrypt(patientList.get(i).iAPF);
                copiedDecryptedPatientList.get(i).spironolactone = crypto.decrypt(patientList.get(i).spironolactone);
                copiedDecryptedPatientList.get(i).diuretics = crypto.decrypt(patientList.get(i).diuretics);
                copiedDecryptedPatientList.get(i).cordaron = crypto.decrypt(patientList.get(i).cordaron);
                copiedDecryptedPatientList.get(i).hospitalizationDuration = crypto.decrypt(patientList.get(i).hospitalizationDuration);
                copiedDecryptedPatientList.get(i).CEAfteer = crypto.decrypt(patientList.get(i).CEAfteer);
                copiedDecryptedPatientList.get(i).ANCOperationsAfter = crypto.decrypt(patientList.get(i).ANCOperationsAfter);
                copiedDecryptedPatientList.get(i).antiplateletAgentsAfter = crypto.decrypt(patientList.get(i).antiplateletAgentsAfter);
                copiedDecryptedPatientList.get(i).anticoagulants = crypto.decrypt(patientList.get(i).anticoagulants);
                copiedDecryptedPatientList.get(i).BABAfter = crypto.decrypt(patientList.get(i).BABAfter);
                copiedDecryptedPatientList.get(i).AKKAfter = crypto.decrypt(patientList.get(i).AKKAfter);
                copiedDecryptedPatientList.get(i).iAPFAfter = crypto.decrypt(patientList.get(i).iAPFAfter);
                copiedDecryptedPatientList.get(i).ARAAfter = crypto.decrypt(patientList.get(i).ARAAfter);
                copiedDecryptedPatientList.get(i).diureticsAfter = crypto.decrypt(patientList.get(i).diureticsAfter);
                copiedDecryptedPatientList.get(i).statins = crypto.decrypt(patientList.get(i).statins);
                copiedDecryptedPatientList.get(i).heartAttack = crypto.decrypt(patientList.get(i).heartAttack);
                copiedDecryptedPatientList.get(i).PCI = crypto.decrypt(patientList.get(i).PCI);
                copiedDecryptedPatientList.get(i).insult = crypto.decrypt(patientList.get(i).insult);
                copiedDecryptedPatientList.get(i).death = crypto.decrypt(patientList.get(i).death);
            }
            return copiedDecryptedPatientList;
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }
}
