package game.carta.pokemon.electric;

import game.carta.energia.Energia;
import game.carta.pokemon.Phase1;
import game.habilidad.Habilidad;
import game.visitor.VisitorCard;

import java.util.ArrayList;

public class Phase1ElectricPokemon extends PokemonElectrico implements Phase1 {

    public Phase1ElectricPokemon(int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad> habilidades, int preid){
        super(hp,id,energias,habilidades);
        this.setPreEvID(preid);
    }

    @Override
    public void accept(VisitorCard visitor){
        visitor.visitP1Pokemon(this);
    }

    @Override
    public boolean isPhase1(){return true;}
}
