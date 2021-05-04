package geekbrains.hm8;

public class Adventure {

    private static final int TIMEOUT = 1000;
    private static int heroLost = 0;

    public static void main(String[] args) throws InterruptedException {

        letsGo(introduceHeroes(), generationObstacles());

    }

    private static Hero[] introduceHeroes() throws InterruptedException {
        System.out.println("Смогут ли отважные герои добраться до Гудвина, чтобы вернуться к себе на родину в Канзас? " +
                "Сейчас узнаем.");
        Thread.sleep(TIMEOUT);
        return new Hero[]{new Hero("Девочка Элли", Hero.generationRunAbility(1), Hero.generationJumpAbility(1)),
                new Hero("Железный дровосек", Hero.generationRunAbility(2), Hero.generationJumpAbility(2)),
                new Hero("Пёсик Тотошка", Hero.generationRunAbility(4), Hero.generationJumpAbility(3))};
    }

    private static Obstacle[] generationObstacles() {
        Obstacle obstacle = new Obstacle();
        Obstacle.Cliff cliff1 = new Obstacle.Cliff(Obstacle.Cliff.generationHeightCliff(1));
        Obstacle.Cliff cliff2 = new Obstacle.Cliff(Obstacle.Cliff.generationHeightCliff(2));
        Obstacle.Wood wood1 = new Obstacle.Wood(Obstacle.Wood.generationDistanceTrack(1));
        Obstacle.Wood wood2 = new Obstacle.Wood(Obstacle.Wood.generationDistanceTrack(2));
        return new Obstacle[]{wood1, cliff1, wood2, cliff2};
    }

    private static void letsGo(Hero[] heroes, Obstacle[] obstacles) throws InterruptedException {

        descriptionHeroes(heroes);
        passingObstacles(heroes, obstacles);
        summary(heroes);

    }

    public static void descriptionHeroes(Hero[] heroes) throws InterruptedException {
        System.out.println("Но сначала представим наших героев:");
        Thread.sleep(TIMEOUT);
        for (int i = 0; i < heroes.length; i++) {
            System.out.printf("Отважный(-ая) %s, дальность бега %dм, мощность прыжка %dм\n",
                    heroes[i].getName(), heroes[i].getMaxRunAbility(), heroes[i].getMaxJumpAbility());
            Thread.sleep(TIMEOUT);
        }
        System.out.println("Приключения начинаются!\n");
        Thread.sleep(TIMEOUT);
    }

    private static void passingObstacles(Hero[] heroes, Obstacle[] obstacles) throws InterruptedException {
        for (int i = 0; i < heroes.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                System.out.printf("%s пытается преодолеть препятствие %s\n", heroes[i].getName(),
                        obstacles[j].descriptionTrouble());
                Thread.sleep(TIMEOUT);
                if (!obstacles[j].checkSuccess(heroes[i])) {
                    System.out.printf("Неудача! %s не смог(-ла) преодолеть препятствие %s и сходит " +
                            "с дистанции\n", heroes[i].getName(), obstacles[j].descriptionTrouble());
                    heroLost++;
                    Thread.sleep(TIMEOUT);
                    break;
                } else System.out.println("Успех!");
                Thread.sleep(TIMEOUT);
            }
        }
    }

    private static void summary(Hero[] heroes) throws InterruptedException {
        if (heroLost == 0) {
            System.out.println("\nДо Гудвина добрались все!\n");
            Thread.sleep(TIMEOUT);
            System.out.println("Happy End!");
            System.exit(0);
        }
        if (heroes.length - heroLost == 0) {
            System.out.println("\nДо Гудвина не добрался никто...\n");
            Thread.sleep(TIMEOUT);
            System.out.println("THE END");
            System.exit(0);
        }
        System.out.println("\nХоть и не все, но наши герои смогли добраться до Гудвина.\n");
        Thread.sleep(TIMEOUT);
        System.out.println("THE END");
    }
}

