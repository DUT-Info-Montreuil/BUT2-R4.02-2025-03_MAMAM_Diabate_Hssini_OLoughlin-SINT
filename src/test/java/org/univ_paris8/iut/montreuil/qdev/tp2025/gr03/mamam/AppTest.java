package org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import entities.dto.QuizzDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.services.impl.JoueurServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.utils.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.utils.exceptions.ListeJoueursVideException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.services.impl.QuestionnaireServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.utils.exceptions.ChargementFichierException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.utils.exceptions.FichierCorrompuException;
import services.impl.QuizzServicesImpl;
import services.interfaces.IQuizzServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class AppTest {

    private static IQuizzServices quizzServices;

    @Mock
    private QuestionnaireServicesImpl questionnaireServices;

    @Mock
    private JoueurServicesImpl joueurServices;

    @BeforeAll
    static void setUp() {
        quizzServices = new QuizzServicesImpl();
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void determinerElementsDispoPourUnePartieOK() throws ChargementFichierException, ListeJoueursVideException {
        QuestionDTO question1 = new QuestionDTO(1, "fr", "2 + 2 est égal à quoi ?", "4", 1, "2 + 2 = 4", "moi");
        QuestionDTO question2 = new QuestionDTO(2, "fr", "Cette phrase est écrite en quelle langue ?", "Français", 1, "C'est du français", "moi");

        List<QuestionDTO> listeQuestions = new ArrayList<>();
        listeQuestions.add(question1);
        listeQuestions.add(question2);

        QuestionnaireDTO questionnaire = new QuestionnaireDTO();
        questionnaire.add(listeQuestions);

        List<QuestionnaireDTO> listeQuestionnaires = new ArrayList<>();
        listeQuestionnaires.add(questionnaire);

        JoueurDTO joueur1 = new JoueurDTO("Maeve", Langue.FRANÇAIS, "natation", "Maeve", 2005);
        JoueurDTO joueur2 = new JoueurDTO("Maeve2", Langue.ANGLAIS, "cuisine, lecture", "Maeve", 2005);

        List<JoueurDTO> listeJoueurs = new ArrayList<>();
        listeJoueurs.add(joueur1);
        listeJoueurs.add(joueur2);

        when(questionnaireServices.fournirListeQuestionnaires("questionsQuizzOK.csv")).thenReturn(listeQuestionnaires);
        when(joueurServices.listerJoueurs()).thenReturn(listeJoueurs);

        QuizzDTO quizz = new QuizzDTO(listeQuestionnaires, listeJoueurs);

        assertEquals(quizz, quizzServices.determinerElementsDispoPourUnePartie("questionsQuizzOK.csv", questionnaireServices, joueurServices));
    }

    @Test
    public void determinerElementsDispoPourUnePartieFichierCorrompu() throws ChargementFichierException {
        when(questionnaireServices.fournirListeQuestionnaires("questionsQuizzCorrompu.csv")).thenThrow(FichierCorrompuException.class);

        assertThrows(FichierCorrompuException.class, () -> quizzServices.determinerElementsDispoPourUnePartie("questionsQuizzCorrompu.csv", questionnaireServices, joueurServices));
    }

    @Test
    public void determinerElementsDispoPourUnePartieListeJoueursVide() throws ChargementFichierException, ListeJoueursVideException {
        QuestionDTO question1 = new QuestionDTO(1, "fr", "2 + 2 est égal à quoi ?", "4", 1, "2 + 2 = 4", "moi");
        QuestionDTO question2 = new QuestionDTO(2, "fr", "Cette phrase est écrite en quelle langue ?", "Français", 1, "C'est du français", "moi");

        List<QuestionDTO> listeQuestions = new ArrayList<>();
        listeQuestions.add(question1);
        listeQuestions.add(question2);

        QuestionnaireDTO questionnaire = new QuestionnaireDTO();
        questionnaire.add(listeQuestions);

        List<QuestionnaireDTO> listeQuestionnaires = new ArrayList<>();
        listeQuestionnaires.add(questionnaire);

        when(questionnaireServices.fournirListeQuestionnaires("questionsQuizzOK.csv")).thenReturn(listeQuestionnaires);
        when(joueurServices.listerJoueurs()).thenThrow(ListeJoueursVideException.class);

        assertThrows(ListeJoueursVideException.class, () -> quizzServices.determinerElementsDispoPourUnePartie("questionsQuizzOK.csv", questionnaireServices, joueurServices));
    }
}
