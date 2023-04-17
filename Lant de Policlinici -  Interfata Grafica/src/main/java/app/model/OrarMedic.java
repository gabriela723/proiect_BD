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
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "orar_medic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrarMedic implements Serializable {
    @Id
    private String idMedic;
    @Column
    private Time oraStart;
    @Column
    private Time oraFinal;
    @Column
    private Date zi;
    @Column
    private String unitate;

    public String getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(String idMedic) {
        this.idMedic = idMedic;
    }

    public Time getOraStart() {
        return oraStart;
    }

    public void setOraStart(Time oraStart) {
        this.oraStart = oraStart;
    }

    public Time getOraFinal() {
        return oraFinal;
    }

    public void setOraFinal(Time oraFinal) {
        this.oraFinal = oraFinal;
    }

    public Date getZi() {
        return zi;
    }

    public void setZi(Date zi) {
        this.zi = zi;
    }

    public String getUnitate() {
        return unitate;
    }

    public void setUnitate(String unitate) {
        this.unitate = unitate;
    }
}
