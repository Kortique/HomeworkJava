import java.util.Arrays;
import java.util.Date;

public class HomeWork {
    public static void main(String[] args) {
        System.out.printf("Сегодня %tA %<te %<tB %<tY года.%nВыполняется ДЗ №2.%n%n", new Date());

        //задание 1
        int[] arrayBinary = getRandomArray(6, 2);
        System.out.printf("Задание 1: сгенерирован массив %s, преобразуется в %s;%n",
                Arrays.toString(arrayBinary), Arrays.toString(reverseArray(arrayBinary)));

        //задание 2
        System.out.printf("Задание 2: сгенерирован массив %s;%n", Arrays.toString(generationArray()));

        //задание 3
        int[] arrayAlpha = getRandomArray(8, 10);
        System.out.printf("Задание 3: сгенерирован массив %s, " +
                "после преобразования он равен %s;%n", Arrays.toString(arrayAlpha),
                Arrays.toString(changeArray(arrayAlpha)));

        //задание 4
        System.out.printf("Задание 4:%n");
        drawCrossInArray(7);

        //задание 5
        int[] arrayBeta = getRandomArray(10, 100);
        System.out.printf("Задание 5: сгенерирован массив %s. Его max = %s, min = %s;%n", Arrays.toString(arrayBeta),
                findMaxArray(arrayBeta), findMinArray(arrayBeta));

        //задание 6
        int[] arrayGamma = getRandomArray(6, 4);
        System.out.printf("Задание 6: сгенерирован массив %s. Выполняется ли условие задачи? %b;%n",
                Arrays.toString(arrayGamma), checkBalance(arrayGamma));

        //задание 7
        System.out.print("Задание 7: ");
        offsetElementsOfArray(4, 4, -2);
    }

    public static int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
        return array;
    }

    public static int[] generationArray() {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
        return array;
    }

    public static int[] changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    public static int[] getRandomArray(int length, int highNum) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            int a = (int) (Math.random()*highNum);
            array[i] = a;
        }
        return array;
    }

    public static void drawCrossInArray(int a) {
        System.out.println();
        int[][] array = new int[a][a];
        for (a = 0; a < array.length; a++) {
            array[a][a] = 1;
            array[a][array.length - 1 - a] = 1;
            }
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%3d", anInt);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int findMaxArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int a : array) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    public static int findMinArray(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int a : array) {
            if (a < min) {
                min = a;
            }
        }
        return min;
    }

    public static boolean checkBalance(int[] array) {
        int sum = 0;
        int balance = 0;
        for (int a : array) sum += a;
        if (sum % 2 == 0) {
            sum = sum / 2;
        } else
            return false;
        for (int a : array) {
            balance += a;
            if (balance == sum)
                return true;
            }
        return false;
    }

    public static void offsetElementsOfArray(int length, int highNum, int offset) {
        int[] array = getRandomArray(length, highNum);
        System.out.printf("сгенерирован массив %s. Смещая элементы на %s, ", Arrays.toString(array), offset);
        if (offset >= 0) {
            while (offset > 0) {
                for (int i = array.length-1; i > 0; i--) {
                    int nextIndex = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = nextIndex;
                }
                offset--;
            }
        } else {
            while (offset < 0) {
                for (int i = 0; i < array.length - 1; i++) {
                    int nextIndex = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = nextIndex;
                }
                offset++;
            }
        }
        System.out.printf("получаем массив %s.%n", Arrays.toString(array));
    }
}
