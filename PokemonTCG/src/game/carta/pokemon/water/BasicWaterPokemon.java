package game.carta.pokemon.water;

import game.carta.energia.Energia;
import game.carta.pokemon.Basic;
import game.habilidad.Habilidad;

import java.util.ArrayList;

public class BasicWaterPokemon extends PokemonAgua implements Basic {
    public BasicWaterPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades){
        super(hp, id, energias, habilidades);
    }
}
