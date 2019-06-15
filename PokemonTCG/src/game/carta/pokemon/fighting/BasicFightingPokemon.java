package game.carta.pokemon.fighting;

import game.carta.energia.Energia;
import game.carta.pokemon.Basic;
import game.habilidad.Habilidad;
import game.visitor.Visitor;

import java.util.ArrayList;

public class BasicFightingPokemon extends PokemonLucha implements Basic {
    public BasicFightingPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades) {
        super(hp, id, energias, habilidades);
    }

    @Override
    public boolean isBasic(){return true;}

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPokemon(this);
    }
}
