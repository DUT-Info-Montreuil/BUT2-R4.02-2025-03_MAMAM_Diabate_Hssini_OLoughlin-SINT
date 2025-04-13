package services.interfaces;

import entities.dto.QuizzDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.services.impl.JoueurServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.utils.exceptions.ListeJoueursVideException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.services.impl.QuestionnaireServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.utils.exceptions.ChargementFichierException;

public interface IQuizzServices {

    QuizzDTO determinerElementsDispoPourUnePartie(String lienVersFichierQuestionnaires, QuestionnaireServicesImpl questionnaireServices, JoueurServicesImpl joueurServices) throws ChargementFichierException, ListeJoueursVideException;

}
