package entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr3.jeuQuizz.entities.dto.QuestionnaireDTO;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.jeuQuizz.entities.dto.JoueurDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuizzDTO {

    private List<QuestionnaireDTO> listeQuestionnaires;
    private List<JoueurDTO> listeJoueurs;

    public QuizzDTO(List<QuestionnaireDTO> listeQuestionnaires, List<JoueurDTO> listeJoueurs) {
        this.listeQuestionnaires = listeQuestionnaires;
        this.listeJoueurs = listeJoueurs;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuizzDTO quizzDTO = (QuizzDTO) o;
        return Objects.equals(listeQuestionnaires, quizzDTO.listeQuestionnaires) && Objects.equals(listeJoueurs, quizzDTO.listeJoueurs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listeQuestionnaires, listeJoueurs);
    }
}
