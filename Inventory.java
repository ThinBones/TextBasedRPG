import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void add(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        inventory.add(item);
    }

    public Item get(int i) {
        return inventory.get(i);
    }

    // Remove an item from the inventory
    public boolean remove(Item item) {
        return inventory.remove(item); // Returns true if item was removed
    }

    // Get all items (read-only)
    public ArrayList<Item> getItems() {
        return new ArrayList<>(inventory); // Return a copy to preserve encapsulation
    }

    // Check if the inventory contains a specific item
    public boolean contains(Item item) {
        return inventory.contains(item);
    }

    // Get the size of the inventory
    public int size() {
        return inventory.size();
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (int i = 0; i < inventory.size(); i++) {
            totalWeight += inventory.get(i).getWeight();
        }
        return totalWeight;
    }

    public void printAllItems() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ". " + inventory.get(i).getName());
        }
    }
}
