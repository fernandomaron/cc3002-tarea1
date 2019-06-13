package game.carta.soporte;

public class ProfJuniper extends Soporte{
    public ProfJuniper(){
        super("Professor Juniper", "Discard your hand and draw 7 cards from your deck");
    }

    @Override
    public void effect() {
        getTrainer().getDiscard().addAll(getTrainer().getHand());
        getTrainer().getHand().clear();
        getTrainer().drawCards(7);
    }
}
