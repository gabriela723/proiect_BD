package app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "inspector_resurse_umane")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InspectorResurseUmane implements Serializable {
    @Id
    private String idInspector;

    public String getIdInspector() {
        return idInspector;
    }

    public void setIdInspector(String idInspector) {
        this.idInspector = idInspector;
    }
}
