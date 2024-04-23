public class GameController {
    private final GameData data;
    private final CombatEngine engine;
    private final GameView view;

    public GameController(GameData data, GameView view, CombatEngine engine) {
        this.data = data;
        this.view = view;
        this.engine = engine;
    }

    protected boolean processCommand(String command) {
        String[] parts = command.split(" ");
        switch (command) {
            case "exit":
            case "bye":
                return false;
            case "ls":
            case "list all":
                view.listKnights(data.getKnights());
                break;
            case "list active":
                view.listKnights(data.getActiveKnights());
                break;
            case command.contains("show"):
                data.getKnight(parts[1]).toString();
                break;
            case command.contains("set active"):
                data.setActive(data.getKnight(parts[1]));
                break;
            case command.contains("remove"):
                data.removeActive(data.getKnight(parts[1]));
                break;
            case command.contains("save"):
                if (parts.length < 2) {
                    data.save();
                } else {
                    data.save(parts[1]);
                }
                break;
            case "explore":
            case "adventure":
            case "quest":
                engine.initialize();
                engine.clear();
                break;
            default:
                view.printHelp();
        }
        return true;
    }

    public void start() {
        view.splashScreen();
        while (true) {
            view.checkContinue();
            if (!processCommand(view.displayMainMenu())) {
                break;
            }
        }
        view.endGame();
    }

}
