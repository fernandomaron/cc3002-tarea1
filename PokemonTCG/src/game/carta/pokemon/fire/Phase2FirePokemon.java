package game.carta.pokemon.fire;

import game.carta.energia.Energia;
import game.carta.pokemon.Phase2;
import game.carta.pokemon.Pokemon;
import game.habilidad.Habilidad;
import game.visitor.Visitor;

import java.util.ArrayList;

public class Phase2FirePokemon extends PokemonFuego implements Phase2 {
    private int PreEvID;

    public Phase2FirePokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades, int preid){
        super(hp,id,energias,habilidades);
        PreEvID =preid;
    }

    @Override
    public void evolve2P2(Pokemon obj) {
        setEnergias(obj.getEnergias());
        obj.setEnergias(new ArrayList<>());
        getTrainer().Evolve(this);
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visitP2Pokemon(this);
    }

    @Override
    public int getPreEvID(){
        return PreEvID;
    }
}
