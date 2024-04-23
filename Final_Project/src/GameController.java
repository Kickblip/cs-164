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
        if (command.equals("exit") || command.equals("bye")) {
            return false;
        } else if (command.equals("ls") || command.equals("list all")) {
            view.listKnights(data.getKnights());
        } else if (command.equals("list active")) {
            view.listKnights(data.getActiveKnights());
        } else if (command.contains("show")) {
            data.getKnight(parts[1]).toString();
        } else if (command.contains("set active")) {
            data.setActive(data.getKnight(parts[1]));
        } else if (command.contains("remove")) {
            data.removeActive(data.getKnight(parts[1]));
        } else if (command.contains("save")) {
            if (parts.length < 2) {
                data.save("saveData.csv");
            } else {
                data.save(parts[1]);
            }
        } else if (command.equals("explore") || command.equals("adventure") || command.equals("quest")) {
            engine.initialize();
            engine.clear();
        } else {
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
