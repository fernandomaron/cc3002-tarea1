package Game.Carta.Energia;

/**
 * @author Fernando Maron
 */
public class EnergiaFuego extends Energia {
    public EnergiaFuego(){
    }

    @Override
    public boolean equals(Object energia) {
        return energia instanceof EnergiaFuego;
    }
}
