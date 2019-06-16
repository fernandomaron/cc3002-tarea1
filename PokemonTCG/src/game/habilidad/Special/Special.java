package game.habilidad.Special;

import game.CoinFlip;
import game.carta.pokemon.Pokemon;
import game.habilidad.Habilidad;

public  class Special extends Habilidad {
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
        this.efecto(usuario, CoinFlip.Flip());
    }

    @Override
    public void efecto(Pokemon usuario, Boolean b) {

    }


}
