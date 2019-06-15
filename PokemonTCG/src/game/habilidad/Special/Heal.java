package game.habilidad.Special;

import game.carta.pokemon.Pokemon;

public class Heal extends Special{
    public Heal(){
        super("Heal","Heals 1 damage counter");
    }

    @Override
    public void efecto(Pokemon usuario,Boolean b) {
        usuario.getObjetivo().setDMGCounter(usuario.getObjetivo().getDMGCounter()-10);
    }
}
