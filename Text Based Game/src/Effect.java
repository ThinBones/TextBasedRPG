public abstract class Effect {
    private String name;
    private int duration; // number of turns the effect lasts
    private int magnitude;

    public Effect(String n, int d, int m) {
        name = n;
        duration = d;
        magnitude = m;
    }

    public abstract void EffectExecution(Character target);

    public void reduceDuration() {
        duration--;
    }

    public boolean effectComplete() {
        return duration == 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public void setName(String n) {
        name = n;
    }

    public void setDuration(int d) {
        duration = d;
    }

    public void setMagnitude(int m) {
        magnitude = m;
    }
}