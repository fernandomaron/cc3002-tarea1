package Testing;
import Game.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtaqueTest {
    private Ataque ataque;
    private PokemonAgua Totodile;
    private PokemonFuego Charmander;
    private PokemonLucha Makuhita;
    private PokemonElectrico Magnemite;
    private PokemonPsiquico Beldum;
    private PokemonPlanta Seedot;


    @Before
    public void setUp(){
        ataque=new Ataque(10, "Tackle", "The user slams into the enemy pokemon", new ArrayList<>());
        Totodile= new PokemonAgua(40, 158, new ArrayList<>(), new ArrayList<>());
        Charmander= new PokemonFuego(40, 4, new ArrayList<>(), new ArrayList<>());
        Makuhita= new PokemonLucha(40, 296, new ArrayList<>(), new ArrayList<>());
        Magnemite= new PokemonElectrico(40, 81, new ArrayList<>(), new ArrayList<>());
        Beldum= new PokemonPsiquico(40, 374, new ArrayList<>(), new ArrayList<>());
        Seedot= new PokemonPlanta(40 , 273, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void atacadoPorAgua(){
        Totodile.atacadoPorAgua(ataque);
        assertEquals(30,Totodile.getHP());
        Charmander.atacadoPorAgua(ataque);
        assertEquals(20,Charmander.getHP());
        Makuhita.atacadoPorAgua(ataque);
        assertEquals(30,Makuhita.getHP());
        Magnemite.atacadoPorAgua(ataque);
        assertEquals(30,Magnemite.getHP());
        Beldum.atacadoPorAgua(ataque);
        assertEquals(30,Beldum.getHP());
        Seedot.atacadoPorAgua(ataque);
        assertEquals(40,Seedot.getHP());
    }

    @Test
    public void atacadoPorFuego(){
        Totodile.atacadoPorFuego(ataque);
        assertEquals(30,Totodile.getHP());
        Charmander.atacadoPorFuego(ataque);
        assertEquals(30,Charmander.getHP());
        Makuhita.atacadoPorFuego(ataque);
        assertEquals(30,Makuhita.getHP());
        Magnemite.atacadoPorFuego(ataque);
        assertEquals(30,Magnemite.getHP());
        Beldum.atacadoPorFuego(ataque);
        assertEquals(30,Beldum.getHP());
        Seedot.atacadoPorFuego(ataque);
        assertEquals(20,Seedot.getHP());
    }

    @Test
    public void atacadoPorPlanta(){
        Totodile.atacadoPorPlanta(ataque);
        assertEquals(20,Totodile.getHP());
        Charmander.atacadoPorPlanta(ataque);
        assertEquals(30,Charmander.getHP());
        Makuhita.atacadoPorPlanta(ataque);
        assertEquals(20,Makuhita.getHP());
        Magnemite.atacadoPorPlanta(ataque);
        assertEquals(30,Magnemite.getHP());
        Beldum.atacadoPorPlanta(ataque);
        assertEquals(30,Beldum.getHP());
        Seedot.atacadoPorPlanta(ataque);
        assertEquals(40,Seedot.getHP());
    }

    @Test
    public void atacadoPorElectrico(){
        Totodile.atacadoPorElectrico(ataque);
        assertEquals(20,Totodile.getHP());
        Charmander.atacadoPorElectrico(ataque);
        assertEquals(30,Charmander.getHP());
        Makuhita.atacadoPorElectrico(ataque);
        assertEquals(30,Makuhita.getHP());
        Magnemite.atacadoPorElectrico(ataque);
        assertEquals(30,Magnemite.getHP());
        Beldum.atacadoPorElectrico(ataque);
        assertEquals(30,Beldum.getHP());
        Seedot.atacadoPorElectrico(ataque);
        assertEquals(30,Seedot.getHP());
    }

    @Test
    public void atacadoPorLucha(){
        Totodile.atacadoPorLucha(ataque);
        assertEquals(40,Totodile.getHP());
        Charmander.atacadoPorLucha(ataque);
        assertEquals(30,Charmander.getHP());
        Makuhita.atacadoPorLucha(ataque);
        assertEquals(30,Makuhita.getHP());
        Magnemite.atacadoPorLucha(ataque);
        assertEquals(20,Magnemite.getHP());
        Beldum.atacadoPorLucha(ataque);
        assertEquals(40,Beldum.getHP());
        Seedot.atacadoPorLucha(ataque);
        assertEquals(30,Seedot.getHP());
    }

    @Test
    public void atacadoPorPsiquico(){
        Totodile.atacadoPorPsiquico(ataque);
        assertEquals(30,Totodile.getHP());
        Charmander.atacadoPorPsiquico(ataque);
        assertEquals(30,Charmander.getHP());
        Makuhita.atacadoPorPsiquico(ataque);
        assertEquals(20,Makuhita.getHP());
        Magnemite.atacadoPorPsiquico(ataque);
        assertEquals(30,Magnemite.getHP());
        Beldum.atacadoPorPsiquico(ataque);
        assertEquals(20,Beldum.getHP());
        Seedot.atacadoPorPsiquico(ataque);
        assertEquals(30,Seedot.getHP());
    }
}