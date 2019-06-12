package game.carta.pokemon;

import game.carta.Carta;
import game.carta.energia.Energia;
import game.habilidad.Ataques.Ataque;
import game.Entrenador;
import game.habilidad.Habilidad;

import java.util.ArrayList;

/**
 * @author Fernando Maron
 * Interface for the pokemons, allowing them to be called by the same methods even if they are of different types
 */
public interface Pokemon extends Carta {
    /**
     * Method that checks whether the pokemon has enough energies to use an ability
     * @param costo the energy cost of an ability
     * @return True if the pokemon has the amount of energies asked, False if not.
     */
    boolean hasEnergy(ArrayList<Energia> costo);

    /**
     * Method that allows to add an energy to a pokemon.
     * @param energia the energy that will be added to the pokemon.
     */
    void agregarEnergia(Energia energia);

    /**
     * Method that tells whether the pokemon in question is a valid pokemon, or one of the null type
     * @return True if it's a PokemonNull, False if not
     */
    boolean isNull();

    /**
     * This method tells the pokemon that will be attacked, with which attack and depending of which subclass
     * of pokemon, i.e. type, the method that should be called by the targeted pokemon.
     * @param ataque the attack that the pokemon will perform
     * @param objetivo the pokemon that will receive said attack
     */
    void atacarCon(Ataque ataque);

    /**
     * Method that performs a psychic attack against the current pokemon, adding the corresponding effectiveness
     * and resistance if needed
     * @param ataque the attack used against the pokemon
     */
    void atacadoPorPsiquico(Ataque ataque);

    /**
     * Method that performs a grass attack against the current pokemon, adding the corresponding effectiveness
     * and resistance if needed
     * @param ataque the attack used against the pokemon
     */
    void atacadoPorPlanta(Ataque ataque);

    /**
     * Method that performs a fighting attack against the current pokemon, adding the corresponding effectiveness
     * and resistance if needed
     * @param ataque the attack used against the pokemon
     */
    void atacadoPorLucha(Ataque ataque);

    /**
     * Method that performs a fire attack against the current pokemon, adding the corresponding effectiveness
     * and resistance if needed
     * @param ataque the attack used against the pokemon
     */
    void atacadoPorFuego(Ataque ataque);

    /**
     * Method that performs a electric attack against the current pokemon, adding the corresponding effectiveness
     * and resistance if needed
     * @param ataque the attack used against the pokemon
     */
    void atacadoPorElectrico(Ataque ataque);

    /**
     * Method that performs a water attack against the current pokemon, adding the corresponding effectiveness
     * and resistance if needed
     * @param ataque the attack used against the pokemon
     */
    void atacadoPorAgua(Ataque ataque);

    /**
     * This method allows to see which abilities the current pokemon has
     * @return
     */
    ArrayList<Habilidad> getHabilidades();

    /**
     * This method tells the pokemon which ability to use, and against whom
     * @param habilidad the ability that's going to be used
     * @param objetivo the target of said ability
     */
    void usar(Habilidad habilidad, Pokemon objetivo);

    /**
     * Method that allows to know the pokemon's current health
     * @return the pokemon's health
     */
    int getHP();

    /**
     * Method that allows to know the pokemon's ID
     * @return the pokemon's ID
     */
    int getID();

    /**
     * Method that allows to set the pokemon's health to a certain value
     * @param hp the new health that the pokemon will have
     */
    void setHP(int hp);

    /**
     * Method that allows to set the pokemon's ID to a certain value
     * @param id the new ID that the pokemon will have
     */
    void setID(int id);

    /**
     * This method allows to give a list of abilities (up to 4) to a pokemon so it can then perform them
     * @param habilidades the list of abilities. If given more than 4 abilities, it will only
     *                    give the pokemon the first 4.
     */
    void setHabilidades(ArrayList<Habilidad> habilidades);

    /**
     * This method tells the pokemon's trainer to check if this pokemon has been K.Od. or not
     */
    void checkHP();

    /**
     * Method that allows to set the trainer of the current pokemon
     * @param entrenador the trainer that owns the current pokemon
     */
    void setTrainer(Entrenador entrenador);

    /**
     * Method to receive the pokemon's trainer
     * @return the pokemon's trainer
     */
    Entrenador getTrainer();

    /**
     * This method allows to change the pokemon's current energy list into a given one
     * @param energias the list of energies that the pokemon will now have
     */
    void setEnergias(ArrayList<Energia> energias);

    Pokemon getObjetivo();

    ArrayList<Energia> getEnergias();

    void setDMGCounter(int i);

    int getDMGCounter();
}
