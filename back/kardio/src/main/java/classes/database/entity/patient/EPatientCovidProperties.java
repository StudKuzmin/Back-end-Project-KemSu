package classes.database.entity.patient;

import jakarta.persistence.*;

import java.util.UUID;


@Embeddable
public class EPatientCovidProperties {
    public EPatientCovidProperties(){}
    @Column(name = "\"sex\"")
    public String sex;
    @Column(name = "\"age\"")
    public String age;
    @Column(name = "\"urea\"")
    public String urea;
    @Column(name = "\"creatinine\"")
    public String creatinine;
    @Column(name = "\"ast\"")
    public String AST;
    @Column(name = "\"alt\"")
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
    @Column(name = "\"severity\"")
    public String severity;
    @Column(name = "\"dDimer\"")
    public String DDimer; //
    @Column(name = "\"ag\"")
    public String AG;
    @Column(name = "\"sd\"")
    public String SD;
    @Column(name = "\"ibs\"")
    public String IBS;
    @Column(name = "\"hobl\"")
    public String HOBL;
    @Column(name = "\"hbp\"")
    public String HBP;
    @Column(name = "\"crp\"")
    public String CRP;
    @Column(name = "\"skf\"")
    public String SKF;
    @Column(name = "\"neutrophilLymphocyteRatio\"")
    public String neutrophilLymphocyteRatio;
    @Column(name = "\"survived\"")
    public String survived;
}
