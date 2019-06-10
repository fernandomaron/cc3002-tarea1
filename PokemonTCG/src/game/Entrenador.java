package game;

/**
 * @author Fernando Maron
 */
import game.carta.Carta;
import game.carta.energia.Energia;
import game.carta.estadio.Estadio;
import game.carta.objeto.Objeto;
import game.carta.pokemon.Pokemon;
import game.carta.pokemon.PokemonNull;
import game.carta.soporte.Soporte;
import game.habilidad.Habilidad;
import game.visitor.Visitor;
import game.visitor.visitCard;

import java.util.ArrayList;

public class Entrenador {
    private Pokemon Active;
    private ArrayList<Pokemon> Bench;
    private ArrayList<Carta> Hand;
    private ArrayList<Carta> Deck;
    private Visitor visitorC;

    public Entrenador(){
        this(new PokemonNull(), new ArrayList<>(), new ArrayList<>());
    }
    public Entrenador(Pokemon activo,ArrayList<Pokemon> banca,ArrayList<Carta> mano){
        Active =activo;
        Bench =banca;
        Hand =mano;
        visitorC=new visitCard(this);
    }

    public ArrayList<Habilidad> habilidadesActivo(){return Active.getHabilidades();}
    public void usarHabilidad(int index, Pokemon objetivo){
        Active.usar(Active.getHabilidades().get(index), objetivo);
    }
    public void jugarCarta(int index) {
        Hand.get(index).setTrainer(this);
        Hand.get(index).accept(visitorC);
        Hand.remove(index);
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
}
