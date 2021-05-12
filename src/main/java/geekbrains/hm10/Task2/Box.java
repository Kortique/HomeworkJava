package geekbrains.hm10.Task2;

public class Box<E extends Fruit> {

    private E[] fruit;
    private static final int DEFAULT_COUNT = 10;
    private int currentSize = 0;

    public Box() {
        this(DEFAULT_COUNT);
    }

    public Box(int size) {
        this.fruit = (E[]) new Fruit[size];
    }

    public int getCurrentSize() {
        System.out.printf("Количество фруктов в ящике равно ");
        return currentSize;
    }

    public void add(E value) {
        fruit[currentSize++] = value;
    }

    public void add(E value, int count) {
        for (int i = 0; i < count; i++) {
            fruit[currentSize++] = value;
        }
    }

    public void display() {
        for (E datum : fruit) {
            if (datum != null) {
                System.out.print(datum.getName() + " ");
            } else {
                System.out.print("[пусто]" + " ");
            }
        }
        System.out.println();
    }

    public float getWeightBox() {
        float weightBox = 0;
        if (currentSize == 0) return weightBox;
        for (int i = 0; i < currentSize; i++) {
            weightBox += fruit[i].getWEIGHT();
        }
        return weightBox;
    }

    public boolean compareWith(Box anotherBox) {
        return this.getWeightBox() == anotherBox.getWeightBox();
    }

    public void transferFrom(Box<E> anotherBox) {
        int freeCapacity = fruit.length - currentSize;
        int count = 0;
        if (freeCapacity <= 0) {
            System.out.println("Перенос невозможен: текущий ящик полон");
        } else {
            for (int i = 0, oldCurrentSize = anotherBox.currentSize; i < oldCurrentSize; i++) {
                if (freeCapacity-- == 0) {
                    System.out.printf("Перенос частично завершён: %d ед. перенесено в новый ящик, " +
                                    "%d ед. осталось в старом ящике;",
                            count, oldCurrentSize - count);
                    break;
                } else {
                    count++;
                    this.add(anotherBox.fruit[i]);
                    anotherBox.fruit[i] = null;
                    anotherBox.currentSize--;
                }
            }
            System.out.println("\nПеренесено " + count + " ед.");
        }
        organizeBox(anotherBox); //смещение объектов к началу массива
    }

    private void organizeBox(Box<E> anotherBox) {
        int countNull = 0;
        for (int i = 0; i < anotherBox.fruit.length; i++) {
            if (anotherBox.fruit[i] == null) {
                countNull++;
            } else {
                for (int j = 0; j < anotherBox.fruit.length - countNull; j++, i++) {
                    anotherBox.fruit[i-countNull] = anotherBox.fruit[i];
                    anotherBox.fruit[i] = null;
                }
                break;
            }
        }
    }
}
