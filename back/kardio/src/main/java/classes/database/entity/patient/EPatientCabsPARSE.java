package classes.database.entity.patient;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;

public class EPatientCabsPARSE {
    public int id;
    public int userid;
    public String description;
    public String type;
    public EPatientCabsPropertiesPARSE properties;
    public int createdAt;
    public int updatedAt;
}
