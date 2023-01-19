package classes.controller.entity;

import java.util.List;

public class EPatient {
    private String id;
    private String dateOfAdmission;
    private String sex;
    private String age;
    private String urea;
    private String creatinine;
    private String AST;
    private String ALT;
    private String glucose;
    private String leukocytes;
    private String platelets;
    private String neutrophils;
    private String lymphocytes;
    private String DminusDimer; //
    private String AG;
    private String SD;
    private String IBS;
    private String HOBL;
    private String HBP;
    private String CRP;
    private String SKF;
    private String neutrophilMinusLymphocyteRatio; //
    private String cabsType;
    private String BMI;
    private String overweight;
    private String smoking;
    private String heredity;
    private String dyslipidemia;
    private String HOBLminusBA; //
    private String PIKS;
    private String FP;
    private String SU;
    private String TH;
    private String varicose;
    private String cardiacLesions;
    private String LLALesions;
    private String FCAnginaPectoris;
    private String FCCHF;
    private String LVEF;
    private String ISs; //
    private String EuroScore2;
    private String IK;
    private String IKTime;
    private String aorticClampTime;
    private String TminusBodies; //
    private String numberOfCardioplegias;
    private String VPminusLZ; //
    private String revascularizationIndex;
    private String YminusTypeCOBS; //
    private String LIMAExcretion;
    private String RIMAExcretion;
    private String LAUsage;
    private String AVUsage;
    private String bloodLoss;
    private String ALVTime;
    private String inotropicSupport;
    private String pneumonia;
    private String SN;
    private String FPminusTP; //
    private String pleuralEffusion;
    private String hydropericardium;
    private String pneumothorax;
    private String sternalComplications;
    private String AKK;
    private String iAPF;
    private String spironolactone;
    private String diuretics;
    private String cordaron;
    private String hospitalizationDuration;
    private String CEAfteer;
    private String ANCOperationsAfter;
    private String antiplateletAgentsAfter;
    private String anticoagulants;
    private String BABAfter;
    private String AKKAfter;
    private String iAPFAfter;
    private String ARAAfter;
    private String diureticsAfter;
    private String statins;
    private String heartAttack;
    private String PCI;
    private String insult;
    private String death;

