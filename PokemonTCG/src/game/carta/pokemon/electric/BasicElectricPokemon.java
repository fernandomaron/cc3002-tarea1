package game.carta.pokemon.electric;

import game.carta.energia.Energia;
import game.carta.pokemon.Basic;
import game.habilidad.Habilidad;
import game.visitor.Visitor;

import java.util.ArrayList;

public class BasicElectricPokemon extends PokemonElectrico implements Basic {
    public BasicElectricPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades) {
        super(hp, id, energias, habilidades);
    }

    @Override
    public boolean isBasic(){return true;}

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPokemon(this);
    }
}
