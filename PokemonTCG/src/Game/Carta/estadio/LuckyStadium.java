package game.carta.estadio;

import game.Entrenador;

public class LuckyStadium extends Estadio {
    public LuckyStadium(){
        super("Lucky Stadium","Once per turn you can flip a coin, if heads draw a card");
    }

    @Override
    public void efecto(Entrenador entrenador) {
        double r = Math.random();
        if (r>0.5){
            entrenador.drawCards(1);
        }
        entrenador.getController().setUsedStadium(true);
    }
}
