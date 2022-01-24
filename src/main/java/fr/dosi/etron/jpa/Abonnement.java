package fr.dosi.etron.jpa;


import javax.persistence.*;
import java.util.List;

@Entity
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String type;
    Double frais;
    String typeCharge;
    Double tarifMin;
    Double tarifLanc;

    public Abonnement() {
    }

    public Abonnement(Long id, String type, Double frais, String typeCharge, Double tarifMin, Double tarifLanc) {
        this.id = id;
        this.type = type;
        this.frais = frais;
        this.typeCharge = typeCharge;
        this.tarifMin = tarifMin;
        this.tarifLanc = tarifLanc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Double getFrais() {
        return frais;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFrais(Double frais) {
        this.frais = frais;
    }

    public String getTypeCharge() {
        return typeCharge;
    }

    public Double getTarifMin() {
        return tarifMin;
    }

    public Double getTarifLanc() {
        return tarifLanc;
    }


    public void setTypeCharge(String typeCharge) {
        this.typeCharge = typeCharge;
    }

    public void setTarifMin(Double tarifMin) {
        this.tarifMin = tarifMin;
    }

    public void setTarifLanc(Double tarifLanc) {
        this.tarifLanc = tarifLanc;
    }

}
