package Game.Visitor;

import Game.Carta.Energia.Energia;
import Game.Carta.Estadio.Estadio;
import Game.Carta.Objeto.Objeto;
import Game.Carta.Pokemon.Pokemon;
import Game.Carta.Soporte.Soporte;
import Game.Entrenador;

public class visitCard implements Visitor{
    private Entrenador Trainer;

    public visitCard(Entrenador e){
        Trainer=e;
    }
    @Override
    public void visitObject(Objeto o) {

    }

    @Override
    public void visitStadium(Estadio s) {

    }

    @Override
    public void visitEnergy(Energia e) {

    }

    @Override
    public void visitPokemon(Pokemon p) {

    }

    @Override
    public void visitSupport(Soporte s) {

    }
}
