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
                    boolean sex,
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
                    boolean AG,
                    boolean SD,
                    boolean IBS,
                    boolean HOBL,
                    boolean HBP,
                    String CRP,
                    String SKF,
                    String neutrophilMinusLymphocyteRatio,
                    boolean cabsType,
                    String BMI,
                    boolean overweight,
                    boolean smoking,
                    boolean heredity,
                    boolean dyslipidemia,
                    boolean HOBLminusBA,
                    boolean PIKS,
                    boolean FP,
                    boolean SU,
                    boolean TH,
                    boolean varicose,
                    boolean cardiacLesions,
                    boolean LLALesions,
                    boolean FCAnginaPectoris,
                    boolean FCCHF,
                    String LVEF,
                    String ISs,
                    String EuroScore2,
                    boolean IK,
                    String IKTime,
                    String aorticClampTime,
                    String TminusBodies,
                    boolean numberOfCardioplegias,
                    boolean VPminusLZ,
                    boolean revascularizationIndex,
                    boolean YminusTypeCOBS,
                    boolean LIMAExcretion,
                    String RIMAExcretion,
                    boolean LAUsage,
                    boolean AVUsage,
                    String bloodLoss,
                    String ALVTime,
                    boolean inotropicSupport,
                    boolean pneumonia,
                    boolean SN,
                    boolean FPminusTP,
                    boolean pleuralEffusion,
                    boolean hydropericardium,
                    boolean pneumothorax,
                    boolean sternalComplications,
                    boolean AKK,
                    boolean iAPF,
                    boolean spironolactone,
                    boolean diuretics,
                    boolean cordaron,
                    String hospitalizationDuration,
                    boolean CEAfteer,
                    boolean ANCOperationsAfter,
                    boolean antiplateletAgentsAfter,
                    boolean anticoagulants,
                    boolean BABAfter,
                    boolean AKKAfter,
                    boolean iAPFAfter,
                    boolean ARAAfter,
                    boolean diureticsAfter,
                    boolean statins,
                    boolean heartAttack,
                    boolean PCI,
                    boolean insult,
                    boolean death){
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

    @Id
    @Column(name = "\"id\"")
    public int id;
    @Column(name = "\"dateOfAdmission\"")
    public String dateOfAdmission;
    @Column(name = "\"sex\"")
    public boolean sex;
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
    public boolean AG;
    @Column(name = "\"SD\"")
    public boolean SD;
    @Column(name = "\"IBS\"")
    public boolean IBS;
    @Column(name = "\"HOBL\"")
    public boolean HOBL;
    @Column(name = "\"HBP\"")
    public boolean HBP;
    @Column(name = "\"CRP\"")
    public String CRP;
    @Column(name = "\"SKF\"")
    public String SKF;
    @Column(name = "\"neutrophilMinusLymphocyteRatio\"")
    public String neutrophilMinusLymphocyteRatio; //
    @Column(name = "\"cabsType\"")
    public boolean cabsType;
    @Column(name = "\"BMI\"")
    public String BMI;
    @Column(name = "\"overweight\"")
    public boolean overweight;
    @Column(name = "\"smoking\"")
    public boolean smoking;
    @Column(name = "\"heredity\"")
    public boolean heredity;
    @Column(name = "\"dyslipidemia\"")
    public boolean dyslipidemia;
    @Column(name = "\"HOBLminusBA\"")
    public boolean HOBLminusBA; //
    @Column(name = "\"PIKS\"")
    public boolean PIKS;
    @Column(name = "\"FP\"")
    public boolean FP;
    @Column(name = "\"SU\"")
    public boolean SU;
    @Column(name = "\"TH\"")
    public boolean TH;
    @Column(name = "\"varicose\"")
    public boolean varicose;
    @Column(name = "\"cardiacLesions\"")
    public boolean cardiacLesions;
    @Column(name = "\"LLALesions\"")
    public boolean LLALesions;
    @Column(name = "\"FCAnginaPectoris\"")
    public boolean FCAnginaPectoris;
    @Column(name = "\"FCCHF\"")
    public boolean FCCHF;
    @Column(name = "\"LVEF\"")
    public String LVEF;
    @Column(name = "\"ISs\"")
    public String ISs; //
    @Column(name = "\"EuroScore2\"")
    public String EuroScore2;
    @Column(name = "\"IK\"")
    public boolean IK;
    @Column(name = "\"IKTime\"")
    public String IKTime;
    @Column(name = "\"aorticClampTime\"")
    public String aorticClampTime;
    @Column(name = "\"TminusBodies\"")
    public String TminusBodies; //
    @Column(name = "\"numberOfCardioplegias\"")
    public boolean numberOfCardioplegias;
    @Column(name = "\"VPminusLZ\"")
    public boolean VPminusLZ; //
    @Column(name = "\"revascularizationIndex\"")
    public boolean revascularizationIndex;
    @Column(name = "\"YminusTypeCOBS\"")
    public boolean YminusTypeCOBS; //
    @Column(name = "\"LIMAExcretion\"")
    public boolean LIMAExcretion;
    @Column(name = "\"RIMAExcretion\"")
    public String RIMAExcretion;
    @Column(name = "\"LAUsage\"")
    public boolean LAUsage;
    @Column(name = "\"AVUsage\"")
    public boolean AVUsage;
    @Column(name = "\"bloodLoss\"")
    public String bloodLoss;
    @Column(name = "\"ALVTime\"")
    public String ALVTime;
    @Column(name = "\"inotropicSupport\"")
    public boolean inotropicSupport;
    @Column(name = "\"pneumonia\"")
    public boolean pneumonia;
    @Column(name = "\"SN\"")
    public boolean SN;
    @Column(name = "\"FPminusTP\"")
    public boolean FPminusTP; //
    @Column(name = "\"pleuralEffusion\"")
    public boolean pleuralEffusion;
    @Column(name = "\"hydropericardium\"")
    public boolean hydropericardium;
    @Column(name = "\"pneumothorax\"")
    public boolean pneumothorax;
    @Column(name = "\"sternalComplications\"")
    public boolean sternalComplications;
    @Column(name = "\"AKK\"")
    public boolean AKK;
    @Column(name = "\"iAPF\"")
    public boolean iAPF;
    @Column(name = "\"spironolactone\"")
    public boolean spironolactone;
    @Column(name = "\"diuretics\"")
    public boolean diuretics;
    @Column(name = "\"cordaron\"")
    public boolean cordaron;
    @Column(name = "\"hospitalizationDuration\"")
    public String hospitalizationDuration;
    @Column(name = "\"CEAfteer\"")
    public boolean CEAfteer;
    @Column(name = "\"ANCOperationsAfter\"")
    public boolean ANCOperationsAfter;
    @Column(name = "\"antiplateletAgentsAfter\"")
    public boolean antiplateletAgentsAfter;
    @Column(name = "\"anticoagulants\"")
    public boolean anticoagulants;
    @Column(name = "\"BABAfter\"")
    public boolean BABAfter;
    @Column(name = "\"AKKAfter\"")
    public boolean AKKAfter;
    @Column(name = "\"iAPFAfter\"")
    public boolean iAPFAfter;
    @Column(name = "\"ARAAfter\"")
    public boolean ARAAfter;
    @Column(name = "\"diureticsAfter\"")
    public boolean diureticsAfter;
    @Column(name = "\"statins\"")
    public boolean statins;
    @Column(name = "\"heartAttack\"")
    public boolean heartAttack;
    @Column(name = "\"PCI\"")
    public boolean PCI;
    @Column(name = "\"insult\"")
    public boolean insult;
    @Column(name = "\"death\"")
    public boolean death;
}

