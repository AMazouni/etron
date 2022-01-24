package fr.dosi.etron.jpa;

import javax.persistence.*;

@Entity
public class PtChargeAbonn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    PointCharge pointCharge;
    @ManyToOne
    Abonnement abonnement;

    public PtChargeAbonn() {
    }

    public PtChargeAbonn(Long id, PointCharge pointCharge, Abonnement abonnement) {
        this.id = id;
        this.pointCharge = pointCharge;
        this.abonnement = abonnement;
    }

    public Long getId() {
        return id;
    }

    public PointCharge getPointCharge() {
        return pointCharge;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPointCharge(PointCharge pointCharge) {
        this.pointCharge = pointCharge;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }
}
