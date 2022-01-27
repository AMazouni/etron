package fr.dosi.etron.dto;

import fr.dosi.etron.jpa.Voiture;

public class AbonnementDTO {

    Long clientID;
    String voitureREF;
    String typeAbonnement;

    public AbonnementDTO() {
    }

    public AbonnementDTO(Long clientID, String voitureREF, String typeAbonnement) {
        this.clientID = clientID;
        this.voitureREF = voitureREF;
        this.typeAbonnement = typeAbonnement;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getVoitureREF() {
        return voitureREF;
    }

    public void setVoitureREF(String voitureREF) {
        this.voitureREF = voitureREF;
    }

    public String getTypeAbonnement() {
        return typeAbonnement;
    }

    public void setTypeAbonnement(String typeAbonnement) {
        this.typeAbonnement = typeAbonnement;
    }
}
