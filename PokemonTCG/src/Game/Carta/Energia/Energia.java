package Game.Carta.Energia;

import Game.Carta.Carta;
import Game.Entrenador;
import Game.Visitor.Visitor;

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
    public boolean equals(Object energia){
        return this.equals(energia);
    }
}
