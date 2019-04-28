package Game;

public class EnergiaPlanta extends Energia {
    public EnergiaPlanta(){
    }

    @Override
    public boolean equals(Object energia) {
        if (energia instanceof EnergiaPlanta){
            return true;
        }
        return false;
    }
}
