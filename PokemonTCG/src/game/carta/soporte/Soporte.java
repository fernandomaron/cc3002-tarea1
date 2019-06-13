package game.carta.soporte;

import game.carta.CartaEntrenador;
import game.visitor.Visitor;

public class Soporte extends CartaEntrenador {

    public Soporte(String name, String desc){
        super(name, desc);
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitSupport(this);
    }

}
