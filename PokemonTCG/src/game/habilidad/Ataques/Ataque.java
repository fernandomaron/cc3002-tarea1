package game.habilidad.Ataques;

import game.CoinFlip;
import game.Entrenador;
import game.carta.energia.Energia;
import game.carta.pokemon.Pokemon;
import game.habilidad.Habilidad;
import game.habilidad.OHabilidad;
import javafx.beans.InvalidationListener;

import java.util.ArrayList;

/**
 * @author Fernando Maron
 * Class for abilities that perform an attack
 */
public class Ataque extends Habilidad {
    private int Dmg;
    private String Nombre;
    private String Descripcion;
    private ArrayList<Energia> Costo;

    public Ataque(){
        this(0, "", "", new ArrayList<>());
    }

    public Ataque(int dmg, String nombre, String descripcion, ArrayList<Energia> costo){
        Dmg=dmg;
        Nombre=nombre;
        Descripcion=descripcion;
        Costo=costo;
    }


    @Override
    public void ejecutar(Pokemon usuario) {
        if(usuario.hasEnergy(this.getCosto())) {
            this.attack(usuario);
        }
        else {
            System.out.println("No se tienen suficientes energías");
        }
    }

    @Override
    public void efecto(Pokemon usuario, Boolean b) {

    }

    public void attack(Pokemon usuario) {
        usuario.atacarCon(this);
        this.efecto(usuario, CoinFlip.Flip());
        notifyObservers();

    }

    public int getDmg(){
        return Dmg;
    }

    public String getNombre(){return Nombre;}

    public String getDescripcion(){return Descripcion;}

    public ArrayList<Energia> getCosto(){return Costo;}


}