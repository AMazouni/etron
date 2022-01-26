package fr.dosi.etron.jpa;

import javax.persistence.*;

@Entity
public class Tarifs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Double type;
    Double tarifMin;
    Double tarifLanc;
    @ManyToOne
    Abonnement abonnement;

    public Tarifs() {
    }

    public Tarifs(Long id, Double type, Double tarifMin, Double tarifLanc) {
        this.id = id;
        this.type = type;
        this.tarifMin = tarifMin;
        this.tarifLanc = tarifLanc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(Double type) {
        this.type = type;
    }

    public void setTarifMin(Double tarifMin) {
        this.tarifMin = tarifMin;
    }

    public void setTarifLanc(Double tarifLanc) {
        this.tarifLanc = tarifLanc;
    }

    public Long getId() {
        return id;
    }

    public Double getType() {
        return type;
    }

    public Double getTarifMin() {
        return tarifMin;
    }

    public Double getTarifLanc() {
        return tarifLanc;
    }
}
