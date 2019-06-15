package game.habilidad;

import game.carta.pokemon.Pokemon;

import java.util.Observable;

/**
 * @author Fernando Maron
 * Interface that allows different types of abiliest to be called by the same methods.
 */
public abstract class Habilidad extends Observable {
    /**
     * Method that tells the ability who has used it, and against who.
     * @param usuario the pokemon that has used this ability
     *
     */
    public abstract void ejecutar(Pokemon usuario);

    public abstract void efecto(Pokemon usuario, Boolean b);
}
