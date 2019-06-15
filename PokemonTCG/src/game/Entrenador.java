package game;

/**
 * @author Fernando Maron
 */
import game.carta.Carta;
import game.carta.pokemon.Basic;
import game.carta.pokemon.Pokemon;
import game.carta.pokemon.PokemonNull;
import game.habilidad.Habilidad;
import game.visitor.Visitor;


import java.util.ArrayList;

public class Entrenador {
    private Pokemon Active;
    private ArrayList<Pokemon> Bench;
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

    public ArrayList<Habilidad> habilidadesPokemon(){
        return Active.getHabilidades();
    }
    public void usarHabilidad(int index){
        Active.usar(Active.getHabilidades().get(index), Objetivo);
    }
    public void jugarCarta(int index, Visitor visitor) {
        UsedCard=index;
        Hand.get(index).setTrainer(this);
        Hand.get(index).accept(visitor);
    }

    public void setActive(Pokemon pokemon){
        Active =pokemon;
    }

    public Pokemon getActive(){return Active;}

    public ArrayList<Pokemon> getBench(){
        return Bench;
    }

    public void addToMano(Carta carta){
        Hand.add(carta);
    }
    public void setHand(ArrayList<Carta> hand) {
        Hand = hand;
    }

    public ArrayList<Carta> getHand() {
        return Hand;
    }

    public void setBench(ArrayList<Pokemon> newBanca){
        Bench =newBanca;}

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
    public void setObjetivo(Pokemon p){
        this.Objetivo=p;
        ArrayList<Pokemon> possible = new ArrayList<>(Bench);
        possible.add(0,Active);
        objID= possible.indexOf(p);

    }
    public Pokemon getObjetivo(){return this.Objetivo;}

    public void useStadium(Controller controller){
        controller.stadiumEffect();
    }
    public void drawCards(int n){
        for(int i=0;i<n;i++){
            addToMano(Deck.get(0));
            Deck.remove(0);
        }
    }

    public void addPrize(Carta carta){
        Prize.add(carta);
    }

    public ArrayList<Carta> getDeck(){
        return Deck;
    }

    public ArrayList<Carta> getDiscard(){
        return Discard;
    }

    public ArrayList<Carta> getPrize(){
        return Prize;
    }

    public void drawPrize(int index){
        Hand.add(Prize.get(index));
        Prize.remove(index);
    }

    public int getUsedCard(){
        return UsedCard;
    }

    public int getObjID() {return objID;
    }

    public void Evolve(Pokemon pokemon) {
        if (objID==0){
            Discard.add(0, Active);
            Active=pokemon;
        }
        else {
            Discard.add(0,Bench.get(objID-1));
            Bench.set(objID - 1, pokemon);
        }
    }

    public void setDeck(ArrayList<Carta> deck){
        Deck=deck;
    }

    public void setPrize(ArrayList<Carta> prize){
        Prize=prize;
    }
}