    public EPatient(){}
    public EPatient(String id,
                    String dateOfAdmission,
                    String sex,
                    String age,
                    String urea,
                    String creatinine,
                    String AST,
                    String ALT,
                    String glucose,
                    String leukocytes,
                    String platelets,
                    String neutrophils,
                    String lymphocytes,
                    String DminusDimer,
                    String AG,
                    String SD,
                    String IBS,
                    String HOBL,
                    String HBP,
                    String CRP,
                    String SKF,
                    String neutrophilMinusLymphocyteRatio,
                    String cabsType,
                    String BMI,
                    String overweight,
                    String smoking,
                    String heredity,
                    String dyslipidemia,
                    String HOBLminusBA,
                    String PIKS,
                    String FP,
                    String SU,
                    String TH,
                    String varicose,
                    String cardiacLesions,
                    String LLALesions,
                    String FCAnginaPectoris,
                    String FCCHF,
                    String LVEF,
                    String ISs,
                    String EuroScore2,
                    String IK,
                    String IKTime,
                    String aorticClampTime,
                    String TminusBodies,
                    String numberOfCardioplegias,
                    String VPminusLZ,
                    String revascularizationIndex,
                    String YminusTypeCOBS,
                    String LIMAExcretion,
                    String RIMAExcretion,
                    String LAUsage,
                    String AVUsage,
                    String bloodLoss,
                    String ALVTime,
                    String inotropicSupport,
                    String pneumonia,
                    String SN,
                    String FPminusTP,
                    String pleuralEffusion,
                    String hydropericardium,
                    String pneumothorax,
                    String sternalComplications,
                    String AKK,
                    String iAPF,
                    String spironolactone,
                    String diuretics,
                    String cordaron,
                    String hospitalizationDuration,
                    String CEAfteer,
                    String ANCOperationsAfter,
                    String antiplateletAgentsAfter,
                    String anticoagulants,
                    String BABAfter,
                    String AKKAfter,
                    String iAPFAfter,
                    String ARAAfter,
                    String diureticsAfter,
                    String statins,
                    String heartAttack,
                    String PCI,
                    String insult,
                    String death){
        this.id = id;
        this.dateOfAdmission = dateOfAdmission;
        this.sex = sex;
        this.age = age;
        this.urea = urea;
        this.creatinine = creatinine;
        this.AST = AST;
        this.ALT = ALT;
        this.glucose = glucose;
        this.leukocytes = leukocytes;
        this.platelets = platelets;
        this.neutrophils = neutrophils;
        this.lymphocytes = lymphocytes;
        this.DminusDimer = DminusDimer;
        this.AG = AG;
        this.SD = SD;
        this.IBS = IBS;
        this.HOBL = HOBL;
        this.HBP = HBP;
        this.CRP = CRP;
        this.SKF = SKF;
        this.neutrophilMinusLymphocyteRatio = neutrophilMinusLymphocyteRatio;
        this.cabsType = cabsType;
        this.BMI = BMI;
        this.overweight = overweight;
        this.smoking = smoking;
        this.heredity = heredity;
        this.dyslipidemia = dyslipidemia;
        this.HOBLminusBA = HOBLminusBA;
        this.PIKS = PIKS;
        this.FP = FP;
        this.SU = SU;
        this.TH = TH;
        this.varicose = varicose;
        this.cardiacLesions = cardiacLesions;
        this.LLALesions = LLALesions;
        this.FCAnginaPectoris = FCAnginaPectoris;
        this.FCCHF = FCCHF;
        this.LVEF = LVEF;
        this.ISs = ISs;
        this.EuroScore2 = EuroScore2;
        this.IK = IK;
        this.IKTime = IKTime;
        this.aorticClampTime = aorticClampTime;
        this.TminusBodies = TminusBodies;
        this.numberOfCardioplegias = numberOfCardioplegias;
        this.VPminusLZ = VPminusLZ;
        this.revascularizationIndex = revascularizationIndex;
        this.YminusTypeCOBS = YminusTypeCOBS;
        this.LIMAExcretion = LIMAExcretion;
        this.RIMAExcretion = RIMAExcretion;
        this.LAUsage = LAUsage;
        this.AVUsage = AVUsage;
        this.bloodLoss = bloodLoss;
        this.ALVTime = ALVTime;
        this.inotropicSupport = inotropicSupport;
        this.pneumonia = pneumonia;
        this.SN = SN;
        this.FPminusTP = FPminusTP;
        this.pleuralEffusion = pleuralEffusion;
        this.hydropericardium = hydropericardium;
        this.pneumothorax = pneumothorax;
        this.sternalComplications = sternalComplications;
        this.AKK = AKK;
        this.iAPF = iAPF;
        this.spironolactone = spironolactone;
        this.diuretics = diuretics;
        this.cordaron = cordaron;
        this.hospitalizationDuration = hospitalizationDuration;
        this.CEAfteer = CEAfteer;
        this.ANCOperationsAfter = ANCOperationsAfter;
        this.antiplateletAgentsAfter = antiplateletAgentsAfter;
        this.anticoagulants = anticoagulants;
        this.BABAfter = BABAfter;
        this.AKKAfter = AKKAfter;
        this.iAPFAfter = iAPFAfter;
        this.ARAAfter = ARAAfter;
        this.diureticsAfter = diureticsAfter;
        this.statins = statins;
        this.heartAttack = heartAttack;
        this.PCI = PCI;
        this.insult = insult;
        this.death = death;
    }
    public EPatient(List<String> props){
        this.id = props.get(0);
        this.dateOfAdmission = props.get(1);
        this.sex = props.get(2);
        this.age = props.get(3);
        this.urea = props.get(4);
        this.creatinine = props.get(5);
        this.AST = props.get(6);
        this.ALT = props.get(7);
        this.glucose = props.get(8);
        this.leukocytes = props.get(9);
        this.platelets = props.get(10);
        this.neutrophils = props.get(11);
        this.lymphocytes = props.get(12);
        this.DminusDimer = props.get(13);
        this.AG = props.get(14);
        this.SD = props.get(15);
        this.IBS = props.get(16);
        this.HOBL = props.get(17);
        this.HBP = props.get(18);
        this.CRP = props.get(19);
        this.SKF = props.get(20);
        this.neutrophilMinusLymphocyteRatio = props.get(21);
        this.cabsType = props.get(22);
        this.BMI = props.get(23);
        this.overweight = props.get(24);
        this.smoking = props.get(25);
        this.heredity = props.get(26);
        this.dyslipidemia = props.get(27);
        this.HOBLminusBA = props.get(28);
        this.PIKS = props.get(29);
        this.FP = props.get(30);
        this.SU = props.get(31);
        this.TH = props.get(32);
        this.varicose = props.get(33);
        this.cardiacLesions = props.get(34);
        this.LLALesions = props.get(35);
        this.FCAnginaPectoris = props.get(36);
        this.FCCHF = props.get(37);
        this.LVEF = props.get(38);
        this.ISs = props.get(39);
        this.EuroScore2 = props.get(40);
        this.IK = props.get(41);
        this.IKTime = props.get(42);
        this.aorticClampTime = props.get(43);
        this.TminusBodies = props.get(44);
        this.numberOfCardioplegias = props.get(45);
        this.VPminusLZ = props.get(46);
        this.revascularizationIndex = props.get(47);
        this.YminusTypeCOBS = props.get(48);
        this.LIMAExcretion = props.get(49);
        this.RIMAExcretion = props.get(50);
        this.LAUsage = props.get(51);
        this.AVUsage = props.get(52);
        this.bloodLoss = props.get(53);
        this.ALVTime = props.get(54);
        this.inotropicSupport = props.get(55);
        this.pneumonia = props.get(56);
        this.SN = props.get(57);
        this.FPminusTP = props.get(58);
        this.pleuralEffusion = props.get(59);
        this.hydropericardium = props.get(60);
        this.pneumothorax = props.get(61);
        this.sternalComplications = props.get(62);
        this.AKK = props.get(63);
        this.iAPF = props.get(64);
        this.spironolactone = props.get(65);
        this.diuretics = props.get(66);
        this.cordaron = props.get(67);
        this.hospitalizationDuration = props.get(68);
        this.CEAfteer = props.get(69);
        this.ANCOperationsAfter = props.get(70);
        this.antiplateletAgentsAfter = props.get(71);
        this.anticoagulants = props.get(72);
        this.BABAfter = props.get(73);
        this.AKKAfter = props.get(74);
        this.iAPFAfter = props.get(75);
        this.ARAAfter = props.get(76);
        this.diureticsAfter = props.get(77);
        this.statins = props.get(78);
        this.heartAttack = props.get(79);
        this.PCI = props.get(80);
        this.insult = props.get(81);
        this.death = props.get(82);
    }

