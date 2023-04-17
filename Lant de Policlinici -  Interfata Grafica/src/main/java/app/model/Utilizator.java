package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "utilizator")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(
        {@NamedQuery(name = "findPersonByName", query = "from Person pers where pers.name = :name"),
                @NamedQuery(name = "findPersonByNameAndPassword", query = "from Person pers where pers.name = :name and pers.password=:password"),
                @NamedQuery(name = "findPersonById", query = "from Person pers where pers.id = :id"),
                @NamedQuery(name = "findAllPersons", query = "from Person")
        }
)
public class Utilizator implements Serializable {
    @Id
    private String CNP;
    @Column
    private String parola;
    @Column
    private String nume;
    @Column
    private String prenume;
    @Column
    private String adresa;
    @Column
    private String nrTelefon;
    @Column
    private String email;
    @Column
    private String IBAN;
    @Column
    private String nrContract;
    @Column
    private Date dataAngajarii;
    @Column
    private String functia;
    @Column
    private Double salariuNeg;
    @Column
    private Integer ore;
    @Column
    private Date concediuStart;
    @Column
    private Date concediuFinal;

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getNrContract() {
        return nrContract;
    }

    public void setNrContract(String nrContract) {
        this.nrContract = nrContract;
    }

    public Date getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(Date dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public String getFunctia() {
        return functia;
    }

    public void setFunctia(String functia) {
        this.functia = functia;
    }

    public Double getSalariuNeg() {
        return salariuNeg;
    }

    public void setSalariuNeg(Double salariuNeg) {
        this.salariuNeg = salariuNeg;
    }

    public Integer getOre() {
        return ore;
    }

    public void setOre(Integer ore) {
        this.ore = ore;
    }

    public Date getConcediuStart() {
        return concediuStart;
    }

    public void setConcediuStart(Date concediuStart) {
        this.concediuStart = concediuStart;
    }

    public Date getConcediuFinal() {
        return concediuFinal;
    }

    public void setConcediuFinal(Date concediuFinal) {
        this.concediuFinal = concediuFinal;
    }
}
