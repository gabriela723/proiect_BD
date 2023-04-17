package app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "program_unitate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramUnitate implements Serializable {
    @Id
    private Integer id;
    @Column
    private String zi;
    @Column
    private Time oraDeschidere;
    @Column
    private Time oraInchidere;
    @Column
    private String unitate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public Time getOraDeschidere() {
        return oraDeschidere;
    }

    public void setOraDeschidere(Time oraDeschidere) {
        this.oraDeschidere = oraDeschidere;
    }

    public Time getOraInchidere() {
        return oraInchidere;
    }

    public void setOraInchidere(Time oraInchidere) {
        this.oraInchidere = oraInchidere;
    }

    public String getUnitate() {
        return unitate;
    }

    public void setUnitate(String unitate) {
        this.unitate = unitate;
    }
}
