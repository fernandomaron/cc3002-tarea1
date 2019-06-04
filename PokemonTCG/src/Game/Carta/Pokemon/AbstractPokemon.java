package Game.Carta.Pokemon;

import Game.*;
import Game.Carta.Energia.Energia;
import Game.Habilidad.Ataque;
import Game.Habilidad.Habilidad;
import Game.Visitor.Visitor;

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

    public void accept(Visitor visitor){
        visitor.visitPokemon(this);
    }
    public void jugar() {
        if(Trainer.getActive().isNull() && Trainer.getBench().isEmpty()){
            Trainer.setActive(this);
        }
        else if(Trainer.getActive().isNull() && !Trainer.getBench().isEmpty()){
            Trainer.setActive(Trainer.getBench().get(0));
            Trainer.getBench().remove(0);
            Trainer.getBench().add(this);
        }
        else if (Trainer.getBench().size()<5){
            Trainer.getBench().add(this);
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
