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
@Table(name = "unitate_medicala")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnitateMedicala implements Serializable {
    @Id
    private String denumire;
    @Column
    private String adresa;
    @Column
    private String serviciiOfete;
    @Column
    private Double fond;

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getServiciiOfete() {
        return serviciiOfete;
    }

    public void setServiciiOfete(String serviciiOfete) {
        this.serviciiOfete = serviciiOfete;
    }

    public Double getFond() {
        return fond;
    }

    public void setFond(Double fond) {
        this.fond = fond;
    }
}
