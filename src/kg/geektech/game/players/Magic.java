package kg.geektech.game.players;

public class Magic extends Hero {
    private int damagePoints;
    public Magic(int health, int damage, int damagePoints) {
        super(health, damage, SuperAbility.BOOST);
        this.damagePoints = damagePoints;
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                heroes[i].setDamage(heroes[i].getDamage() + damagePoints);
            }
        }
    }
}
