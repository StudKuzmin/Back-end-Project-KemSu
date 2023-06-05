package classes.model.modelRequests;

import classes.database.dbservice.IDBservice;
import classes.database.entity.patient.*;
import classes.model.modelLogic.IModelLogic;
import classes.model.modelRequests.interfaces.IPatientsModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class PatientsModel implements IPatientsModel {
    @Inject
    IDBservice dbservice;
    @Inject
    IModelLogic modelLogic;

    public List<EPatientPage> getPatientList(String userid, String type) throws Exception{

        try {
            // Достаём из БД данные ковида
            List<EPatientCovid> encryptedPatientCovidList = dbservice.selectPatientsCovid();
            // Расшифровка данных с БД ковида
            List<EPatientCovid> decryptedPatientCovidList = modelLogic.getDecryptedPatientCovidList(encryptedPatientCovidList);

            // Достаём из БД данные шунтирования
            List<EPatientCabs> encryptedPatientCabsList = dbservice.selectPatientsCabs();
            // Расшифровка данных с БД шунтирования
            List<EPatientCabs> decryptedPatientCabsList = modelLogic.getDecryptedPatientCabsList(encryptedPatientCabsList);

            List<EPatientCovidPARSE> list1 = new ArrayList<>();
            for(int i = 0; i < decryptedPatientCovidList.size(); i++){
                EPatientCovidPARSE ePatientCovidPARSE = new EPatientCovidPARSE();
                ePatientCovidPARSE.properties = new EPatientCovidPropertiesPARSE();
                list1.add(ePatientCovidPARSE);
                list1.get(i).id = decryptedPatientCovidList.get(i).id == null? 0 : Integer.parseInt(decryptedPatientCovidList.get(i).id);
                list1.get(i).description = decryptedPatientCovidList.get(i).description;
                list1.get(i).type = decryptedPatientCovidList.get(i).type;
                list1.get(i).createdAt = decryptedPatientCovidList.get(i).createdAt == null? 0 : Integer.parseInt(decryptedPatientCovidList.get(i).createdAt);
                list1.get(i).updatedAt = decryptedPatientCovidList.get(i).updatedAt == null? 0 : Integer.parseInt(decryptedPatientCovidList.get(i).updatedAt);

                list1.get(i).properties.age = decryptedPatientCovidList.get(i).properties.age == null? 0 : Integer.parseInt(decryptedPatientCovidList.get(i).properties.age);
                list1.get(i).properties.sex = decryptedPatientCovidList.get(i).properties.sex;
                list1.get(i).properties.urea = decryptedPatientCovidList.get(i).properties.urea == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.urea);
                list1.get(i).properties.creatinine = decryptedPatientCovidList.get(i).properties.creatinine == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.creatinine);
                list1.get(i).properties.SKF = decryptedPatientCovidList.get(i).properties.SKF == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.SKF);
                list1.get(i).properties.AST = decryptedPatientCovidList.get(i).properties.AST == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.AST);
                list1.get(i).properties.ALT = decryptedPatientCovidList.get(i).properties.ALT == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.ALT);
                list1.get(i).properties.CRP = decryptedPatientCovidList.get(i).properties.CRP == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.CRP);
                list1.get(i).properties.glucose = decryptedPatientCovidList.get(i).properties.glucose == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.glucose);
                list1.get(i).properties.leukocytes = decryptedPatientCovidList.get(i).properties.leukocytes == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.leukocytes);
                list1.get(i).properties.platelets = decryptedPatientCovidList.get(i).properties.platelets == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.platelets);
                list1.get(i).properties.neutrophils = decryptedPatientCovidList.get(i).properties.neutrophils == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.neutrophils);
                list1.get(i).properties.lymphocytes = decryptedPatientCovidList.get(i).properties.lymphocytes == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.lymphocytes);
                list1.get(i).properties.neutrophilLymphocyteRatio = decryptedPatientCovidList.get(i).properties.neutrophilLymphocyteRatio == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.neutrophilLymphocyteRatio);
                list1.get(i).properties.severity = decryptedPatientCovidList.get(i).properties.severity;
                list1.get(i).properties.DDimer = decryptedPatientCovidList.get(i).properties.DDimer == null? 0.0 : Double.parseDouble(decryptedPatientCovidList.get(i).properties.DDimer);
                list1.get(i).properties.AG = decryptedPatientCovidList.get(i).properties.AG == null? false : Boolean.parseBoolean(decryptedPatientCovidList.get(i).properties.AG);
                list1.get(i).properties.SD = decryptedPatientCovidList.get(i).properties.SD == null? false : Boolean.parseBoolean(decryptedPatientCovidList.get(i).properties.SD);
                list1.get(i).properties.IBS = decryptedPatientCovidList.get(i).properties.IBS == null? false : Boolean.parseBoolean(decryptedPatientCovidList.get(i).properties.IBS);
                list1.get(i).properties.HOBL = decryptedPatientCovidList.get(i).properties.HOBL == null? false : Boolean.parseBoolean(decryptedPatientCovidList.get(i).properties.HOBL);
                list1.get(i).properties.HBP = decryptedPatientCovidList.get(i).properties.HBP == null? false : Boolean.parseBoolean(decryptedPatientCovidList.get(i).properties.HBP);
            }

            List<EPatientCabsPARSE> list2 = new ArrayList<>();
            for(int i = 0; i < decryptedPatientCabsList.size(); i++){
                EPatientCabsPARSE ePatientCabsPARSE = new EPatientCabsPARSE();
                ePatientCabsPARSE.properties = new EPatientCabsPropertiesPARSE();
                list2.add(ePatientCabsPARSE);

                list2.get(i).id = decryptedPatientCabsList.get(i).id == null? 0 : Integer.parseInt(decryptedPatientCabsList.get(i).id);
                list2.get(i).description = decryptedPatientCabsList.get(i).description;
                list2.get(i).type = decryptedPatientCabsList.get(i).type;
                list2.get(i).createdAt = decryptedPatientCabsList.get(i).createdAt == null? 0 : Integer.parseInt(decryptedPatientCabsList.get(i).createdAt);
                list2.get(i).updatedAt = decryptedPatientCabsList.get(i).updatedAt == null? 0 : Integer.parseInt(decryptedPatientCabsList.get(i).updatedAt);

                list2.get(i).properties.cabsKind = decryptedPatientCabsList.get(i).properties.cabsKind == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.cabsKind);
                list2.get(i).properties.age = decryptedPatientCabsList.get(i).properties.age == null? 0 : Integer.parseInt(decryptedPatientCabsList.get(i).properties.age);
                list2.get(i).properties.sex = decryptedPatientCabsList.get(i).properties.sex;
                list2.get(i).properties.BMI = decryptedPatientCabsList.get(i).properties.BMI == null? 0.0 : Double.parseDouble(decryptedPatientCabsList.get(i).properties.BMI);
                list2.get(i).properties.syntaxScore = decryptedPatientCabsList.get(i).properties.syntaxScore == null? 0.0 : Double.parseDouble(decryptedPatientCabsList.get(i).properties.syntaxScore);
                list2.get(i).properties.arterialHypertension = decryptedPatientCabsList.get(i).properties.arterialHypertension == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.arterialHypertension);
                list2.get(i).properties.diabetes = decryptedPatientCabsList.get(i).properties.diabetes == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.diabetes);
                list2.get(i).properties.obesity = decryptedPatientCabsList.get(i).properties.obesity == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.obesity);
                list2.get(i).properties.smoking = decryptedPatientCabsList.get(i).properties.smoking == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.smoking);
                list2.get(i).properties.heredity = decryptedPatientCabsList.get(i).properties.heredity == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.heredity);
                list2.get(i).properties.dyslipidemia = decryptedPatientCabsList.get(i).properties.dyslipidemia == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.dyslipidemia);
                list2.get(i).properties.asthma = decryptedPatientCabsList.get(i).properties.asthma == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.asthma);
                list2.get(i).properties.postinfarctionCardiosclerosis = decryptedPatientCabsList.get(i).properties.postinfarctionCardiosclerosis == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.postinfarctionCardiosclerosis);
                list2.get(i).properties.atrialFibrillation = decryptedPatientCabsList.get(i).properties.atrialFibrillation == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.atrialFibrillation);
                list2.get(i).properties.chronicRenalInsufficiency = decryptedPatientCabsList.get(i).properties.chronicRenalInsufficiency == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.chronicRenalInsufficiency);
                list2.get(i).properties.pepticUlcer = decryptedPatientCabsList.get(i).properties.pepticUlcer == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.pepticUlcer);
                list2.get(i).properties.thyroidDisorders = decryptedPatientCabsList.get(i).properties.thyroidDisorders == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.thyroidDisorders);
                list2.get(i).properties.varicoseVein = decryptedPatientCabsList.get(i).properties.varicoseVein == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.varicoseVein);
                list2.get(i).properties.insult = decryptedPatientCabsList.get(i).properties.insult == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.insult);
                list2.get(i).properties.lowerLimbIschemia = decryptedPatientCabsList.get(i).properties.lowerLimbIschemia == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.lowerLimbIschemia);
                list2.get(i).properties.anginaFuncClass = decryptedPatientCabsList.get(i).properties.anginaFuncClass;
                list2.get(i).properties.chronicHeartFailureFuncClass = decryptedPatientCabsList.get(i).properties.chronicHeartFailureFuncClass;
                list2.get(i).properties.leftVentricularEjectionFraction = decryptedPatientCabsList.get(i).properties.leftVentricularEjectionFraction == null? 0 : Integer.parseInt(decryptedPatientCabsList.get(i).properties.leftVentricularEjectionFraction);
                list2.get(i).properties.interventricularSeptum = decryptedPatientCabsList.get(i).properties.interventricularSeptum == null? 0.0 : Double.parseDouble(decryptedPatientCabsList.get(i).properties.interventricularSeptum);
                list2.get(i).properties.euroScoreII = decryptedPatientCabsList.get(i).properties.euroScoreII == null? 0.0 : Double.parseDouble(decryptedPatientCabsList.get(i).properties.euroScoreII);
                list2.get(i).properties.artificialCirculation = decryptedPatientCabsList.get(i).properties.artificialCirculation == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.artificialCirculation);
                list2.get(i).properties.artificialCirculationTime = decryptedPatientCabsList.get(i).properties.artificialCirculationTime == null? 0 : Integer.parseInt(decryptedPatientCabsList.get(i).properties.artificialCirculationTime);
                list2.get(i).properties.aorticConstrictionTime = decryptedPatientCabsList.get(i).properties.aorticConstrictionTime == null? 0 : Integer.parseInt(decryptedPatientCabsList.get(i).properties.aorticConstrictionTime);
                list2.get(i).properties.bodyTemperature = decryptedPatientCabsList.get(i).properties.bodyTemperature == null? 0.0 : Double.parseDouble(decryptedPatientCabsList.get(i).properties.bodyTemperature);
                list2.get(i).properties.cardioplegiaNumber = decryptedPatientCabsList.get(i).properties.cardioplegiaNumber;
                list2.get(i).properties.ventriculoplastLV = decryptedPatientCabsList.get(i).properties.ventriculoplastLV == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.ventriculoplastLV);
                list2.get(i).properties.revascularizationIdx = decryptedPatientCabsList.get(i).properties.revascularizationIdx;
                list2.get(i).properties.yCoronaryBypass = decryptedPatientCabsList.get(i).properties.yCoronaryBypass == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.yCoronaryBypass);
                list2.get(i).properties.litaDischarge = decryptedPatientCabsList.get(i).properties.litaDischarge;
                list2.get(i).properties.ritaDischarge = decryptedPatientCabsList.get(i).properties.ritaDischarge;
                list2.get(i).properties.radialArteryUsage = decryptedPatientCabsList.get(i).properties.radialArteryUsage == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.radialArteryUsage);
                list2.get(i).properties.poplitealArteryUsage = decryptedPatientCabsList.get(i).properties.poplitealArteryUsage == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.poplitealArteryUsage);
                list2.get(i).properties.bloodLoss = decryptedPatientCabsList.get(i).properties.bloodLoss == null? 0 : Integer.parseInt(decryptedPatientCabsList.get(i).properties.bloodLoss);
                list2.get(i).properties.artificialVentTime = decryptedPatientCabsList.get(i).properties.artificialVentTime == null? 0 : Integer.parseInt(decryptedPatientCabsList.get(i).properties.artificialVentTime);
                list2.get(i).properties.inotropicSupport = decryptedPatientCabsList.get(i).properties.inotropicSupport == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.inotropicSupport);
                list2.get(i).properties.pneumonia = decryptedPatientCabsList.get(i).properties.pneumonia == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.pneumonia);
                list2.get(i).properties.heartFailure = decryptedPatientCabsList.get(i).properties.heartFailure == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.heartFailure);
                list2.get(i).properties.reanimationAtrialFibrillation = decryptedPatientCabsList.get(i).properties.reanimationAtrialFibrillation == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.reanimationAtrialFibrillation);
                list2.get(i).properties.pleuralEffusion = decryptedPatientCabsList.get(i).properties.pleuralEffusion == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.pleuralEffusion);
                list2.get(i).properties.hydropericardium = decryptedPatientCabsList.get(i).properties.hydropericardium == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.hydropericardium);
                list2.get(i).properties.pneumothorax = decryptedPatientCabsList.get(i).properties.pneumothorax == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.pneumothorax);
                list2.get(i).properties.sternalComplications = decryptedPatientCabsList.get(i).properties.sternalComplications == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.sternalComplications);
                list2.get(i).properties.postCalciumChannelAntagonists = decryptedPatientCabsList.get(i).properties.postCalciumChannelAntagonists == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.postCalciumChannelAntagonists);
                list2.get(i).properties.postAngiotensinInhibitors = decryptedPatientCabsList.get(i).properties.postAngiotensinInhibitors == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.postAngiotensinInhibitors);
                list2.get(i).properties.spironolactone = decryptedPatientCabsList.get(i).properties.spironolactone == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.spironolactone);
                list2.get(i).properties.postDiuretics = decryptedPatientCabsList.get(i).properties.postDiuretics == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.postDiuretics);
                list2.get(i).properties.cordarone = decryptedPatientCabsList.get(i).properties.cordarone == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.cordarone);
                list2.get(i).properties.hospitalizationDuration = decryptedPatientCabsList.get(i).properties.hospitalizationDuration == null? 0 : Integer.parseInt(decryptedPatientCabsList.get(i).properties.hospitalizationDuration);
                list2.get(i).properties.carotidEndarterectomy = decryptedPatientCabsList.get(i).properties.carotidEndarterectomy == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.carotidEndarterectomy);
                list2.get(i).properties.lowerLimbSurgery = decryptedPatientCabsList.get(i).properties.lowerLimbSurgery == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.lowerLimbSurgery);
                list2.get(i).properties.antiaggregants = decryptedPatientCabsList.get(i).properties.antiaggregants == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.antiaggregants);
                list2.get(i).properties.anticoagulants = decryptedPatientCabsList.get(i).properties.anticoagulants == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.anticoagulants);
                list2.get(i).properties.betaAB = decryptedPatientCabsList.get(i).properties.betaAB == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.betaAB);
                list2.get(i).properties.angiotensinAntagonists = decryptedPatientCabsList.get(i).properties.angiotensinAntagonists == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.angiotensinAntagonists);
                list2.get(i).properties.statins = decryptedPatientCabsList.get(i).properties.statins == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.statins);
                list2.get(i).properties.MI = decryptedPatientCabsList.get(i).properties.MI == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.MI);
                list2.get(i).properties.CI = decryptedPatientCabsList.get(i).properties.CI == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.CI);
                list2.get(i).properties.insultOutcome = decryptedPatientCabsList.get(i).properties.insultOutcome == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.insultOutcome);
                list2.get(i).properties.death = decryptedPatientCabsList.get(i).properties.death == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.death);
                list2.get(i).properties.comb = decryptedPatientCabsList.get(i).properties.comb == null? false : Boolean.parseBoolean(decryptedPatientCabsList.get(i).properties.comb);
            }

            List<EPatientCovid> newDecryptedPatientCovidList = new ArrayList<>();
            for (EPatientCovid e : decryptedPatientCovidList){
                if(e.userid.equals(userid)){
                    newDecryptedPatientCovidList.add(e);
                }
            }
            List<EPatientCabs> newDecryptedPatientCabsList = new ArrayList<>();
            for (EPatientCabs e : decryptedPatientCabsList){
                if(e.userid.equals(userid)){
                    newDecryptedPatientCabsList.add(e);
                }
            }


            ObjectMapper objectMapper = new ObjectMapper();
            List<EPatientPage> patientList = new ArrayList<>();

            EPatientPage ePatientPage = new EPatientPage();
            if (type.equals("covid"))
                ePatientPage.contents.addAll(objectMapper.convertValue(list1, List.class));
            if (type.equals("cabs"))
                ePatientPage.contents.addAll(objectMapper.convertValue(list2, List.class));
            patientList.add(ePatientPage);


