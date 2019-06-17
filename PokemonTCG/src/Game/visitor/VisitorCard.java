package game.visitor;

import game.Controller;
import game.Entrenador;
import game.carta.energia.Energia;
import game.carta.estadio.Estadio;
import game.carta.objeto.Objeto;
import game.carta.pokemon.Basic;
import game.carta.pokemon.Phase1;
import game.carta.pokemon.Phase2;
import game.carta.soporte.Soporte;

/**
 * @author Fernando Maron
 */
public interface VisitorCard {
    /**
     * Method that allows to remove the used card of the trainer from it's hand
     * @param trainer the trainer that will remove it's card
     */
    void removeCard(Entrenador trainer);

    /**
     * Method that allows to discard the used card of the trainer from it's hand
     * @param trainer the trainer that will discard it's card
     */
    void discardCard(Entrenador trainer);

    /**
     * Method that receives an item card and uses it's effects
     * @param obj the item card that was played
     */
    void visitObject(Objeto obj);

    /**
     * Method that receives a stadium card and uses it's effects
     * @param s the stadium card the was played
     */
    void visitStadium(Estadio s);

    /**
     * Method that receives an energy card adds it to it's trainer's target pokemon
     * @param e the energy card the was played
     */
    void visitEnergy(Energia e);

    /**
     * Method that receives a Basic pokemon card and adds it to it's trainer's bench or sets
     * it as the active pokemon
     * @param p the pokemon card the was played
     */
    void visitPokemon(Basic p);

    /**
     * Method that receives a support card and uses it's effects
     * @param s the support card the was played
     */
    void visitSupport(Soporte s);

    /**
     * Sets the visitor's controller, allowing it to communicate with the controller
     * @param control the game controller that uses this visitor
     */
    void setCotroller(Controller control);

    /**
     * Method that receives a phase 1 pokemon card and tries to evolve it's trainer's target pokemon
     * to it
     * @param phase1 the stadium card the was played
     */
    void visitP1Pokemon(Phase1 phase1);

    /**
     * Method that receives a phase 2 pokemon card and tries to evolve it's trainer's target pokemon
     * to it
     * @param phase2 the stadium card the was played
     */
    void visitP2Pokemon(Phase2 phase2);

}
