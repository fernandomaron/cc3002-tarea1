package Game;

import Game.AbstractPokemon;
import Game.Ataque;
import Game.Pokemon;

import java.util.ArrayList;

public class PokemonPlanta extends AbstractPokemon {
    public PokemonPlanta(){
        this(0,0,new ArrayList<>(), new ArrayList<>());
    }

    public PokemonPlanta (int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad>habilidades){
        this.setHP(hp);
        this.setID(id);
        this.setEnergias(energias);
        this.setHabilidades(habilidades);
    }

    public void atacarCon(Ataque ataque, Pokemon objetivo) {
        objetivo.atacadoPorPlanta(ataque);
    }

    @Override
    public void atacadoPorPsiquico(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    @Override
    public void atacadoPorPlanta(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    @Override
    public void atacadoPorLucha(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    @Override
    public void atacadoPorFuego(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg()*2);
        this.checkHP();
    }

    @Override
    public void atacadoPorElectrico(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    @Override
    public void atacadoPorAgua(Ataque ataque) {
        this.setHP(this.getHP()-(Math.max(ataque.getDmg()-30,0)));
        this.checkHP();
    }
}
