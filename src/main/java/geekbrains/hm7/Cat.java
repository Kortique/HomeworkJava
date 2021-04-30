package geekbrains.hm7;

import java.util.Random;

public class Cat {

    Random random = new Random();
    private final String name;
    private boolean satiety = false;
    private int countEat;
    private int totalCountEat = 0;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getSatiety() {
        int b = 0;
        if (satiety = true)
            b = random.nextInt(3); {
            if (b == 2)
                return false;
        }
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public int getCountEat() {
        return countEat;
    }

    public void eat(Plate plate) {
        countEat = plate.decreaseFood(random.nextInt(8) + 5);
        totalCountEat += countEat;
    }

    public int getTotalCountEat() {
        return totalCountEat;
    }
}
