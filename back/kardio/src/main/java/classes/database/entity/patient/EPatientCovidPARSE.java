package classes.database.entity.patient;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Id;

public class EPatientCovidPARSE {
    public int id;
    public int userid;
    public String description;
    public String type;
    public EPatientCovidPropertiesPARSE properties;
    public int createdAt;
    public int updatedAt;
}
