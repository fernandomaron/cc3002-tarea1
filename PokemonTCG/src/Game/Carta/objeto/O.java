package game.carta.objeto;

import game.carta.ACartaEntrenador;
import game.visitor.Visitor;

public class O extends ACartaEntrenador {
    public O(){this("","");}
    public O(String name, String desc){
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