//            patientList.add(new EPatientPage());
//            for(int i = 0; i < decryptedPatientCovidList.size(); i++){
//                patientList.get(0).contents.add(objectMapper.convertValue(decryptedPatientCovidList.get(i), Map.class));
//                patientList.get(0).numberOfElements = i+1;
//            }
//            patientList.get(0).page = 1;


            // TODO Лучше возвращать List<Map<String, String>>. Ошибка каста в List<Map<String, String>>, посмотреть
            return patientList;
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select");
        }
    }

    public EPatientCovid createPatientCovid(EPatientCovid ePatientCovid) throws Exception{
        long startTime = System.nanoTime();
        try {
            // Получаем текущее время по МСК
            long milliseconds = System.currentTimeMillis();

            // Преобразование миллисекунд в секунды
            long seconds = milliseconds / 1000;

            // Закидываем текущее время в поле
            ePatientCovid.createdAt = String.valueOf(seconds);

            // Шифруем данные
            EPatientCovid encryptedPatientCovid = modelLogic.getEncryptedPatientCovid(ePatientCovid);

            // Добавляем шифрованные данные в БД
            boolean inserted = dbservice.insert(encryptedPatientCovid);

            if(inserted){
                ePatientCovid.description = "TODAY";
                long endTime = System.nanoTime();
                double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
                return ePatientCovid;
            }
            throw new Exception("no instert");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("no insterted");
        }
    }

    public EPatientCabs createPatientCabs(EPatientCabs ePatientCabs) throws Exception{
        long startTime = System.nanoTime();
        try {
            long milliseconds = System.currentTimeMillis();

            // Преобразование миллисекунд в секунды
            long seconds = milliseconds / 1000;

            // Закидываем текущее время в поле
            ePatientCabs.createdAt = String.valueOf(seconds);

            // Шифруем данные
            EPatientCabs encryptedPatientCabs = modelLogic.getEncryptedPatientCabs(ePatientCabs);

            // Добавляем шифрованные данные в БД
            boolean inserted = dbservice.insert(encryptedPatientCabs);

            if(inserted){
                ePatientCabs.description = "TODAY";
                long endTime = System.nanoTime();
                double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
                return ePatientCabs;
            }
            throw new Exception("no insterted");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("no instert");
        }
    }
    public Map<String, String> getOnePatient(String patientId, String userid) throws Exception{
        long startTime = System.nanoTime();
        try {
            // Достаём из БД данные ковида
            List<EPatientCovid> encryptedPatientCovidList = dbservice.selectPatientsCovid();
            // Расшифровка данных с БД ковида
            List<EPatientCovid> decryptedPatientCovidList = modelLogic.getDecryptedPatientCovidList(encryptedPatientCovidList);

            // Достаём из БД данные шунтирования
            List<EPatientCabs> encryptedPatientCabsList = dbservice.selectPatientsCabs();
            // Расшифровка данных с БД шунтирования
            List<EPatientCabs> decryptedPatientCabsList = modelLogic.getDecryptedPatientCabsList(encryptedPatientCabsList);


            ObjectMapper objectMapper = new ObjectMapper();
            for(EPatientCovid ePatientCovid : decryptedPatientCovidList){
                if (patientId.equals(ePatientCovid.id) && ePatientCovid.userid.equals(userid)){
                    EPatientCovidPARSE ePatientCovidPARSE = new EPatientCovidPARSE();
                    ePatientCovidPARSE.properties = new EPatientCovidPropertiesPARSE();

                    ePatientCovidPARSE.id = ePatientCovid.id == null? 0 : Integer.parseInt(ePatientCovid.id);
                    ePatientCovidPARSE.description =ePatientCovid.description;
                    ePatientCovidPARSE.type = ePatientCovid.type;
                    ePatientCovidPARSE.createdAt = ePatientCovid.createdAt == null? 0 : Integer.parseInt(ePatientCovid.createdAt);
                    ePatientCovidPARSE.updatedAt = ePatientCovid.updatedAt == null? 0 : Integer.parseInt(ePatientCovid.updatedAt);

                    ePatientCovidPARSE.properties.age = ePatientCovid.properties.age == null? 0 : Integer.parseInt(ePatientCovid.properties.age);
                    ePatientCovidPARSE.properties.sex = ePatientCovid.properties.sex;
                    ePatientCovidPARSE.properties.urea = ePatientCovid.properties.urea == null? 0.0 : Double.parseDouble(ePatientCovid.properties.urea);
                    ePatientCovidPARSE.properties.creatinine = ePatientCovid.properties.creatinine == null? 0.0 : Double.parseDouble(ePatientCovid.properties.creatinine);
                    ePatientCovidPARSE.properties.SKF = ePatientCovid.properties.SKF == null? 0.0 : Double.parseDouble(ePatientCovid.properties.SKF);
                    ePatientCovidPARSE.properties.AST = ePatientCovid.properties.AST == null? 0.0 : Double.parseDouble(ePatientCovid.properties.AST);
                    ePatientCovidPARSE.properties.ALT = ePatientCovid.properties.ALT == null? 0.0 : Double.parseDouble(ePatientCovid.properties.ALT);
                    ePatientCovidPARSE.properties.CRP = ePatientCovid.properties.CRP == null? 0.0 : Double.parseDouble(ePatientCovid.properties.CRP);
                    ePatientCovidPARSE.properties.glucose = ePatientCovid.properties.glucose == null? 0.0 : Double.parseDouble(ePatientCovid.properties.glucose);
                    ePatientCovidPARSE.properties.leukocytes = ePatientCovid.properties.leukocytes == null? 0.0 : Double.parseDouble(ePatientCovid.properties.leukocytes);
                    ePatientCovidPARSE.properties.platelets = ePatientCovid.properties.platelets == null? 0.0 : Double.parseDouble(ePatientCovid.properties.platelets);
                    ePatientCovidPARSE.properties.neutrophils = ePatientCovid.properties.neutrophils == null? 0.0 : Double.parseDouble(ePatientCovid.properties.neutrophils);
                    ePatientCovidPARSE.properties.lymphocytes = ePatientCovid.properties.lymphocytes == null? 0.0 : Double.parseDouble(ePatientCovid.properties.lymphocytes);
                    ePatientCovidPARSE.properties.neutrophilLymphocyteRatio = ePatientCovid.properties.neutrophilLymphocyteRatio == null? 0.0 : Double.parseDouble(ePatientCovid.properties.neutrophilLymphocyteRatio);
                    ePatientCovidPARSE.properties.severity = ePatientCovid.properties.severity;
                    ePatientCovidPARSE.properties.DDimer = ePatientCovid.properties.DDimer == null? 0.0 : Double.parseDouble(ePatientCovid.properties.DDimer);
                    ePatientCovidPARSE.properties.AG = ePatientCovid.properties.AG == null? false : Boolean.parseBoolean(ePatientCovid.properties.AG);
                    ePatientCovidPARSE.properties.SD = ePatientCovid.properties.SD == null? false : Boolean.parseBoolean(ePatientCovid.properties.SD);
                    ePatientCovidPARSE.properties.IBS = ePatientCovid.properties.IBS == null? false : Boolean.parseBoolean(ePatientCovid.properties.IBS);
                    ePatientCovidPARSE.properties.HOBL = ePatientCovid.properties.HOBL == null? false : Boolean.parseBoolean(ePatientCovid.properties.HOBL);
                    ePatientCovidPARSE.properties.HBP = ePatientCovid.properties.HBP == null? false : Boolean.parseBoolean(ePatientCovid.properties.HBP);
                    return objectMapper.convertValue(ePatientCovidPARSE, Map.class);
                }
            }
            for(EPatientCabs ePatientCabs : decryptedPatientCabsList){
                if (patientId.equals(ePatientCabs.id) && ePatientCabs.userid.equals(userid)){
                    EPatientCabsPARSE ePatientCabsPARSE = new EPatientCabsPARSE();
                    ePatientCabsPARSE.properties = new EPatientCabsPropertiesPARSE();

                    ePatientCabsPARSE.id = ePatientCabs.id == null? 0 : Integer.parseInt(ePatientCabs.id);
                    ePatientCabsPARSE.description = ePatientCabs.description;
                    ePatientCabsPARSE.type = ePatientCabs.type;
                    ePatientCabsPARSE.createdAt = ePatientCabs.createdAt == null? 0 : Integer.parseInt(ePatientCabs.createdAt);
                    ePatientCabsPARSE.updatedAt = ePatientCabs.updatedAt == null? 0 : Integer.parseInt(ePatientCabs.updatedAt);

                    ePatientCabsPARSE.properties.cabsKind = ePatientCabs.properties.cabsKind == null? false : Boolean.parseBoolean(ePatientCabs.properties.cabsKind);
                    ePatientCabsPARSE.properties.age = ePatientCabs.properties.age == null? 0 : Integer.parseInt(ePatientCabs.properties.age);
                    ePatientCabsPARSE.properties.sex = ePatientCabs.properties.sex;
                    ePatientCabsPARSE.properties.BMI = ePatientCabs.properties.BMI == null? 0.0 : Double.parseDouble(ePatientCabs.properties.BMI);
                    ePatientCabsPARSE.properties.syntaxScore = ePatientCabs.properties.syntaxScore == null? 0.0 : Double.parseDouble(ePatientCabs.properties.syntaxScore);
                    ePatientCabsPARSE.properties.arterialHypertension = ePatientCabs.properties.arterialHypertension == null? false : Boolean.parseBoolean(ePatientCabs.properties.arterialHypertension);
                    ePatientCabsPARSE.properties.diabetes = ePatientCabs.properties.diabetes == null? false : Boolean.parseBoolean(ePatientCabs.properties.diabetes);
                    ePatientCabsPARSE.properties.obesity = ePatientCabs.properties.obesity == null? false : Boolean.parseBoolean(ePatientCabs.properties.obesity);
                    ePatientCabsPARSE.properties.smoking = ePatientCabs.properties.smoking == null? false : Boolean.parseBoolean(ePatientCabs.properties.smoking);
                    ePatientCabsPARSE.properties.heredity = ePatientCabs.properties.heredity == null? false : Boolean.parseBoolean(ePatientCabs.properties.heredity);
                    ePatientCabsPARSE.properties.dyslipidemia = ePatientCabs.properties.dyslipidemia == null? false : Boolean.parseBoolean(ePatientCabs.properties.dyslipidemia);
                    ePatientCabsPARSE.properties.asthma = ePatientCabs.properties.asthma == null? false : Boolean.parseBoolean(ePatientCabs.properties.asthma);
                    ePatientCabsPARSE.properties.postinfarctionCardiosclerosis = ePatientCabs.properties.postinfarctionCardiosclerosis == null? false : Boolean.parseBoolean(ePatientCabs.properties.postinfarctionCardiosclerosis);
                    ePatientCabsPARSE.properties.atrialFibrillation = ePatientCabs.properties.atrialFibrillation == null? false : Boolean.parseBoolean(ePatientCabs.properties.atrialFibrillation);
                    ePatientCabsPARSE.properties.chronicRenalInsufficiency = ePatientCabs.properties.chronicRenalInsufficiency == null? false : Boolean.parseBoolean(ePatientCabs.properties.chronicRenalInsufficiency);
                    ePatientCabsPARSE.properties.pepticUlcer = ePatientCabs.properties.pepticUlcer == null? false : Boolean.parseBoolean(ePatientCabs.properties.pepticUlcer);
                    ePatientCabsPARSE.properties.thyroidDisorders = ePatientCabs.properties.thyroidDisorders == null? false : Boolean.parseBoolean(ePatientCabs.properties.thyroidDisorders);
                    ePatientCabsPARSE.properties.varicoseVein = ePatientCabs.properties.varicoseVein == null? false : Boolean.parseBoolean(ePatientCabs.properties.varicoseVein);
                    ePatientCabsPARSE.properties.insult = ePatientCabs.properties.insult == null? false : Boolean.parseBoolean(ePatientCabs.properties.insult);
                    ePatientCabsPARSE.properties.lowerLimbIschemia = ePatientCabs.properties.lowerLimbIschemia == null? false : Boolean.parseBoolean(ePatientCabs.properties.lowerLimbIschemia);
                    ePatientCabsPARSE.properties.anginaFuncClass = ePatientCabs.properties.anginaFuncClass;
                    ePatientCabsPARSE.properties.chronicHeartFailureFuncClass = ePatientCabs.properties.chronicHeartFailureFuncClass;
                    ePatientCabsPARSE.properties.leftVentricularEjectionFraction = ePatientCabs.properties.leftVentricularEjectionFraction == null? 0 : Integer.parseInt(ePatientCabs.properties.leftVentricularEjectionFraction);
                    ePatientCabsPARSE.properties.interventricularSeptum = ePatientCabs.properties.interventricularSeptum == null? 0.0 : Double.parseDouble(ePatientCabs.properties.interventricularSeptum);
                    ePatientCabsPARSE.properties.euroScoreII = ePatientCabs.properties.euroScoreII == null? 0.0 : Double.parseDouble(ePatientCabs.properties.euroScoreII);
                    ePatientCabsPARSE.properties.artificialCirculation = ePatientCabs.properties.artificialCirculation == null? false : Boolean.parseBoolean(ePatientCabs.properties.artificialCirculation);
                    ePatientCabsPARSE.properties.artificialCirculationTime = ePatientCabs.properties.artificialCirculationTime == null? 0 : Integer.parseInt(ePatientCabs.properties.artificialCirculationTime);
                    ePatientCabsPARSE.properties.aorticConstrictionTime = ePatientCabs.properties.aorticConstrictionTime == null? 0 : Integer.parseInt(ePatientCabs.properties.aorticConstrictionTime);
                    ePatientCabsPARSE.properties.bodyTemperature = ePatientCabs.properties.bodyTemperature == null? 0.0 : Double.parseDouble(ePatientCabs.properties.bodyTemperature);
                    ePatientCabsPARSE.properties.cardioplegiaNumber = ePatientCabs.properties.cardioplegiaNumber;
                    ePatientCabsPARSE.properties.ventriculoplastLV = ePatientCabs.properties.ventriculoplastLV == null? false : Boolean.parseBoolean(ePatientCabs.properties.ventriculoplastLV);
                    ePatientCabsPARSE.properties.revascularizationIdx = ePatientCabs.properties.revascularizationIdx;
                    ePatientCabsPARSE.properties.yCoronaryBypass = ePatientCabs.properties.yCoronaryBypass == null? false : Boolean.parseBoolean(ePatientCabs.properties.yCoronaryBypass);
                    ePatientCabsPARSE.properties.litaDischarge = ePatientCabs.properties.litaDischarge;
                    ePatientCabsPARSE.properties.ritaDischarge = ePatientCabs.properties.ritaDischarge;
                    ePatientCabsPARSE.properties.radialArteryUsage = ePatientCabs.properties.radialArteryUsage == null? false : Boolean.parseBoolean(ePatientCabs.properties.radialArteryUsage);
                    ePatientCabsPARSE.properties.poplitealArteryUsage = ePatientCabs.properties.poplitealArteryUsage == null? false : Boolean.parseBoolean(ePatientCabs.properties.poplitealArteryUsage);
                    ePatientCabsPARSE.properties.bloodLoss = ePatientCabs.properties.bloodLoss == null? 0 : Integer.parseInt(ePatientCabs.properties.bloodLoss);
                    ePatientCabsPARSE.properties.artificialVentTime = ePatientCabs.properties.artificialVentTime == null? 0 : Integer.parseInt(ePatientCabs.properties.artificialVentTime);
                    ePatientCabsPARSE.properties.inotropicSupport = ePatientCabs.properties.inotropicSupport == null? false : Boolean.parseBoolean(ePatientCabs.properties.inotropicSupport);
                    ePatientCabsPARSE.properties.pneumonia = ePatientCabs.properties.pneumonia == null? false : Boolean.parseBoolean(ePatientCabs.properties.pneumonia);
                    ePatientCabsPARSE.properties.heartFailure = ePatientCabs.properties.heartFailure == null? false : Boolean.parseBoolean(ePatientCabs.properties.heartFailure);
                    ePatientCabsPARSE.properties.reanimationAtrialFibrillation = ePatientCabs.properties.reanimationAtrialFibrillation == null? false : Boolean.parseBoolean(ePatientCabs.properties.reanimationAtrialFibrillation);
                    ePatientCabsPARSE.properties.pleuralEffusion = ePatientCabs.properties.pleuralEffusion == null? false : Boolean.parseBoolean(ePatientCabs.properties.pleuralEffusion);
                    ePatientCabsPARSE.properties.hydropericardium = ePatientCabs.properties.hydropericardium == null? false : Boolean.parseBoolean(ePatientCabs.properties.hydropericardium);
                    ePatientCabsPARSE.properties.pneumothorax = ePatientCabs.properties.pneumothorax == null? false : Boolean.parseBoolean(ePatientCabs.properties.pneumothorax);
                    ePatientCabsPARSE.properties.sternalComplications = ePatientCabs.properties.sternalComplications == null? false : Boolean.parseBoolean(ePatientCabs.properties.sternalComplications);
                    ePatientCabsPARSE.properties.postCalciumChannelAntagonists = ePatientCabs.properties.postCalciumChannelAntagonists == null? false : Boolean.parseBoolean(ePatientCabs.properties.postCalciumChannelAntagonists);
                    ePatientCabsPARSE.properties.postAngiotensinInhibitors = ePatientCabs.properties.postAngiotensinInhibitors == null? false : Boolean.parseBoolean(ePatientCabs.properties.postAngiotensinInhibitors);
                    ePatientCabsPARSE.properties.spironolactone = ePatientCabs.properties.spironolactone == null? false : Boolean.parseBoolean(ePatientCabs.properties.spironolactone);
                    ePatientCabsPARSE.properties.postDiuretics = ePatientCabs.properties.postDiuretics == null? false : Boolean.parseBoolean(ePatientCabs.properties.postDiuretics);
                    ePatientCabsPARSE.properties.cordarone = ePatientCabs.properties.cordarone == null? false : Boolean.parseBoolean(ePatientCabs.properties.cordarone);
                    ePatientCabsPARSE.properties.hospitalizationDuration = ePatientCabs.properties.hospitalizationDuration == null? 0 : Integer.parseInt(ePatientCabs.properties.hospitalizationDuration);
                    ePatientCabsPARSE.properties.carotidEndarterectomy = ePatientCabs.properties.carotidEndarterectomy == null? false : Boolean.parseBoolean(ePatientCabs.properties.carotidEndarterectomy);
                    ePatientCabsPARSE.properties.lowerLimbSurgery = ePatientCabs.properties.lowerLimbSurgery == null? false : Boolean.parseBoolean(ePatientCabs.properties.lowerLimbSurgery);
                    ePatientCabsPARSE.properties.antiaggregants = ePatientCabs.properties.antiaggregants == null? false : Boolean.parseBoolean(ePatientCabs.properties.antiaggregants);
                    ePatientCabsPARSE.properties.anticoagulants = ePatientCabs.properties.anticoagulants == null? false : Boolean.parseBoolean(ePatientCabs.properties.anticoagulants);
                    ePatientCabsPARSE.properties.betaAB = ePatientCabs.properties.betaAB == null? false : Boolean.parseBoolean(ePatientCabs.properties.betaAB);
                    ePatientCabsPARSE.properties.angiotensinAntagonists = ePatientCabs.properties.angiotensinAntagonists == null? false : Boolean.parseBoolean(ePatientCabs.properties.angiotensinAntagonists);
                    ePatientCabsPARSE.properties.statins = ePatientCabs.properties.statins == null? false : Boolean.parseBoolean(ePatientCabs.properties.statins);
                    ePatientCabsPARSE.properties.MI = ePatientCabs.properties.MI == null? false : Boolean.parseBoolean(ePatientCabs.properties.MI);
                    ePatientCabsPARSE.properties.CI = ePatientCabs.properties.CI == null? false : Boolean.parseBoolean(ePatientCabs.properties.CI);
                    ePatientCabsPARSE.properties.insultOutcome = ePatientCabs.properties.insultOutcome == null? false : Boolean.parseBoolean(ePatientCabs.properties.insultOutcome);
                    ePatientCabsPARSE.properties.death = ePatientCabs.properties.death == null? false : Boolean.parseBoolean(ePatientCabs.properties.death);
                    ePatientCabsPARSE.properties.comb = ePatientCabs.properties.comb == null? false : Boolean.parseBoolean(ePatientCabs.properties.comb);

                    return objectMapper.convertValue(ePatientCabsPARSE, Map.class);
                }
            }
            throw new Exception("ID not found");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select");
        }
    }
    public boolean deleteOnePatient(String patientId) throws Exception{
        long startTime = System.nanoTime();
        try {
            // Достаём из БД данные ковида
            List<EPatientCovid> encryptedPatientCovidList = dbservice.selectPatientsCovid();
            // Расшифровка данных с БД ковида
            List<EPatientCovid> decryptedPatientCovidList = modelLogic.getDecryptedPatientCovidList(encryptedPatientCovidList);

            // Достаём из БД данные шунтирования
            List<EPatientCabs> encryptedPatientCabsList = dbservice.selectPatientsCabs();
            // Расшифровка данных с БД шунтирования
            List<EPatientCabs> decryptedPatientCabsList = modelLogic.getDecryptedPatientCabsList(encryptedPatientCabsList);

            for(EPatientCovid ePatientCovid : decryptedPatientCovidList){
                if (patientId.equals(ePatientCovid.id)){
                    if(dbservice.delete("patientsCovid", patientId)) {
                        long endTime = System.nanoTime();
                        double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                        System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
                        return true;
                    }
                }
            }
            for(EPatientCabs ePatientCabs : decryptedPatientCabsList){
                if (patientId.equals(ePatientCabs.id)){
                    if(dbservice.delete("patientsCabs", patientId)) {
                        long endTime = System.nanoTime();
                        double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                        System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
                        return true;
                    }
                }
            }
            throw new Exception("ID not found");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select or delete");
        }
    }
    public Map<String, String> updateOnePatient(String patientId, Map<String, String> newPatientData) throws Exception{
        long startTime = System.nanoTime();
        try {
            // Достаём из БД данные ковида
            List<EPatientCovid> encryptedPatientCovidList = dbservice.selectPatientsCovid();
            // Расшифровка данных с БД ковида
            List<EPatientCovid> decryptedPatientCovidList = modelLogic.getDecryptedPatientCovidList(encryptedPatientCovidList);
            // Достаём из БД данные шунтирования
            List<EPatientCabs> encryptedPatientCabsList = dbservice.selectPatientsCabs();
            // Расшифровка данных с БД шунтирования
            List<EPatientCabs> decryptedPatientCabsList = modelLogic.getDecryptedPatientCabsList(encryptedPatientCabsList);

            System.out.println("TEST MAP: " + newPatientData);
            // Ищем пациента по ид в списке ковид
            String entity = null;
            for(EPatientCovid ePatientCovid: decryptedPatientCovidList){
                if (patientId.equals(String.valueOf(ePatientCovid.id))) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    EPatientCovid newPatientCovid = new EPatientCovid();
                    newPatientCovid.properties = objectMapper.convertValue(newPatientData, EPatientCovidProperties.class);
                    // Шифровка новых данных для патча в БД
                    EPatientCovid newEncryptedPatientCovid = modelLogic.getEncryptedPatientCovid(newPatientCovid);
                    newEncryptedPatientCovid.id = patientId;
                    boolean updated = dbservice.updatePatientCovid(newEncryptedPatientCovid);
                    if (updated) {
                        long endTime = System.nanoTime();
                        double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                        System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
                        return newPatientData;
                    }
                    throw new Exception("not updated");
                }
            }
            for(EPatientCabs ePatientCabs: decryptedPatientCabsList){
                if (patientId.equals(String.valueOf(ePatientCabs.id))) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    EPatientCabs newPatientCabs = new EPatientCabs();
                    newPatientCabs.properties = objectMapper.convertValue(newPatientData, EPatientCabsProperties.class);
                    // Шифровка новых данных для патча в БД
                    EPatientCabs newEncryptedPatientCabs = modelLogic.getEncryptedPatientCabs(newPatientCabs);
                    newEncryptedPatientCabs.id = patientId;
                    boolean updated = dbservice.updatePatientCabs(newEncryptedPatientCabs);
                    if (updated) {
                        long endTime = System.nanoTime();
                        double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                        System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
                        return newPatientData;
                    }
                    throw new Exception("not updated");
                }
            }
            throw new Exception("ID not found");
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while update");
        }
    }
}
