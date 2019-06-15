package game.carta.pokemon.fire;

import game.carta.energia.Energia;
import game.carta.pokemon.Basic;
import game.habilidad.Habilidad;
import game.visitor.Visitor;

import java.util.ArrayList;

public class BasicFirePokemon extends PokemonFuego implements Basic {
    public BasicFirePokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades) {
        super(hp, id, energias, habilidades);
    }

    @Override
    public boolean isBasic(){return true;}

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPokemon(this);
    }
}
