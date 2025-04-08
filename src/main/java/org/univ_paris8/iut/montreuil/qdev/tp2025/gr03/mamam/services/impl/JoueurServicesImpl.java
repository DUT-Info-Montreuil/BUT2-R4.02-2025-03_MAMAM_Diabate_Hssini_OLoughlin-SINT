package org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.services.interfaces.JoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.utils.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class JoueurServicesImpl implements JoueurServices {

    private List<JoueurDTO> joueurs;

    public JoueurServicesImpl() {
        joueurs = new ArrayList<>();
    }

    @Override
    public JoueurDTO ajouterJoueur(String pseudo, Langue langue, String interets, String prenom , int annee_naissance) throws AjoutJoueurException {
        //vérifier pseudo
        for (JoueurDTO joueur : joueurs) if (joueur.getPseudo().equals(pseudo)) throw new PseudoExistantException();
        if (Pattern.matches("^\\d.*", pseudo)) throw new PseudoInvalideException();

        //vérifier interets
        if (Pattern.matches(".*,$", interets)) throw new InteretsInvalidesException();

        //ajout joueur à la liste
        JoueurDTO joueur = new JoueurDTO(pseudo, langue, interets, prenom, annee_naissance);
        joueurs.add(joueur);
        return joueur;
    }
}