    public String getId() {
        return String.valueOf(id);
    }
    public void setId(Object id) {
        this.id = String.valueOf(id);
    }

    public String getDateOfAdmission() {
        return String.valueOf(dateOfAdmission);
    }
    public void setDateOfAdmission(Object dateOfAdmission) {
        this.dateOfAdmission = String.valueOf(dateOfAdmission);
    }

    public String getSex() {
        return String.valueOf(sex);
    }
    public void setSex(Object sex) {
        this.sex = String.valueOf(sex);
    }

    public String getAge() {
        return String.valueOf(age);
    }
    public void setAge(Object age) {
        this.age = String.valueOf(age);
    }

    public String getUrea() {
        return String.valueOf(urea);
    }
    public void setUrea(Object urea) {
        this.urea = String.valueOf(urea);
    }

    public String getCreatinine() {
        return String.valueOf(creatinine);
    }
    public void setCreatinine(Object creatinine) {
        this.creatinine = String.valueOf(creatinine);
    }

    public String getAST() {
        return String.valueOf(AST);
    }
    public void setAST(Object AST) {
        this.AST = String.valueOf(AST);
    }

    public String getALT() {
        return String.valueOf(ALT);
    }
    public void setALT(Object ALT) {
        this.ALT = String.valueOf(ALT);
    }

