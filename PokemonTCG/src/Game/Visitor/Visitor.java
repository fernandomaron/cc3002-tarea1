package Game.Visitor;

import Game.Carta.Energia.Energia;
import Game.Carta.Estadio.Estadio;
import Game.Carta.Objeto.Objeto;
import Game.Carta.Pokemon.Pokemon;
import Game.Carta.Soporte.Soporte;

public interface Visitor {
    void visitObject(Objeto o);
    void visitStadium(Estadio s);
    void visitEnergy(Energia e);
    void visitPokemon(Pokemon p);
    void visitSupport(Soporte s);
}
