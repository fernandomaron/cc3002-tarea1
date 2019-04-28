package Game;

import java.util.ArrayList;

@SuppressWarnings("InfiniteRecursion")
public abstract class AbstractPokemon implements Pokemon {
    private int HP;
    private int ID;
    private ArrayList<Energia> Energias;
    private ArrayList<Habilidad> Habilidades;
    private Entrenador Trainer;

    public void agregarEnergia(Energia energia){
        Energias.add(energia);
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int hp){
        this.HP=hp;
    }

    public void setID(int id){
        this.ID=id;
    }

    public int getID(){
        return ID;
    }

    public void setEnergias(ArrayList<Energia> energias){
        this.Energias=energias;
    }

    public void setHabilidades(ArrayList<Habilidad> habilidades){
        this.Habilidades=habilidades;
    }
    @Override
    public void jugar(Entrenador entrenador) {
        this.setTrainer(entrenador);
        entrenador.jugarPokemon(this);
    }

    @Override
    public boolean isNull() {
        return false;
    }

    public void setTrainer(Entrenador trainer) {
        Trainer = trainer;
    }

    public void usar(Habilidad habilidad, Pokemon objetivo) {
        habilidad.ejecutar(this, objetivo);
    }

    public boolean hasEnergy(ArrayList<Energia> costo){
        ArrayList<Energia> check = (ArrayList<Energia>) Energias.clone();
        int c;
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
        if (this.getHP()<=0){
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
