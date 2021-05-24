package geekbrains.hm13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static geekbrains.hm13.Main.cb;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;
    private static int finisher = 1;
    private static Object winner;
    private final Lock LOCK = new ReentrantLock();

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public static Object getWinner() {
        return winner;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится к старту");
            Thread.sleep(500 + (int) (Math.random() * 800));
            cb.await();
            System.out.println(this.name + " поехал!");


            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            try {
                LOCK.lock();
                if (finisher == 1) {
                    System.out.println(this.name + " финишировал первым!");
                    winner = this.name;
                    finisher++;
                } else {
                    System.out.println(this.name + " финишировал " + finisher);
                    finisher++;
                }
            } finally {
                LOCK.unlock();
            }
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}