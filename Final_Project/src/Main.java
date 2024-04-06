public class Main {
    public static void main(String[] args) {
        MOB mob = new MOB("Goblin", 10, 2, 1, DiceType.D6);
        System.out.println(mob.toString());
        Knight knight = new Knight(1, "Sir Lancelot", 20, 5, 2, DiceType.D12, 0);
        System.out.println(knight.toString());
        Fortune ftn = new Fortune("Merlin Luck", 10, 5, 2, DiceType.D12);
        System.out.println(ftn.toString());
        knight.setActiveFortune(ftn);
        System.out.println(knight.toString());
        System.out.println(knight.toCSV());
    }
}
