import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GameData {
    protected final List<Knight> activeKnights;
    protected final List<Fortune> fortunes;
    protected final List<Knight> knights;
    private static final int MAX_ACTIVE = 4;
    protected final List<MOB> monsters;
    private static final Random random = new Random();

    public GameData() {
        activeKnights = new ArrayList<>();
        fortunes = new ArrayList<>();
        knights = new ArrayList<>();
        monsters = new ArrayList<>();
    }

    protected Knight findKnight(String nameOrId, List<Knight> list) {
        for (Knight knight : list) {
            if (nameOrId.toLowerCase().contains(knight.getName().toLowerCase()) || knight.getId() == Integer.parseInt(nameOrId)) {
                return knight;
            }
        }
        return null;
    }

    public Knight getActive(String nameOrId) {
        return findKnight(nameOrId, activeKnights);
    }

    public List<Knight> getActiveKnights() {
        return activeKnights;
    }

    public Knight getKnight(String nameOrId) {
        return findKnight(nameOrId, knights);
    }

    public List<Knight> getKnights() {
        return knights;
    }

    public Fortune getRandomFortune() {
        return fortunes.get(random.nextInt(fortunes.size()));
    }

    public List<MOB> getRandomMonsters() {
        List<MOB> res = new ArrayList<>();
        for (int i = 0; i < activeKnights.size(); i++) {
            res.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return res;
    }

    public List<MOB> getRandomMonsters(int number) {
        List<MOB> res = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            res.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return res;
    }

    public void removeActive(Knight kt) {
        activeKnights.remove(kt);
        kt.resetDamage();
    }

    public boolean setActive(Knight kt) {
        if (activeKnights.size() < MAX_ACTIVE) {
            activeKnights.add(kt);
            return true;
        }
        return false;
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
