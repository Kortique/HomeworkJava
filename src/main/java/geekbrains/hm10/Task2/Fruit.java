package geekbrains.hm10.Task2;

public abstract class Fruit {

    protected float weight;
    protected String name;

    public Fruit(float weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
