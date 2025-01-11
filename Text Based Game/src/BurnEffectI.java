
public class BurnEffectI extends Effect {
    private final int damage;

    public BurnEffectI() {
        super("Burn", 3, 1);
        damage = 2;
    }

    @Override
    public void EffectExecution(Character target) {
        reduceDuration();
        target.setHealth(target.getHealth() - damage);
        if (effectComplete()) {
            target.removeEffect(this);
        }
    }
}
