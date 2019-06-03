package Game.Carta.Pokemon;

import Game.*;
import Game.Carta.Energia.Energia;
import Game.Habilidad.Ataque;
import Game.Habilidad.Habilidad;

import java.util.ArrayList;

@SuppressWarnings("InfiniteRecursion")
/**
 * @author Fernando Maron
 * Class that sets a base for all different classes of pokemon, except for the null class
 */
public abstract class AbstractPokemon implements Pokemon {
    private int HP;
    private int ID;
    private ArrayList<Energia> Energias;
    private ArrayList<Habilidad> Habilidades;
    private Entrenador Trainer;

    public void setTrainer(Entrenador trainer) {
        Trainer = trainer;
    }

    public Entrenador getTrainer(){
        return this.Trainer;
    }

    @Override
    public void jugar() {
        if(Trainer.getActivo().isNull() && Trainer.getBanca().isEmpty()){
            Trainer.setActivo(this);
        }
        else if(Trainer.getActivo().isNull() && !Trainer.getBanca().isEmpty()){
            Trainer.setActivo(Trainer.getBanca().get(0));
            Trainer.getBanca().remove(0);
            Trainer.getBanca().add(this);
        }
        else if (Trainer.getBanca().size()<5){
            Trainer.getBanca().add(this);
        }
        else {
            System.out.println("No se puede jugar este pokemon");
        }
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

    public void agregarEnergia(Energia energia){
        Energias.add(energia);
    }

    public boolean hasEnergy(ArrayList<Energia> costo){
        ArrayList<Energia> check = (ArrayList<Energia>) Energias.clone();
        int c;
        for (Energia aCosto : costo) {
            c = 0;
            for (int j = 0; j < check.size(); j++) {
                if (aCosto.equals(check.get(j))) {
                    check.remove(j);
                    c = 1;
                    break;
                }
            }
            if (c == 0) {
                return false;
            }
        }
        return true;
    }

    public void setHabilidades(ArrayList<Habilidad> habilidades){
        if(habilidades.size()<5) {
            this.Habilidades = habilidades;
        }
        else{
            for(int i=0;i<5;i++){
                this.Habilidades.add(habilidades.get(i));
            }
        }
    }

    @Override
    public ArrayList<Habilidad> getHabilidades() {
        return Habilidades;
    }

    public void usar(Habilidad habilidad, Pokemon objetivo) {
        habilidad.ejecutar(this, objetivo);
    }

    @Override
    public boolean isNull() {
        return false;
    }

    public void checkHP(){
        if (this.Trainer!=null) {
            Trainer.checkActivo();
        }
    }

    @Override
    public void atacarCon(Ataque ataque, Pokemon objetivo) {
        this.atacarCon(ataque, objetivo);
    }

    @Override
    public void atacadoPorPsiquico(Ataque ataque) {
        this.atacadoPorPsiquico(ataque);
    }

    @Override
    public void atacadoPorPlanta(Ataque ataque) {
        this.atacadoPorPlanta(ataque);
    }

    @Override
    public void atacadoPorLucha(Ataque ataque) {
        this.atacadoPorLucha(ataque);
    }

    @Override
    public void atacadoPorFuego(Ataque ataque) {
        this.atacadoPorFuego(ataque);
    }

    @Override
    public void atacadoPorElectrico(Ataque ataque) {
        this.atacadoPorElectrico(ataque);
    }

    @Override
    public void atacadoPorAgua(Ataque ataque) {
        this.atacadoPorAgua(ataque);
    }

}
