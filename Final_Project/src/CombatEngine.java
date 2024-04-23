public class CombatEngine {
    private final GameData data;
    private final DiceSet dice;

    public CombatEngine(GameData data, GameView view) {
        this.data = data;
        this.view = view;
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
