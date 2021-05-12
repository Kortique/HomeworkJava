package geekbrains.hm10.Task2;

public class Main {

    public static void main(String[] args) {

        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> box1 = new Box();
        Box<Orange> box2 = new Box();
        Box<Apple> box3 = new Box();
        Box<Apple> box4 = new Box();

        box1.add(apple, 6);
        box2.add(orange, 4);
        box3.add(apple, 7);
        box4.add(apple, 8);

        System.out.println(box2.getWeightBox());
        System.out.println(box1.compareWith(box2));
        box2.display();

        box1.transferFrom(box3);
        System.out.println(box1.getCurrentSize());
        box1.display();
        System.out.println(box3.getCurrentSize());
        box3.display();
        box3.transferFrom(box4);
        box3.display();
        box4.display();
    }
}
