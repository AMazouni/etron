package fr.dosi.etron.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Temporal(TemporalType.DATE)
    Date date;
    String description;
    Double sommePayee;
    Double sommeDue;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties("factures")
    Contrat contrat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSommePayee() {
        return sommePayee;
    }

    public void setSommePayee(Double swsommePayee) {
        this.sommePayee = swsommePayee;
    }

    public Double getSommeDue() {
        return sommeDue;
    }

    public void setSommeDue(Double sommeDue) {
        this.sommeDue = sommeDue;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }
}
