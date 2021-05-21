package geekbrains.hm12;

import java.util.Arrays;

public class Main {

    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) {

        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        startSingleThread(arr);
        startDoubleThreads(arr);
        startQuadThreads(arr);
    }

    private static void startSingleThread(float[] array) {
        long a = System.currentTimeMillis();
        float[] array1 = Arrays.copyOfRange(array, 0, SIZE);
        calculate(array1, 0);
//        System.out.println(Arrays.toString(array1));
        System.out.println("Время выполнения для 1 потока " + (System.currentTimeMillis() - a) + "мс");
    }

    private static void calculate(float[] array, int add) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + (i + add) / 5) *
                    Math.cos(0.2f + (i + add) / 5) * Math.cos(0.4f + (i + add) / 2));
        }
    }

    private static void startDoubleThreads(float[] array) {
        long a = System.currentTimeMillis();
        float[] array1 = Arrays.copyOfRange(array, 0, H);
        float[] array2 = Arrays.copyOfRange(array, H, SIZE);
        Thread thread1 = new Thread(() -> calculate(array1, 0));
        Thread thread2 = new Thread(() -> calculate(array2, H));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float[] arrayOriginal = new float[SIZE];
            System.arraycopy(array1, 0, arrayOriginal, 0, array1.length);
            System.arraycopy(array2, 0, arrayOriginal, array1.length, array2.length);
//        System.out.println(Arrays.toString(arrayOriginal));

        System.out.println("Время выполнения для 2 потоков " + (System.currentTimeMillis() - a) + "мс");

    }

    private static void startQuadThreads(float[] array) {
        long a = System.currentTimeMillis();

        float[] array1 = Arrays.copyOfRange(array, 0, H/2);
        float[] array2 = Arrays.copyOfRange(array, H/2, H);
        float[] array3 = Arrays.copyOfRange(array, H, SIZE-H/2);
        float[] array4 = Arrays.copyOfRange(array, SIZE-H/2, SIZE);
        Thread thread1 = new Thread(() -> calculate(array1, 0));
        Thread thread2 = new Thread(() -> calculate(array2, H/2));
        Thread thread3 = new Thread(() -> calculate(array3, H));
        Thread thread4 = new Thread(() -> calculate(array4, SIZE-H/2));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float[] arrayOriginal = new float[SIZE];
        System.arraycopy(array1, 0, arrayOriginal, 0, array1.length);
        System.arraycopy(array2, 0, arrayOriginal, array1.length, array2.length);
        System.arraycopy(array3, 0, arrayOriginal, array2.length, array3.length);
        System.arraycopy(array4, 0, arrayOriginal, array3.length, array4.length);

        System.out.println("Время выполнения для 4 потоков " + (System.currentTimeMillis() - a) + "мс");

    }

}
