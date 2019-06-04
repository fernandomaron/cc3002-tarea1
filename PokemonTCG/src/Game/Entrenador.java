package Game;

/**
 * @author Fernando Maron
 */
import Game.Carta.Carta;
import Game.Carta.Pokemon.Pokemon;
import Game.Carta.Pokemon.PokemonNull;
import Game.Habilidad.Habilidad;

import java.util.ArrayList;

public class Entrenador {
    private Pokemon Active;
    private ArrayList<Pokemon> Bench;
    private ArrayList<Carta> Hand;
    private ArrayList<Carta> Deck;

    public Entrenador(){
        this(new PokemonNull(), new ArrayList<>(), new ArrayList<>());
    }
    public Entrenador(Pokemon activo,ArrayList<Pokemon> banca,ArrayList<Carta> mano){
        Active =activo;
        Bench =banca;
        Hand =mano;
    }

    public ArrayList<Habilidad> habilidadesActivo(){return Active.getHabilidades();}
    public void usarHabilidad(int index, Pokemon objetivo){
        Active.usar(Active.getHabilidades().get(index), objetivo);
    }
    public void jugarCarta(int index) {
        Hand.get(index).setTrainer(this);
        Hand.get(index).jugar();
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
        if (Active.getHP()<=0){
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
