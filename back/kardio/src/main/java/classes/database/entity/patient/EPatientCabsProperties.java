package classes.database.entity.patient;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EPatientCabsProperties {
    @Column(name = "\"cabsKind\"")
    public String cabsKind;
    @Column(name = "\"age\"")
    public String age;
    @Column(name = "\"sex\"")
    public String sex;
    @Column(name = "\"BMI\"")
    public String BMI;
    @Column(name = "\"syntaxScore\"")
    public String syntaxScore;
    @Column(name = "\"arterialHypertension\"")
    public String arterialHypertension;
    @Column(name = "\"diabetes\"")
    public String diabetes;
    @Column(name = "\"obesity\"")
    public String obesity;
    @Column(name = "\"smoking\"")
    public String smoking;
    @Column(name = "\"heredity\"")
    public String heredity;
    @Column(name = "\"dyslipidemia\"")
    public String dyslipidemia;
    @Column(name = "\"asthma\"")
    public String asthma;
    @Column(name = "\"postinfarctionCardiosclerosis\"")
    public String postinfarctionCardiosclerosis;
    @Column(name = "\"atrialFibrillation\"")
    public String atrialFibrillation;
    @Column(name = "\"chronicRenalInsufficiency\"")
    public String chronicRenalInsufficiency;
    @Column(name = "\"pepticUlcer\"")
    public String pepticUlcer;
    @Column(name = "\"thyroidDisorders\"")
    public String thyroidDisorders;
    @Column(name = "\"varicoseVein\"")
    public String varicoseVein;
    @Column(name = "\"insult\"")
    public String insult;
    @Column(name = "\"lowerLimbIschemia\"")
    public String lowerLimbIschemia;
    @Column(name = "\"anginaFuncClass\"")
    public String anginaFuncClass;
    @Column(name = "\"chronicHeartFailureFuncClass\"")
    public String chronicHeartFailureFuncClass;
    @Column(name = "\"leftVentricularEjectionFraction\"")
    public String leftVentricularEjectionFraction;
    @Column(name = "\"interventricularSeptum\"")
    public String interventricularSeptum;
    @Column(name = "\"euroScoreII\"")
    public String euroScoreII;
    @Column(name = "\"artificialCirculation\"")
    public String artificialCirculation;
    @Column(name = "\"artificialCirculationTime\"")
    public String artificialCirculationTime;
    @Column(name = "\"aorticConstrictionTime\"")
    public String aorticConstrictionTime;
    @Column(name = "\"bodyTemperature\"")
    public String bodyTemperature;
    @Column(name = "\"cardioplegiaNumber\"")
    public String cardioplegiaNumber;
    @Column(name = "\"ventriculoplastLV\"")
    public String ventriculoplastLV;
    @Column(name = "\"revascularizationIdx\"")
    public String revascularizationIdx;
    @Column(name = "\"yCoronaryBypass\"")
    public String yCoronaryBypass;
    @Column(name = "\"litaDischarge\"")
    public String litaDischarge;
    @Column(name = "\"ritaDischarge\"")
    public String ritaDischarge;
    @Column(name = "\"radialArteryUsage\"")
    public String radialArteryUsage;
    @Column(name = "\"poplitealArteryUsage\"")
    public String poplitealArteryUsage;
    @Column(name = "\"bloodLoss\"")
    public String bloodLoss;
    @Column(name = "\"artificialVentTime\"")
    public String artificialVentTime;
    @Column(name = "\"inotropicSupport\"")
    public String inotropicSupport;
    @Column(name = "\"pneumonia\"")
    public String pneumonia;
    @Column(name = "\"heartFailure\"")
    public String heartFailure;
    @Column(name = "\"reanimationAtrialFibrillation\"")
    public String reanimationAtrialFibrillation;
    @Column(name = "\"pleuralEffusion\"")
    public String pleuralEffusion;
    @Column(name = "\"hydropericardium\"")
    public String hydropericardium;
    @Column(name = "\"pneumothorax\"")
    public String pneumothorax;
    @Column(name = "\"sternalComplications\"")
    public String sternalComplications;
    @Column(name = "\"postCalciumChannelAntagonists\"")
    public String postCalciumChannelAntagonists;
    @Column(name = "\"postAngiotensinInhibitors\"")
    public String postAngiotensinInhibitors;
    @Column(name = "\"spironolactone\"")
    public String spironolactone;
    @Column(name = "\"postDiuretics\"")
    public String postDiuretics;
    @Column(name = "\"cordarone\"")
    public String cordarone;
    @Column(name = "\"hospitalizationDuration\"")
    public String hospitalizationDuration;
    @Column(name = "\"carotidEndarterectomy\"")
    public String carotidEndarterectomy;
    @Column(name = "\"lowerLimbSurgery\"")
    public String lowerLimbSurgery;
    @Column(name = "\"antiaggregants\"")
    public String antiaggregants;
    @Column(name = "\"anticoagulants\"")
    public String anticoagulants;
    @Column(name = "\"betaAB\"")
    public String betaAB;
    @Column(name = "\"angiotensinInhibitors\"")
    public String angiotensinInhibitors;
    @Column(name = "\"angiotensinAntagonists\"")
    public String angiotensinAntagonists;
    @Column(name = "\"statins\"")
    public String statins;
    @Column(name = "\"MI\"")
    public String MI;
    @Column(name = "\"CI\"")
    public String CI;
    @Column(name = "\"insultOutcome\"")
    public String insultOutcome;
    @Column(name = "\"death\"")
    public String death;

    @Column(name = "\"comb\"")
    public String comb;
}
