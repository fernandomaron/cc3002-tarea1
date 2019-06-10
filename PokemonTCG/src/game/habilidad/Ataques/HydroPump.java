package game.habilidad.Ataques;

import game.carta.energia.Energia;
import game.carta.pokemon.Pokemon;

import java.util.ArrayList;

public class HydroPump extends Ataque{
    public HydroPump(int dmg, ArrayList<Energia> costo){
        super(dmg, "Hydro Pump", "Does x damage plus 10 for each energy of the same type as the pokemon.It can't exceed from y damage", costo);
    }

    @Override
    public void efecto(Pokemon usuario) {
        usuario.getEnergias();

    }
}
