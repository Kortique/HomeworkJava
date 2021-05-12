package geekbrains.hm10.Task1;

import java.util.Arrays;

public class Gen<E> {

    private E[] array;

    public Gen(E... number) {
        this.array = number;
    }

    public static void main(String[] args) {
        Gen<?> gen = new Gen<>(10,"20",'\u0491',50.6,70);

        gen.swappingIndexOfArray(1, 4);
    }

    private void swappingIndexOfArray(int a, int b) {
        if (!(a > array.length || b > array.length)) {
        E temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        System.out.printf("Новый массив имеет вид %s ", Arrays.toString(array));
        } else {
            System.err.println("Невозможно поменять выбранные элементы");
        }
    }
}
