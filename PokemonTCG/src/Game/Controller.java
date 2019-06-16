package game;

import game.carta.Carta;
import game.carta.estadio.Estadio;
import game.carta.pokemon.Pokemon;
import game.habilidad.Habilidad;
import game.visitor.VisitCard;
import game.visitor.VisitorCard;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Fernando Maron
 * Class that is capable of controlling the flow of the game, setting conditions for certain actions
 */
public class Controller implements Observer {
    private boolean UsedStadium = false;
    private Entrenador jugador1;
    private Entrenador jugador2;
    private Estadio currentStadium=new Estadio();
    private Entrenador currentTrainer;
    private Entrenador opponentTrainer;
    private VisitorCard visit=new VisitCard();
    private boolean UsedEnergy=false;

    public Controller(Entrenador j1, Entrenador j2){
        jugador1=j1;
        jugador2=j2;
        currentTrainer=j1;
        opponentTrainer=j2;
    }

    /**
     * Method that makes the current player draw index number of cards
     * @param index the number of cards the player will draw
     */
    public void playCard(int index){
        currentTrainer.jugarCarta(index, visit);
    }

    /**
     * Method that allows to tells the visitor who is the controller of the game
     */
    public void cotrolVisitor(){
        this.visit.setCotroller(this);
    }

    /**
     * Method that activates the current stadium's effect on to the current player
     */
    public void stadiumEffect() {
        if(!UsedStadium) {
            this.currentStadium.efecto(currentTrainer, CoinFlip.Flip());
            UsedStadium = true;
        }
    }

    /**
     * Sets the current stadium to the one that has been received
     * @param s the stadium which will take the place of the current stadium
     */
    public void setCurrentStadium(Estadio s) {
        this.currentStadium=s;
    }

    /**
     * Method that sets a pokemon as a target of the current player
     * @param pokemon the pokemon that is targeted
     */
    public void chooseTargetPokemon(Pokemon pokemon){
        currentTrainer.setObjetivo(pokemon);
    }

    /**
     * Method that allows to retieve the card visitor of the game
     * @return the card visitor of the game
     */
    public VisitorCard getVisitor() {
        return this.visit;
    }

    /**
     * This method allows to set the condition of the usage of the current stadium's effect
     * @param b boolean parameter that is set as the condition of the usage of the current stadium
     */
    public void setUsedStadium(boolean b) {
        UsedStadium=b;
    }

    /**
     * Method that checks if the pokemon phase 1 that was played can evolve from the selected pokemon
     * the current trainer
     * @param prevolutionid the id that the selected pokemon by the current player must have
     * @return true if the pokemon is basic and of the same id as the one given, false if not
     */
    public boolean canEvolvePhase1(int prevolutionid) {
        return currentTrainer.getObjetivo().getID()==prevolutionid && currentTrainer.getObjetivo().isBasic();


    }

    /**
     * Resets all conditions of one's turn
     */
    public void startTurn(){
        UsedEnergy=false;
        UsedStadium=false;
    }

    /**
     * This method signalizes the end ofa turn, changing the current player with his opponent and
     * resetting all conditions, such as the usage of energy an the stadium's effect, by starting
     * a new turn
     */
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

    /**
     * Method to check what you are currently holding in your hand
     * @return an array with the cards in your hand
     */
    public ArrayList<Carta> getHand(){return currentTrainer.getHand();}

    /**
     * This method allows you to get the list of all your opponent's pokemons, active and benched
     * @return an array with all your pokemon
     */
    public ArrayList<Pokemon> getEnemyPokemon(){
        ArrayList<Pokemon> res = new ArrayList<>(opponentTrainer.getBench());
        res.add(0,opponentTrainer.getActive());
        return res;
    }

    /**
     * This method allows you to get the list of all your pokemons, active and benched
     * @return an array with all your pokemon
     */
    public ArrayList<Pokemon> getMyPokemon(){
        ArrayList<Pokemon> res = new ArrayList<>(currentTrainer.getBench());
        res.add(0,currentTrainer.getActive());
        return res;
    }

    /**
     * method that allows the current player to draw i number of cards
     * @param i the number of cards thatwill be drawn
     */
    public void drawMyCards(int i){
        currentTrainer.drawCards(i);
    }

    /**
     * Method that allows the current opponent player to draw i number of cards
     * @param i the number of cards that will be drawn
     */
    public void opponentDrawCards(int i){
        opponentTrainer.drawCards(i);
    }

    /**
     * Allows to check the list of abilities of the current trainer's active pokemon
     * @return an array with the active pokemon's abilities
     */
    public ArrayList<Habilidad> getActivesAbility(){
        return currentTrainer.getActive().getHabilidades();
    }

    /**
     * Allows to use a chosen ability from the current trainer's active pokemon
     * @param index the index of the ability in it's pokemon's array
     */
    public void useAbility(int index){
        currentTrainer.usarHabilidad(index);
    }

    /**
     * Method that checks if the pokemon phase 2 that was played can evolve from the selected pokemon
     * the current trainer
     * @param preEvID the id that the selected pokemon by the current player must have
     * @return true if the pokemon is phase 2 and of the same id as the one given, false if not
     */
    public boolean canEvolvePhase2(int preEvID) {
        return currentTrainer.getObjetivo().getID()==preEvID && currentTrainer.getObjetivo().isPhase1();
    }

    /**
     * this method sets the usage of an energy according to the parameter given
     * @param b a boolean that describes the current status of an used energy
     */
    public void setUsedEnergy(boolean b) {
        UsedEnergy=b;
    }

    /**
     * Method that is activated when informed from the controller's observed abilities.
     * It only activates when an attack has been used, signalizing the end of a turn
     * @param o the ability that has made the notification
     * @param arg an argument that allows to identify the type of update that is required
     */
    @Override
    public void update(Observable o, Object arg) {
        opponentTrainer.checkActivo();
        endTurn();
        startTurn();
    }

    /**
     * This method allows to know if an energy has already been used in the current turn
     * @return true if an energy has been used, otherwise returns false
     */
    public boolean getUsedEnergy() {return UsedEnergy;
    }

    /**
     * Method that allows to check if a deck has exceeded the maximum amount of cards
     * @param Deck the deck that will be checked to see if it's valid
     * @return true if the deck is valid, false if not
     */
    public boolean checkDeck(ArrayList<Carta> Deck){
        return Deck.size() <= 60;
    }

    public Entrenador getCurrentTrainer(){
        return currentTrainer;
    }

    public Entrenador getOpponentTrainer(){
        return opponentTrainer;
    }

    public void drawPrize() {
        currentTrainer.drawPrize();
    }
}
