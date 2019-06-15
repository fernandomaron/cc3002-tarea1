package game.carta.estadio;

import game.carta.ACarta;
import game.Entrenador;
import game.carta.CartaEntrenador;
import game.visitor.Visitor;

public class Estadio extends CartaEntrenador {


    public Estadio(String name, String desc) {
        super(name,desc);
    }

    public Estadio() {
        super();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitStadium(this);
    }

    public void efecto(Entrenador entrenador, Boolean b){}
}
