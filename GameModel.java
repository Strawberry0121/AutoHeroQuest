package model;

public class GameModel {
    private int score;
    private int heroLP;
    private int allyCount;
    private int allyLP;

    public GameModel() {
        score = 0;
        heroLP = 100;
        allyCount = 0;
        allyLP = 0;
    }

    public int getScore() { return score; }
    public void addScore(int value) { score += value; }

    public int getHeroLP() { return heroLP; }
    public void damageHero(int dmg) {
        heroLP -= dmg;
        if (heroLP < 0) heroLP = 0;
    }
    public void healHero(int heal) { heroLP += heal; }

    public int getAllyCount() { return allyCount; }
    public int getAllyLP() { return allyLP; }
    public void addAlly() { 
        allyCount++; 
        allyLP += 50; 
    }
    public void damageAlly(int dmg) {
        allyLP -= dmg;
        if (allyLP < 0) allyLP = 0;
    }
    public void healAlly(int heal) { allyLP += heal; }

    // 戦闘処理
    public void battle(int enemyDamage, int scoreGain) {
        int heroDmg = enemyDamage;
        if (allyCount > 0) heroDmg = Math.max(0, enemyDamage - allyCount*2);
        damageHero(heroDmg);
        damageAlly(Math.max(0, enemyDamage - heroDmg));
        addScore(scoreGain + allyCount*2);
    }
}