package game.carta.energia;

/**
 * @author Fernando Maron
 */
public class EnergiaElectrico extends Energia {
    public EnergiaElectrico(){
    }

    @Override
    public boolean equals(Object energia) {
        return energia instanceof EnergiaElectrico;
    }
}
