package classes.model.modelLogic;
import classes.database.entity.patient.EPatientCabs;
import classes.database.entity.patient.EPatientCovid;
import classes.database.entity.patient.EPatientCovidProperties;
import classes.database.entity.user.EUser;
import classes.model.security.ICrypto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModelLogic implements IModelLogic {
    @Inject
    ICrypto crypto;

    public EUser getEncryptedUser(EUser euser) {
        try {
            System.out.println("TEST IN getEncryptedUser: " + euser.id + " " + euser.userName + " " + euser.password);
            EUser copiedEncryptedEuser = new EUser();
            euser.clone(copiedEncryptedEuser);

            copiedEncryptedEuser.firstName = crypto.encrypt(euser.firstName);
            copiedEncryptedEuser.middleName = crypto.encrypt(euser.middleName);
            copiedEncryptedEuser.lastName = crypto.encrypt(euser.lastName);
            copiedEncryptedEuser.userName = crypto.encrypt(euser.userName);
            copiedEncryptedEuser.password = crypto.encrypt(euser.password);
            copiedEncryptedEuser.role = crypto.encrypt(euser.role);
            copiedEncryptedEuser.createdAt = crypto.encrypt(euser.createdAt);

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

            copiedDecryptedEuser.firstName = crypto.decrypt(euser.firstName);
            copiedDecryptedEuser.middleName = crypto.decrypt(euser.middleName);
            copiedDecryptedEuser.lastName = crypto.decrypt(euser.lastName);
            copiedDecryptedEuser.userName = crypto.decrypt(euser.userName);
            copiedDecryptedEuser.password = crypto.decrypt(euser.password);
            copiedDecryptedEuser.role = crypto.decrypt(euser.role);
            copiedDecryptedEuser.createdAt = crypto.decrypt(euser.createdAt);

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
                copiedEncryptedUserList.get(i).firstName = crypto.encrypt(userList.get(i).firstName);
                copiedEncryptedUserList.get(i).middleName = crypto.encrypt(userList.get(i).middleName);
                copiedEncryptedUserList.get(i).lastName = crypto.encrypt(userList.get(i).lastName);
                copiedEncryptedUserList.get(i).userName = crypto.encrypt(userList.get(i).userName);
                copiedEncryptedUserList.get(i).password = crypto.encrypt(userList.get(i).password);
                copiedEncryptedUserList.get(i).createdAt = crypto.encrypt(userList.get(i).createdAt);
                copiedEncryptedUserList.get(i).role = crypto.encrypt(userList.get(i).role);
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
                copiedEncryptedUserList.get(i).firstName = crypto.decrypt(userList.get(i).firstName);
                copiedEncryptedUserList.get(i).middleName = crypto.decrypt(userList.get(i).middleName);
                copiedEncryptedUserList.get(i).lastName = crypto.decrypt(userList.get(i).lastName);
                copiedEncryptedUserList.get(i).userName = crypto.decrypt(userList.get(i).userName);
                copiedEncryptedUserList.get(i).password = crypto.decrypt(userList.get(i).password);
                copiedEncryptedUserList.get(i).createdAt = crypto.decrypt(userList.get(i).createdAt);
                copiedEncryptedUserList.get(i).role = crypto.decrypt(userList.get(i).role);
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

    public EPatientCovid getEncryptedPatientCovid(EPatientCovid ePatientCovid) {
        try {
            EPatientCovid copiedEncryptedPatientCovid = new EPatientCovid();

            copiedEncryptedPatientCovid.id = ePatientCovid.id;
            copiedEncryptedPatientCovid.userid = ePatientCovid.userid;
            copiedEncryptedPatientCovid.description = crypto.encrypt(ePatientCovid.description);
            copiedEncryptedPatientCovid.createdAt = crypto.encrypt(ePatientCovid.createdAt);
            copiedEncryptedPatientCovid.updatedAt = crypto.encrypt(ePatientCovid.updatedAt);
            copiedEncryptedPatientCovid.type = crypto.encrypt(ePatientCovid.type);
            copiedEncryptedPatientCovid.properties.sex = crypto.encrypt(ePatientCovid.properties.sex);
            copiedEncryptedPatientCovid.properties.age = crypto.encrypt(ePatientCovid.properties.age);
            copiedEncryptedPatientCovid.properties.urea = crypto.encrypt(ePatientCovid.properties.urea);
            copiedEncryptedPatientCovid.properties.creatinine = crypto.encrypt(ePatientCovid.properties.creatinine);
            copiedEncryptedPatientCovid.properties.AST = crypto.encrypt(ePatientCovid.properties.AST);
            copiedEncryptedPatientCovid.properties.ALT = crypto.encrypt(ePatientCovid.properties.ALT);
            copiedEncryptedPatientCovid.properties.glucose = crypto.encrypt(ePatientCovid.properties.glucose);
            copiedEncryptedPatientCovid.properties.leukocytes = crypto.encrypt(ePatientCovid.properties.leukocytes);
            copiedEncryptedPatientCovid.properties.platelets = crypto.encrypt(ePatientCovid.properties.platelets);
            copiedEncryptedPatientCovid.properties.neutrophils = crypto.encrypt(ePatientCovid.properties.neutrophils);
            copiedEncryptedPatientCovid.properties.lymphocytes = crypto.encrypt(ePatientCovid.properties.lymphocytes);
            copiedEncryptedPatientCovid.properties.severity = crypto.encrypt(ePatientCovid.properties.severity);
            copiedEncryptedPatientCovid.properties.DDimer = crypto.encrypt(ePatientCovid.properties.DDimer);
            copiedEncryptedPatientCovid.properties.AG = crypto.encrypt(ePatientCovid.properties.AG);
            copiedEncryptedPatientCovid.properties.SD = crypto.encrypt(ePatientCovid.properties.SD);
            copiedEncryptedPatientCovid.properties.IBS = crypto.encrypt(ePatientCovid.properties.IBS);
            copiedEncryptedPatientCovid.properties.HOBL = crypto.encrypt(ePatientCovid.properties.HOBL);
            copiedEncryptedPatientCovid.properties.HBP = crypto.encrypt(ePatientCovid.properties.HBP);
            copiedEncryptedPatientCovid.properties.CRP = crypto.encrypt(ePatientCovid.properties.CRP);
            copiedEncryptedPatientCovid.properties.SKF = crypto.encrypt(ePatientCovid.properties.SKF);
            copiedEncryptedPatientCovid.properties.neutrophilLymphocyteRatio = crypto.encrypt(ePatientCovid.properties.neutrophilLymphocyteRatio);
            copiedEncryptedPatientCovid.properties.survived = crypto.encrypt(ePatientCovid.properties.survived);

            return copiedEncryptedPatientCovid;
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return null;
        }
    }

    public EPatientCabs getEncryptedPatientCabs(EPatientCabs ePatientCabs) {
        try {
            EPatientCabs copiedEncryptedPatientCabs = new EPatientCabs();

            copiedEncryptedPatientCabs.id = ePatientCabs.id;
            copiedEncryptedPatientCabs.userid = ePatientCabs.userid;
            copiedEncryptedPatientCabs.description = crypto.encrypt(ePatientCabs.description);
            copiedEncryptedPatientCabs.createdAt = crypto.encrypt(ePatientCabs.createdAt);
            copiedEncryptedPatientCabs.updatedAt = crypto.encrypt(ePatientCabs.updatedAt);
            copiedEncryptedPatientCabs.type = crypto.encrypt(ePatientCabs.type);

            copiedEncryptedPatientCabs.properties.cabsKind = crypto.encrypt(ePatientCabs.properties.cabsKind);
            copiedEncryptedPatientCabs.properties.age = crypto.encrypt(ePatientCabs.properties.age);
            copiedEncryptedPatientCabs.properties.sex = crypto.encrypt(ePatientCabs.properties.sex);
            copiedEncryptedPatientCabs.properties.BMI = crypto.encrypt(ePatientCabs.properties.BMI);
            copiedEncryptedPatientCabs.properties.syntaxScore = crypto.encrypt(ePatientCabs.properties.syntaxScore);
            copiedEncryptedPatientCabs.properties.arterialHypertension = crypto.encrypt(ePatientCabs.properties.arterialHypertension);
            copiedEncryptedPatientCabs.properties.diabetes = crypto.encrypt(ePatientCabs.properties.diabetes);
            copiedEncryptedPatientCabs.properties.obesity = crypto.encrypt(ePatientCabs.properties.obesity);
            copiedEncryptedPatientCabs.properties.smoking = crypto.encrypt(ePatientCabs.properties.smoking);
            copiedEncryptedPatientCabs.properties.angiotensinInhibitors = crypto.encrypt(ePatientCabs.properties.angiotensinInhibitors);
            copiedEncryptedPatientCabs.properties.heredity = crypto.encrypt(ePatientCabs.properties.heredity);
            copiedEncryptedPatientCabs.properties.dyslipidemia = crypto.encrypt(ePatientCabs.properties.dyslipidemia);
            copiedEncryptedPatientCabs.properties.asthma = crypto.encrypt(ePatientCabs.properties.asthma);
            copiedEncryptedPatientCabs.properties.postinfarctionCardiosclerosis = crypto.encrypt(ePatientCabs.properties.postinfarctionCardiosclerosis);
            copiedEncryptedPatientCabs.properties.atrialFibrillation = crypto.encrypt(ePatientCabs.properties.atrialFibrillation);
            copiedEncryptedPatientCabs.properties.chronicRenalInsufficiency = crypto.encrypt(ePatientCabs.properties.chronicRenalInsufficiency);
            copiedEncryptedPatientCabs.properties.pepticUlcer = crypto.encrypt(ePatientCabs.properties.pepticUlcer);
            copiedEncryptedPatientCabs.properties.thyroidDisorders = crypto.encrypt(ePatientCabs.properties.thyroidDisorders);
            copiedEncryptedPatientCabs.properties.varicoseVein = crypto.encrypt(ePatientCabs.properties.varicoseVein);
            copiedEncryptedPatientCabs.properties.insult = crypto.encrypt(ePatientCabs.properties.insult);
            copiedEncryptedPatientCabs.properties.lowerLimbIschemia = crypto.encrypt(ePatientCabs.properties.lowerLimbIschemia);
            copiedEncryptedPatientCabs.properties.anginaFuncClass = crypto.encrypt(ePatientCabs.properties.anginaFuncClass);
            copiedEncryptedPatientCabs.properties.chronicHeartFailureFuncClass = crypto.encrypt(ePatientCabs.properties.chronicHeartFailureFuncClass);
            copiedEncryptedPatientCabs.properties.leftVentricularEjectionFraction = crypto.encrypt(ePatientCabs.properties.leftVentricularEjectionFraction);
            copiedEncryptedPatientCabs.properties.interventricularSeptum = crypto.encrypt(ePatientCabs.properties.interventricularSeptum);
            copiedEncryptedPatientCabs.properties.euroScoreII = crypto.encrypt(ePatientCabs.properties.euroScoreII);
            copiedEncryptedPatientCabs.properties.artificialCirculation = crypto.encrypt(ePatientCabs.properties.artificialCirculation);
            copiedEncryptedPatientCabs.properties.artificialCirculationTime = crypto.encrypt(ePatientCabs.properties.artificialCirculationTime);
            copiedEncryptedPatientCabs.properties.aorticConstrictionTime = crypto.encrypt(ePatientCabs.properties.aorticConstrictionTime);
            copiedEncryptedPatientCabs.properties.bodyTemperature = crypto.encrypt(ePatientCabs.properties.bodyTemperature);
            copiedEncryptedPatientCabs.properties.cardioplegiaNumber = crypto.encrypt(ePatientCabs.properties.cardioplegiaNumber);
            copiedEncryptedPatientCabs.properties.ventriculoplastLV = crypto.encrypt(ePatientCabs.properties.ventriculoplastLV);
            copiedEncryptedPatientCabs.properties.revascularizationIdx = crypto.encrypt(ePatientCabs.properties.revascularizationIdx);
            copiedEncryptedPatientCabs.properties.yCoronaryBypass = crypto.encrypt(ePatientCabs.properties.yCoronaryBypass);
            copiedEncryptedPatientCabs.properties.litaDischarge = crypto.encrypt(ePatientCabs.properties.litaDischarge);
            copiedEncryptedPatientCabs.properties.ritaDischarge = crypto.encrypt(ePatientCabs.properties.ritaDischarge);
            copiedEncryptedPatientCabs.properties.radialArteryUsage = crypto.encrypt(ePatientCabs.properties.radialArteryUsage);
            copiedEncryptedPatientCabs.properties.poplitealArteryUsage = crypto.encrypt(ePatientCabs.properties.poplitealArteryUsage);
            copiedEncryptedPatientCabs.properties.bloodLoss = crypto.encrypt(ePatientCabs.properties.bloodLoss);
            copiedEncryptedPatientCabs.properties.artificialVentTime = crypto.encrypt(ePatientCabs.properties.artificialVentTime);
            copiedEncryptedPatientCabs.properties.inotropicSupport = crypto.encrypt(ePatientCabs.properties.inotropicSupport);
            copiedEncryptedPatientCabs.properties.pneumonia = crypto.encrypt(ePatientCabs.properties.pneumonia);
            copiedEncryptedPatientCabs.properties.heartFailure = crypto.encrypt(ePatientCabs.properties.heartFailure);
            copiedEncryptedPatientCabs.properties.reanimationAtrialFibrillation = crypto.encrypt(ePatientCabs.properties.reanimationAtrialFibrillation);
            copiedEncryptedPatientCabs.properties.pleuralEffusion = crypto.encrypt(ePatientCabs.properties.pleuralEffusion);
            copiedEncryptedPatientCabs.properties.hydropericardium = crypto.encrypt(ePatientCabs.properties.hydropericardium);
            copiedEncryptedPatientCabs.properties.pneumothorax = crypto.encrypt(ePatientCabs.properties.pneumothorax);
            copiedEncryptedPatientCabs.properties.sternalComplications = crypto.encrypt(ePatientCabs.properties.sternalComplications);
            copiedEncryptedPatientCabs.properties.postCalciumChannelAntagonists = crypto.encrypt(ePatientCabs.properties.postCalciumChannelAntagonists);
            copiedEncryptedPatientCabs.properties.postAngiotensinInhibitors = crypto.encrypt(ePatientCabs.properties.postAngiotensinInhibitors);
            copiedEncryptedPatientCabs.properties.spironolactone = crypto.encrypt(ePatientCabs.properties.spironolactone);
            copiedEncryptedPatientCabs.properties.postDiuretics = crypto.encrypt(ePatientCabs.properties.postDiuretics);
            copiedEncryptedPatientCabs.properties.cordarone = crypto.encrypt(ePatientCabs.properties.cordarone);
            copiedEncryptedPatientCabs.properties.hospitalizationDuration = crypto.encrypt(ePatientCabs.properties.hospitalizationDuration);
            copiedEncryptedPatientCabs.properties.carotidEndarterectomy = crypto.encrypt(ePatientCabs.properties.carotidEndarterectomy);
            copiedEncryptedPatientCabs.properties.lowerLimbSurgery = crypto.encrypt(ePatientCabs.properties.lowerLimbSurgery);
            copiedEncryptedPatientCabs.properties.antiaggregants = crypto.encrypt(ePatientCabs.properties.antiaggregants);
            copiedEncryptedPatientCabs.properties.anticoagulants = crypto.encrypt(ePatientCabs.properties.anticoagulants);
            copiedEncryptedPatientCabs.properties.betaAB = crypto.encrypt(ePatientCabs.properties.betaAB);
            copiedEncryptedPatientCabs.properties.angiotensinAntagonists = crypto.encrypt(ePatientCabs.properties.angiotensinAntagonists);
            copiedEncryptedPatientCabs.properties.statins = crypto.encrypt(ePatientCabs.properties.statins);
            copiedEncryptedPatientCabs.properties.MI = crypto.encrypt(ePatientCabs.properties.MI);
            copiedEncryptedPatientCabs.properties.CI = crypto.encrypt(ePatientCabs.properties.CI);
            copiedEncryptedPatientCabs.properties.insultOutcome = crypto.encrypt(ePatientCabs.properties.insultOutcome);
            copiedEncryptedPatientCabs.properties.death = crypto.encrypt(ePatientCabs.properties.death);
            copiedEncryptedPatientCabs.properties.comb = crypto.encrypt(ePatientCabs.properties.comb);

            return copiedEncryptedPatientCabs;
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return null;
        }
    }

//    public EPatientCovid getDecryptedPatientCovid(EPatientCovid ePatientCovid) {
//        try {
//            EPatientCovidProperties copiedDecryptedPatientCovidProperties = new EPatientCovidProperties();
//            ePatientCovidProperties.clone(copiedDecryptedPatientCovidProperties);
//
//            copiedDecryptedPatientCovidProperties.sex = crypto.decrypt(ePatientCovidProperties.sex);
//            copiedDecryptedPatientCovidProperties.age = crypto.decrypt(ePatientCovidProperties.age);
//            copiedDecryptedPatientCovidProperties.urea = crypto.decrypt(ePatientCovidProperties.urea);
//            copiedDecryptedPatientCovidProperties.creatinine = crypto.decrypt(ePatientCovidProperties.creatinine);
//            copiedDecryptedPatientCovidProperties.ast = crypto.decrypt(ePatientCovidProperties.ast);
//            copiedDecryptedPatientCovidProperties.alt = crypto.decrypt(ePatientCovidProperties.alt);
//            copiedDecryptedPatientCovidProperties.glucose = crypto.decrypt(ePatientCovidProperties.glucose);
//            copiedDecryptedPatientCovidProperties.leukocytes = crypto.decrypt(ePatientCovidProperties.leukocytes);
//            copiedDecryptedPatientCovidProperties.platelets = crypto.decrypt(ePatientCovidProperties.platelets);
//            copiedDecryptedPatientCovidProperties.neutrophils = crypto.decrypt(ePatientCovidProperties.neutrophils);
//            copiedDecryptedPatientCovidProperties.lymphocytes = crypto.decrypt(ePatientCovidProperties.lymphocytes);
//            copiedDecryptedPatientCovidProperties.dDimer = crypto.decrypt(ePatientCovidProperties.dDimer);
//            copiedDecryptedPatientCovidProperties.ag = crypto.decrypt(ePatientCovidProperties.ag);
//            copiedDecryptedPatientCovidProperties.sd = crypto.decrypt(ePatientCovidProperties.sd);
//            copiedDecryptedPatientCovidProperties.ibs = crypto.decrypt(ePatientCovidProperties.ibs);
//            copiedDecryptedPatientCovidProperties.hobl = crypto.decrypt(ePatientCovidProperties.hobl);
//            copiedDecryptedPatientCovidProperties.hbp = crypto.decrypt(ePatientCovidProperties.hbp);
//            copiedDecryptedPatientCovidProperties.crp = crypto.decrypt(ePatientCovidProperties.crp);
//            copiedDecryptedPatientCovidProperties.skf = crypto.decrypt(ePatientCovidProperties.skf);
//            copiedDecryptedPatientCovidProperties.neutrophilLymphocyteRatio = crypto.decrypt(ePatientCovidProperties.neutrophilLymphocyteRatio);
//
//            return copiedDecryptedPatientCovidProperties;
//        }
//        catch (Exception ex) {
//            System.out.printf("ERROR in %s.%s: %s%n",
//                    this.getClass(),
//                    new Throwable().getStackTrace()[0].getMethodName(),
//                    ex.getMessage());
//            return null;
//        }
//    }

    public List<EPatientCovid> getDecryptedPatientCovidList(List<EPatientCovid> patientCovidList) throws Exception {
        try {
            List<EPatientCovid> copiedDecryptedPatientCovidList = new ArrayList<>();

            for (int i = 0; i < patientCovidList.size(); i++) {
                copiedDecryptedPatientCovidList.add(new EPatientCovid());

                copiedDecryptedPatientCovidList.get(i).id = patientCovidList.get(i).id;
                copiedDecryptedPatientCovidList.get(i).userid = patientCovidList.get(i).userid;
                copiedDecryptedPatientCovidList.get(i).description = crypto.decrypt(patientCovidList.get(i).description);
                copiedDecryptedPatientCovidList.get(i).createdAt = crypto.decrypt(patientCovidList.get(i).createdAt);
                copiedDecryptedPatientCovidList.get(i).updatedAt = crypto.decrypt(patientCovidList.get(i).updatedAt);
                copiedDecryptedPatientCovidList.get(i).type = crypto.decrypt(patientCovidList.get(i).type);
                copiedDecryptedPatientCovidList.get(i).properties.sex = crypto.decrypt(patientCovidList.get(i).properties.sex);
                copiedDecryptedPatientCovidList.get(i).properties.age = crypto.decrypt(patientCovidList.get(i).properties.age);
                copiedDecryptedPatientCovidList.get(i).properties.urea = crypto.decrypt(patientCovidList.get(i).properties.urea);
                copiedDecryptedPatientCovidList.get(i).properties.creatinine = crypto.decrypt(patientCovidList.get(i).properties.creatinine);
                copiedDecryptedPatientCovidList.get(i).properties.AST = crypto.decrypt(patientCovidList.get(i).properties.AST);
                copiedDecryptedPatientCovidList.get(i).properties.ALT = crypto.decrypt(patientCovidList.get(i).properties.ALT);
                copiedDecryptedPatientCovidList.get(i).properties.glucose = crypto.decrypt(patientCovidList.get(i).properties.glucose);
                copiedDecryptedPatientCovidList.get(i).properties.leukocytes = crypto.decrypt(patientCovidList.get(i).properties.leukocytes);
                copiedDecryptedPatientCovidList.get(i).properties.platelets = crypto.decrypt(patientCovidList.get(i).properties.platelets);
                copiedDecryptedPatientCovidList.get(i).properties.neutrophils = crypto.decrypt(patientCovidList.get(i).properties.neutrophils);
                copiedDecryptedPatientCovidList.get(i).properties.lymphocytes = crypto.decrypt(patientCovidList.get(i).properties.lymphocytes);
                copiedDecryptedPatientCovidList.get(i).properties.severity = crypto.decrypt(patientCovidList.get(i).properties.severity);
                copiedDecryptedPatientCovidList.get(i).properties.DDimer = crypto.decrypt(patientCovidList.get(i).properties.DDimer);
                copiedDecryptedPatientCovidList.get(i).properties.AG = crypto.decrypt(patientCovidList.get(i).properties.AG);
                copiedDecryptedPatientCovidList.get(i).properties.SD = crypto.decrypt(patientCovidList.get(i).properties.SD);
                copiedDecryptedPatientCovidList.get(i).properties.IBS = crypto.decrypt(patientCovidList.get(i).properties.IBS);
                copiedDecryptedPatientCovidList.get(i).properties.HOBL = crypto.decrypt(patientCovidList.get(i).properties.HOBL);
                copiedDecryptedPatientCovidList.get(i).properties.HBP = crypto.decrypt(patientCovidList.get(i).properties.HBP);
                copiedDecryptedPatientCovidList.get(i).properties.CRP = crypto.decrypt(patientCovidList.get(i).properties.CRP);
                copiedDecryptedPatientCovidList.get(i).properties.SKF = crypto.decrypt(patientCovidList.get(i).properties.SKF);
                copiedDecryptedPatientCovidList.get(i).properties.neutrophilLymphocyteRatio = crypto.decrypt(patientCovidList.get(i).properties.neutrophilLymphocyteRatio);
                copiedDecryptedPatientCovidList.get(i).properties.survived = crypto.decrypt(patientCovidList.get(i).properties.survived);
            }
            return copiedDecryptedPatientCovidList;
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    public List<EPatientCabs> getDecryptedPatientCabsList(List<EPatientCabs> patientCabsList) throws Exception {
        try {
            List<EPatientCabs> copiedDecryptedPatientCabsList = new ArrayList<>();

            for (int i = 0; i < patientCabsList.size(); i++) {
                copiedDecryptedPatientCabsList.add(new EPatientCabs());

                copiedDecryptedPatientCabsList.get(i).id = patientCabsList.get(i).id;
                copiedDecryptedPatientCabsList.get(i).userid = patientCabsList.get(i).userid;
                copiedDecryptedPatientCabsList.get(i).description = crypto.decrypt(patientCabsList.get(i).description);
                copiedDecryptedPatientCabsList.get(i).createdAt = crypto.decrypt(patientCabsList.get(i).createdAt);
                copiedDecryptedPatientCabsList.get(i).updatedAt = crypto.decrypt(patientCabsList.get(i).updatedAt);
                copiedDecryptedPatientCabsList.get(i).type = crypto.decrypt(patientCabsList.get(i).type);

                copiedDecryptedPatientCabsList.get(i).properties.cabsKind = crypto.decrypt(patientCabsList.get(i).properties.cabsKind);
                copiedDecryptedPatientCabsList.get(i).properties.age = crypto.decrypt(patientCabsList.get(i).properties.age);
                copiedDecryptedPatientCabsList.get(i).properties.sex = crypto.decrypt(patientCabsList.get(i).properties.sex);
                copiedDecryptedPatientCabsList.get(i).properties.BMI = crypto.decrypt(patientCabsList.get(i).properties.BMI);
                copiedDecryptedPatientCabsList.get(i).properties.syntaxScore = crypto.decrypt(patientCabsList.get(i).properties.syntaxScore);
                copiedDecryptedPatientCabsList.get(i).properties.arterialHypertension = crypto.decrypt(patientCabsList.get(i).properties.arterialHypertension);
                copiedDecryptedPatientCabsList.get(i).properties.diabetes = crypto.decrypt(patientCabsList.get(i).properties.diabetes);
                copiedDecryptedPatientCabsList.get(i).properties.obesity = crypto.decrypt(patientCabsList.get(i).properties.obesity);
                copiedDecryptedPatientCabsList.get(i).properties.smoking = crypto.decrypt(patientCabsList.get(i).properties.smoking);
                copiedDecryptedPatientCabsList.get(i).properties.heredity = crypto.decrypt(patientCabsList.get(i).properties.heredity);
                copiedDecryptedPatientCabsList.get(i).properties.dyslipidemia = crypto.decrypt(patientCabsList.get(i).properties.dyslipidemia);
                copiedDecryptedPatientCabsList.get(i).properties.asthma = crypto.decrypt(patientCabsList.get(i).properties.asthma);
                copiedDecryptedPatientCabsList.get(i).properties.postinfarctionCardiosclerosis = crypto.decrypt(patientCabsList.get(i).properties.postinfarctionCardiosclerosis);
                copiedDecryptedPatientCabsList.get(i).properties.atrialFibrillation = crypto.decrypt(patientCabsList.get(i).properties.atrialFibrillation);
                copiedDecryptedPatientCabsList.get(i).properties.chronicRenalInsufficiency = crypto.decrypt(patientCabsList.get(i).properties.chronicRenalInsufficiency);
                copiedDecryptedPatientCabsList.get(i).properties.pepticUlcer = crypto.decrypt(patientCabsList.get(i).properties.pepticUlcer);
                copiedDecryptedPatientCabsList.get(i).properties.thyroidDisorders = crypto.decrypt(patientCabsList.get(i).properties.thyroidDisorders);
                copiedDecryptedPatientCabsList.get(i).properties.varicoseVein = crypto.decrypt(patientCabsList.get(i).properties.varicoseVein);
                copiedDecryptedPatientCabsList.get(i).properties.insult = crypto.decrypt(patientCabsList.get(i).properties.insult);
                copiedDecryptedPatientCabsList.get(i).properties.angiotensinInhibitors = crypto.decrypt(patientCabsList.get(i).properties.angiotensinInhibitors);
                copiedDecryptedPatientCabsList.get(i).properties.lowerLimbIschemia = crypto.decrypt(patientCabsList.get(i).properties.lowerLimbIschemia);
                copiedDecryptedPatientCabsList.get(i).properties.anginaFuncClass = crypto.decrypt(patientCabsList.get(i).properties.anginaFuncClass);
                copiedDecryptedPatientCabsList.get(i).properties.chronicHeartFailureFuncClass = crypto.decrypt(patientCabsList.get(i).properties.chronicHeartFailureFuncClass);
                copiedDecryptedPatientCabsList.get(i).properties.leftVentricularEjectionFraction = crypto.decrypt(patientCabsList.get(i).properties.leftVentricularEjectionFraction);
                copiedDecryptedPatientCabsList.get(i).properties.interventricularSeptum = crypto.decrypt(patientCabsList.get(i).properties.interventricularSeptum);
                copiedDecryptedPatientCabsList.get(i).properties.euroScoreII = crypto.decrypt(patientCabsList.get(i).properties.euroScoreII);
                copiedDecryptedPatientCabsList.get(i).properties.artificialCirculation = crypto.decrypt(patientCabsList.get(i).properties.artificialCirculation);
                copiedDecryptedPatientCabsList.get(i).properties.artificialCirculationTime = crypto.decrypt(patientCabsList.get(i).properties.artificialCirculationTime);
                copiedDecryptedPatientCabsList.get(i).properties.aorticConstrictionTime = crypto.decrypt(patientCabsList.get(i).properties.aorticConstrictionTime);
                copiedDecryptedPatientCabsList.get(i).properties.bodyTemperature = crypto.decrypt(patientCabsList.get(i).properties.bodyTemperature);
                copiedDecryptedPatientCabsList.get(i).properties.cardioplegiaNumber = crypto.decrypt(patientCabsList.get(i).properties.cardioplegiaNumber);
                copiedDecryptedPatientCabsList.get(i).properties.ventriculoplastLV = crypto.decrypt(patientCabsList.get(i).properties.ventriculoplastLV);
                copiedDecryptedPatientCabsList.get(i).properties.revascularizationIdx = crypto.decrypt(patientCabsList.get(i).properties.revascularizationIdx);
                copiedDecryptedPatientCabsList.get(i).properties.yCoronaryBypass = crypto.decrypt(patientCabsList.get(i).properties.yCoronaryBypass);
                copiedDecryptedPatientCabsList.get(i).properties.litaDischarge = crypto.decrypt(patientCabsList.get(i).properties.litaDischarge);
                copiedDecryptedPatientCabsList.get(i).properties.ritaDischarge = crypto.decrypt(patientCabsList.get(i).properties.ritaDischarge);
                copiedDecryptedPatientCabsList.get(i).properties.radialArteryUsage = crypto.decrypt(patientCabsList.get(i).properties.radialArteryUsage);
                copiedDecryptedPatientCabsList.get(i).properties.poplitealArteryUsage = crypto.decrypt(patientCabsList.get(i).properties.poplitealArteryUsage);
                copiedDecryptedPatientCabsList.get(i).properties.bloodLoss = crypto.decrypt(patientCabsList.get(i).properties.bloodLoss);
                copiedDecryptedPatientCabsList.get(i).properties.artificialVentTime = crypto.decrypt(patientCabsList.get(i).properties.artificialVentTime);
                copiedDecryptedPatientCabsList.get(i).properties.inotropicSupport = crypto.decrypt(patientCabsList.get(i).properties.inotropicSupport);
                copiedDecryptedPatientCabsList.get(i).properties.pneumonia = crypto.decrypt(patientCabsList.get(i).properties.pneumonia);
                copiedDecryptedPatientCabsList.get(i).properties.heartFailure = crypto.decrypt(patientCabsList.get(i).properties.heartFailure);
                copiedDecryptedPatientCabsList.get(i).properties.reanimationAtrialFibrillation = crypto.decrypt(patientCabsList.get(i).properties.reanimationAtrialFibrillation);
                copiedDecryptedPatientCabsList.get(i).properties.pleuralEffusion = crypto.decrypt(patientCabsList.get(i).properties.pleuralEffusion);
                copiedDecryptedPatientCabsList.get(i).properties.hydropericardium = crypto.decrypt(patientCabsList.get(i).properties.hydropericardium);
                copiedDecryptedPatientCabsList.get(i).properties.pneumothorax = crypto.decrypt(patientCabsList.get(i).properties.pneumothorax);
                copiedDecryptedPatientCabsList.get(i).properties.sternalComplications = crypto.decrypt(patientCabsList.get(i).properties.sternalComplications);
                copiedDecryptedPatientCabsList.get(i).properties.postCalciumChannelAntagonists = crypto.decrypt(patientCabsList.get(i).properties.postCalciumChannelAntagonists);
                copiedDecryptedPatientCabsList.get(i).properties.postAngiotensinInhibitors = crypto.decrypt(patientCabsList.get(i).properties.postAngiotensinInhibitors);
                copiedDecryptedPatientCabsList.get(i).properties.spironolactone = crypto.decrypt(patientCabsList.get(i).properties.spironolactone);
                copiedDecryptedPatientCabsList.get(i).properties.postDiuretics = crypto.decrypt(patientCabsList.get(i).properties.postDiuretics);
                copiedDecryptedPatientCabsList.get(i).properties.cordarone = crypto.decrypt(patientCabsList.get(i).properties.cordarone);
                copiedDecryptedPatientCabsList.get(i).properties.hospitalizationDuration = crypto.decrypt(patientCabsList.get(i).properties.hospitalizationDuration);
                copiedDecryptedPatientCabsList.get(i).properties.carotidEndarterectomy = crypto.decrypt(patientCabsList.get(i).properties.carotidEndarterectomy);
                copiedDecryptedPatientCabsList.get(i).properties.lowerLimbSurgery = crypto.decrypt(patientCabsList.get(i).properties.lowerLimbSurgery);
                copiedDecryptedPatientCabsList.get(i).properties.antiaggregants = crypto.decrypt(patientCabsList.get(i).properties.antiaggregants);
                copiedDecryptedPatientCabsList.get(i).properties.anticoagulants = crypto.decrypt(patientCabsList.get(i).properties.anticoagulants);
                copiedDecryptedPatientCabsList.get(i).properties.betaAB = crypto.decrypt(patientCabsList.get(i).properties.betaAB);
                copiedDecryptedPatientCabsList.get(i).properties.angiotensinAntagonists = crypto.decrypt(patientCabsList.get(i).properties.angiotensinAntagonists);
                copiedDecryptedPatientCabsList.get(i).properties.statins = crypto.decrypt(patientCabsList.get(i).properties.statins);
                copiedDecryptedPatientCabsList.get(i).properties.MI = crypto.decrypt(patientCabsList.get(i).properties.MI);
                copiedDecryptedPatientCabsList.get(i).properties.CI = crypto.decrypt(patientCabsList.get(i).properties.CI);
                copiedDecryptedPatientCabsList.get(i).properties.insultOutcome = crypto.decrypt(patientCabsList.get(i).properties.insultOutcome);
                copiedDecryptedPatientCabsList.get(i).properties.death = crypto.decrypt(patientCabsList.get(i).properties.death);
                copiedDecryptedPatientCabsList.get(i).properties.comb = crypto.decrypt(patientCabsList.get(i).properties.comb);
            }
            return copiedDecryptedPatientCabsList;
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
