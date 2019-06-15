package game.habilidad.Ataques;

import game.CoinFlip;
import game.carta.energia.Energia;
import game.carta.pokemon.Pokemon;

import java.util.ArrayList;

public class ElectricShock extends Ataque{
    private int X;

    public ElectricShock(int dmg, ArrayList<Energia> costo, int x){
        super(dmg,"Electric Shock", "Throw a coin, if tails does x damage to the user", costo);
        X=x;
    }

    @Override
    public void efecto(Pokemon usuario, Boolean b) {
        if (!b){
            usuario.setDMGCounter(usuario.getDMGCounter()+X);
        }
    }
}
