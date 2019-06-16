package game.carta.pokemon.water;

import game.carta.energia.Energia;
import game.carta.pokemon.Phase2;
import game.carta.pokemon.Pokemon;
import game.habilidad.Habilidad;
import game.visitor.VisitorCard;

import java.util.ArrayList;

public class Phase2WaterPokemon extends PokemonAgua implements Phase2 {

    public Phase2WaterPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades, int preid){
        super(hp,id,energias,habilidades);
        this.setPreEvID(preid);
    }

    @Override
    public void evolve(Pokemon obj) {
        setEnergias(obj.getEnergias());
        obj.setEnergias(new ArrayList<>());
        getTrainer().Evolve(this);
    }

    @Override
    public void accept(VisitorCard visitor){
        visitor.visitP2Pokemon(this);
    }

    @Override
    public boolean isPhase2(){return true;}
}
