package Game.Carta.Soporte;

import Game.Carta.Carta;
import Game.Entrenador;
import Game.Visitor.Visitor;

public class Soporte implements Carta {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitSupport(this);
    }

    @Override
    public void setTrainer(Entrenador entrenador) {

    }
}
