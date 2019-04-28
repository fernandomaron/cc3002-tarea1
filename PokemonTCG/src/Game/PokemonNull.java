package Game;

import Game.Ataque;
import Game.Energia;
import Game.Entrenador;
import Game.Pokemon;

import java.util.ArrayList;

public class PokemonNull implements Pokemon {


    @Override
    public boolean hasEnergy(ArrayList<Energia> costo) {
        return false;
    }

    @Override
    public void agregarEnergia(Energia energia) {
        System.out.println("No se puede agregar energia");
        return;
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public void atacarCon(Ataque ataque, Pokemon objetivo) {
        return;
    }

    @Override
    public void atacadoPorPsiquico(Ataque ataque) {

    }

    @Override
    public void atacadoPorPlanta(Ataque ataque) {

    }

    @Override
    public void atacadoPorLucha(Ataque ataque) {

    }

    @Override
    public void atacadoPorFuego(Ataque ataque) {

    }

    @Override
    public void atacadoPorElectrico(Ataque ataque) {

    }

    @Override
    public void atacadoPorAgua(Ataque ataque) {

    }

    @Override
    public void jugar(Entrenador entrenador) {
        return;
    }
}
