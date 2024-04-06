public class Knight extends MOB {
    private Fortune activeFortune;
    protected final int id;
    protected int xp;

    public Knight(int id, String name, int hp, int armor, int hitmodifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitmodifier, damageDie);
        this.id = id;
        this.xp = xp;
    }

    public void addXP(int xp) {
        this.xp += xp;
    }

    public Fortune getActiveFortune() {
        return activeFortune;
    }

    public int getArmor() {
        return super.getArmor() + (activeFortune != null ? activeFortune.getArmor() : 0);
    }

    public DiceType getDamageDie() {
        return activeFortune != null ? activeFortune.getDamageDie() : super.getDamageDie();
    }

    public int getHitModifier() {
        return super.getHitModifier() + (activeFortune != null ? activeFortune.getHitModifier() : 0);
    }

    public Integer getId () {
        return id;
    }

    public int getMaxHP() {
        return super.getMaxHP() + (activeFortune != null ? activeFortune.getMaxHP() : 0);
    }

    public int getXP() {
        return xp;
    }

    public void setActiveFortune(Fortune activeFortune) {
        this.activeFortune = activeFortune;
    }

    public String toCSV() {
        // name,maxHP,armor,hitmodifer,damageDie,xp
        return String.format("%s,%d,%d,%d,%s,%d", getName(), getMaxHP(), getArmor(), getHitModifier(), getDamageDie(), getXP());
    }

    public String toString() {
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                String.format("| id: %-23d|%n", getId()) +
                "|                            |\n" +
                String.format("| Health: %-6s  XP: %-7d|%n", getMaxHP(), getXP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }

    public static void main(String[] args) {
        
    }
    
}
