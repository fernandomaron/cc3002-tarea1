package game.carta.estadio;

import game.carta.ACarta;
import game.Entrenador;
import game.visitor.Visitor;

public class Estadio extends ACarta {


    @Override
    public void accept(Visitor visitor) {
        visitor.visitStadium(this);
    }

}