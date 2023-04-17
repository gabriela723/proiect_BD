package app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "salarii")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BonFiscal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer idConsultatie;
    @Column
    private String idReceptioner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdConsultatie() {
        return idConsultatie;
    }

    public void setIdConsultatie(Integer idConsultatie) {
        this.idConsultatie = idConsultatie;
    }

    public String getIdReceptioner() {
        return idReceptioner;
    }

    public void setIdReceptioner(String idReceptioner) {
        this.idReceptioner = idReceptioner;
    }
}
