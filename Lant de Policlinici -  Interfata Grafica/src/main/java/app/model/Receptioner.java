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
@Table(name = "receptioner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receptioner implements Serializable {
    @Id
    private String idReceptioner;
    @Column
    private String functia;
    @Column
    private String unitate;

    public String getIdReceptioner() {
        return idReceptioner;
    }

    public void setIdReceptioner(String idReceptioner) {
        this.idReceptioner = idReceptioner;
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
