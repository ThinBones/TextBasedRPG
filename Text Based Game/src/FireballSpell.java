public class FireballSpell extends Spell {
    public FireballSpell() {
        super("Fireball");
    }

    @Override
    public void spellExecution(Character target) {
        target.addEffect(new BurnEffectI());
    }
}
