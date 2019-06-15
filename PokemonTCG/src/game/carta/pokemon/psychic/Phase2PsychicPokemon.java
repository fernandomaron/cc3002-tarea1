package game.carta.pokemon.psychic;

import game.carta.energia.Energia;
import game.carta.pokemon.Phase2;
import game.carta.pokemon.Pokemon;
import game.habilidad.Habilidad;
import game.visitor.Visitor;

import java.util.ArrayList;

public class Phase2PsychicPokemon extends PokemonPsiquico implements Phase2 {

    public Phase2PsychicPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades, int preid){
        super(hp,id,energias,habilidades);
        this.setPreEvID(preid);    }

    @Override
    public void accept(Visitor visitor){
        visitor.visitP2Pokemon(this);
    }

    @Override
    public boolean isPhase2(){return true;}
}
