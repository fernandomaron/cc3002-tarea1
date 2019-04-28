package Testing;
import Game.*;

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
    private ArrayList<Energia> costo;


    public void setUp(){

        costo=new ArrayList<>();
        costo.add(new EnergiaAgua());
        costo.add(new EnergiaFuego());
        ataque=new Ataque(30, "Tackle", "The user slams into the enemy pokemon", costo);
        Totodile= new PokemonAgua(30, 158, new ArrayList<Energia>(),  );
    }
}