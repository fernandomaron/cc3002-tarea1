package Game;

public class EnergiaAgua extends Energia {
    public EnergiaAgua(){
    }

    @Override
    public boolean equals(Object energia) {
        if (energia instanceof EnergiaAgua){
            return true;
        }
        return false;
    }
}
