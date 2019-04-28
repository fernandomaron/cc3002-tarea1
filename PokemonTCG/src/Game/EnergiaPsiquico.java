package Game;

public class EnergiaPsiquico extends Energia {
    public EnergiaPsiquico(){
    }

    @Override
    public boolean equals(Object energia) {
        if (energia instanceof EnergiaPsiquico){
            return true;
        }
        return false;
    }
}
