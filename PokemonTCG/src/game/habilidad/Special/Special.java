package game.habilidad.Special;

import game.carta.pokemon.Pokemon;
import game.habilidad.Habilidad;

public  class Special implements Habilidad {
    private String Nombre;
    private String Descripcion;

    public Special(){
        this("", "");
    }

    public Special(String nombre, String descripcion){
        Nombre=nombre;
        Descripcion=descripcion;
    }
    @Override
    public void ejecutar(Pokemon usuario) {
        this.efecto(usuario);
    }

    @Override
    public void efecto(Pokemon usuario) {
    }
}
