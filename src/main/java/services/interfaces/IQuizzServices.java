package services.interfaces;

import entities.dto.QuizzDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.utils.exceptions.ListeJoueursVideException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.utils.exceptions.ChargementFichierException;

public interface IQuizzServices {

    QuizzDTO determinerElementsDispoPourUnePartieExcpetion(String lienVersFichierQuestionnaires) throws ChargementFichierException, ListeJoueursVideException;

}
