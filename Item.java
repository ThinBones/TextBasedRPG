public abstract class Item {
    private String  name;
    private int     id;
    private int     value;
    private int     weight;
    private boolean isEquipable;

    public Item() {
        name = "example";
        id   = -1;
        value = 0;
        weight = 0;
        isEquipable = false;
    }

    public Item(String n, int i, int v, int w, boolean e) {
        name = n;
        id = i;
        value = v;
        weight = w;
        isEquipable = e;
    }

    public String getName() {
        return name;
    }
    
    public int getID() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public boolean getIsEquipable() {
        return isEquipable;
    }

    public void setName(String n) {
        name = n;
    }

    public void setID(int i) {
        id = i;
    }

    public void setValue(int v) {
        value = v;
    }

    public void setWeight(int w) {
        weight = w;
    }

    public void setIsEquipable(boolean e) {
        isEquipable = e;
    }
}
