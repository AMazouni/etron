package fr.dosi.etron.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarifs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    String typeCharge;
    Double tarifMin;
    Double tarifLanc;

    public Tarifs() {

    }

    public Tarifs(Long id, String typeCharge, Double tarifMin, Double tarifLanc) {
        Id = id;
        this.typeCharge = typeCharge;
        this.tarifMin = tarifMin;
        this.tarifLanc = tarifLanc;

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTypeCharge() {
        return typeCharge;
    }

    public void setTypeCharge(String typeCharge) {
        this.typeCharge = typeCharge;
    }

    public Double getTarifMin() {
        return tarifMin;
    }

    public void setTarifMin(Double tarifMin) {
        this.tarifMin = tarifMin;
    }

    public Double getTarifLanc() {
        return tarifLanc;
    }

    public void setTarifLanc(Double tarifLanc) {
        this.tarifLanc = tarifLanc;
    }

    @Override
    public String toString() {
        return "Tarifs{" +
                "Id=" + Id +
                ", typeCharge='" + typeCharge + '\'' +
                ", tarifMin=" + tarifMin +
                ", tarifLanc=" + tarifLanc +
                '}';
    }
}
