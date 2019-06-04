package Game.Carta.Estadio;

import Game.Carta.Carta;
import Game.Entrenador;
import Game.Visitor.Visitor;

public class Estadio implements Carta {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitStadium(this);
    }

    @Override
    public void setTrainer(Entrenador entrenador) {

    }
}
