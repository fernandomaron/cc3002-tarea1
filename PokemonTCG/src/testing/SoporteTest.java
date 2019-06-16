package testing;

import game.Entrenador;
import game.carta.Carta;
import game.carta.soporte.ProfJuniper;
import game.carta.soporte.Soporte;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class SoporteTest {
    private Soporte ProfJuniper;
    private Entrenador Trainer;
    private ArrayList<Carta> Deck=new ArrayList<>();

    @Before
    public void setUp(){
        ProfJuniper=new ProfJuniper();
        Trainer=new Entrenador(Deck);
        ProfJuniper.setTrainer(Trainer);
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
        Deck.add(new ProfJuniper());
    }

    @Test
    public void ProfJuniper(){
        assertEquals(0, Trainer.getHand().size());
        assertEquals(15,Trainer.getDeck().size());
        assertEquals(0,Trainer.getDiscard().size());
        ProfJuniper.effect();
        assertEquals(7,Trainer.getHand().size());
        assertEquals(8,Trainer.getDeck().size());
        assertEquals(0,Trainer.getDiscard().size());
        ProfJuniper.effect();
        assertEquals(7,Trainer.getHand().size());
        assertEquals(1,Trainer.getDeck().size());
        assertEquals(7,Trainer.getDiscard().size());
    }
}
