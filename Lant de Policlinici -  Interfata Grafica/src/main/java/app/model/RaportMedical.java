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
@Table(name = "raport_medical")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RaportMedical implements Serializable {
    @Id
    private String idRaport;
    @Column
    private String idAsistent;
    @Column
    private Integer idConsultatie;
    @Column
    private String istoric;
    @Column
    private String simptome;
    @Column
    private String diagnostic;
    @Column
    private String recomandari;
    @Column
    private String codParafa;

    public String getIdRaport() {
        return idRaport;
    }

    public void setIdRaport(String idRaport) {
        this.idRaport = idRaport;
    }

    public String getIdAsistent() {
        return idAsistent;
    }

    public void setIdAsistent(String idAsistent) {
        this.idAsistent = idAsistent;
    }

    public Integer getIdConsultatie() {
        return idConsultatie;
    }

    public void setIdConsultatie(Integer idConsultatie) {
        this.idConsultatie = idConsultatie;
    }

    public String getIstoric() {
        return istoric;
    }

    public void setIstoric(String istoric) {
        this.istoric = istoric;
    }

    public String getSimptome() {
        return simptome;
    }

    public void setSimptome(String simptome) {
        this.simptome = simptome;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getRecomandari() {
        return recomandari;
    }

    public void setRecomandari(String recomandari) {
        this.recomandari = recomandari;
    }

    public String getCodParafa() {
        return codParafa;
    }

    public void setCodParafa(String codParafa) {
        this.codParafa = codParafa;
    }
}
