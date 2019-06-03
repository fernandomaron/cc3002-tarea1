package Testing;
import Game.Carta.Pokemon.*;
import Game.Habilidad.Ataque;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtaqueTest {
    private Ataque Tackle;
    private PokemonAgua Totodile;
    private PokemonFuego Charmander;
    private PokemonLucha Makuhita;
    private PokemonElectrico Magnemite;
    private PokemonPsiquico Beldum;
    private PokemonPlanta Seedot;


    @Before
    public void setUp(){
        Tackle=new Ataque(10, "Tackle", "The user slams into the enemy pokemon", new ArrayList<>());
        Totodile= new PokemonAgua(40, 158, new ArrayList<>(), new ArrayList<>());
        Charmander= new PokemonFuego(40, 4, new ArrayList<>(), new ArrayList<>());
        Makuhita= new PokemonLucha(40, 296, new ArrayList<>(), new ArrayList<>());
        Magnemite= new PokemonElectrico(40, 81, new ArrayList<>(), new ArrayList<>());
        Beldum= new PokemonPsiquico(40, 374, new ArrayList<>(), new ArrayList<>());
        Seedot= new PokemonPlanta(40 , 273, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void atacadoPorAgua(){
        Totodile.atacadoPorAgua(Tackle);
        assertEquals(30,Totodile.getHP());
        Charmander.atacadoPorAgua(Tackle);
        assertEquals(20,Charmander.getHP());
        Makuhita.atacadoPorAgua(Tackle);
        assertEquals(30,Makuhita.getHP());
        Magnemite.atacadoPorAgua(Tackle);
        assertEquals(30,Magnemite.getHP());
        Beldum.atacadoPorAgua(Tackle);
        assertEquals(30,Beldum.getHP());
        Seedot.atacadoPorAgua(Tackle);
        assertEquals(40,Seedot.getHP());
    }

    @Test
    public void atacadoPorFuego(){
        Totodile.atacadoPorFuego(Tackle);
        assertEquals(30,Totodile.getHP());
        Charmander.atacadoPorFuego(Tackle);
        assertEquals(30,Charmander.getHP());
        Makuhita.atacadoPorFuego(Tackle);
        assertEquals(30,Makuhita.getHP());
        Magnemite.atacadoPorFuego(Tackle);
        assertEquals(30,Magnemite.getHP());
        Beldum.atacadoPorFuego(Tackle);
        assertEquals(30,Beldum.getHP());
        Seedot.atacadoPorFuego(Tackle);
        assertEquals(20,Seedot.getHP());
    }

    @Test
    public void atacadoPorPlanta(){
        Totodile.atacadoPorPlanta(Tackle);
        assertEquals(20,Totodile.getHP());
        Charmander.atacadoPorPlanta(Tackle);
        assertEquals(30,Charmander.getHP());
        Makuhita.atacadoPorPlanta(Tackle);
        assertEquals(20,Makuhita.getHP());
        Magnemite.atacadoPorPlanta(Tackle);
        assertEquals(30,Magnemite.getHP());
        Beldum.atacadoPorPlanta(Tackle);
        assertEquals(30,Beldum.getHP());
        Seedot.atacadoPorPlanta(Tackle);
        assertEquals(30,Seedot.getHP());
    }

    @Test
    public void atacadoPorElectrico(){
        Totodile.atacadoPorElectrico(Tackle);
        assertEquals(20,Totodile.getHP());
        Charmander.atacadoPorElectrico(Tackle);
        assertEquals(30,Charmander.getHP());
        Makuhita.atacadoPorElectrico(Tackle);
        assertEquals(30,Makuhita.getHP());
        Magnemite.atacadoPorElectrico(Tackle);
        assertEquals(30,Magnemite.getHP());
        Beldum.atacadoPorElectrico(Tackle);
        assertEquals(30,Beldum.getHP());
        Seedot.atacadoPorElectrico(Tackle);
        assertEquals(30,Seedot.getHP());
    }

    @Test
    public void atacadoPorLucha(){
        Totodile.atacadoPorLucha(Tackle);
        assertEquals(40,Totodile.getHP());
        Charmander.atacadoPorLucha(Tackle);
        assertEquals(30,Charmander.getHP());
        Makuhita.atacadoPorLucha(Tackle);
        assertEquals(30,Makuhita.getHP());
        Magnemite.atacadoPorLucha(Tackle);
        assertEquals(20,Magnemite.getHP());
        Beldum.atacadoPorLucha(Tackle);
        assertEquals(40,Beldum.getHP());
        Seedot.atacadoPorLucha(Tackle);
        assertEquals(30,Seedot.getHP());
    }

    @Test
    public void atacadoPorPsiquico(){
        Totodile.atacadoPorPsiquico(Tackle);
        assertEquals(30,Totodile.getHP());
        Charmander.atacadoPorPsiquico(Tackle);
        assertEquals(30,Charmander.getHP());
        Makuhita.atacadoPorPsiquico(Tackle);
        assertEquals(20,Makuhita.getHP());
        Magnemite.atacadoPorPsiquico(Tackle);
        assertEquals(30,Magnemite.getHP());
        Beldum.atacadoPorPsiquico(Tackle);
        assertEquals(20,Beldum.getHP());
        Seedot.atacadoPorPsiquico(Tackle);
        assertEquals(30,Seedot.getHP());
    }

    @Test
    public void atacarVariasVeces(){
        Charmander.atacadoPorAgua(Tackle);
        assertEquals(20,Charmander.getHP());
        Charmander.atacadoPorAgua(Tackle);
        assertEquals(0,Charmander.getHP());
        Charmander.atacadoPorAgua(Tackle);
        assertEquals(-20,Charmander.getHP());
    }
}