    public String getGlucose() {
        return String.valueOf(glucose);
    }
    public void setGlucose(Object glucose) {
        this.glucose = String.valueOf(glucose);
    }

    public String getLeukocytes() {
        return String.valueOf(leukocytes);
    }
    public void setLeukocytes(Object leukocytes) {
        this.leukocytes = String.valueOf(leukocytes);
    }

    public String getPlatelets() {
        return String.valueOf(platelets);
    }
    public void setPlatelets(Object platelets) {
        this.platelets = String.valueOf(platelets);
    }

    public String getNeutrophils() {
        return String.valueOf(neutrophils);
    }
    public void setNeutrophils(Object neutrophils) {
        this.neutrophils = String.valueOf(neutrophils);
    }

    public String getLymphocytes() {
        return String.valueOf(lymphocytes);
    }
    public void setLymphocytes(Object lymphocytes) {
        this.lymphocytes = String.valueOf(lymphocytes);
    }

    public String getDminusDimer() {
        return String.valueOf(DminusDimer);
    }
    public void setDminusDimer(Object dminusDimer) {
        DminusDimer = String.valueOf(dminusDimer);
    }

    public String getAG() {
        return String.valueOf(AG);
    }
    public void setAG(Object AG) {
        this.AG = String.valueOf(AG);
    }

    public String getSD() {
        return String.valueOf(SD);
    }
    public void setSD(Object SD) {
        this.SD = String.valueOf(SD);
    }

    public String getIBS() {
        return String.valueOf(IBS);
    }
    public void setIBS(Object IBS) {
        this.IBS = String.valueOf(IBS);
    }

    public String getHOBL() {
        return String.valueOf(HOBL);
    }
    public void setHOBL(Object HOBL) {
        this.HOBL = String.valueOf(HOBL);
    }

    public String getHBP() {
        return String.valueOf(HBP);
    }
    public void setHBP(Object HBP) {
        this.HBP = String.valueOf(HBP);
    }

    public String getCRP() {
        return String.valueOf(CRP);
    }
    public void setCRP(Object CRP) {
        this.CRP = String.valueOf(CRP);
    }

    public String getSKF() {
        return String.valueOf(SKF);
    }
    public void setSKF(Object SKF) {
        this.SKF = String.valueOf(SKF);
    }

    public String getNeutrophilMinusLymphocyteRatio() {
        return String.valueOf(neutrophilMinusLymphocyteRatio);
    }
    public void setNeutrophilMinusLymphocyteRatio(Object neutrophilMinusLymphocyteRatio) {
        this.neutrophilMinusLymphocyteRatio = String.valueOf(neutrophilMinusLymphocyteRatio);
    }

    public String getCabsType() {
        return String.valueOf(cabsType);
    }
    public void setCabsType(Object cabsType) {
        this.cabsType = String.valueOf(cabsType);
    }

    public String getBMI() {
        return String.valueOf(BMI);
    }
    public void setBMI(Object BMI) {
        this.BMI = String.valueOf(BMI);
    }

    public String getOverweight() {
        return String.valueOf(overweight);
    }
    public void setOverweight(Object overweight) {
        this.overweight = String.valueOf(overweight);
    }

