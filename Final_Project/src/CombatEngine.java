import java.util.Random;

public class CombatEngine {
    private final GameData data;
    private final GameView view;
    private final DiceSet dice;
    private final Random rnd;

    public CombatEngine(GameData data, GameView view) {
        this.data = data;
        this.view = view;
        this.dice = new DiceSet();
        this.rnd = new Random();
    }

    public void clear() {
        for (Knight knight : data.getKnights()) {
            knight.setActiveFortune(null);
        }
    }

    public void initialize() {
        for (Knight knight : data.getActiveKnights()) {
            knight.setActiveFortune(data.getRandomFortune());
        }
        view.printFortunes(data.getActiveKnights());
    }
}
