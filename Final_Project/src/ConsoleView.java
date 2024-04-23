import java.util.List;
import java.util.Scanner;

public class ConsoleView implements GameView {
    private final Scanner in = new Scanner(System.in);

    public boolean checkContinue() {
        System.out.println("Would you like to continue on your quest (y/n)?");
        return in.nextLine().toLowerCase().charAt(0) == 'y';
    }

    public String displayMainMenu() {
        System.out.println("What would you like to do?");
        return in.nextLine();
    }

    public void endGame() {
        System.out.println("Goodbye!");
    }

    public void knightNotFound() {
        System.out.println("Knight not found!");
    }

    public void listKnights(List<Knight> knights) {
        if (knights.size() == 0) {
            System.out.println("No knights to list");
            return;
        }
        for (Knight knight : knights) {
            System.out.println(knight.getId() + ": " + knight.getName());
        }
    }
 
    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights) {
        System.out.println("Our heroes come across the following monsters. Prepare for battle!");
        System.out.printf("%-27s %s%n", "Knights", "Foes");
        for (int i = 0; i < activeKnights.size(); i++) {
            if (i < monsters.size()) {
                System.out.printf("%-27s %s%n", activeKnights.get(i).getName(), monsters.get(i).getName());
            } else {
                System.out.printf("%-27s %n", activeKnights.get(i).getName());
            }
        }
    }
 
    public void printBattleText(MOB dead) {
        System.out.println(dead.getName() + " was defeated!");
    }

    public void printDefeated() {
        System.out.println("All active knights have been defeated!");
        System.out.println();
    }

    public void printFortunes(List<Knight> activeKnights) {
        System.out.println("For this quest, our knights drew the following fortunes!");
        for (Knight knight : activeKnights) {
            System.out.println(knight.getName() + "drew");
            System.out.println(knight.getActiveFortune().toString());
        }
    }

    public void printHelp() {
        System.out.println("Unsure what to do, here are some options:");
        System.out.println("    ls or list all  - listing the knights");
        System.out.println("    list active  - list the active knights knights only");
        System.out.println("    show name or id - show the knight details card");
        System.out.println("    set active name or id - set knight as active (note: only 4 knights can be active)");
        System.out.println("    remove active name or id - remove a knight from active status (heals knight)");
        System.out.println("    explore or adventure or quest - find random monsters to fight");
        System.out.println("    save filename - save the game to the file name (default: saveData.csv)");
        System.out.println("    exit or goodbye - to leave the game");
        System.out.println();
        System.out.println("Game rules: You can have four active knights. As long as they are active, they won't heal,");
        System.out.println("but they can gain XP by going on adventures.");
        System.out.println("When you make a knight inactive, they will heal. How many monsters can you defeat");
        System.out.println("before, you have to heal?");
    }

    public void setActiveFailed() {
        System.out.println("Unable to set active knight. Only four can be active at a time.");
        System.out.println();
    }

    public void showKnight(Knight knight) {
        System.out.println(knight.toString());
        System.out.println();
    }

    public void splashScreen() {
        System.out.println("WELCOME TO A GAME ABOUT KNIGHTS");
    }
}