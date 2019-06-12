package game.carta.objeto;

public class Potion extends Objeto {
    private int X;
    public Potion(int x){
        super("Potion","Remove up to x damage counters from the target pokemon");
        X=x;
    }
    @Override
    public void efecto(){
        getTrainer().getObjetivo().setDMGCounter(getTrainer().getObjetivo().getDMGCounter()-this.X);
    }

    @Override
    public void somtin() {
        super.somtin();
    }
}
