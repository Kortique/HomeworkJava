package geekbrains.hm9;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try {
            String[][] array = generateArray(4, 4,"2", "7");
            sumArray(array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void sumArray(String[][] array) {
        int summary = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    summary += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Сумма чисел массива: " + summary);
    }

    private static String[][] generateArray(int row, int col, String firstArraySymbol,
                                            String initArraySymbols) {
        String[][] array = new String[row][col];
        if (row != 4 || col != 4) throw new MyArraySizeException(row, col);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[row-1].length; j++) {
                array[i][j] = initArraySymbols;
            }
        }
        array[0][0] = firstArraySymbol;
        System.out.println("Массив: " + Arrays.deepToString(array));
        return array;
    }
}
