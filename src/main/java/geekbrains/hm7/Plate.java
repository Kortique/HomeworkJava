package geekbrains.hm7;

public class Plate {
    private int foodCount;

    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }

    public void printInfo() {
        System.out.println("Еды в миске осталось : " + foodCount + " ед.");
    }

    public int decreaseFood(int foodCount) {
        this.foodCount -= foodCount;
        return foodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }
}
