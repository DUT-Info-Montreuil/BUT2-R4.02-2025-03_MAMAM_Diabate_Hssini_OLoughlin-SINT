package services.impl;

import entities.dto.QuizzDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.services.impl.JoueurServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.utils.exceptions.ListeJoueursVideException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.services.impl.QuestionnaireServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.utils.exceptions.ChargementFichierException;

import java.util.List;

public class QuizzServicesImpl {

    private QuestionnaireServicesImpl questionnaireServices;
    private JoueurServicesImpl joueurServices;

    public QuizzServicesImpl() {
        questionnaireServices = QuestionnaireServicesImpl.getInstance();
        joueurServices = new JoueurServicesImpl();
    }

    public QuizzDTO determinerElementsDispoPourUnePartieExcpetion(String lienVersFichierQuestionnaires) throws ChargementFichierException, ListeJoueursVideException {
        List<QuestionnaireDTO> listeQuestionnaires = questionnaireServices.fournirListeQuestionnaires(lienVersFichierQuestionnaires);
        List<JoueurDTO> listeJoueurs = joueurServices.listerJoueurs();
        QuizzDTO elementsDispoPourUnePartie = new QuizzDTO(listeQuestionnaires, listeJoueurs);
        return elementsDispoPourUnePartie;
    }

}
