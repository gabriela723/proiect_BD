package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "medic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medic implements Serializable {
    @Id
    private String idMedic;
    @Column
    private String idSpecialzare;
    @Column
    private String functia;
    @Column
    private String grad;
    @Column
    private String codParafa;
    @Column
    private String competente;
    @Column
    private String titlulStintiific;
    @Column
    private String postDidactic;

    public String getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(String idMedic) {
        this.idMedic = idMedic;
    }

    public String getIdSpecialzare() {
        return idSpecialzare;
    }

    public void setIdSpecialzare(String idSpecialzare) {
        this.idSpecialzare = idSpecialzare;
    }

    public String getFunctia() {
        return functia;
    }

    public void setFunctia(String functia) {
        this.functia = functia;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getCodParafa() {
        return codParafa;
    }

    public void setCodParafa(String codParafa) {
        this.codParafa = codParafa;
    }

    public String getCompetente() {
        return competente;
    }

    public void setCompetente(String competente) {
        this.competente = competente;
    }

    public String getTitlulStintiific() {
        return titlulStintiific;
    }

    public void setTitlulStintiific(String titlulStintiific) {
        this.titlulStintiific = titlulStintiific;
    }

    public String getPostDidactic() {
        return postDidactic;
    }

    public void setPostDidactic(String postDidactic) {
        this.postDidactic = postDidactic;
    }
}
