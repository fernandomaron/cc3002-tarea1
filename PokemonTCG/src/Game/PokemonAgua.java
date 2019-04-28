package Game;

import Game.AbstractPokemon;
import Game.Ataque;
import Game.Pokemon;

import java.util.ArrayList;

public class PokemonAgua extends AbstractPokemon {
    public PokemonAgua (){
        this.setHP(0);
        this.setID(0);
        this.setEnergias(new ArrayList<>());
        this.setHabilidades(new ArrayList<>());
    }
    public PokemonAgua (int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad>habilidades){
        this.setHP(hp);
        this.setID(id);
        this.setEnergias(energias);
        this.setHabilidades(habilidades);
    }

    @Override
    public void atacarCon(Ataque ataque, Pokemon objetivo) {
        objetivo.atacadoPorAgua(ataque);
    }

    @Override
    public void atacadoPorPsiquico(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
    }

    @Override
    public void atacadoPorPlanta(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg()*2);
    }

    @Override
    public void atacadoPorLucha(Ataque ataque) {
        this.setHP(this.getHP()-(Math.max(ataque.getDmg()-30,0)));
    }

    @Override
    public void atacadoPorFuego(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
    }

    @Override
    public void atacadoPorElectrico(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg()*2);
    }

    @Override
    public void atacadoPorAgua(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
    }
}
