package game;

import game.carta.Carta;
import game.carta.estadio.Estadio;
import game.carta.pokemon.Pokemon;
import game.habilidad.Habilidad;
import game.visitor.VisitCard;
import game.visitor.Visitor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
    private boolean UsedStadium = false;
    private Entrenador jugador1;
    private Entrenador jugador2;
    private Estadio currentStadium=new Estadio();
    private Entrenador currentTrainer;
    private Entrenador opponentTrainer;
    private Visitor visit=new VisitCard();
    private boolean UsedEnergy=false;

    public Controller(Entrenador j1, Entrenador j2){
        jugador1=j1;
        jugador2=j2;
        currentTrainer=j1;
        opponentTrainer=j2;
    }

    public void playCard(int index){
        currentTrainer.jugarCarta(index, visit);
    }

    public void cotrolVisitor(){
        this.visit.setCotroller(this);
    }

    public void stadiumEffect() {
        if(!UsedStadium) {
            this.currentStadium.efecto(currentTrainer, CoinFlip.Flip());
            UsedStadium = true;
        }
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

    public boolean canEvolvePhase1(int prevolutionid) {
        return currentTrainer.getObjetivo().getID()==prevolutionid && currentTrainer.getObjetivo().isBasic();


    }

    public void startTurn(){
        UsedEnergy=false;
        UsedStadium=false;
    }

    public void endTurn(){
        if(currentTrainer.equals(jugador1)){
            currentTrainer=jugador2;
            opponentTrainer=jugador1;
        }
        else {
            currentTrainer=jugador1;
            opponentTrainer=jugador2;
        }
    }

    public ArrayList<Carta> getHand(){return currentTrainer.getHand();}

    public ArrayList<Pokemon> getEnemyPokemon(){
        ArrayList<Pokemon> res = new ArrayList<>(opponentTrainer.getBench());
        res.add(0,opponentTrainer.getActive());
        return res;
    }

    public ArrayList<Pokemon> getMyPokemon(){
        ArrayList<Pokemon> res = new ArrayList<>(currentTrainer.getBench());
        res.add(0,currentTrainer.getActive());
        return res;
    }

    public void drawMyCards(int i){
        currentTrainer.drawCards(i);
    }

    public void opponentDrawCards(int i){
        opponentTrainer.drawCards(i);
    }

    public ArrayList<Habilidad> getActivesAbility(){
        return currentTrainer.getActive().getHabilidades();
    }

    public void useAbility(int index){
        currentTrainer.usarHabilidad(index);
    }

    public boolean canEvolvePhase2(int preEvID) {
        return currentTrainer.getObjetivo().getID()==preEvID && currentTrainer.getObjetivo().isPhase1();
    }

    public void setUsedEnergy(boolean b) {
        UsedEnergy=b;
    }

    @Override
    public void update(Observable o, Object arg) {
        opponentTrainer.checkActivo();
        endTurn();
        startTurn();
    }

    public boolean getUsedEnergy() {return UsedEnergy;
    }

    public boolean checkDeck(Entrenador entrenador){
        return entrenador.getDeck().size() <= 60;
    }
}
