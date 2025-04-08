package org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.utils.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.utils.exceptions.*;

public interface JoueurServices {
    JoueurDTO ajouterJoueur(String pseudo, Langue langue, String interets, String prenom , int annee_naissance) throws AjoutJoueurException;
}
