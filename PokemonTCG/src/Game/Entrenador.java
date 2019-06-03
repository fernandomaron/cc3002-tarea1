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
    private Pokemon Activo;
    private ArrayList<Pokemon> Banca;
    private ArrayList<Carta> Mano;
    public Entrenador(){
        this(new PokemonNull(), new ArrayList<>(), new ArrayList<>());
    }
    public Entrenador(Pokemon activo,ArrayList<Pokemon> banca,ArrayList<Carta> mano){
        Activo=activo;
        Banca=banca;
        Mano=mano;
    }

    public ArrayList<Habilidad> habilidadesActivo(){return Activo.getHabilidades();}
    public void usarHabilidad(int index, Pokemon objetivo){
        Activo.usar(Activo.getHabilidades().get(index), objetivo);
    }
    public void jugarCarta(int index) {
        Mano.get(index).setTrainer(this);
        Mano.get(index).jugar();
        Mano.remove(index);
    }

    public void setActivo(Pokemon pokemon){
        Activo=pokemon;
    }

    public Pokemon getActivo(){return Activo;}

    public ArrayList<Pokemon> getBanca(){
        return Banca;
    }

    public void addToMano(Carta carta){
        Mano.add(carta);
    }
    public void setMano(ArrayList<Carta> mano) {
        Mano = mano;
    }

    public ArrayList<Carta> getMano() {
        return Mano;
    }

    public void setBanca(ArrayList<Pokemon> newBanca){Banca=newBanca;}

    public void checkActivo() {
        if (Activo.getHP()<=0){
            if(!Banca.isEmpty()){
                Activo=Banca.get(0);
                Banca.remove(0);
            }
            else {
                Activo=new PokemonNull();
            }
        }
    }
}
