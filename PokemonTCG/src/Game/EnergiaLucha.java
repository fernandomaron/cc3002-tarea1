package Game;

public class EnergiaLucha extends Energia {
    public EnergiaLucha(){
    }

    @Override
    public boolean equals(Object energia) {
        if (energia instanceof EnergiaLucha){
            return true;
        }
        return false;
    }
}
