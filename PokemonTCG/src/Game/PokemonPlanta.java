package Game;

import Game.AbstractPokemon;
import Game.Ataque;
import Game.Pokemon;

import java.util.ArrayList;

public class PokemonPlanta extends AbstractPokemon {
    public PokemonPlanta(){
        HP=0;
        ID=0;
        Energias= new ArrayList<>();
        Habilidades= new ArrayList<>();
    }

    public PokemonPlanta (int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad>habilidades){
        HP=hp;
        ID=id;
        Energias= energias;
        Habilidades= habilidades;
    }

    public void atacarCon(Ataque ataque, Pokemon objetivo) {
        objetivo.atacadoPorPlanta(ataque);
    }

    @Override
    public void atacadoPorPsiquico(Ataque ataque) {
        HP-=ataque.getDmg();
    }

    @Override
    public void atacadoPorPlanta(Ataque ataque) {
        HP-=ataque.getDmg();
    }

    @Override
    public void atacadoPorLucha(Ataque ataque) {
        HP-=ataque.getDmg();
    }

    @Override
    public void atacadoPorFuego(Ataque ataque) {
        HP-=ataque.getDmg()*2;
    }

    @Override
    public void atacadoPorElectrico(Ataque ataque) {
        HP-=ataque.getDmg();
    }

    @Override
    public void atacadoPorAgua(Ataque ataque) {
        HP-=ataque.getDmg()-30;
    }
}
