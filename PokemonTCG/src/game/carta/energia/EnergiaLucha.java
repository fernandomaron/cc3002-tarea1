package game.carta.energia;

/**
 * @author Fernando Maron
 */
public class EnergiaLucha extends Energia {
    public EnergiaLucha(){
    }

    @Override
    public boolean equals(Object energia) {
        return energia instanceof EnergiaLucha;
    }
}
