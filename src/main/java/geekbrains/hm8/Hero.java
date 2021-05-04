package geekbrains.hm8;

import java.util.Random;

public class Hero {

    private static final Random random = new Random();

    private String name;
    private int maxRunAbility;
    private int maxJumpAbility;

    public Hero(String name, int maxRunAbility, int maxJumpAbility) {
        this.name = name;
        this.maxRunAbility = maxRunAbility;
        this.maxJumpAbility = maxJumpAbility;
    }

    public static int generationRunAbility(int ratio) {
        return ratio*(random.nextInt(1000) + 500);
    }

    public static int generationJumpAbility(int ratio) {
        return ratio*(random.nextInt(2) + 1);
    }

    public String getName() {
        return name;
    }

    public int getMaxRunAbility() {
        return maxRunAbility;
    }

    public int getMaxJumpAbility() {
        return maxJumpAbility;
    }
}
