package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "specializare")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Specializare implements Serializable {
    @Id
    private Integer idSpecializare;
    @Column
    private String denumire;
    @Column
    private Double pret;

    public Integer getIdSpecializare() {
        return idSpecializare;
    }

    public void setIdSpecializare(Integer idSpecializare) {
        this.idSpecializare = idSpecializare;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }
}
