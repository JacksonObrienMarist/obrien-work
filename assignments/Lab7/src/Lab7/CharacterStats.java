package Lab7;

public class CharacterStats {
    private int health;
    private int attack;
    private int defense;

    public CharacterStats(int health, int attack, int defense) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public int getHealth() {
        return this.health;
    }
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }
    public int getAttack() {
        return this.attack;
    }
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }
    public int getDefense() {
        return this.defense;
    }
    public void setDefense(int newDefense) {
        this.defense = newDefense;
    }

    public static void main(String[] args) {
        CharacterStats stats = new CharacterStats( 30, 5, 5);
        System.out.println("Starting stats:");
        System.out.println("Health:" + stats.getHealth());
        System.out.println("Attack:" + stats.getAttack());
        System.out.println("Defense:" + stats.getDefense());
        System.out.println();

        stats.setHealth(20);
        stats.setAttack(10);
        stats.setDefense(10);
        System.out.println("New Stats");

        System.out.println("Health:" + stats.getHealth());
        System.out.println("Attack:" + stats.getAttack());
        System.out.println("Defense:" + stats.getDefense());

    }
}