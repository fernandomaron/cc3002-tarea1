package game.habilidad.Ataques;

import game.Entrenador;
import game.carta.energia.Energia;
import game.carta.pokemon.Pokemon;
import game.habilidad.Habilidad;

import java.util.ArrayList;

/**
 * @author Fernando Maron
 * Class for abilities that perform an attack
 */
public class Ataque implements Habilidad {
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
            this.efecto(usuario);
        }
        else {
            System.out.println("No se tienen suficientes energías");
        }
    }

    @Override
    public void efecto(Pokemon usuario) {
        usuario.atacarCon(this);
    }

    public int getDmg(){
        return Dmg;
    }

    public String getNombre(){return Nombre;}

    public String getDescripcion(){return Descripcion;}

    public ArrayList<Energia> getCosto(){return Costo;}
}