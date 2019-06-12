package game.carta.objeto;

import game.carta.ACartaEntrenador;
import game.visitor.Visitor;

public class Objeto extends ACartaEntrenador {
    public Objeto(){this("","");}
    public Objeto(String name, String desc){
        this.setDescription(desc);
        this.setName(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitObject(this);
    }

    public void efecto(){

    }
    public void somtin(){}

}
