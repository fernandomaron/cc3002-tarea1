package testing;

import game.Controller;
import game.Entrenador;
import game.carta.Carta;
import game.carta.energia.Energia;
import game.carta.energia.EnergiaPlanta;
import game.carta.estadio.Estadio;
import game.carta.pokemon.electric.BasicElectricPokemon;
import game.carta.pokemon.grass.BasicGrassPokemon;
import game.carta.pokemon.grass.Phase1GrassPokemon;
import game.carta.pokemon.grass.Phase2GrassPokemon;
import game.carta.pokemon.water.BasicWaterPokemon;
import game.habilidad.Ataques.Ataque;
import game.habilidad.Habilidad;
import game.habilidad.Special.Heal;
import game.visitor.VisitCard;
import game.visitor.VisitorCard;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class ControllerTest {
    private Controller controller;
    private Entrenador p1;
    private Entrenador p2;
    private ArrayList<Carta> Deck1;
    private ArrayList<Carta> Deck2;
    private BasicGrassPokemon Bulbasaur;
    private Phase1GrassPokemon Ivysaur;
    private Phase2GrassPokemon Venusaur;
    private Habilidad VineWhip;
    private Estadio estadio;
    private Habilidad Heal;
    private BasicWaterPokemon Squirtle;
    private ArrayList<Energia> costo;
    private ArrayList<Habilidad> Abilities;

    @Before
    public void setUp(){
        Heal=new Heal();
        costo=new ArrayList<>();
        costo.add(new EnergiaPlanta());
        VineWhip=new Ataque(20, "Vine Whip", "Attacks the target with a whip like vine", costo);
        Abilities=new ArrayList<>();
        Abilities.add(VineWhip);
        Abilities.add(Heal);
        Bulbasaur=new BasicGrassPokemon(60,1,new ArrayList<>(),Abilities);
        Squirtle=new BasicWaterPokemon(60, 4, new ArrayList<>(), new ArrayList<>());
        Ivysaur=new Phase1GrassPokemon(100,2,new ArrayList<>(),new ArrayList<>(),1);
        Venusaur=new Phase2GrassPokemon(150, 3, new ArrayList<>(), Abilities, 2);
        estadio=new Estadio();
        Deck1=new ArrayList<>();
        Deck1.add(Bulbasaur);
        Deck1.add(Squirtle);
        Deck1.add(Ivysaur);
        Deck1.add(Venusaur);
        Deck1.add(estadio);
        for(int i=0; i<55; i++){
            Deck1.add(new EnergiaPlanta());
        }
        Deck2=new ArrayList<>(Deck1);
        p1= new Entrenador(Deck1);
        p2= new Entrenador(Deck2);
        controller=new Controller(p1,p2);
        controller.cotrolVisitor();
    }

    @Test
    public void drawingCards(){
        assertEquals(p1,controller.getCurrentTrainer());
        assertEquals(60,controller.getCurrentTrainer().getDeck().size());
        assertEquals(0,controller.getCurrentTrainer().getHand().size());
        controller.drawMyCards(5);
        assertEquals(5,controller.getCurrentTrainer().getHand().size());
        assertEquals(55,controller.getCurrentTrainer().getDeck().size());
        assertEquals(0,controller.getCurrentTrainer().getPrize().size());
        controller.drawPrize();
        assertEquals(5,controller.getCurrentTrainer().getHand().size());
        assertEquals(49,controller.getCurrentTrainer().getDeck().size());
        assertEquals(6,controller.getCurrentTrainer().getPrize().size());
        assertEquals(p2,controller.getOpponentTrainer());
        assertEquals(60,controller.getOpponentTrainer().getDeck().size());
        assertEquals(0,controller.getOpponentTrainer().getHand().size());
        controller.opponentDrawCards(5);
        assertEquals(5,controller.getOpponentTrainer().getHand().size());
        assertEquals(55,controller.getOpponentTrainer().getDeck().size());
        assertEquals(0,controller.getOpponentTrainer().getPrize().size());
    }

    @Test
    public void playingCardsEvolvingAndAbilities(){
        assertEquals(p1,controller.getCurrentTrainer());
        //Playing Pokemons evolving and their abilities
        controller.drawMyCards(6);//we draw a hand with Bulbasaur, Squirtle, Ivysaur, Venusaur, Estadio and a plant energy
        assertEquals(Bulbasaur,controller.getHand().get(0));
        controller.playCard(0);//swe play the Bulbasaur card
        assertEquals(5,controller.getHand().size());
        assertEquals(Bulbasaur,controller.getCurrentTrainer().getActive());
        assertEquals(Squirtle,controller.getHand().get(0));
        assertEquals(0,controller.getCurrentTrainer().getBench().size());
        controller.playCard(0);//we play the Squirtle card
        assertEquals(4,controller.getHand().size());
        assertEquals(Ivysaur,controller.getHand().get(0));
        assertEquals(1,controller.getCurrentTrainer().getBench().size());
        controller.chooseTargetPokemon(Squirtle);//we choose Squirtle as the target of our trainer
        controller.playCard(0);//we try to evolve Squirtle into Ivy saur
        assertEquals(4,controller.getHand().size());
        assertEquals(Ivysaur,controller.getHand().get(0));
        assertEquals(1,controller.getCurrentTrainer().getBench().size());
        assertEquals(Venusaur,controller.getHand().get(1));
        controller.chooseTargetPokemon(Bulbasaur);//we change the target to Bulbasaur
        controller.playCard(1);//we try to evolve Bulbasaur into Venusaur
        assertEquals(4,controller.getHand().size());
        assertEquals(0,controller.getCurrentTrainer().getDiscard().size());
        assertEquals(Ivysaur,controller.getHand().get(0));
        assertEquals(Venusaur,controller.getHand().get(1));
        controller.playCard(0);//we evolve Bulbasaur into Ivysaur, now Ivysaur is our target pokemon
        assertEquals(3,controller.getHand().size());
        assertEquals(1,controller.getCurrentTrainer().getDiscard().size());
        assertEquals(Venusaur,controller.getHand().get(0));
        assertTrue(new EnergiaPlanta().equals(controller.getHand().get(2)));
        assertEquals(0,controller.getCurrentTrainer().getActive().getEnergias().size());
        assertFalse(controller.getUsedEnergy());
        controller.playCard(2);//we play the energy card on Ivysaur
        assertEquals(1,controller.getCurrentTrainer().getActive().getEnergias().size());
        assertEquals(2,controller.getHand().size());
        assertTrue(controller.getUsedEnergy());
        controller.playCard(0);//we evolve Ivysaur into Venusaur
        assertEquals(1,controller.getHand().size());
        assertEquals(2,controller.getCurrentTrainer().getDiscard().size());
        assertEquals(1,controller.getCurrentTrainer().getActive().getEnergias().size());
        Venusaur.setDMGCounter(10);//we "attack" Venusaur in order to use it's ability to heal
        assertEquals(10,Venusaur.getDMGCounter());
        controller.useAbility(1);
        assertEquals(0,Venusaur.getDMGCounter());
        BasicElectricPokemon Magnemite=new BasicElectricPokemon();//we create a new pokemon to attack
        controller.chooseTargetPokemon(Magnemite);
        controller.useAbility(0);//we use Vine Whip against the Magnemite, ending the players turn
        assertEquals(p2,controller.getCurrentTrainer());
    }
}
