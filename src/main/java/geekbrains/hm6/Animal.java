package geekbrains.hm6;

public class Animal {
    protected String name;
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int runDist) {};
    public void swim(int swimDist) {};
}
