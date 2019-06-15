package game.carta.pokemon.psychic;

import game.carta.energia.Energia;
import game.carta.pokemon.Basic;
import game.habilidad.Habilidad;
import game.visitor.Visitor;

import java.util.ArrayList;

public class BasicPsychicPokemon extends PokemonPsiquico implements Basic {
    public BasicPsychicPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades) {
        super(hp, id, energias, habilidades);
    }

    @Override
    public boolean isBasic(){return true;}

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPokemon(this);
    }
}
