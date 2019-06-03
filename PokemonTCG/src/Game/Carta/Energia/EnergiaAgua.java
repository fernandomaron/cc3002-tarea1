package Game.Carta.Energia;

/**
 * @author Fernando Maron
 */
public class EnergiaAgua extends Energia {
    public EnergiaAgua(){
    }

    @Override
    public boolean equals(Object energia) {
        return energia instanceof EnergiaAgua;
    }
}
