
public abstract class Enemy extends Character {
    private int attack;

    public Enemy(String n, int mh, int h, int d, int a) {
        super(n, mh, h, d);
        attack = a;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int a) {
        attack = a;
    }

    public void attack(Player p) {
        int enemyAttack = this.getAttack();
        int playerDefense = p.getDefense();

        double damageReduction = playerDefense / 100.0; // 1 defense = 1% reduction
    
        int finalDamage = (int) (enemyAttack * (1 - damageReduction));
    
        p.setHealth(Math.max(finalDamage, 1));
    }
}
