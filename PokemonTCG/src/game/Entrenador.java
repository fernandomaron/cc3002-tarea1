package game;

/**
 * @author Fernando Maron
 * Trainer class that is capable of playing cards and using pokemon's abilities
 */
import game.carta.Carta;
import game.carta.pokemon.Pokemon;
import game.carta.pokemon.PokemonNull;
import game.habilidad.Habilidad;
import game.visitor.VisitorCard;


import java.util.ArrayList;

public class Entrenador {
    private Pokemon Active=new PokemonNull();
    private ArrayList<Pokemon> Bench=new ArrayList<>();
    private ArrayList<Carta> Hand=new ArrayList<>();
    private ArrayList<Carta> Deck;
    private Pokemon Objetivo;
    private int objID;
    private ArrayList<Carta> Discard=new ArrayList<>();
    private ArrayList<Carta> Prize=new ArrayList<>();
    private int UsedCard= -1;

    public Entrenador(){
        this(new ArrayList<>());
    }
    public Entrenador(ArrayList<Carta> deck){
        Deck =deck;
    }

    /**
     * Method that allows to check what abilities the trainer's active pokemon has
     * @return list of active pokemon's abilities
     */
    public ArrayList<Habilidad> habilidadesPokemon(){
        return Active.getHabilidades();
    }

    /**
     * Method that allows the trainer to use an ability from his active pokemon
     * @param index the index of the ability that is going to be used
     */
    public void usarHabilidad(int index){
        Active.usar(Active.getHabilidades().get(index), Objetivo);
    }

    /**
     * This method allows the trainer to use a card from it's hand
     * @param index the index of the card that's going to be used
     * @param visitor the visitor that will check what type of card has been played
     */
    public void jugarCarta(int index, VisitorCard visitor) {
        UsedCard=index;
        Hand.get(index).setTrainer(this);
        Hand.get(index).accept(visitor);
    }

    /**
     * This method allows the trainer to set his active pokemon to another one
     * @param pokemon the pokemon that will be the active one
     */
    public void setActive(Pokemon pokemon){
        Active =pokemon;
    }

    /**
     * Method that allows to get the trainer's active pokemon
     * @return the trainer's active pokemon
     */
    public Pokemon getActive(){return Active;}

    /**
     * Method that allows to get the trainer's bench
     * @return the array of pokemons in the trainer's bench
     */
    public ArrayList<Pokemon> getBench(){
        return Bench;
    }

    /**
     * This method adds a card to the trainer's hand
     * @param carta the card that will be added
     */
    public void addToMano(Carta carta){
        Hand.add(carta);
    }

    /**
     * This method allows to set an array of cards as the trainer's hand
     * @param hand the array of cards that will be the trainer's new hand
     */
    public void setHand(ArrayList<Carta> hand) {
        Hand = hand;
    }

    /**
     * Allows to get the hand of the trainer
     * @return the trainer's hand
     */
    public ArrayList<Carta> getHand() {
        return Hand;
    }

    /**
     * Sets the bench of the trainer
     * @param newBanca the array of pokemon that will be the new bench
     */
    public void setBench(ArrayList<Pokemon> newBanca){
        Bench =newBanca;
    }

    /**
     * Checks if the Active pokemon is alive or not and sets the first benched pokemon as the new Active
     */
    public void checkActivo() {
        if (Active.getHP()==Active.getDMGCounter()){
            if(!Bench.isEmpty()){
                Active = Bench.get(0);
                Bench.remove(0);
            }
            else {
                Active =new PokemonNull();
            }
        }
    }

    /**
     * Sets the trainer's target pokemon
     * @param p the targeted pokemon
     */
    public void setObjetivo(Pokemon p){
        this.Objetivo=p;
        ArrayList<Pokemon> possible = new ArrayList<>(Bench);
        possible.add(0,Active);
        objID= possible.indexOf(p);

    }

    /**
     * Allows to get the current target pokemon
     * @return the target pokemon
     */
    public Pokemon getObjetivo(){return this.Objetivo;}

    /**
     * Allows to draw cards from the deck
     * @param n the number of cards that will be drawn
     */
    public void drawCards(int n){
        for(int i=0;i<n;i++){
            addToMano(Deck.get(0));
            Deck.remove(0);
        }
    }

    /**
     * Gets 6 cards from the deck to be the prize cards
     */
    public void drawPrize(){
        for(int i=0; i<6; i++){
            Prize.add(Deck.get(0));
            Deck.remove(0);
        }
    }

    /**
     * Allows to get the deck of the trainer
     * @return the trainer's deck
     */
    public ArrayList<Carta> getDeck(){
        return Deck;
    }

    /**
     * Allows to get the discard pile of the trainer
     * @return the trainer's discard pile
     */
    public ArrayList<Carta> getDiscard(){
        return Discard;
    }

    /**
     * Allows to get the prizes of the trainer
     * @return the trainer's prizes
     */
    public ArrayList<Carta> getPrize(){
        return Prize;
    }

    /**
     * Allows to draw a card from the prizes
     * @param index the index of the prize that wants to be drawn
     */
    public void winPrize(int index){
        Hand.add(Prize.get(index));
        Prize.remove(index);
    }

    /**
     * Allows to get the index of the card that was just used
     * @return the index of the used card
     */
    public int getUsedCard(){
        return UsedCard;
    }

    /**
     * Allows to get the id of the targeted pokemon
     * @return the id of the targeted pokemon
     */
    public int getObjID() {return objID;
    }

    /**
     * Method that evolves the targeted pokemon to the pokemon given
     * @param pokemon evolution of the targeted pokemon
     */
    public void Evolve(Pokemon pokemon) {
        if (objID==0){
            Discard.add(0, Active);
            Active=pokemon;
        }
        else {
            Discard.add(0,Bench.get(objID-1));
            Bench.set(objID - 1, pokemon);
        }
        Objetivo=pokemon;
    }

    /**
     * Allows to set the deck
     * @param deck the deck that will be the trainer's new deck
     */
    public void setDeck(ArrayList<Carta> deck){
        Deck=deck;
    }

}
