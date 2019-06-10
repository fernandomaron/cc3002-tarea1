package testing;


import game.carta.Carta;
import game.carta.estadio.*;
import org.junit.Before;

public class EstadioTest {
    private Carta ChaosGym;
    private Carta FrozenCity;
    private Carta LuckyStadium;
    private Carta PokemonPark;
    private Carta TrainingCenter;

    @Before
    public void setUp(){
        ChaosGym=new ChaosGym();
        FrozenCity=new FrozenCity();
        LuckyStadium=new LuckyStadium();
        PokemonPark=new PokemonPark();
        TrainingCenter=new TrainingCenter();
    }
    

}
