package fr.dosi.etron.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class PointCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String type;
    Double tarifMin;
    Double tarifLanc;
    Integer puissance;
    @OneToMany
    List<PtChargeAbonn> ptChargeAbonn;

    public PointCharge() {
    }

    public PointCharge(Long id, String type, Double tarifMin, Double tarifLanc, Integer puissance, List<PtChargeAbonn> ptChargeAbonn) {
        this.id = id;
        this.type = type;
        this.tarifMin = tarifMin;
        this.tarifLanc = tarifLanc;
        this.puissance = puissance;
        this.ptChargeAbonn = ptChargeAbonn;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Double getTarifMin() {
        return tarifMin;
    }

    public Double getTarifLanc() {
        return tarifLanc;
    }

    public Integer getPuissance() {
        return puissance;
    }

    public List<PtChargeAbonn> getPtChargeAbonn() {
        return ptChargeAbonn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTarifMin(Double tarifMin) {
        this.tarifMin = tarifMin;
    }

    public void setTarifLanc(Double tarifLanc) {
        this.tarifLanc = tarifLanc;
    }

    public void setPuissance(Integer puissance) {
        this.puissance = puissance;
    }

    public void setPtChargeAbonn(List<PtChargeAbonn> ptChargeAbonn) {
        this.ptChargeAbonn = ptChargeAbonn;
    }
}
