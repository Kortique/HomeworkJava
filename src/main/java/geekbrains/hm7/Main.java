package geekbrains.hm7;

import java.util.Random;

public class Main {

    protected static int time = 0;
    protected static final int TIME_PLUS = 10;
    protected static final int TIME_END = 1500;
    protected static final int TIMEOUT = 500;
    protected static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        Cat cat1 = new Cat("Кряк");
        Cat cat2 = new Cat("Варез");
        Cat cat3 = new Cat("Баг");
        Cat cat4 = new Cat("Патч");
        Cat[] cat = new Cat[]{cat1, cat2, cat3, cat4};

        Plate plate1 = new Plate(30);
        Plate plate2 = new Plate(40);
        Plate plate3 = new Plate(20);
        Plate[] plate = new Plate[]{plate1, plate2, plate3};

        feedingCats(cat, plate);
        resultOfFeeding(cat);

    }

    private static void feedingCats(Cat[] cat, Plate[] plate) throws InterruptedException {
        for (int i = 0; i < cat.length; ) {
            if (!cat[i].getSatiety()) makeSnack(cat, plate, i);
            else {
                i = keepSleeping(cat, i);
                time += TIME_PLUS;
                if (time > TIME_END) break;
            }
        }
    }

    private static void makeSnack(Cat[] cat, Plate[] plate, int i) throws InterruptedException {
        for (int j = 0; j < plate.length; ) {
            if (plate[j].getFoodCount() > 0) {
                Thread.sleep(TIMEOUT);
                cat[i].eat(plate[j]);
                if ((plate[j].getFoodCount() < 0))
                    break;
                System.out.println("Кот " + cat[i].getName() + " проголодался");
                Thread.sleep(TIMEOUT);
                System.out.println(cat[i].getName() + " съел " + cat[i].getCountEat() + " ед. из " +
                        (j + 1) + "-й миски");
                plate[j].printInfo();
                cat[i].setSatiety(true);
                Thread.sleep(TIMEOUT);
                time += TIME_PLUS;
                break;
            } else {
                j++;
                if (j < plate.length)
                    time += TIME_PLUS;
                else
                    poutFood(plate, j);
            }
        }
    }

    private static int poutFood(Plate[] plate, int j) {
        int b;
        if (j >= plate.length) {
            b = random.nextInt(2);
            if (b == 0) {
                j = 0;
                plate[j].setFoodCount(30);
                System.out.println("В момент отчаяния, когда казалось, что надежды уже нет" +
                        " и все миски пусты, одна из них чудесным образом наполнилась вновь");
                time += TIME_PLUS;
                return j;
            } else {
                time = TIME_END;
            }
        }
        return j;
    }


    private static int keepSleeping(Cat[] cat, int i) throws InterruptedException {
        System.out.println(("Кот " + cat[i].getName() + " спит"));
        Thread.sleep(TIMEOUT);
        i++;
        if (i == cat.length)
            i = 0;
        return i;
    }

    private static void resultOfFeeding(Cat[] cat) {
        System.out.println("\nКогда последняя миска оказалась пуста, определились главные жруны:");
        for (Cat value : cat) {
            System.out.println("Кот " + value.getName() + " съел суммарно " +
                    value.getTotalCountEat() + " еды");
            System.out.println(value.getSatiety() ? "и остался сытым;" : "и остался голодным;");
        }
    }
}


