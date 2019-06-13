package game.carta.objeto;

public class Potion extends Objeto {
    private int X;
    public Potion(int x){
        super("Potion","Remove up to x damage counters from the target pokemon");
        X=x;
    }
    @Override
    public void effect(){
        getTrainer().getObjetivo().setDMGCounter(getTrainer().getObjetivo().getDMGCounter()-this.X);
    }

}
