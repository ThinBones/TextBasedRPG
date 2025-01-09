import java.util.ArrayList;

public abstract class Spell {
    private String name;
    private final ArrayList<Effect> spellEffects; // Private access

    public Spell(String name) {
        this.name = name;
        this.spellEffects = new ArrayList<>(); // Initialize the ArrayList
    }

    public abstract void spellExecution(Character target);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Method to add an effect
    public void add(Effect effect) {
        spellEffects.add(effect);
    }

    // Method to get an effect
    public Effect getEffect(int index) {
        return spellEffects.get(index);
    }

    public int getNumberOfEffects() {
        return spellEffects.size(); // Return the number of effects
    }
}