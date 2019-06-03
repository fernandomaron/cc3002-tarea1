package Game.Habilidad;

import Game.Carta.Pokemon.Pokemon;

/**
 * @author Fernando Maron
 * Interface that allows different types of abiliest to be called by the same methods.
 */
public interface Habilidad {
    /**
     * Method that tells the ability who has used it, and against who.
     * @param usuario the pokemon that has used this ability
     * @param objetivo the pokemon that will take the effects of the ability
     */
    void ejecutar(Pokemon usuario, Pokemon objetivo);
}
