package game.carta.energia;

/**
 * @author Fernando Maron
 */
public class EnergiaPsiquico extends Energia {
    public EnergiaPsiquico(){
    }

    @Override
    public boolean equals(Object energia) {
        return energia instanceof EnergiaPsiquico;
    }
}
