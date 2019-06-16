package game.carta.pokemon.electric;

import game.carta.energia.Energia;
import game.carta.pokemon.Basic;
import game.habilidad.Habilidad;
import game.visitor.VisitorCard;

import java.util.ArrayList;

public class BasicElectricPokemon extends PokemonElectrico implements Basic {
    public BasicElectricPokemon(){super();}

    public BasicElectricPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades) {
        super(hp, id, energias, habilidades);
    }

    @Override
    public boolean isBasic(){return true;}

    @Override
    public void accept(VisitorCard visitor) {
        visitor.visitPokemon(this);
    }
}
