public class Boots extends Item {
    private int armorRating;

    public Boots(String n, int i, int v, int w, int a) {
        super(n, i, v, w, true);
        armorRating = a;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int a) {
        armorRating = a;
    }
}
