package kg.geektech.game.general;

import kg.geektech.game.players.*;

public class Rpg_Game {

    public static void startGame() {
        Boss boss = new Boss(450, 50);
        Magic magic = new Magic(160, 20,3);
        Warrior warrior = new Warrior(200, 10);
        Medic medic = new Medic(180, 10, 15);
        Hunter hunter = new Hunter(190, 20, 10, 100);
        Medic youngMedic = new Medic(170, 15, 5);
        Hero[] heroes = {magic, warrior, medic, hunter, youngMedic};

        printStatistics(boss, heroes);
        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        heroesHit(boss, heroes);
        bossHit(boss, heroes);
        heroesApplyAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0
                    && !(heroes[i] instanceof Medic) && boss.getHealth() > 0) {
                if (boss.getHealth() - heroes[i].getDamage() < 0) {
                    boss.setHealth(0);
                } else if (!(heroes[i] instanceof Hunter) && !(heroes[i] instanceof Warrior)){
                    boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                }
            }
        }
    }
    private static void bossHit(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    if (heroes[i].getHealth() - boss.getDamage() < 0) {
                        heroes[i].setHealth(0);
                    } else if (!(heroes[i] instanceof Hunter)){
                        heroes[i].setHealth(heroes[i].getHealth()
                                - boss.getDamage());
                    }
                }
            }
        }
    }
    private static void heroesApplyAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].apllySuperAbility(boss, heroes);
            }
        }
    }
    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("_________________");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth());
        }
        System.out.println("_________________");
    }
}
