package Game;

public class EnergiaFuego extends Energia {
    public EnergiaFuego(){
    }

    @Override
    public boolean equals(Object energia) {
        if (energia instanceof EnergiaFuego){
            return true;
        }
        return false;
    }
}
