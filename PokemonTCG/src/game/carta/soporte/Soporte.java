package game.carta.soporte;

import game.carta.Carta;
import game.Entrenador;
import game.visitor.Visitor;

public class Soporte implements Carta {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitSupport(this);
    }

    @Override
    public void setTrainer(Entrenador entrenador) {

    }
}
