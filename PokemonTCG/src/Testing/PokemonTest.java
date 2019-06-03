package Testing;
import Game.*;
import Game.Carta.Energia.Energia;
import Game.Carta.Energia.EnergiaAgua;
import Game.Carta.Energia.EnergiaElectrico;
import Game.Carta.Energia.EnergiaFuego;
import Game.Carta.Pokemon.*;
import Game.Habilidad.Ataque;
import Game.Habilidad.Habilidad;
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
        Magnemite= new PokemonElectrico(40, 81, new ArrayList<>(),Abilities);
        Beldum= new PokemonPsiquico(100, 374, new ArrayList<>(), new ArrayList<>());
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
        assertEquals(100, Beldum.getHP());
        Magnemite.usar(Magnemite.getHabilidades().get(0),Beldum);
        assertEquals(90, Beldum.getHP());
        Magnemite.usar(Magnemite.getHabilidades().get(1),Beldum);
        assertEquals(70, Beldum.getHP());
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

    @Test
    public void jugarPokemon(){
        assertTrue(Red.getActivo().isNull());
        assertTrue(Red.getBanca().isEmpty());
        Beldum.jugar();
        assertFalse(Red.getActivo().isNull());
        assertTrue(Red.getBanca().isEmpty());
        ArrayList<Pokemon> Banca= new ArrayList<>();
        Banca.add(new PokemonElectrico());
        Banca.add(new PokemonElectrico());
        Banca.add(new PokemonElectrico());
        Banca.add(new PokemonElectrico());
        Red.setBanca((ArrayList<Pokemon>) Banca.clone());
        assertFalse(Red.getBanca().isEmpty());
        assertTrue(Red.getBanca().size()<5);
        Pokemon Bulbasaur = new PokemonPlanta();
        Bulbasaur.setTrainer(Red);
        Bulbasaur.jugar();
        assertNotEquals(Banca,Red.getBanca());
        Banca=Red.getBanca();
        Pokemon Pikachu=new PokemonElectrico();
        Pikachu.setTrainer(Red);
        Pikachu.jugar();
        assertEquals(Banca,Red.getBanca());

        Red.setActivo(new PokemonNull());
        assertTrue(Red.getActivo().isNull());
        Banca= new ArrayList<>();
        Banca.add(Magnemite);
        Red.setBanca(Banca);
        assertFalse(Red.getBanca().isEmpty());
        Beldum.jugar();
        assertEquals(Magnemite,Red.getActivo());
        assertEquals(Beldum,Red.getBanca().get(0));
    }
}