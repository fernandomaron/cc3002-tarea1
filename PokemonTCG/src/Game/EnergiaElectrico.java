package Game;

/**
 * @author Fernando Maron
 */
public class EnergiaElectrico extends Energia {
    public EnergiaElectrico(){
    }

    @Override
    public boolean equals(Object energia) {
        if (energia instanceof EnergiaElectrico){
            return true;
        }
        return false;
    }
}
