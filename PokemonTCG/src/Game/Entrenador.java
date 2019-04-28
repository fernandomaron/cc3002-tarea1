package Game;

import Game.Carta;
import Game.Energia;

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
    public void jugarCarta(int index){
        Mano.get(index).jugar(this);
        Mano.remove(index);
    }
    public void jugarEnergia(Energia energia) {
        Activo.agregarEnergia(energia);
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
    public void jugarPokemon(Pokemon pokemon){
        if(this.getActivo().isNull() && Banca.isEmpty()){
            this.setActivo(pokemon);
        }
        else if(this.getActivo().isNull() && !Banca.isEmpty()){
            this.setActivo(Banca.get(0));
            Banca.remove(0);
            Banca.add(pokemon);
        }
        else if (Banca.size()<5){
            Banca.add(pokemon);
        }
        else {
            System.out.println("No se puede jugar este pokemon");
        }
    }

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
