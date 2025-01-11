
public abstract class Enemy extends Character {
    private int attack;

    public Enemy(String n, int mh, int h, int a) {
        super(n, mh, h);
        attack = a;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int a) {
        attack = a;
    }

    public void attack(Player p) {
        p.setHealth(p.getHealth() - attack);
    }
}
