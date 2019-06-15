package testing;
import game.CoinFlip;
import game.carta.pokemon.electric.BasicElectricPokemon;
import game.carta.pokemon.electric.PokemonElectrico;
import game.carta.pokemon.fighting.BasicFightingPokemon;
import game.carta.pokemon.fighting.PokemonLucha;
import game.carta.pokemon.fire.BasicFirePokemon;
import game.carta.pokemon.fire.PokemonFuego;
import game.carta.pokemon.grass.BasicGrassPokemon;
import game.carta.pokemon.grass.PokemonPlanta;
import game.carta.pokemon.psychic.BasicPsychicPokemon;
import game.carta.pokemon.psychic.PokemonPsiquico;
import game.carta.pokemon.water.BasicWaterPokemon;
import game.carta.pokemon.water.PokemonAgua;
import game.habilidad.Ataques.Ataque;
import game.habilidad.Ataques.ElectricShock;
import game.habilidad.Special.Heal;
import game.habilidad.Special.Special;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HabilidadTest {
    private Ataque Tackle;
    private Ataque ElectricShock;
    private Special Heal;
    private PokemonAgua Totodile;
    private PokemonFuego Charmander;
    private PokemonLucha Makuhita;
    private PokemonElectrico Magnemite;
    private PokemonPsiquico Beldum;
    private PokemonPlanta Seedot;


    @Before
    public void setUp(){
        Tackle=new Ataque(10, "Tackle", "The user slams into the enemy pokemon", new ArrayList<>());
        ElectricShock=new ElectricShock(10,new ArrayList<>(),10);
        Heal=new Heal();
        Totodile= new BasicWaterPokemon(40, 158, new ArrayList<>(), new ArrayList<>());
        Charmander= new BasicFirePokemon(40, 4, new ArrayList<>(), new ArrayList<>());
        Makuhita= new BasicFightingPokemon(40, 296, new ArrayList<>(), new ArrayList<>());
        Magnemite= new BasicElectricPokemon(40, 81, new ArrayList<>(), new ArrayList<>());
        Beldum= new BasicPsychicPokemon(40, 374, new ArrayList<>(), new ArrayList<>());
        Seedot= new BasicGrassPokemon(40 , 273, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void atacadoPorAgua(){
        Totodile.atacadoPorAgua(Tackle);
        assertEquals(10,Totodile.getDMGCounter());
        Charmander.atacadoPorAgua(Tackle);
        assertEquals(20,Charmander.getDMGCounter());
        Makuhita.atacadoPorAgua(Tackle);
        assertEquals(10,Makuhita.getDMGCounter());
        Magnemite.atacadoPorAgua(Tackle);
        assertEquals(10,Magnemite.getDMGCounter());
        Beldum.atacadoPorAgua(Tackle);
        assertEquals(10,Beldum.getDMGCounter());
        Seedot.atacadoPorAgua(Tackle);
        assertEquals(0,Seedot.getDMGCounter());
    }

    @Test
    public void atacadoPorFuego(){
        Totodile.atacadoPorFuego(Tackle);
        assertEquals(10,Totodile.getDMGCounter());
        Charmander.atacadoPorFuego(Tackle);
        assertEquals(10,Charmander.getDMGCounter());
        Makuhita.atacadoPorFuego(Tackle);
        assertEquals(10,Makuhita.getDMGCounter());
        Magnemite.atacadoPorFuego(Tackle);
        assertEquals(10,Magnemite.getDMGCounter());
        Beldum.atacadoPorFuego(Tackle);
        assertEquals(10,Beldum.getDMGCounter());
        Seedot.atacadoPorFuego(Tackle);
        assertEquals(20,Seedot.getDMGCounter());
    }

    @Test
    public void atacadoPorPlanta(){
        Totodile.atacadoPorPlanta(Tackle);
        assertEquals(20,Totodile.getDMGCounter());
        Charmander.atacadoPorPlanta(Tackle);
        assertEquals(10,Charmander.getDMGCounter());
        Makuhita.atacadoPorPlanta(Tackle);
        assertEquals(20,Makuhita.getDMGCounter());
        Magnemite.atacadoPorPlanta(Tackle);
        assertEquals(10,Magnemite.getDMGCounter());
        Beldum.atacadoPorPlanta(Tackle);
        assertEquals(10,Beldum.getDMGCounter());
        Seedot.atacadoPorPlanta(Tackle);
        assertEquals(10,Seedot.getDMGCounter());
    }

    @Test
    public void atacadoPorElectrico(){
        Totodile.atacadoPorElectrico(Tackle);
        assertEquals(20,Totodile.getDMGCounter());
        Charmander.atacadoPorElectrico(Tackle);
        assertEquals(10,Charmander.getDMGCounter());
        Makuhita.atacadoPorElectrico(Tackle);
        assertEquals(10,Makuhita.getDMGCounter());
        Magnemite.atacadoPorElectrico(Tackle);
        assertEquals(10,Magnemite.getDMGCounter());
        Beldum.atacadoPorElectrico(Tackle);
        assertEquals(10,Beldum.getDMGCounter());
        Seedot.atacadoPorElectrico(Tackle);
        assertEquals(10,Seedot.getDMGCounter());
    }

    @Test
    public void atacadoPorLucha(){
        Totodile.atacadoPorLucha(Tackle);
        assertEquals(0,Totodile.getDMGCounter());
        Charmander.atacadoPorLucha(Tackle);
        assertEquals(10,Charmander.getDMGCounter());
        Makuhita.atacadoPorLucha(Tackle);
        assertEquals(10,Makuhita.getDMGCounter());
        Magnemite.atacadoPorLucha(Tackle);
        assertEquals(20,Magnemite.getDMGCounter());
        Beldum.atacadoPorLucha(Tackle);
        assertEquals(0,Beldum.getDMGCounter());
        Seedot.atacadoPorLucha(Tackle);
        assertEquals(10,Seedot.getDMGCounter());
    }

    @Test
    public void atacadoPorPsiquico(){
        Totodile.atacadoPorPsiquico(Tackle);
        assertEquals(10,Totodile.getDMGCounter());
        Charmander.atacadoPorPsiquico(Tackle);
        assertEquals(10,Charmander.getDMGCounter());
        Makuhita.atacadoPorPsiquico(Tackle);
        assertEquals(20,Makuhita.getDMGCounter());
        Magnemite.atacadoPorPsiquico(Tackle);
        assertEquals(10,Magnemite.getDMGCounter());
        Beldum.atacadoPorPsiquico(Tackle);
        assertEquals(20,Beldum.getDMGCounter());
        Seedot.atacadoPorPsiquico(Tackle);
        assertEquals(10,Seedot.getDMGCounter());
    }

    @Test
    public void atacarVariasVeces(){
        Charmander.atacadoPorAgua(Tackle);
        assertEquals(20,Charmander.getDMGCounter());
        Charmander.atacadoPorAgua(Tackle);
        assertEquals(40,Charmander.getDMGCounter());
        Charmander.atacadoPorAgua(Tackle);
        assertEquals(60,Charmander.getDMGCounter());
    }

    @Test
    public void ElectricShockAndHeal(){
        assertEquals(0, Magnemite.getDMGCounter());
        ElectricShock.efecto(Magnemite,true);
        assertEquals(0,Magnemite.getDMGCounter());
        ElectricShock.efecto(Magnemite,false);
        assertEquals(10,Magnemite.getDMGCounter());
        Magnemite.usar(Heal,Magnemite);
        assertEquals(0,Magnemite.getDMGCounter());
        ElectricShock.efecto(Magnemite,false);
        assertEquals(10,Magnemite.getDMGCounter());
        Heal.efecto(Magnemite,CoinFlip.Flip());
        assertEquals(0,Magnemite.getDMGCounter());
    }
}