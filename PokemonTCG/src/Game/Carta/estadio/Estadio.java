package game.carta.estadio;

import game.Entrenador;
import game.carta.CartaEntrenador;
import game.visitor.VisitorCard;

public class Estadio extends CartaEntrenador {


    public Estadio(String name, String desc) {
        super(name,desc);
    }

    public Estadio() {
        super();
    }

    @Override
    public void accept(VisitorCard visitor) {
        visitor.visitStadium(this);
    }

    public void efecto(Entrenador entrenador, Boolean b){}

    public boolean isNullStadium(){return false;};
}
