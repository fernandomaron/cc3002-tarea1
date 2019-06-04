package Game.Carta.Objeto;

import Game.Carta.Carta;
import Game.Entrenador;
import Game.Visitor.Visitor;

public class Objeto implements Carta {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitObject(this);
    }

    @Override
    public void setTrainer(Entrenador entrenador) {

    }
}
