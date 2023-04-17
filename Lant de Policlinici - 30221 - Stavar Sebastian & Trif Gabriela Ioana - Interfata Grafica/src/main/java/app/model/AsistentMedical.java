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
@Table(name = "asistent_medical")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsistentMedical implements Serializable {
    @Id
    private String idAsistent;
    @Column
    private String tip;
    @Column
    private String grad;
    @Column
    private String functia;
    @Column
    private String unitate;

    public String getIdAsistent() {
        return idAsistent;
    }

    public void setIdAsistent(String idAsistent) {
        this.idAsistent = idAsistent;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getFunctia() {
        return functia;
    }

    public void setFunctia(String functia) {
        this.functia = functia;
    }

    public String getUnitate() {
        return unitate;
    }

    public void setUnitate(String unitate) {
        this.unitate = unitate;
    }
}
