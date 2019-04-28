package Game;

/**
 * @author Fernando Maron
 * This interface was created in order to work with both energies and pokemon as the same entity by the trainer
 */

public interface Carta {
    /**
     * This method allows the interaction between trainer and card
     * @param entrenador it asks for a trainer parameter in order to establish which trainer has being assigned
     *                   to the card, so it can use it's effects accordingly.
     */
    void jugar(Entrenador entrenador);

}
