package game.carta.energia;

import game.carta.Carta;
import game.Entrenador;
import game.visitor.Visitor;

/**
 * @author Fernando Maron
 * Abstract class that allows Energies to be used by the same method, even if of different type
 */
public abstract class Energia implements Carta {

    private Entrenador Trainer;

    @Override
    public void setTrainer(Entrenador trainer) {
        Trainer = trainer;
    }

    public void accept(Visitor visitor){
        visitor.visitEnergy(this);
    }

    @Override
    public Entrenador getTrainer() {
        return Trainer;
    }
}
