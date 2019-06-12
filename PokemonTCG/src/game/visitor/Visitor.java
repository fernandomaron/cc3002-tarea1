package game.visitor;

import game.carta.energia.Energia;
import game.carta.estadio.E;
import game.carta.objeto.O;
import game.carta.pokemon.Pokemon;
import game.carta.soporte.Soporte;

public interface Visitor {
    void visitObject(O o);
    void visitStadium(E s);
    void visitEnergy(Energia e);
    void visitPokemon(Pokemon p);
    void visitSupport(Soporte s);
}
