public abstract class Weapon extends Item {
    private int damage;

    public Weapon(String n, int i, int v, int w, boolean e, int d) {
        super(n, i , v, w, e);
        damage = d;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int d) {
        damage = d;
    }

}
