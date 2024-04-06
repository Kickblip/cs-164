public class Fortune implements Attributes {
    private final int armor;
    private final DiceType dtype;
    private final int hitModifier;
    private final int hpBonus;
    private final String name;

    public Fortune(String name, int hpBonus, int armor, int hitModifier) {
        this(name, hpBonus, armor, hitModifier, null);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.armor = armor;
        this.dtype = type;
        this.hitModifier = hitModifier;
        this.hpBonus = hpBonus;
        this.name = name;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public DiceType getDamageDie() {
        return dtype;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    @Override
    public int getMaxHP() {
        return hpBonus;
    }

    public String getName() {
        return name;
    }

    public String toString () {
        return "+======================+\n" +
                String.format("|%-22s|%n", getName()) +
                String.format("|HP Bonus: %+12d|%n", getMaxHP()) +
                String.format("|AC Bonus: %+12d|%n", getArmor()) +
                String.format("|Hit Bonus: %+11d|%n", getHitModifier()) +
                String.format("|Damage Adj: %10s|%n", (getDamageDie() != null ? getDamageDie() : '-')) +
                "+======================+";
    }

    public static void main(String[] args) {
        Fortune ftn = new Fortune("Merlin Luck", 10, 5, 2, DiceType.D12);
        System.out.println("TESTING Armor in fortune " + ftn.getArmor());
    }
    
}
