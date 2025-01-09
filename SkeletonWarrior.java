public class SkeletonWarrior extends Enemy {
    public SkeletonWarrior() {
        super("Skeleton Warrior", 10, 10, 0, 5);
    }

    public void drops(Inventory i) {
        if (((int) (Math.random() * 10) + 1) > 4) {
            Bone bone = new Bone();
            i.add(bone);
        }
    }
}
