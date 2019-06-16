package game.carta.pokemon.electric;

import game.carta.energia.Energia;
import game.carta.pokemon.Phase2;
import game.habilidad.Habilidad;
import game.visitor.VisitorCard;

import java.util.ArrayList;

public class Phase2ElectricPokemon extends PokemonElectrico implements Phase2{

    public Phase2ElectricPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades, int preid){
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
