package testing;
import static org.junit.Assert.*;

import game.carta.energia.*;
import org.junit.Before;
import org.junit.Test;

public class EnergiaTest {
    private EnergiaFuego Fire;
    private EnergiaAgua Water;
    private EnergiaLucha Fight;
    private EnergiaElectrico Electric;
    private EnergiaPlanta Grass;
    private EnergiaPsiquico Psychic;

    @Before
    public void setUp(){
        Fire=new EnergiaFuego();
        Water=new EnergiaAgua();
        Fight=new EnergiaLucha();
        Electric=new EnergiaElectrico();
        Grass=new EnergiaPlanta();
        Psychic=new EnergiaPsiquico();
    }

    @Test
    public void equals(){
        assertTrue(Water.equals(Water));
        assertTrue(Water.equals(new EnergiaAgua()));
        assertFalse(Water.equals(Fire));
        assertFalse(Water.equals(Fight));
        assertFalse(Water.equals(Electric));
        assertFalse(Water.equals(Grass));
        assertFalse(Water.equals(Psychic));

        assertTrue(Fire.equals(Fire));
        assertTrue(Fire.equals(new EnergiaFuego()));
        assertFalse(Fire.equals(Water));
        assertFalse(Fire.equals(Fight));
        assertFalse(Fire.equals(Electric));
        assertFalse(Fire.equals(Grass));
        assertFalse(Fire.equals(Psychic));

        assertTrue(Fight.equals(Fight));
        assertTrue(Fight.equals(new EnergiaLucha()));
        assertFalse(Fight.equals(Fire));
        assertFalse(Fight.equals(Water));
        assertFalse(Fight.equals(Electric));
        assertFalse(Fight.equals(Grass));
        assertFalse(Fight.equals(Psychic));

        assertTrue(Electric.equals(Electric));
        assertTrue(Electric.equals(new EnergiaElectrico()));
        assertFalse(Electric.equals(Fire));
        assertFalse(Electric.equals(Fight));
        assertFalse(Electric.equals(Water));
        assertFalse(Electric.equals(Grass));
        assertFalse(Electric.equals(Psychic));

        assertTrue(Grass.equals(Grass));
        assertTrue(Grass.equals(new EnergiaPlanta()));
        assertFalse(Grass.equals(Fire));
        assertFalse(Grass.equals(Fight));
        assertFalse(Grass.equals(Electric));
        assertFalse(Grass.equals(Water));
        assertFalse(Grass.equals(Psychic));

        assertTrue(Psychic.equals(Psychic));
        assertTrue(Psychic.equals(new EnergiaPsiquico()));
        assertFalse(Psychic.equals(Fire));
        assertFalse(Psychic.equals(Fight));
        assertFalse(Psychic.equals(Electric));
        assertFalse(Psychic.equals(Grass));
        assertFalse(Psychic.equals(Water));
    }
}