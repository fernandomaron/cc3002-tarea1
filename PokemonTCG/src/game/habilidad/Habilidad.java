package game.habilidad;

import game.Entrenador;
import game.carta.pokemon.Pokemon;

/**
 * @author Fernando Maron
 * Interface that allows different types of abiliest to be called by the same methods.
 */
public interface Habilidad {
    /**
     * Method that tells the ability who has used it, and against who.
     * @param usuario the pokemon that has used this ability
     *
     */
    void ejecutar(Pokemon usuario);

    void efecto(Pokemon usuario);
}
