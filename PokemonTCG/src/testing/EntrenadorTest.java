package testing;
import game.*;
import game.carta.*;
import game.carta.energia.Energia;
import game.carta.energia.EnergiaElectrico;
import game.carta.pokemon.*;
import game.carta.pokemon.electric.PokemonElectrico;
import game.carta.pokemon.fighting.PokemonLucha;
import game.carta.pokemon.psychic.PokemonPsiquico;
import game.carta.pokemon.water.PokemonAgua;
import game.habilidad.Ataques.Ataque;
import game.habilidad.Habilidad;
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
        Red=new Entrenador(new PokemonNull(),new ArrayList<>(), Mano);
    }

    @Test
    public void firstCards(){
        assertFalse(Red.getHand().isEmpty());
        assertTrue(Red.getActive().isNull());
        Red.jugarCarta(0);
        assertFalse(Red.getHand().isEmpty());
        assertFalse(Red.getActive().isNull());
        assertEquals(40, Beldum.getHP());

        assertEquals(Abilities1,Red.habilidadesActivo());
        Red.usarHabilidad(0,Beldum);
        assertEquals(40, Beldum.getHP());
        Red.jugarCarta(0);
        assertTrue(Red.getHand().isEmpty());
        Red.usarHabilidad(0,Beldum);
        assertEquals(30, Beldum.getHP());

        assertTrue(Red.getBench().isEmpty());
        Totodile.setTrainer(Red);
        Totodile.jugar();
        assertFalse(Red.getBench().isEmpty());
        Energia ele=new EnergiaElectrico();
        ele.setTrainer(Red);
        ele.jugar();
        Red.usarHabilidad(1,Beldum);
        assertEquals(10,Beldum.getHP());

        Makuhita.agregarEnergia(new EnergiaElectrico());
        Makuhita.agregarEnergia(new EnergiaElectrico());
        Makuhita.atacarCon(Thunderbolt,Magnemite); //Si, Makuhita genera tanta friccion con sus puños que tira un rayo ;)
        assertEquals(Totodile,Red.getActive());
        assertTrue(Red.getBench().isEmpty());
    }

    @Test
    public void addToMano(){
        assertFalse(Red.getHand().isEmpty());
        Red.setHand(new ArrayList<>());
        assertTrue(Red.getHand().isEmpty());
        Red.addToMano(Makuhita);
        assertFalse(Red.getHand().isEmpty());
    }
}