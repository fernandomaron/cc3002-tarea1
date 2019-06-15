package game;

public class CoinFlip {
    public static boolean Flip(){
        double random=Math.random();
        return !(random < 0.5);
    }
}
