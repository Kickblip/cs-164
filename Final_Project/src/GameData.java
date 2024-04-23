import java.util.List;

public class GameData {
    protected final List<Knight> activeKnights;
    protected final List<Fortune> fortunes;
    protected final List<Knight> knights;
    private static final int MAX_ACTIVE;
    protected final List<MOB> monsters;
    private static final Random random;

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
        if (activeKnights.size() < 4) {
            activeKnights.add(kt);
            return true;
        }
        return false;
    }

    public abstract void save(String filename);

}
