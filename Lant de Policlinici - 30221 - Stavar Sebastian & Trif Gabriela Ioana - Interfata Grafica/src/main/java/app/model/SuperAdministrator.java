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
@Table(name = "superAdministrator")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdministrator implements Serializable {
    @Id
    private String idSuperAdmin;
    @Column
    private String functia;
    @Column
    private String unitate;

    public String getIdSuperAdmin() {
        return idSuperAdmin;
    }

    public void setIdSuperAdmin(String idSuperAdmin) {
        this.idSuperAdmin = idSuperAdmin;
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
