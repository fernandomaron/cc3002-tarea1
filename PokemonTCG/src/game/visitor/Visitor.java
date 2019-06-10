package game.visitor;

import game.carta.energia.Energia;
import game.carta.estadio.Estadio;
import game.carta.objeto.Objeto;
import game.carta.pokemon.Pokemon;
import game.carta.soporte.Soporte;

public interface Visitor {
    void visitObject(Objeto o);
    void visitStadium(Estadio s);
    void visitEnergy(Energia e);
    void visitPokemon(Pokemon p);
    void visitSupport(Soporte s);
}
