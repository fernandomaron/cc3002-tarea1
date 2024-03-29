package testing;
import game.*;
import game.carta.energia.Energia;
import game.carta.energia.EnergiaAgua;
import game.carta.energia.EnergiaElectrico;
import game.carta.energia.EnergiaFuego;
import game.carta.pokemon.*;
import game.carta.pokemon.electric.BasicElectricPokemon;
import game.carta.pokemon.electric.PokemonElectrico;
import game.carta.pokemon.grass.PokemonPlanta;
import game.carta.pokemon.psychic.BasicPsychicPokemon;
import game.carta.pokemon.psychic.PokemonPsiquico;
import game.habilidad.Ataques.Ataque;
import game.habilidad.Habilidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokemonTest {
    private Pokemon Magnemite;
    private Pokemon Beldum;
    private Entrenador Red;
    private Ataque Tackle;
    private Ataque Thunderbolt;
    private ArrayList<Energia> Costo1;
    private ArrayList<Energia> Costo2;
    private ArrayList<Habilidad> Abilities;



    @Before
    public void setUp(){
        Red= new Entrenador();
        Costo1=new ArrayList<>();
        Costo1.add(new EnergiaElectrico());
        Costo1.add(new EnergiaFuego());
        Costo2=new ArrayList<>();
        Costo2.add(new EnergiaElectrico());
        Costo2.add(new EnergiaElectrico());
        Thunderbolt=new Ataque(20, "Thunderbolt", "The user releases a powerful shock against it's opponent", Costo2);
        Tackle=new Ataque(10, "Tackle", "The user slams into the enemy pokemon", Costo1);
        Abilities=new ArrayList<>();
        Abilities.add(Tackle);
        Abilities.add(Thunderbolt);
        Magnemite= new BasicElectricPokemon(40, 81, new ArrayList<>(),Abilities);
        Beldum= new BasicPsychicPokemon(100, 374, new ArrayList<>(), new ArrayList<>());
        Beldum.setTrainer(Red);
        Magnemite.setTrainer(Red);
    }

    @Test
    public void hasEnergy(){
        assertFalse(Magnemite.hasEnergy(Costo1));
        Magnemite.agregarEnergia(new EnergiaElectrico());
        assertFalse(Magnemite.hasEnergy(Costo1));
        Magnemite.agregarEnergia(new EnergiaFuego());
        assertTrue(Magnemite.hasEnergy(Costo1));
        assertFalse(Magnemite.hasEnergy(Costo2));
        Magnemite.agregarEnergia(new EnergiaAgua());
        assertTrue(Magnemite.hasEnergy(Costo1));
        assertFalse(Magnemite.hasEnergy(Costo2));
        Magnemite.agregarEnergia(new EnergiaElectrico());
        assertTrue(Magnemite.hasEnergy(Costo1));
        assertTrue(Magnemite.hasEnergy(Costo2));
    }

    @Test
    public void usarHabilidad(){
        Magnemite.agregarEnergia(new EnergiaElectrico());
        Magnemite.agregarEnergia(new EnergiaElectrico());
        Magnemite.agregarEnergia(new EnergiaFuego());
        assertEquals(0, Beldum.getDMGCounter());
        Magnemite.usar(Magnemite.getHabilidades().get(0),Beldum);
        assertEquals(10, Beldum.getDMGCounter());
        Magnemite.usar(Magnemite.getHabilidades().get(1),Beldum);
        assertEquals(30, Beldum.getDMGCounter());
    }

    @Test
    public void isNull(){
        Pokemon NULL=new PokemonNull();
        assertTrue(NULL.isNull());
        assertFalse(Magnemite.isNull());
        assertFalse(Beldum.isNull());
    }

    @Test
    public void setGet(){
        assertTrue(Beldum.getHabilidades().isEmpty());
        Beldum.setHabilidades(Abilities);
        assertFalse(Beldum.getHabilidades().isEmpty());
        assertFalse(Magnemite.hasEnergy(Costo1));
        Magnemite.setEnergias(Costo1);
        assertTrue(Magnemite.hasEnergy(Costo1));
        assertEquals(100, Beldum.getHP());
        Beldum.setHP(50);
        assertEquals(50,Beldum.getHP());
        assertEquals(374,Beldum.getID());
        Beldum.setID(203);
        assertEquals(203,Beldum.getID());
        Entrenador Ash=new Entrenador();
        assertEquals(Red, Magnemite.getTrainer());
        Magnemite.setTrainer(Ash);
        assertEquals(Ash,Magnemite.getTrainer());
    }

}