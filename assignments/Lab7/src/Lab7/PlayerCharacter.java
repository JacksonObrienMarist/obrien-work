package Lab7;

public class PlayerCharacter {
    private String name;
    private CharacterStats stats;

    public PlayerCharacter(String name, int health, int attack, int defense){
        this.name = name;
        this.stats = new CharacterStats(health, attack, defense);
    }

    public boolean isAlive() {
        return stats.getHealth() > 0;
    }

    public void heal(int num) {
        stats.setHealth(stats.getHealth() + num);
    }
    public void damage(int num) {
        if (isAlive()) {
            int newNum = Math.max(num - stats.getDefense(), 0);
            stats.setHealth(stats.getHealth() - newNum);
        } else {
            System.out.println("Player is dead");
        }
    }
    public void levelUp() {
        stats.setAttack(stats.getAttack() + 1);
        stats.setDefense(stats.getDefense() + 1);
    }

    public static void main(String[] args) {
        PlayerCharacter player = new PlayerCharacter("Jackson", 30, 5, 5);
        if (player.isAlive()) {
            System.out.println("Player is alive");
        }
        System.out.println("Starting stats:");
        System.out.println("Health:" + player.stats.getHealth());
        System.out.println("Attack:" + player.stats.getAttack());
        System.out.println("Defense:" + player.stats.getDefense());
        System.out.println();
        System.out.println("Player is attacked by 15 damage");
        player.damage(15);
        System.out.println("Health:" + player.stats.getHealth());
        System.out.println("Player is healed by 10");
        player.heal(10);
        System.out.println("Health:" + player.stats.getHealth());
        System.out.println("Player levels up");
        player.levelUp();
        System.out.println("Attack:" + player.stats.getAttack());
        System.out.println("Defense:" + player.stats.getDefense());
        System.out.println();
        System.out.println("Player gets attacked at its full hp");
        player.damage(player.stats.getHealth() + player.stats.getDefense());
        if (player.isAlive()) {
            System.out.println("Player is alive");
        } else {
            System.out.println("Player is dead");
        }
        System.out.println("Health:" + player.stats.getHealth());
    }
}