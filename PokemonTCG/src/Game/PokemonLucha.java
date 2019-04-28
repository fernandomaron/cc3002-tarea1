package Game;

import Game.AbstractPokemon;
import Game.Ataque;
import Game.Pokemon;

import java.util.ArrayList;

public class PokemonLucha extends AbstractPokemon {
    public PokemonLucha(){
        this.setHP(0);
        this.setID(0);
        this.setEnergias(new ArrayList<>());
        this.setHabilidades(new ArrayList<>());
    }

    public PokemonLucha (int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad>habilidades){
        this.setHP(hp);
        this.setID(id);
        this.setEnergias(energias);
        this.setHabilidades(habilidades);
    }

    public void atacarCon(Ataque ataque, Pokemon objetivo) {
        objetivo.atacadoPorLucha(ataque);
        this.checkHP();
    }

    @Override
    public void atacadoPorPsiquico(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg()*2);
        this.checkHP();
    }

    @Override
    public void atacadoPorPlanta(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg()*2);
        this.checkHP();
    }

    @Override
    public void atacadoPorLucha(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    @Override
    public void atacadoPorFuego(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    @Override
    public void atacadoPorElectrico(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    @Override
    public void atacadoPorAgua(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }
}
