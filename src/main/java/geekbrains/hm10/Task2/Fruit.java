package geekbrains.hm10.Task2;

public abstract class Fruit {

    private final float WEIGHT;
    private String name;

    public Fruit(float WEIGHT, String name) {
        this.WEIGHT = WEIGHT;
        this.name = name;
    }

    public float getWEIGHT() {
        return WEIGHT;
    }

    public String getName() {
            return name;
    }
}
