package game.carta.pokemon.water;

import game.carta.energia.Energia;
import game.carta.pokemon.AbstractPokemon;
import game.carta.pokemon.Pokemon;
import game.habilidad.Ataques.Ataque;
import game.habilidad.Habilidad;

import java.util.ArrayList;

/**
 * @author Fernando Maron
 * Class for water type pokemons
 */
public abstract class PokemonAgua extends AbstractPokemon {
    public PokemonAgua (){
        this(0,0,new ArrayList<>(), new ArrayList<>());
    }
    public PokemonAgua (int hp, int id, ArrayList<Energia> energias, ArrayList<Habilidad>habilidades){
        this.setHP(hp);
        this.setID(id);
        this.setEnergias(energias);
        this.setHabilidades(habilidades);
    }

    /**
     * @see Pokemon#atacarCon(Ataque)
     * @param ataque Attack the current pokemon will perform
     */
    @Override
    public void atacarCon(Ataque ataque) {
        this.getObjetivo().atacadoPorAgua(ataque);
    }

    /**
     * @see Pokemon#atacadoPorPsiquico(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorPsiquico(Ataque ataque) {
        this.setHP(this.getDMGCounter()-ataque.getDmg());
    }

    /**
     * @see Pokemon#atacadoPorPlanta(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorPlanta(Ataque ataque) {
        this.setDMGCounter(this.getDMGCounter()-ataque.getDmg()*2);
        this.checkHP();
    }

    /**
     * @see Pokemon#atacadoPorLucha(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorLucha(Ataque ataque) {
        this.setDMGCounter(this.getDMGCounter()-(Math.max(ataque.getDmg()-30,0)));
        this.checkHP();
    }

    /**
     * @see Pokemon#atacadoPorFuego(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorFuego(Ataque ataque) {
        this.setDMGCounter(this.getDMGCounter()-ataque.getDmg());
        this.checkHP();
    }

    /**
     * @see Pokemon#atacadoPorElectrico(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorElectrico(Ataque ataque) {
        this.setDMGCounter(this.getDMGCounter()-ataque.getDmg()*2);
        this.checkHP();
    }

    /**
     * @see Pokemon#atacadoPorAgua(Ataque)
     * @param ataque Attack the current pokemon is receiving
     */
    @Override
    public void atacadoPorAgua(Ataque ataque) {
        this.setDMGCounter(this.getDMGCounter()-ataque.getDmg());
        this.checkHP();
    }
}
