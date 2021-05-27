package geekbrains.hm14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int[] arrayOne = {1, 2, 4, 6, 5, 1, 22, 4, 3, 97, 4, 25, 4, 6, 1, 3};
        firstMethod(shuffleArray(arrayOne));

        int[] arrayTwo = {1, 1, 1, 1, 1, 4};
        System.out.println("Значение массива: " + secondMethod(arrayTwo));

    }

    public static int[] shuffleArray(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
        System.out.println("Исходный массив " + Arrays.toString(array));
        return array;
    }

    public static int[] firstMethod(int[] array) {
        int index = -1;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == 4) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            int[] arrayCopy = Arrays.copyOfRange(array, index + 1, array.length);
            System.out.println("Преобразованный массив " + Arrays.toString(arrayCopy));
            return arrayCopy;
        } else {
            System.out.println("Данный массив не отвечат условиям задачи");
            return null;
        }
    }

    public static boolean secondMethod(int[] array) {
        int[] checkArray = {1, 4};
        Set<Integer> set = new HashSet<>();
        boolean isEquality = false;
        for (int j : array) {
            for (int k : checkArray)
                if (j == k) {
                    isEquality = true;
                    break;
                }
            if (isEquality) {
                set.add(j);
                isEquality = false;
            } else {
                return false;
            }
        }
        if (set.size() == checkArray.length) {
            return true;
        } else {
            return false;
        }
    }
}

