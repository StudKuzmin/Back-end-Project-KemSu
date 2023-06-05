package classes.database.entity.patient;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "\"patientsCabs\"")
@NamedQueries({
        @NamedQuery(name="patientsCabs.findAll", query="SELECT ep FROM EPatientCabs ep"),
        @NamedQuery(name="patientsCabs.deleteById", query="DELETE FROM EPatientCabs where id=:id"),
})
public class EPatientCabs {
    public EPatientCabs(){
        // Генерация id
        String characters = "1234567890";
        StringBuilder sb = new StringBuilder(6);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        this.id = sb.toString();
        this.properties = new EPatientCabsProperties();
    }
    @Id
    @Column(name = "\"id\"")
    public String id;
    @Column(name = "\"userid\"")
    public String userid;
    @Column(name = "\"description\"")
    public String description;
    @Column(name = "\"type\"")
    public String type;
    @Embedded
    public EPatientCabsProperties properties;
    @Column(name = "\"createdAt\"")
    public String createdAt;
    @Column(name = "\"updatedAt\"")
    public String updatedAt;
}
