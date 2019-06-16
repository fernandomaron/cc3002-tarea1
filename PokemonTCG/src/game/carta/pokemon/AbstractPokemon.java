package game.carta.pokemon;

import game.*;
import game.carta.ACarta;
import game.carta.energia.Energia;
import game.habilidad.Habilidad;

import java.util.ArrayList;

/**
 * @author Fernando Maron
 * Class that sets a base for all different classes of pokemon, except for the null class
 */
public abstract class AbstractPokemon extends ACarta implements Pokemon{
    private int HP;
    private int ID;
    private ArrayList<Energia> Energias= new ArrayList<>();
    private ArrayList<Habilidad> Habilidades=new ArrayList<>();
    private Entrenador Trainer = super.getTrainer();
    private Pokemon objetivo=null;
    private int DMGCounter;
    private int PreEvID;

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
        ArrayList<Energia> check = new ArrayList<>(Energias);
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
        this.objetivo=objetivo;
        habilidad.ejecutar(this);
    }

    @Override
    public boolean isNull() {
        return false;
    }

    public Pokemon getObjetivo(){return this.objetivo;}

    public int getDMGCounter(){return this.DMGCounter;}

    public ArrayList<Energia> getEnergias(){return this.Energias;}

    public void setDMGCounter(int i) {
        this.DMGCounter = i;
        if (this.DMGCounter<0)this.DMGCounter=0;
    }

    @Override
    public boolean isBasic(){return false;}

    @Override
    public boolean isPhase1(){return false;}

    @Override
    public boolean isPhase2(){return false;}

    @Override
    public void evolve(Pokemon obj) {
        setEnergias(obj.getEnergias());
        obj.setEnergias(new ArrayList<>());
        getTrainer().Evolve(this);
    }

    @Override
    public int getPreEvID(){
        return PreEvID;
    }

    public void setPreEvID(int preEvID) {
        PreEvID = preEvID;
    }
}
