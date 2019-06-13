package game;

import game.carta.estadio.Estadio;
import game.carta.pokemon.Pokemon;
import game.visitor.VisitCard;
import game.visitor.Visitor;

public class Controller {
    private boolean UsedStadium = false;
    private Entrenador jugador1=new Entrenador();
    private Entrenador jugador2=new Entrenador();
    private Estadio currentStadium=new Estadio();
    private Visitor visit=new VisitCard();

    public Controller(){}

    public void controlPlayers(Entrenador j1, Entrenador j2){
        this.jugador1=j1;
        this.jugador2=j2;
        j1.setController(this);
        j2.setController(this);
    }

    public void cotrolVisitor(){
        this.visit.setCotroller(this);
    }

    public void stadiumEffect(Entrenador entrenador) {
        this.currentStadium.efecto(entrenador);
    }

    public void setCurrentStadium(Estadio s) {
        this.currentStadium=s;
    }

    public void chooseTargetPokemon(Entrenador entrenador, Pokemon pokemon){
        entrenador.setObjetivo(pokemon);
    }

    public Visitor getVisitor() {
        return this.visit;
    }

    public void setUsedStadium(boolean b) {
        UsedStadium=b;
    }

    public boolean canEvolve(Entrenador trainer, int prevolutionid) {
        return trainer.getObjetivo().getID()==prevolutionid;

    }
}
