package geekbrains.hm10.Task2;

public class Main {

    public static void main(String[] args) {

        Apple apple = new Apple(1f, "[яблоко]");
        Orange orange = new Orange(1.5f, "[апельсин]");
        WormyApple wormyApple = new WormyApple(4f, "[червивое яблоко]");

        Box<Apple> box1 = new Box();
        Box<Orange> box2 = new Box();
        Box<Apple> box3 = new Box();
        Box<Apple> box4 = new Box(15);
        Box<WormyApple> box5 = new Box(7);

        box1.add(apple, 6);
        box2.add(orange, 4);
        box3.add(apple, 7);
        box4.add(apple, 10);
        box5.add(wormyApple, 5);

        System.out.println(box5.getWeightBox());
        System.out.println(box5.compareWith(box2));
        box2.display();

        box1.transferFrom(box3);
        System.out.println(box1.getCurrentSize());
        box1.display();
        System.out.println(box3.getCurrentSize());
        box3.display();
        box3.transferFrom(box4);
        box3.display();
        box4.display();

        box4.transferFrom(box5);
        box4.display();
        box5.display();
    }
}
