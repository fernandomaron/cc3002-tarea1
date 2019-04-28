package Game;

import Game.Carta;

/**
 * @author Fernando Maron
 * Abstract class that allows Energies to be used by the same method, even if of different type
 */
public abstract class Energia implements Carta {
    @Override
    public void jugar(Entrenador entrenador) {
        entrenador.jugarEnergia(this);
    }

    @Override
    public boolean equals(Object energia){
        return this.equals(energia);
    }
}