    public String getSmoking() {
        return String.valueOf(smoking);
    }
    public void setSmoking(Object smoking) {
        this.smoking = String.valueOf(smoking);
    }

    public String getHeredity() {
        return String.valueOf(heredity);
    }
    public void setHeredity(Object heredity) {
        this.heredity = String.valueOf(heredity);
    }

    public String getDyslipidemia() {
        return String.valueOf(dyslipidemia);
    }
    public void setDyslipidemia(Object dyslipidemia) {
        this.dyslipidemia = String.valueOf(dyslipidemia);
    }

    public String getHOBLminusBA() {
        return String.valueOf(HOBLminusBA);
    }
    public void setHOBLminusBA(Object HOBLminusBA) {
        this.HOBLminusBA = String.valueOf(HOBLminusBA);
    }

    public String getPIKS() {
        return String.valueOf(PIKS);
    }
    public void setPIKS(Object PIKS) {
        this.PIKS = String.valueOf(PIKS);
    }

    public String getFP() {
        return String.valueOf(FP);
    }
    public void setFP(Object FP) {
        this.FP = String.valueOf(FP);
    }

    public String getSU() {
        return String.valueOf(SU);
    }
    public void setSU(Object SU) {
        this.SU = String.valueOf(SU);
    }

    public String getTH() {
        return String.valueOf(TH);
    }
    public void setTH(Object TH) {
        this.TH = String.valueOf(TH);
    }

    public String getVaricose() {
        return String.valueOf(varicose);
    }
    public void setVaricose(Object varicose) {
        this.varicose = String.valueOf(varicose);
    }

    public String getCardiacLesions() {
        return String.valueOf(cardiacLesions);
    }
    public void setCardiacLesions(Object cardiacLesions) {
        this.cardiacLesions = String.valueOf(cardiacLesions);
    }

    public String getLLALesions() {
        return String.valueOf(LLALesions);
    }
    public void setLLALesions(Object LLALesions) {
        this.LLALesions = String.valueOf(LLALesions);
    }

    public String getFCAnginaPectoris() {
        return String.valueOf(FCAnginaPectoris);
    }
    public void setFCAnginaPectoris(Object FCAnginaPectoris) {
        this.FCAnginaPectoris = String.valueOf(FCAnginaPectoris);
    }

    public String getFCCHF() {
        return String.valueOf(FCCHF);
    }
    public void setFCCHF(Object FCCHF) {
        this.FCCHF = String.valueOf(FCCHF);
    }

    public String getLVEF() {
        return String.valueOf(LVEF);
    }
    public void setLVEF(Object LVEF) {
        this.LVEF = String.valueOf(LVEF);
    }

    public String getISs() {
        return String.valueOf(ISs);
    }
    public void setISs(Object ISs) {
        this.ISs = String.valueOf(ISs);
    }

    public String getEuroScore2() {
        return String.valueOf(EuroScore2);
    }
    public void setEuroScore2(Object euroScore2) {
        EuroScore2 = String.valueOf(euroScore2);
    }

    public String getIK() {
        return String.valueOf(IK);
    }
    public void setIK(Object IK) {
        this.IK = String.valueOf(IK);
    }

    public String getIKTime() {
        return String.valueOf(IKTime);
    }
    public void setIKTime(Object IKTime) {
        this.IKTime = String.valueOf(IKTime);
    }

    public String getAorticClampTime() {
        return String.valueOf(aorticClampTime);
    }
    public void setAorticClampTime(Object aorticClampTime) {
        this.aorticClampTime = String.valueOf(aorticClampTime);
    }

    public String getTminusBodies() {
        return String.valueOf(TminusBodies);
    }
    public void setTminusBodies(Object tminusBodies) {
        TminusBodies = String.valueOf(tminusBodies);
    }

    public String getNumberOfCardioplegias() {
        return String.valueOf(numberOfCardioplegias);
    }
    public void setNumberOfCardioplegias(Object numberOfCardioplegias) {
        this.numberOfCardioplegias = String.valueOf(numberOfCardioplegias);
    }

