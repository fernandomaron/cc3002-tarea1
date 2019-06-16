package game;

/**
 * @author Fernando Maron
 * This class is creates to enable a random coin flip for the effects that need it
 */
public class CoinFlip {
    /**
     * Static method that has 50% chance of being true, and 50% chance of being false
     * @return true or false depending on the coin flip
     */
    public static boolean Flip(){
        double random=Math.random();
        return !(random < 0.5);
    }
}
