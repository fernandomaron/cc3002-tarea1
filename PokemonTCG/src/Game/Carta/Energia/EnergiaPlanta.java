package Game.Carta.Energia;

/**
 * @author Fernando Maron
 */
public class EnergiaPlanta extends Energia {
    public EnergiaPlanta(){
    }

    @Override
    public boolean equals(Object energia) {
        return energia instanceof EnergiaPlanta;
    }
}
