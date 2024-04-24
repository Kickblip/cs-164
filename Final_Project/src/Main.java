public class Main {
    private static String gamedata;
    private static String saveData;
    
    public static void main(String[] args) {
        gamedata = "gamedata.csv";
        saveData = "knights.csv";

        processArgs(args);
        GameData data = new CSVGameData(gamedata, saveData);
        GameView view  = new ConsoleView();
        CombatEngine engine = new CombatEngine(data, view);
        GameController controller = new GameController(data, view, engine);
        controller.start();
    }

    private static void processArgs(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("--data")) {
                gamedata = arg.substring(arg.indexOf("=") + 1);
            } else {
                saveData = arg;
            }
        }
    }

}
