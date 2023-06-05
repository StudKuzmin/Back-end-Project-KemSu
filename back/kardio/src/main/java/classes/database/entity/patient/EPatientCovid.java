package classes.database.entity.patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "\"patientsCovid\"")
@NamedQueries({
        @NamedQuery(name="patientsCovid.findAll", query="SELECT ep FROM EPatientCovid ep"),
        @NamedQuery(name="patientsCovid.deleteById", query="DELETE FROM EPatientCovid where id=:id"),
})
public class EPatientCovid {
    public EPatientCovid(){
        String characters = "1234567890";
        StringBuilder sb = new StringBuilder(6);
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        this.id = sb.toString();
        this.properties = new EPatientCovidProperties();
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
    public EPatientCovidProperties properties;
    @Column(name = "\"createdAt\"")
    public String createdAt;
    @Column(name = "\"updatedAt\"")
    public String updatedAt;
}