    public String getVPminusLZ() {
        return String.valueOf(VPminusLZ);
    }
    public void setVPminusLZ(Object VPminusLZ) {
        this.VPminusLZ = String.valueOf(VPminusLZ);
    }

    public String getRevascularizationIndex() {
        return String.valueOf(revascularizationIndex);
    }
    public void setRevascularizationIndex(Object revascularizationIndex) {
        this.revascularizationIndex = String.valueOf(revascularizationIndex);
    }

    public String getYminusTypeCOBS() {
        return String.valueOf(YminusTypeCOBS);
    }
    public void setYminusTypeCOBS(Object yminusTypeCOBS) {
        YminusTypeCOBS = String.valueOf(yminusTypeCOBS);
    }

    public String getLIMAExcretion() {
        return String.valueOf(LIMAExcretion);
    }
    public void setLIMAExcretion(Object LIMAExcretion) {
        this.LIMAExcretion = String.valueOf(LIMAExcretion);
    }

    public String getRIMAExcretion() {
        return String.valueOf(RIMAExcretion);
    }
    public void setRIMAExcretion(Object RIMAExcretion) {
        this.RIMAExcretion = String.valueOf(RIMAExcretion);
    }

    public String getLAUsage() {
        return String.valueOf(LAUsage);
    }
    public void setLAUsage(Object LAUsage) {
        this.LAUsage = String.valueOf(LAUsage);
    }

    public String getAVUsage() {
        return String.valueOf(AVUsage);
    }
    public void setAVUsage(Object AVUsage) {
        this.AVUsage = String.valueOf(AVUsage);
    }

    public String getBloodLoss() {
        return String.valueOf(bloodLoss);
    }
    public void setBloodLoss(Object bloodLoss) {
        this.bloodLoss = String.valueOf(bloodLoss);
    }

    public String getALVTime() {
        return String.valueOf(ALVTime);
    }
    public void setALVTime(Object ALVTime) {
        this.ALVTime = String.valueOf(ALVTime);
    }

    public String getInotropicSupport() {
        return String.valueOf(inotropicSupport);
    }
    public void setInotropicSupport(Object inotropicSupport) {
        this.inotropicSupport = String.valueOf(inotropicSupport);
    }

    public String getPneumonia() {
        return String.valueOf(pneumonia);
    }
    public void setPneumonia(Object pneumonia) {
        this.pneumonia = String.valueOf(pneumonia);
    }

    public String getSN() {
        return String.valueOf(SN);
    }
    public void setSN(Object SN) {
        this.SN = String.valueOf(SN);
    }

    public String getFPminusTP() {
        return String.valueOf(FPminusTP);
    }
    public void setFPminusTP(Object FPminusTP) {
        this.FPminusTP = String.valueOf(FPminusTP);
    }

    public String getPleuralEffusion() {
        return String.valueOf(pleuralEffusion);
    }
    public void setPleuralEffusion(Object pleuralEffusion) {
        this.pleuralEffusion = String.valueOf(pleuralEffusion);
    }

    public String getHydropericardium() {
        return String.valueOf(hydropericardium);
    }
    public void setHydropericardium(Object hydropericardium) {
        this.hydropericardium = String.valueOf(hydropericardium);
    }

    public String getPneumothorax() {
        return String.valueOf(pneumothorax);
    }
    public void setPneumothorax(Object pneumothorax) {
        this.pneumothorax = String.valueOf(pneumothorax);
    }

    public String getSternalComplications() {
        return String.valueOf(sternalComplications);
    }
    public void setSternalComplications(Object sternalComplications) {
        this.sternalComplications = String.valueOf(sternalComplications);
    }

    public String getAKK() {
        return String.valueOf(AKK);
    }
    public void setAKK(Object AKK) {
        this.AKK = String.valueOf(AKK);
    }

