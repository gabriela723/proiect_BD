package app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "consultatie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consultatie implements Serializable {
    @Id
    private Integer idConsultatie;
    @Column
    private Time durata;
    @Column
    private Double pret;
    @Column
    private String idMedic;
    @Column
    private String idSpecializare;
    @Column
    private String idPacient;

    public Integer getIdConsultatie() {
        return idConsultatie;
    }

    public void setIdConsultatie(Integer idConsultatie) {
        this.idConsultatie = idConsultatie;
    }

    public Time getDurata() {
        return durata;
    }

    public void setDurata(Time durata) {
        this.durata = durata;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public String getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(String idMedic) {
        this.idMedic = idMedic;
    }

    public String getIdSpecializare() {
        return idSpecializare;
    }

    public void setIdSpecializare(String idSpecializare) {
        this.idSpecializare = idSpecializare;
    }

    public String getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(String idPacient) {
        this.idPacient = idPacient;
    }
}
