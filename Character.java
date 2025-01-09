import java.util.ArrayList;

public abstract class Character {
    private String name;
    private int    maxHealth;
    private int    health;
    private int    defense;
    private final ArrayList<Effect> activeEffects;

    public Character(String n, int mh, int h, int d) {
        name = n;
        maxHealth = mh;
        health = h;
        defense = d;
        activeEffects = new ArrayList<>();
    }

    public void addEffect(Effect e) {
        activeEffects.add(e);
    }

    public void removeEffect(Effect e) {
        activeEffects.remove(e);
    }

    public String getName() {
        return  name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public void setName(String n) {
        name = n;
    }

    public void setMaxHealth(int m) {
        maxHealth = m;
    }

    public void setHealth(int h) {
        health = h;
    }

    public void setDefense(int d) {
        defense = d;
    }
}
