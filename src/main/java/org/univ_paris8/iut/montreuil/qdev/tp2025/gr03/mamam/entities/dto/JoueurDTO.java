package org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.entities.dto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.utils.Langue;

public class JoueurDTO {
    private String pseudo;
    private Langue langue;
    private  String prenom;
    private int annee_naissance;
    private String interets;
    public JoueurDTO(String pseudo, Langue langue, String interets, String prenom , int annee_naissance){
        this.pseudo=pseudo;
        this.langue=langue;
        this.interets=interets;
        this.prenom=prenom;
        this.annee_naissance=annee_naissance;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAnnee_naissance() {
        return annee_naissance;
    }

    public void setAnnee_naissance(int annee_naissance) {
        this.annee_naissance = annee_naissance;
    }

    public String getInterets() {
        return interets;
    }

    public void setInterets(String interets) {
        this.interets = interets;
    }
}
