package game.visitor;

import game.Controller;
import game.carta.energia.Energia;
import game.carta.estadio.Estadio;
import game.carta.objeto.Objeto;
import game.carta.pokemon.Basic;
import game.carta.pokemon.Phase1;
import game.carta.pokemon.Phase2;
import game.carta.soporte.Soporte;
import game.Entrenador;
import game.habilidad.Habilidad;

/**
 * @author Fernando Maron
 */
public class VisitCard implements VisitorCard {
    private Controller Control;

    public VisitCard(){
    }

    /**
     * @see VisitorCard#removeCard(Entrenador)
     * @param trainer the trainer that will remove it's card
     */
    @Override
    public  void removeCard(Entrenador trainer){
        trainer.getHand().remove(trainer.getUsedCard());
    }

    /**
     * @see VisitorCard#discardCard(Entrenador)
     * @param trainer the trainer that will discard it's card
     */
    @Override
    public void discardCard(Entrenador trainer){
        trainer.getDiscard().add(0,trainer.getHand().get(trainer.getUsedCard()));
        trainer.getHand().remove(trainer.getUsedCard());
    }

    /**
     * @see VisitorCard#visitObject(Objeto)
     * @param obj the item card that was played
     */
    @Override
    public void visitObject(Objeto obj) {
        obj.effect();
        discardCard(obj.getTrainer());
    }

    /**
     * @see VisitorCard#visitStadium(Estadio)
     * @param s the stadium card the was played
     */
    @Override
    public void visitStadium(Estadio s) {
        this.Control.setCurrentStadium(s);
        removeCard(s.getTrainer());
    }

    /**
     * @see VisitorCard#visitEnergy(Energia)
     * @param e the energy card the was played
     */
    @Override
    public void visitEnergy(Energia e) {
        if(!Control.getUsedEnergy()) {
            e.getTrainer().getObjetivo().agregarEnergia(e);
            removeCard(e.getTrainer());
            Control.setUsedEnergy(true);
        }
    }

    /**
     * @see VisitorCard#visitPokemon(Basic)
     * @param p the pokemon card the was played
     */
    @Override
    public void visitPokemon(Basic p) {
        if(p.getTrainer().getActive().isNull() && p.getTrainer().getBench().isEmpty()){
            p.getTrainer().setActive(p);
            removeCard(p.getTrainer());
            for (Habilidad h:p.getHabilidades()){
                h.addObserver(Control);
            }
        }
        else if(p.getTrainer().getActive().isNull() && !p.getTrainer().getBench().isEmpty()){
            p.getTrainer().setActive(p.getTrainer().getBench().get(0));
            p.getTrainer().getBench().remove(0);
            p.getTrainer().getBench().add(p);
            removeCard(p.getTrainer());
            for (Habilidad h:p.getHabilidades()){
                h.addObserver(Control);
            }
        }
        else if (p.getTrainer().getBench().size()<5){
            p.getTrainer().getBench().add(p);
            removeCard(p.getTrainer());
            for (Habilidad h:p.getHabilidades()){
                h.addObserver(Control);
            }
        }
        else {
            System.out.println("No se puede jugar este pokemon");
        }

    }

    /**
     * @see VisitorCard#visitSupport(Soporte)
     * @param s the support card the was played
     */
    @Override
    public void visitSupport(Soporte s) {
        s.effect();
        discardCard(s.getTrainer());
    }

    /**
     * @see VisitorCard#setCotroller(Controller)
     * @param control the game controller that uses this visitor
     */
    @Override
    public void setCotroller(Controller control) {
        this.Control=control;
    }

    /**
     * @see VisitorCard#visitP1Pokemon(Phase1)
     * @param phase1 the stadium card the was played
     */
    @Override
    public void visitP1Pokemon(Phase1 phase1) {
        if(Control.canEvolvePhase1(phase1.getPreEvID())){
            phase1.evolve(phase1.getTrainer().getObjetivo());
            removeCard(phase1.getTrainer());
        }
    }

    /**
     * @see VisitorCard#visitP2Pokemon(Phase2)
     * @param phase2 the stadium card the was played
     */
    @Override
    public void visitP2Pokemon(Phase2 phase2) {
        if(Control.canEvolvePhase2(phase2.getPreEvID())){
            phase2.evolve(phase2.getTrainer().getObjetivo());
            removeCard(phase2.getTrainer());
        }
    }

}
