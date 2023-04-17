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
@Table(name = "economist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Economist implements Serializable {
    @Id
    private String idEconomist;
    @Column
    private String functia;
    @Column
    private String unitate;

    public String getIdEconomist() {
        return idEconomist;
    }

    public void setIdEconomist(String idEconomist) {
        this.idEconomist = idEconomist;
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
