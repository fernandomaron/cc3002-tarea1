package testing;

import static org.junit.Assert.*;


import game.carta.objeto.Objeto;
import game.carta.objeto.Potion;
import game.carta.pokemon.water.BasicWaterPokemon;
import game.carta.pokemon.water.PokemonAgua;
import game.habilidad.Ataques.Ataque;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ObjetoTest {
    private Objeto potion;
    private PokemonAgua Totodile;
    private Ataque Tackle;

    @Before
    public void setUp(){
        potion=new Potion(30);
        Tackle=new Ataque(10, "Tackle", "The user slams into the enemy pokemon", new ArrayList<>());
        Totodile= new BasicWaterPokemon(40, 158, new ArrayList<>(), new ArrayList<>());
    }

    

    @Test
    public void Potion(){

    }
}
