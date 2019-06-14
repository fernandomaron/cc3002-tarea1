package game.carta.pokemon.fire;

import game.carta.energia.Energia;
import game.carta.pokemon.Phase1;
import game.carta.pokemon.Pokemon;
import game.habilidad.Habilidad;
import game.visitor.Visitor;

import java.util.ArrayList;

public class Phase1FirePokemon extends PokemonFuego implements Phase1{
    private int PreEvID;

    public Phase1FirePokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades, int preid){
        super(hp,id,energias,habilidades);
        PreEvID =preid;
    }

    @Override
    public void evolve2P1(Pokemon obj) {
        setEnergias(obj.getEnergias());
        obj.setEnergias(new ArrayList<>());
        getTrainer().Evolve(this);
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visitP1Pokemon(this);
    }

    @Override
    public int getPreEvID(){
        return PreEvID;
    }
}
