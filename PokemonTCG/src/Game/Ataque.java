package Game;

import java.util.ArrayList;

public class Ataque implements Habilidad {
    private int Dmg;
    private String Nombre;
    private String Descripcion;
    private ArrayList<Energia> Costo;

    public Ataque(){
        Dmg=0;
        Nombre="";
        Descripcion="";
        Costo=new ArrayList<>();
    }

    public Ataque(int dmg, String nombre, String descripcion, ArrayList<Energia> costo){
        Dmg=dmg;
        Nombre=nombre;
        Descripcion=descripcion;
        Costo=costo;
    }


    @Override
    public void ejecutar(Pokemon usuario, Pokemon objetivo) {
        if(usuario.hasEnergy(this.getCosto())) {
            usuario.atacarCon(this, objetivo);
        }
        else {
            System.out.println("No se tienen suficientes energías");
        }
    }

    public int getDmg(){
        return Dmg;
    }

    public String getNombre(){return Nombre;}

    public String getDescripcion(){return Descripcion;}

    public ArrayList<Energia> getCosto(){return Costo;}
}