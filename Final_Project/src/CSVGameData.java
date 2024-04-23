import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVGameData extends GameData{
    CSVGameData(String gamedata, String saveData) {
        loadGameData(gamedata);
        loadSaveData(saveData);
    }
 
    void loadGameData(String gamedata) {
        if (gamedata == null) return;
        Scanner file = readFile(gamedata);
        if(file == null) return;
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(",");
            String type = line.next().trim();
            if(type.equals("MOB")) {
                String name = line.next().trim();
                int health = line.nextInt();
                int attack = line.nextInt();
                int defense = line.nextInt();
                String diceTypeToken = line.next().trim();
                monsters.add(new MOB(
                        name,
                        health,
                        attack,
                        defense,
                        diceTypeToken.equals("-") ? null : DiceType.valueOf(diceTypeToken)));
            } else if(type.equals("FORTUNE")) {
                String name = line.next().trim();
                int health = line.nextInt();
                int attack = line.nextInt();
                int defense = line.nextInt();
                String diceTypeToken = line.next().trim();
                fortunes.add(new Fortune(
                        name,
                        health,
                        attack,
                        defense,
                        diceTypeToken.equals("-") ? null : DiceType.valueOf(diceTypeToken)));
            }
        }
    }

    void loadSaveData(String saveData) {
        int counter = 0;
        if (saveData == null) return;
        Scanner file = readFile(saveData);
        if(file == null) return;
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(","); 
            Knight kt = new Knight(
                    ++counter,
                    line.next().trim(),
                    line.nextInt(),
                    line.nextInt(),
                    line.nextInt(),
                    DiceType.valueOf(line.next()),
                    line.nextInt());
            knights.add(kt);
        }
    }

    private Scanner readFile(String fileName) {
        try {
            Scanner filescanner = new Scanner(new File(fileName));
            return filescanner;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return null;
        }
    }

    public void save(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new File(filename));
            for(Knight kt : knights) {
                writer.println(kt.toCSV());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

}
