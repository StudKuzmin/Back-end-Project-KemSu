package classes.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"patients\"")
@NamedQueries({
        @NamedQuery(name="patients.findAll", query="SELECT ep FROM EPatient ep"),
        @NamedQuery(name="patients.deleteById", query="DELETE FROM EPatient where id=:id"),
        @NamedQuery(name="patients.updateById", query="UPDATE EPatient SET id=:id," +
                "dateOfAdmission=:dateOfAdmission, " +
                "sex=:sex, " +
                "age=:age, " +
                "urea=:urea, " +
                "creatinine=:creatinine, " +
                "AST=:AST, " +
                "ALT=:ALT, " +
                "glucose=:glucose, " +
                "leukocytes=:leukocytes, " +
                "platelets=:platelets, " +
                "neutrophils=:neutrophils, " +
                "lymphocytes=:lymphocytes, " +
                "DminusDimer=:DminusDimer, " +
                "AG=:AG, " +
                "SD=:SD, " +
                "IBS=:IBS, " +
                "HOBL=:HOBL, " +
                "HBP=:HBP, " +
                "CRP=:CRP, " +
                "SKF=:SKF, " +
                "neutrophilMinusLymphocyteRatio=:neutrophilMinusLymphocyteRatio, " +
                "cabsType=:cabsType, " +
                "BMI=:BMI, " +
                "overweight=:overweight, " +
                "smoking=:smoking, " +
                "heredity=:heredity, " +
                "dyslipidemia=:dyslipidemia, " +
                "HOBLminusBA=:HOBLminusBA, " +
                "PIKS=:PIKS, " +
                "FP=:FP, " +
                "SU=:SU, " +
                "TH=:TH, " +
                "varicose=:varicose, " +
                "cardiacLesions=:cardiacLesions, " +
                "LLALesions=:LLALesions, " +
                "FCAnginaPectoris=:FCAnginaPectoris, " +
                "FCCHF=:FCCHF, " +
                "LVEF=:LVEF, " +
                "ISs=:ISs, " +
                "EuroScore2=:EuroScore2, " +
                "IK=:IK, " +
                "IKTime=:IKTime, " +
                "aorticClampTime=:aorticClampTime, " +
                "TminusBodies=:TminusBodies, " +
                "numberOfCardioplegias=:numberOfCardioplegias, " +
                "VPminusLZ=:VPminusLZ, " +
                "revascularizationIndex=:revascularizationIndex, " +
                "YminusTypeCOBS=:YminusTypeCOBS, " +
                "LIMAExcretion=:LIMAExcretion, " +
                "RIMAExcretion=:RIMAExcretion, " +
                "LAUsage=:LAUsage, " +
                "AVUsage=:AVUsage, " +
                "bloodLoss=:bloodLoss, " +
                "ALVTime=:ALVTime, " +
                "inotropicSupport=:inotropicSupport, " +
                "pneumonia=:pneumonia, " +
                "SN=:SN, " +
                "FPminusTP=:FPminusTP, " +
                "pleuralEffusion=:pleuralEffusion, " +
                "hydropericardium=:hydropericardium, " +
                "pneumothorax=:pneumothorax, " +
                "sternalComplications=:sternalComplications, " +
                "AKK=:AKK, " +
                "iAPF=:iAPF, " +
                "spironolactone=:spironolactone, " +
                "diuretics=:diuretics, " +
                "cordaron=:cordaron, " +
                "hospitalizationDuration=:hospitalizationDuration, " +
                "CEAfteer=:CEAfteer, " +
                "ANCOperationsAfter=:ANCOperationsAfter, " +
                "antiplateletAgentsAfter=:antiplateletAgentsAfter, " +
                "anticoagulants=:anticoagulants, " +
                "BABAfter=:BABAfter, " +
                "AKKAfter=:AKKAfter, " +
                "iAPFAfter=:iAPFAfter, " +
                "ARAAfter=:ARAAfter, " +
                "diureticsAfter=:diureticsAfter, " +
                "statins=:statins, " +
                "heartAttack=:heartAttack, " +
                "PCI=:PCI, " +
                "insult=:insult, " +
                "death=:death " +
                "WHERE id = :id")
})
public class EPatient {
    public EPatient(){}
    public EPatient(int id,
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

    public void clone(EPatient ePatient){
        ePatient.id = this.id;
        ePatient.dateOfAdmission = this.dateOfAdmission;
        ePatient.sex = this.sex;
        ePatient.age = this.age;
        ePatient.urea = this.urea;
        ePatient.creatinine = this.creatinine;
        ePatient.AST = this.AST;
        ePatient.ALT = this.ALT;
        ePatient.glucose = this.glucose;
        ePatient.leukocytes = this.leukocytes;
        ePatient.platelets = this.platelets;
        ePatient.neutrophils = this.neutrophils;
        ePatient.lymphocytes = this.lymphocytes;
        ePatient.DminusDimer = this.DminusDimer;
        ePatient.AG = this.AG;
        ePatient.SD = this.SD;
        ePatient.IBS = this.IBS;
        ePatient.HOBL = this.HOBL;
        ePatient.HBP = this.HBP;
        ePatient.CRP = this.CRP;
        ePatient.SKF = this.SKF;
        ePatient.neutrophilMinusLymphocyteRatio = this.neutrophilMinusLymphocyteRatio;
        ePatient.cabsType = this.cabsType;
        ePatient.BMI = this.BMI;
        ePatient.overweight = this.overweight;
        ePatient.smoking = this.smoking;
        ePatient.heredity = this.heredity;
        ePatient.dyslipidemia = this.dyslipidemia;
        ePatient.HOBLminusBA = this.HOBLminusBA;
        ePatient.PIKS = this.PIKS;
        ePatient.FP = this.FP;
        ePatient.SU = this.SU;
        ePatient.TH = this.TH;
        ePatient.varicose = this.varicose;
        ePatient.cardiacLesions = this.cardiacLesions;
        ePatient.LLALesions = this.LLALesions;
        ePatient.FCAnginaPectoris = this.FCAnginaPectoris;
        ePatient.FCCHF = this.FCCHF;
        ePatient.LVEF = this.LVEF;
        ePatient.ISs = this.ISs;
        ePatient.EuroScore2 = this.EuroScore2;
        ePatient.IK = this.IK;
        ePatient.IKTime = this.IKTime;
        ePatient.aorticClampTime = this.aorticClampTime;
        ePatient.TminusBodies = this.TminusBodies;
        ePatient.numberOfCardioplegias = this.numberOfCardioplegias;
        ePatient.VPminusLZ = this.VPminusLZ;
        ePatient.revascularizationIndex = this.revascularizationIndex;
        ePatient.YminusTypeCOBS = this.YminusTypeCOBS;
        ePatient.LIMAExcretion = this.LIMAExcretion;
        ePatient.RIMAExcretion = this.RIMAExcretion;
        ePatient.LAUsage = this.LAUsage;
        ePatient.AVUsage = this.AVUsage;
        ePatient.bloodLoss = this.bloodLoss;
        ePatient.ALVTime = this.ALVTime;
        ePatient.inotropicSupport = this.inotropicSupport;
        ePatient.pneumonia = this.pneumonia;
        ePatient.SN = this.SN;
        ePatient.FPminusTP = this.FPminusTP;
        ePatient.pleuralEffusion = this.pleuralEffusion;
        ePatient.hydropericardium = this.hydropericardium;
        ePatient.pneumothorax = this.pneumothorax;
        ePatient.sternalComplications = this.sternalComplications;
        ePatient.AKK = this.AKK;
        ePatient.iAPF = this.iAPF;
        ePatient.spironolactone = this.spironolactone;
        ePatient.diuretics = this.diuretics;
        ePatient.cordaron = this.cordaron;
        ePatient.hospitalizationDuration = this.hospitalizationDuration;
        ePatient.CEAfteer = this.CEAfteer;
        ePatient.ANCOperationsAfter = this.ANCOperationsAfter;
        ePatient.antiplateletAgentsAfter = this.antiplateletAgentsAfter;
        ePatient.anticoagulants = this.anticoagulants;
        ePatient.BABAfter = this.BABAfter;
        ePatient.AKKAfter = this.AKKAfter;
        ePatient.iAPFAfter = this.iAPFAfter;
        ePatient.ARAAfter = this.ARAAfter;
        ePatient.diureticsAfter = this.diureticsAfter;
        ePatient.statins = this.statins;
        ePatient.heartAttack = this.heartAttack;
        ePatient.PCI = this.PCI;
        ePatient.insult = this.insult;
        ePatient.death = this.death;
    }

    @Id
    @Column(name = "\"id\"")
    public int id;
    @Column(name = "\"dateOfAdmission\"")
    public String dateOfAdmission;
    @Column(name = "\"sex\"")
    public String sex;
    @Column(name = "\"age\"")
    public String age;
    @Column(name = "\"urea\"")
    public String urea;
    @Column(name = "\"creatinine\"")
    public String creatinine;
    @Column(name = "\"AST\"")
    public String AST;
    @Column(name = "\"ALT\"")
    public String ALT;
    @Column(name = "\"glucose\"")
    public String glucose;
    @Column(name = "\"leukocytes\"")
    public String leukocytes;
    @Column(name = "\"platelets\"")
    public String platelets;
    @Column(name = "\"neutrophils\"")
    public String neutrophils;
    @Column(name = "\"lymphocytes\"")
    public String lymphocytes;
    @Column(name = "\"DminusDimer\"")
    public String DminusDimer; //
    @Column(name = "\"AG\"")
    public String AG;
    @Column(name = "\"SD\"")
    public String SD;
    @Column(name = "\"IBS\"")
    public String IBS;
    @Column(name = "\"HOBL\"")
    public String HOBL;
    @Column(name = "\"HBP\"")
    public String HBP;
    @Column(name = "\"CRP\"")
    public String CRP;
    @Column(name = "\"SKF\"")
    public String SKF;
    @Column(name = "\"neutrophilMinusLymphocyteRatio\"")
    public String neutrophilMinusLymphocyteRatio; //
    @Column(name = "\"cabsType\"")
    public String cabsType;
    @Column(name = "\"BMI\"")
    public String BMI;
    @Column(name = "\"overweight\"")
    public String overweight;
    @Column(name = "\"smoking\"")
    public String smoking;
    @Column(name = "\"heredity\"")
    public String heredity;
    @Column(name = "\"dyslipidemia\"")
    public String dyslipidemia;
    @Column(name = "\"HOBLminusBA\"")
    public String HOBLminusBA; //
    @Column(name = "\"PIKS\"")
    public String PIKS;
    @Column(name = "\"FP\"")
    public String FP;
    @Column(name = "\"SU\"")
    public String SU;
    @Column(name = "\"TH\"")
    public String TH;
    @Column(name = "\"varicose\"")
    public String varicose;
    @Column(name = "\"cardiacLesions\"")
    public String cardiacLesions;
    @Column(name = "\"LLALesions\"")
    public String LLALesions;
    @Column(name = "\"FCAnginaPectoris\"")
    public String FCAnginaPectoris;
    @Column(name = "\"FCCHF\"")
    public String FCCHF;
    @Column(name = "\"LVEF\"")
    public String LVEF;
    @Column(name = "\"ISs\"")
    public String ISs; //
    @Column(name = "\"EuroScore2\"")
    public String EuroScore2;
    @Column(name = "\"IK\"")
    public String IK;
    @Column(name = "\"IKTime\"")
    public String IKTime;
    @Column(name = "\"aorticClampTime\"")
    public String aorticClampTime;
    @Column(name = "\"TminusBodies\"")
    public String TminusBodies; //
    @Column(name = "\"numberOfCardioplegias\"")
    public String numberOfCardioplegias;
    @Column(name = "\"VPminusLZ\"")
    public String VPminusLZ; //
    @Column(name = "\"revascularizationIndex\"")
    public String revascularizationIndex;
    @Column(name = "\"YminusTypeCOBS\"")
    public String YminusTypeCOBS; //
    @Column(name = "\"LIMAExcretion\"")
    public String LIMAExcretion;
    @Column(name = "\"RIMAExcretion\"")
    public String RIMAExcretion;
    @Column(name = "\"LAUsage\"")
    public String LAUsage;
    @Column(name = "\"AVUsage\"")
    public String AVUsage;
    @Column(name = "\"bloodLoss\"")
    public String bloodLoss;
    @Column(name = "\"ALVTime\"")
    public String ALVTime;
    @Column(name = "\"inotropicSupport\"")
    public String inotropicSupport;
    @Column(name = "\"pneumonia\"")
    public String pneumonia;
    @Column(name = "\"SN\"")
    public String SN;
    @Column(name = "\"FPminusTP\"")
    public String FPminusTP; //
    @Column(name = "\"pleuralEffusion\"")
    public String pleuralEffusion;
    @Column(name = "\"hydropericardium\"")
    public String hydropericardium;
    @Column(name = "\"pneumothorax\"")
    public String pneumothorax;
    @Column(name = "\"sternalComplications\"")
    public String sternalComplications;
    @Column(name = "\"AKK\"")
    public String AKK;
    @Column(name = "\"iAPF\"")
    public String iAPF;
    @Column(name = "\"spironolactone\"")
    public String spironolactone;
    @Column(name = "\"diuretics\"")
    public String diuretics;
    @Column(name = "\"cordaron\"")
    public String cordaron;
    @Column(name = "\"hospitalizationDuration\"")
    public String hospitalizationDuration;
    @Column(name = "\"CEAfteer\"")
    public String CEAfteer;
    @Column(name = "\"ANCOperationsAfter\"")
    public String ANCOperationsAfter;
    @Column(name = "\"antiplateletAgentsAfter\"")
    public String antiplateletAgentsAfter;
    @Column(name = "\"anticoagulants\"")
    public String anticoagulants;
    @Column(name = "\"BABAfter\"")
    public String BABAfter;
    @Column(name = "\"AKKAfter\"")
    public String AKKAfter;
    @Column(name = "\"iAPFAfter\"")
    public String iAPFAfter;
    @Column(name = "\"ARAAfter\"")
    public String ARAAfter;
    @Column(name = "\"diureticsAfter\"")
    public String diureticsAfter;
    @Column(name = "\"statins\"")
    public String statins;
    @Column(name = "\"heartAttack\"")
    public String heartAttack;
    @Column(name = "\"PCI\"")
    public String PCI;
    @Column(name = "\"insult\"")
    public String insult;
    @Column(name = "\"death\"")
    public String death;
}

