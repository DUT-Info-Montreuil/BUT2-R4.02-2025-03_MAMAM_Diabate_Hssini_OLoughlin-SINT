package services.impl;

import entities.dto.QuizzDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.services.impl.JoueurServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.services.interfaces.JoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.utils.exceptions.ListeJoueursVideException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.services.impl.QuestionnaireServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.utils.exceptions.ChargementFichierException;
import services.interfaces.IQuizzServices;

import java.util.List;

public class QuizzServicesImpl implements IQuizzServices {

    public QuizzDTO determinerElementsDispoPourUnePartie(String lienVersFichierQuestionnaires, QuestionnaireServicesImpl questionnaireServices, JoueurServicesImpl joueurServices) throws ChargementFichierException, ListeJoueursVideException {
        List<QuestionnaireDTO> listeQuestionnaires = questionnaireServices.fournirListeQuestionnaires(lienVersFichierQuestionnaires);
        List<JoueurDTO> listeJoueurs = joueurServices.listerJoueurs();
        return new QuizzDTO(listeQuestionnaires, listeJoueurs);
    }

}
