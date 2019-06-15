package testing;


import game.Controller;
import game.Entrenador;
import game.carta.Carta;
import game.carta.estadio.*;
import org.junit.Before;

import java.util.ArrayList;

public class EstadioTest {
    private Carta LuckyStadium;
    private Controller Controller;
    private Entrenador p1;
    private Entrenador p2;
    private ArrayList<Carta> Deck;
    @Before
    public void setUp(){
        LuckyStadium=new LuckyStadium();
        p1=new Entrenador();
        p2=new Entrenador();
        Deck=new ArrayList<>();
    }
    

}
