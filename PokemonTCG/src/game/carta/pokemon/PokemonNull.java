package game.carta.pokemon;

import game.carta.energia.Energia;
import game.habilidad.Ataques.Ataque;
import game.Entrenador;
import game.habilidad.Habilidad;
import game.visitor.Visitor;

import java.util.ArrayList;

/**
 * @author Fernando Maron
 * This class was created to act as a null counterpart for the pokemon class
 */
public class PokemonNull implements Pokemon {
    public PokemonNull(){
    }

    @Override
    public boolean hasEnergy(ArrayList<Energia> costo) {
        return false;
    }

    @Override
    public void agregarEnergia(Energia energia) {
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public void atacarCon(Ataque ataque) {

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
    public ArrayList<Habilidad> getHabilidades() {
        return null;
    }

    @Override
    public void usar(Habilidad habilidad, Pokemon objetivo) {

    }

    @Override
    public int getHP() {
        return 0;
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void setHP(int hp) {

    }

    @Override
    public void setID(int id) {

    }

    @Override
    public void setHabilidades(ArrayList<Habilidad> habilidades) {

    }

    @Override
    public void checkHP() {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPokemon(this);
    }

    @Override
    public void setTrainer(Entrenador entrenador) {

    }

    @Override
    public Entrenador getTrainer() {
        return null;
    }

    @Override
    public void setEnergias(ArrayList<Energia> energias) {

    }

    @Override
    public Pokemon getObjetivo() {
        return null;
    }

    @Override
    public ArrayList<Energia> getEnergias() {
        return null;
    }

    @Override
    public void setDMGCounter(int i) {

    }

    @Override
    public int getDMGCounter() {
        return 0;
    }
}
