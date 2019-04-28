package Game;

import java.util.ArrayList;

public abstract class AbstractPokemon implements Pokemon {
    protected int HP;
    protected int ID;
    protected ArrayList<Energia> Energias;
    protected ArrayList<Habilidad> Habilidades;
    protected Entrenador Trainer;

    public void agregarEnergia(Energia energia){
        Energias.add(energia);
    }

    @Override
    public void jugar(Entrenador entrenador) {
        Trainer=entrenador;
        entrenador.jugarPokemon(this);
    }

    @Override
    public boolean isNull() {
        return false;
    }

    public void usar(Habilidad habilidad, Pokemon objetivo) {
        habilidad.ejecutar(this, objetivo);
    }

    public boolean hasEnergy(ArrayList<Energia> costo){
        ArrayList<Energia> check = (ArrayList<Energia>) Energias.clone();
        int c=0;
        for(int i=0; i<costo.size(); i++){
            c=0;
            for(int j=0; j<check.size(); j++) {
                if (costo.get(i).equals(check.get(j))) {
                    check.remove(j);
                    c=1;
                    break;
                }
            }
            if (c==0){
                return false;
            }
        }
        return true;
    }

    @Override
    public void atacarCon(Ataque ataque, Pokemon objetivo) {
        this.atacarCon(ataque, objetivo);
    }

    public void checkHP(){
        if (HP<=0){
            ArrayList<Pokemon>newBanca=Trainer.getBanca();
            if (!newBanca.isEmpty()) {
                Trainer.setActivo(newBanca.get(0));
                newBanca.remove(0);
                Trainer.setBanca(newBanca);
            }
            else{
                System.out.println("No se tiene Pokemon en banca");
            }
        }
    }

    @Override
    public void atacadoPorPsiquico(Ataque ataque) {
        this.atacadoPorPsiquico(ataque);
        this.checkHP();
    }

    @Override
    public void atacadoPorPlanta(Ataque ataque) {
        this.atacadoPorPlanta(ataque);
        this.checkHP();
    }

    @Override
    public void atacadoPorLucha(Ataque ataque) {
        this.atacadoPorLucha(ataque);
        this.checkHP();
    }

    @Override
    public void atacadoPorFuego(Ataque ataque) {
        this.atacadoPorFuego(ataque);
        this.checkHP();
    }

    @Override
    public void atacadoPorElectrico(Ataque ataque) {
        this.atacadoPorElectrico(ataque);
        this.checkHP();
    }

    @Override
    public void atacadoPorAgua(Ataque ataque) {
        this.atacadoPorAgua(ataque);
        this.checkHP();
    }

    @Override
    public ArrayList<Habilidad> getHabilidades() {
        return Habilidades;
    }
}
