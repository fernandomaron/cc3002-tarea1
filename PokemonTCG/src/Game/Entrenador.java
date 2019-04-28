package Game;

import Game.Carta;
import Game.Energia;

import java.util.ArrayList;

public class Entrenador {
    private Pokemon Activo;
    private ArrayList<Pokemon> Banca;
    private ArrayList<Carta> Mano;
    public Entrenador(){
        Activo=new PokemonNull();
        Banca=new ArrayList<>();
        Mano=new ArrayList<>();
    }

    public ArrayList<Habilidad> habilidadesActivo(){return Activo.getHabilidades();}
    public void usarHabilidad(int index, Pokemon objetivo){
        Activo.usar(Activo.getHabilidades().get(index), objetivo);
    }
    public void jugarCarta(int index){
        Mano.get(index).jugar(this);
    }
    public void jugarEnergia(Energia energia) {
        Activo.agregarEnergia(energia);
    }

    public void setActivo(Pokemon pokemon){
        Activo=pokemon;
    }

    public ArrayList<Pokemon> getBanca(){
        return Banca;
    }

    public void setBanca(ArrayList<Pokemon> newBanca){Banca=newBanca;}
    public void jugarPokemon(Pokemon pokemon){
        int check=0;
        if (Banca.isEmpty()){
            Banca.add(pokemon);
            Mano.remove(pokemon);
            check=1;
        }
        if(Activo.isNull()){
            this.setActivo(Banca.get(0));
            Banca.remove(0);
        }
        if (check==0 && Banca.size()<5){
            Banca.add(pokemon);
            Mano.remove(pokemon);
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
