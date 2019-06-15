package game.carta.pokemon.grass;

import game.carta.energia.Energia;
import game.carta.pokemon.Basic;
import game.habilidad.Habilidad;
import game.visitor.Visitor;

import java.util.ArrayList;

public class BasicGrassPokemon extends PokemonPlanta implements Basic {
    public BasicGrassPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades) {
        super(hp, id, energias, habilidades);
    }

    @Override
    public boolean isBasic(){return true;}

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPokemon(this);
    }
}
