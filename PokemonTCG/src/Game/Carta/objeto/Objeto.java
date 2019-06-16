package game.carta.objeto;

import game.carta.CartaEntrenador;
import game.visitor.VisitorCard;

public abstract class Objeto extends CartaEntrenador {

    public Objeto(String name, String desc) {
        super(name,desc);
    }

    @Override
    public void accept(VisitorCard visitor) {
        visitor.visitObject(this);
    }

}
