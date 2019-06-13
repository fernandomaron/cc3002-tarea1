package game.visitor;

import game.carta.energia.Energia;
import game.carta.estadio.Estadio;
import game.carta.objeto.Objeto;
import game.carta.pokemon.Pokemon;
import game.carta.soporte.Soporte;
import game.Entrenador;

public class visitCard implements Visitor{
    private Entrenador Trainer;

    public visitCard(Entrenador e){
        Trainer=e;
    }
    @Override
    public void visitObject(Objeto obj) {
        obj.efecto();
    }

    @Override
    public void visitStadium(Estadio s) {

    }

    @Override
    public void visitEnergy(Energia e) {

    }

    @Override
    public void visitPokemon(Pokemon p) {
        if(Trainer.getActive().isNull() && Trainer.getBench().isEmpty()){
            Trainer.setActive(p);
        }
        else if(Trainer.getActive().isNull() && !Trainer.getBench().isEmpty()){
            Trainer.setActive(Trainer.getBench().get(0));
            Trainer.getBench().remove(0);
            Trainer.getBench().add(p);
        }
        else if (Trainer.getBench().size()<5){
            Trainer.getBench().add(p);
        }
        else {
            System.out.println("No se puede jugar este pokemon");
        }
    }

    @Override
    public void visitSupport(Soporte s) {

    }
}
