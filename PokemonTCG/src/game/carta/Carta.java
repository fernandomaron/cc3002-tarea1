package game.carta;

import game.Entrenador;
import game.visitor.VisitorCard;

/**
 * @author Fernando Maron
 * This interface was created in order to work with both energies and pokemon as the same entity by the trainer
 */

public interface Carta {
    /**
     * This method allows the interaction between trainer and card
     */
    void accept(VisitorCard visitor);
    void setTrainer(Entrenador entrenador);
    Entrenador getTrainer();

}