    public String getiAPF() {
        return String.valueOf(iAPF);
    }
    public void setiAPF(Object iAPF) {
        this.iAPF = String.valueOf(iAPF);
    }

    public String getSpironolactone() {
        return String.valueOf(spironolactone);
    }
    public void setSpironolactone(Object spironolactone) {
        this.spironolactone = String.valueOf(spironolactone);
    }

    public String getDiuretics() {
        return String.valueOf(diuretics);
    }
    public void setDiuretics(Object diuretics) {
        this.diuretics = String.valueOf(diuretics);
    }

    public String getCordaron() {
        return String.valueOf(cordaron);
    }
    public void setCordaron(Object cordaron) {
        this.cordaron = String.valueOf(cordaron);
    }

    public String getHospitalizationDuration() {
        return String.valueOf(hospitalizationDuration);
    }
    public void setHospitalizationDuration(Object hospitalizationDuration) {
        this.hospitalizationDuration = String.valueOf(hospitalizationDuration);
    }

    public String getCEAfteer() {
        return String.valueOf(CEAfteer);
    }
    public void setCEAfteer(Object CEAfteer) {
        this.CEAfteer = String.valueOf(CEAfteer);
    }

    public String getANCOperationsAfter() {
        return String.valueOf(ANCOperationsAfter);
    }
    public void setANCOperationsAfter(Object ANCOperationsAfter) {
        this.ANCOperationsAfter = String.valueOf(ANCOperationsAfter);
    }

    public String getAntiplateletAgentsAfter() {
        return String.valueOf(antiplateletAgentsAfter);
    }
    public void setAntiplateletAgentsAfter(Object antiplateletAgentsAfter) {
        this.antiplateletAgentsAfter = String.valueOf(antiplateletAgentsAfter);
    }

    public String getAnticoagulants() {
        return String.valueOf(anticoagulants);
    }
    public void setAnticoagulants(Object anticoagulants) {
        this.anticoagulants = String.valueOf(anticoagulants);
    }

    public String getBABAfter() {
        return String.valueOf(BABAfter);
    }
    public void setBABAfter(Object BABAfter) {
        this.BABAfter = String.valueOf(BABAfter);
    }

    public String getAKKAfter() {
        return String.valueOf(AKKAfter);
    }
    public void setAKKAfter(Object AKKAfter) {
        this.AKKAfter = String.valueOf(AKKAfter);
    }

    public String getiAPFAfter() {
        return String.valueOf(iAPFAfter);
    }
    public void setiAPFAfter(Object iAPFAfter) {
        this.iAPFAfter = String.valueOf(iAPFAfter);
    }

    public String getARAAfter() {
        return String.valueOf(ARAAfter);
    }
    public void setARAAfter(Object ARAAfter) {
        this.ARAAfter = String.valueOf(ARAAfter);
    }

    public String getDiureticsAfter() {
        return String.valueOf(diureticsAfter);
    }
    public void setDiureticsAfter(Object diureticsAfter) {
        this.diureticsAfter = String.valueOf(diureticsAfter);
    }

    public String getStatins() {
        return String.valueOf(statins);
    }
    public void setStatins(Object statins) {
        this.statins = String.valueOf(statins);
    }

    public String getHeartAttack() {
        return String.valueOf(heartAttack);
    }
    public void setHeartAttack(Object heartAttack) {
        this.heartAttack = String.valueOf(heartAttack);
    }

    public String getPCI() {
        return String.valueOf(PCI);
    }
    public void setPCI(Object PCI) {
        this.PCI = String.valueOf(PCI);
    }

    public String getInsult() {
        return String.valueOf(insult);
    }
    public void setInsult(Object insult) {
        this.insult = String.valueOf(insult);
    }

    public String getDeath() {
        return String.valueOf(death);
    }
    public void setDeath(Object death) {
        this.death = String.valueOf(death);
    }
}
