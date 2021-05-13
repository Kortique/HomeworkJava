package geekbrains.hm10.Task2;

public class WormyApple extends Apple{

    private float weight = 4f;
    private String name = "[червивое яблоко]";

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}
