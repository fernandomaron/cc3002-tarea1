package testing;

import static org.junit.Assert.*;

import game.Controller;
import game.Entrenador;
import game.carta.Carta;
import game.carta.estadio.*;
import game.carta.pokemon.psychic.BasicPsychicPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class EstadioTest {
    private Estadio LuckyStadium;
    private Controller Controller;
    private Entrenador p1;
    private Entrenador p2;
    private ArrayList<Carta> Deck;
    @Before
    public void setUp(){
        LuckyStadium=new LuckyStadium();
        Deck=new ArrayList<>();
        Deck.add(new BasicPsychicPokemon(40,12,new ArrayList<>(), new ArrayList<>()));
        Deck.add(new BasicPsychicPokemon(40,12,new ArrayList<>(), new ArrayList<>()));
        Deck.add(new BasicPsychicPokemon(40,12,new ArrayList<>(), new ArrayList<>()));
        Deck.add(new BasicPsychicPokemon(40,12,new ArrayList<>(), new ArrayList<>()));
        Deck.add(new BasicPsychicPokemon(40,12,new ArrayList<>(), new ArrayList<>()));
        Deck.add(new BasicPsychicPokemon(40,12,new ArrayList<>(), new ArrayList<>()));
        p1=new Entrenador(Deck);
        p2=new Entrenador();
        Controller=new Controller(p1,p2);

    }

    @Test
    public void LuckyStadium(){
        assertEquals(6,p1.getDeck().size());
        assertEquals(0,p1.getHand().size());
        Controller.setCurrentStadium(LuckyStadium);
        LuckyStadium.efecto(p1,true);
        assertEquals(5,p1.getDeck().size());
        assertEquals(1,p1.getHand().size());
        LuckyStadium.efecto(p1,false);
        assertEquals(5,p1.getDeck().size());
        assertEquals(1,p1.getHand().size());
    }

    

}
