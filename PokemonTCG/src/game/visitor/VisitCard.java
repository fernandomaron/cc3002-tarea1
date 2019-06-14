package game.visitor;

import game.Controller;
import game.carta.energia.Energia;
import game.carta.estadio.Estadio;
import game.carta.objeto.Objeto;
import game.carta.pokemon.Phase1;
import game.carta.pokemon.Phase2;
import game.carta.pokemon.Pokemon;
import game.carta.pokemon.water.Phase1WaterPokemon;
import game.carta.soporte.Soporte;
import game.Entrenador;

public class VisitCard implements Visitor{
    private Controller Control;

    public VisitCard(){
    }

    public void DiscardCard(Entrenador trainer){
        trainer.getDiscard().add(0,trainer.getHand().get(trainer.getUsedCard()));
        trainer.getHand().remove(trainer.getUsedCard());
    }
    @Override
    public void visitObject(Objeto obj) {
        obj.effect();
        DiscardCard(obj.getTrainer());
    }

    @Override
    public void visitStadium(Estadio s) {
        this.Control.setCurrentStadium(s);
        DiscardCard(s.getTrainer());
    }

    @Override
    public void visitEnergy(Energia e) {
        e.getTrainer().getObjetivo().agregarEnergia(e);
        DiscardCard(e.getTrainer());
    }

    @Override
    public void visitPokemon(Pokemon p) {
        if(p.getTrainer().getActive().isNull() && p.getTrainer().getBench().isEmpty()){
            p.getTrainer().setActive(p);
            DiscardCard(p.getTrainer());
        }
        else if(p.getTrainer().getActive().isNull() && !p.getTrainer().getBench().isEmpty()){
            p.getTrainer().setActive(p.getTrainer().getBench().get(0));
            p.getTrainer().getBench().remove(0);
            p.getTrainer().getBench().add(p);
            DiscardCard(p.getTrainer());
        }
        else if (p.getTrainer().getBench().size()<5){
            p.getTrainer().getBench().add(p);
            DiscardCard(p.getTrainer());
        }
        else {
            System.out.println("No se puede jugar este pokemon");
        }
    }

    @Override
    public void visitSupport(Soporte s) {
        s.effect();
        DiscardCard(s.getTrainer());
    }

    @Override
    public void setCotroller(Controller control) {
        this.Control=control;
    }

    @Override
    public void visitP1Pokemon(Phase1 phase1) {
        if(Control.canEvolve(phase1.getTrainer(), phase1.getPreEvID())){
            phase1.evolve2P1(phase1.getTrainer().getObjetivo());
            DiscardCard(phase1.getTrainer());
        }
    }

    @Override
    public void visitP2Pokemon(Phase2 phase2) {
        if(Control.canEvolve(phase2.getTrainer(), phase2.getPreEvID())){
            phase2.evolve2P2(phase2.getTrainer().getObjetivo());
            DiscardCard(phase2.getTrainer());
        }
    }

}
