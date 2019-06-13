package game.visitor;

import game.Controller;
import game.Entrenador;
import game.carta.energia.Energia;
import game.carta.estadio.Estadio;
import game.carta.objeto.Objeto;
import game.carta.pokemon.Phase1;
import game.carta.pokemon.Pokemon;
import game.carta.pokemon.water.Phase1WaterPokemon;
import game.carta.soporte.Soporte;

public interface Visitor {
    void visitObject(Objeto obj);
    void visitStadium(Estadio s);
    void visitEnergy(Energia e);
    void visitPokemon(Pokemon p);
    void visitSupport(Soporte s);
    void setCotroller(Controller control);
    void visitP1Pokemon(Phase1 phase1);
}
