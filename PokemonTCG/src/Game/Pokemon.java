package Game;

import java.util.ArrayList;

public interface Pokemon extends Carta {
    boolean hasEnergy(ArrayList<Energia> costo);

    void agregarEnergia(Energia energia);

    boolean isNull();

    void atacarCon(Ataque ataque, Pokemon objetivo);

    void atacadoPorPsiquico(Ataque ataque);

    void atacadoPorPlanta(Ataque ataque);

    void atacadoPorLucha(Ataque ataque);

    void atacadoPorFuego(Ataque ataque);

    void atacadoPorElectrico(Ataque ataque);

    void atacadoPorAgua(Ataque ataque);

    ArrayList<Habilidad> getHabilidades();

    void usar(Habilidad habilidad, Pokemon objetivo);

    int getHP();

    int getID();

    void setHP(int hp);

    void setID(int id);

    void setHabilidades(ArrayList<Habilidad> habilidades);

    void checkHP();

    void setTrainer(Entrenador entrenador);

    Entrenador getTrainer();

    void setEnergias(ArrayList<Energia> energias);
}
