package game.carta;

import game.Entrenador;


public abstract class ACarta implements Carta {
    private Entrenador Trainer;

    @Override
    public void setTrainer(Entrenador entrenador) {
        this.Trainer = entrenador;
    }

    public Entrenador getTrainer(){
        return this.Trainer;
    }
}
