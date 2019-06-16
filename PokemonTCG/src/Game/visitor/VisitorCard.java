package game.visitor;

import game.Controller;
import game.carta.energia.Energia;
import game.carta.estadio.Estadio;
import game.carta.objeto.Objeto;
import game.carta.pokemon.Basic;
import game.carta.pokemon.Phase1;
import game.carta.pokemon.Phase2;
import game.carta.soporte.Soporte;

public interface VisitorCard {
    void visitObject(Objeto obj);
    void visitStadium(Estadio s);
    void visitEnergy(Energia e);
    void visitPokemon(Basic p);
    void visitSupport(Soporte s);
    void setCotroller(Controller control);
    void visitP1Pokemon(Phase1 phase1);
    void visitP2Pokemon(Phase2 phase2);
}
