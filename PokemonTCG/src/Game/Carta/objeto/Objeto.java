package game.carta.objeto;

import game.carta.CartaEntrenador;
import game.visitor.Visitor;

public abstract class Objeto extends CartaEntrenador {

    public Objeto(String name, String desc) {
        super(name,desc);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitObject(this);
    }

}
