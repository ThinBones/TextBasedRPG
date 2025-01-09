
import java.util.ArrayList;

public class Player extends Character {
    private int attack;
    private int carry;
    private final Item[] equips;
    private final ArrayList<Spell> spellBook;

    public Player(String n, int mh, int h, int d, int a, int c) {
        super(n, mh, h, d);
        attack = a;
        carry  = c;
        equips = new Item[7];
        spellBook = new ArrayList<>();
    }

    public void attack(Enemy e) {
        int playerAttack = this.getAttack();
        int enemyDefense = e.getDefense();

        double damageReduction = enemyDefense / 100.0; // 1 defense = 1% reduction
    
        int finalDamage = (int) (playerAttack * (1 - damageReduction));
    
        e.setHealth(Math.max(finalDamage, 1));
    }

    public void equip(Item i) {
        if (i instanceof Weapon) {
            equips[0] = i;
        } 
        else if (i instanceof Ring) {
            if (equips[1] == null) {
                equips[1] = i;
            } 
            else if (equips[2] == null) {
                equips[2] = i;
            } 
            else {
                System.out.println("Both ring slots are occupied.");
            }
        } 
        else if (i instanceof Helmet) {
            equips[3] = i;
        } 
        else if (i instanceof Chestplate) {
            equips[4] = i;
        } 
        else if (i instanceof Leggings) {
            equips[5] = i;
        } 
        else if (i instanceof Boots) {
            equips[6] = i;
        } 
        else {
            System.out.println("Invalid item type.");
        }
    }

    public void castSpell(Spell s) {
        s.spellExecution();
    }

    public Spell getSpell(int s) {
        return spellBook.get(s);
    }

    public void printAllSpells() {
        for (int i = 0; i < spellBook.size(); i++) {
            System.out.println(i + ". " + spellBook.get(i).getName());
        }
    }

    public int getAttack() {
        return attack;
    }

    public int getCarry() {
        return carry;
    }

    public void setAttack(int a) {
        attack = a;
    }

    public void setCarry(int c) {
        carry = c;
    }

    public void addSpell(Spell s) {
        spellBook.add(s);
    }
}
