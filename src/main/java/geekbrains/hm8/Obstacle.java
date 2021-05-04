package geekbrains.hm8;

import java.util.Random;

public class Obstacle {

    public boolean checkSuccess(Hero heroes) {
        return false;
    }

    public String descriptionTrouble() {
        return "";
    };

    private static final Random random = new Random();

    public static class Cliff extends Obstacle {

        private int cliffHeight;

        @Override
        public String descriptionTrouble() {
            return ("утёс высотой аж в " + getCliffHeight() + " метров");
        }

        @Override
        public boolean checkSuccess(Hero heroes) {
            return (heroes.getMaxJumpAbility() >= cliffHeight);
        }

        public Cliff(int cliffHeight) {
            this.cliffHeight = cliffHeight;
        }

        public static int generationHeightCliff(int ratio) {
            return ratio * (random.nextInt(2) + 1);
        }

        public int getCliffHeight() {
            return cliffHeight;
        }
    }

    public static class Wood extends Obstacle {

        int deepOfWood;

        @Override
        public String descriptionTrouble() {
            return ("чащоба протяжённостью " + getDeepOfWood() + " метров");
        }

        @Override
        public boolean checkSuccess(Hero heroes) {
            return (heroes.getMaxRunAbility() >= deepOfWood);
        }

        public Wood(int deepOfWood) {
            this.deepOfWood = deepOfWood;
        }

        public static int generationDistanceTrack(int ratio) {
            return ratio * (random.nextInt(1000) + 500);
        }

        public int getDeepOfWood() {
            return deepOfWood;
        }
    }
}
