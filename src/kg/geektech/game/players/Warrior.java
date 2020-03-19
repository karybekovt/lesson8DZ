package kg.geektech.game.players;


import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int coef = random.nextInt(3)+2;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] instanceof Warrior) {
                boss.setHealth(boss.getHealth() - (heroes[i].getDamage() * coef));
            }
        }
    }
}
