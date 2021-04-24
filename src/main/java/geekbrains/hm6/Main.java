package geekbrains.hm6;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Каспер", 250, 20);
        Cat cat2 = new Cat("Буржуй", 25, 0);
        Dog dog1 = new Dog("Тотошка", 800, 12);
        Dog dog2 = new Dog("Вулкан", 225, 7);
        Dog dog3 = new Dog("Барбос", -15, -18);

        cat1.run(cat1.getRunDist());
        cat1.swim(cat1.getSwimDist());
        cat2.run(cat2.getRunDist());
        cat2.swim(cat2.getSwimDist());
        dog1.run(dog1.getRunDist());
        dog1.swim(dog1.getSwimDist());
        dog2.run(dog2.getRunDist());
        dog2.swim(dog2.getSwimDist());
        dog3.run(dog3.getRunDist());
        dog3.swim(dog3.getSwimDist());

        printInfo();
    }

    public static void printInfo() {
        System.out.println();
        System.out.println("В забеге участвовало " + Animal.getCount() + " животных, из них "
        + Cat.getCount() + " кота и " + Dog.getCount() + " собак.");
    }
}