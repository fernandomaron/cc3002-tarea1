package game.carta.pokemon.grass;

import game.carta.energia.Energia;
import game.carta.pokemon.Phase2;
import game.habilidad.Habilidad;
import game.visitor.VisitorCard;

import java.util.ArrayList;

public class Phase2GrassPokemon extends PokemonPlanta implements Phase2 {

    public Phase2GrassPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades, int preid){
        super(hp,id,energias,habilidades);
        this.setPreEvID(preid);
    }

    @Override
    public void accept(VisitorCard visitor){
        visitor.visitP2Pokemon(this);
    }

    @Override
    public boolean isPhase2(){return true;}
}
