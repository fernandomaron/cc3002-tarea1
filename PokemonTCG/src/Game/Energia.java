package Game;

import Game.Carta;

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
