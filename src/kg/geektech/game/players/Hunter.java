package kg.geektech.game.players;

public class Hunter extends Hero {
    private int procent1;
    private int procent;

    public Hunter(int health, int damage, int procent1, int procent) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
        this.procent1 = procent1;
        this.procent = procent;
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] instanceof Hunter) {
                heroes[i].setHealth(heroes[i].getHealth() - (boss.getDamage() - (boss.getDamage() * procent1 / procent)));
                boss.setHealth(boss.getHealth() - (heroes[i].getDamage() + (boss.getDamage() * procent1 / procent)));
            }
        }
    }
}
