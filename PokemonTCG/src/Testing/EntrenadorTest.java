package Testing;
import Game.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EntrenadorTest {
    private Entrenador Red;
    private Ataque Tackle;
    private Ataque Thunderbolt;
    private PokemonAgua Totodile;
    private PokemonLucha Makuhita;
    private PokemonElectrico Magnemite;
    private PokemonPsiquico Beldum;
    private ArrayList<Energia> Costo1;
    private ArrayList<Energia> Costo2;
    private ArrayList<Habilidad> Abilities1;
    private ArrayList<Habilidad> Abilities2;
    private ArrayList<Carta> Mano;

    @Before
    public void setUp(){
        Costo1=new ArrayList<>();
        Costo1.add(new EnergiaElectrico());
        Costo2=new ArrayList<>();
        Costo2.add(new EnergiaElectrico());
        Costo2.add(new EnergiaElectrico());
        Thunderbolt=new Ataque(20, "Thunderbolt", "The user releases a powerful shock against it's opponent", Costo2);
        Tackle=new Ataque(10, "Tackle", "The user slams into the enemy pokemon", Costo1);
        Abilities1=new ArrayList<>();
        Abilities1.add(Tackle);
        Abilities1.add(Thunderbolt);
        Abilities2=new ArrayList<>();
        Abilities2.add(Tackle);
        Magnemite= new PokemonElectrico(40, 81, new ArrayList<>(),Abilities1);
        Makuhita= new PokemonLucha(40, 296, new ArrayList<>(), Abilities2);
        Totodile= new PokemonAgua(40, 158, new ArrayList<>(), new ArrayList<>());
        Beldum= new PokemonPsiquico(40, 374, new ArrayList<>(), new ArrayList<>());
        Mano= new ArrayList<>();
        Mano.add(Magnemite);
        Mano.add(new EnergiaElectrico());
        Red=new Entrenador(new PokemonNull(),new ArrayList<Pokemon>(), Mano);
    }

    @Test
    public void firstCards(){
        assertFalse(Red.getMano().isEmpty());
        assertTrue(Red.getActivo().isNull());
        Red.jugarCarta(0);
        assertFalse(Red.getMano().isEmpty());
        assertFalse(Red.getActivo().isNull());
        assertEquals(40, Beldum.getHP());

        assertEquals(Abilities1,Red.habilidadesActivo());
        Red.usarHabilidad(0,Beldum);
        assertEquals(40, Beldum.getHP());
        Red.jugarCarta(0);
        assertTrue(Red.getMano().isEmpty());
        Red.usarHabilidad(0,Beldum);
        assertEquals(30, Beldum.getHP());

        assertTrue(Red.getBanca().isEmpty());
        Red.jugarPokemon(Totodile);
        assertFalse(Red.getBanca().isEmpty());
        Red.jugarEnergia(new EnergiaElectrico());
        Red.usarHabilidad(1,Beldum);
        assertEquals(10,Beldum.getHP());

        Makuhita.agregarEnergia(new EnergiaElectrico());
        Makuhita.agregarEnergia(new EnergiaElectrico());
        Makuhita.atacarCon(Thunderbolt,Magnemite); //Si, Makuhita genera tanta friccion con sus puños que tira un rayo ;)
        assertEquals(Totodile,Red.getActivo());
        assertTrue(Red.getBanca().isEmpty());
    }

    @Test
    public void jugarPokemon(){
        assertTrue(Red.getActivo().isNull());
        assertTrue(Red.getBanca().isEmpty());
        Red.jugarPokemon(new PokemonElectrico());
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
        Red.jugarPokemon(new PokemonElectrico());
        assertNotEquals(Banca,Red.getBanca());
        Banca=Red.getBanca();
        Red.jugarPokemon(new PokemonElectrico());
        assertEquals(Banca,Red.getBanca());

        Red.setActivo(new PokemonNull());
        assertTrue(Red.getActivo().isNull());
        Banca= new ArrayList<>();
        Banca.add(Magnemite);
        Red.setBanca(Banca);
        assertFalse(Red.getBanca().isEmpty());
        Red.jugarPokemon(Makuhita);
        assertEquals(Magnemite,Red.getActivo());
        assertEquals(Makuhita,Red.getBanca().get(0));
    }

    @Test
    public void addToMano(){
        assertFalse(Red.getMano().isEmpty());
        Red.setMano(new ArrayList<>());
        assertTrue(Red.getMano().isEmpty());
        Red.addToMano(Makuhita);
        assertFalse(Red.getMano().isEmpty());
    }
}