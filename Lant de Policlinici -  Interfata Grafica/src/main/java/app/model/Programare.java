package app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "programare")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Programare implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsultatie;
    @Column
    private String unitate;
    @Column
    private Date zi;
    @Column
    private Time ora;

    public Integer getIdConsultatie() {
        return idConsultatie;
    }

    public void setIdConsultatie(Integer idConsultatie) {
        this.idConsultatie = idConsultatie;
    }

    public String getUnitate() {
        return unitate;
    }

    public void setUnitate(String unitate) {
        this.unitate = unitate;
    }

    public Time getOra() {
        return ora;
    }

    public void setOra(Time ora) {
        this.ora = ora;
    }
}
