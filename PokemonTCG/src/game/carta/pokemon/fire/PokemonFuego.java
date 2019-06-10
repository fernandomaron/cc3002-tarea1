package game.carta.pokemon;

import game.carta.energia.Energia;
import game.habilidad.Ataques.Ataque;
import game.habilidad.Habilidad;

import java.util.ArrayList;

/**
 * @author Fernando Maron
 * Class for fire type pokemons
 */
public class PokemonFuego extends AbstractPokemon {
    public PokemonFuego(){
        this(0,0,new ArrayList<>(), new ArrayList<>());
    }

    public PokemonFuego (int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad>habilidades){
        this.setHP(hp);
        this.setID(id);
        this.setEnergias(energias);
        this.setHabilidades(habilidades);
    }

    /**
     * @see Pokemon#atacarCon(Ataque, Pokemon)
     * @param ataque Attack the current pokemon will perform
     * @param objetivo This pokemon's target
     */
    public void atacarCon(Ataque ataque, Pokemon objetivo) {
        objetivo.atacadoPorFuego(ataque);
    }

    /**
     * @see Pokemon#atacadoPorPsiquico(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorPsiquico(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    /**
     * @see Pokemon#atacadoPorPlanta(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorPlanta(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    /**
     * @see Pokemon#atacadoPorLucha(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorLucha(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    /**
     * @see Pokemon#atacadoPorFuego(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorFuego(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    /**
     * @see Pokemon#atacadoPorElectrico(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorElectrico(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg());
        this.checkHP();
    }

    /**
     * @see Pokemon#atacadoPorAgua(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorAgua(Ataque ataque) {
        this.setHP(this.getHP()-ataque.getDmg()*2);
        this.checkHP();
    }
}
