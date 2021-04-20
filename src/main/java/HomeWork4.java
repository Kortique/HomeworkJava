
import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();

    static char[][] MAP;
    static int turnsCount;
    static int numberOfRepeats = 0;
    static int SIZE;
    static int LINE;
    static int x;
    static int y;

    private static final String EMPTY = " ";
    private static final String HEADER_FIRST_SYMBOL = "♥";

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    public static void main(String[] args) {

        turnGame();
    }

    private static void turnGame() {

        chooseMapSize();

        do {
            initMap();

            printMap();

            playGame();

            endGame();

        } while (false);
    }

    private static void chooseMapSize() {

        turnsCount = 0;

        displayMessageOfGameCondition();

        setSize();

        setLine();
    }

    private static void displayMessageOfGameCondition() {
        System.out.println("Введите размер игрового поля:\nполе от 3 до 5 клеток - победа при ряде = 3;\n" +
                "поле от 6 до 8 клеток - победа при ряде = 4;\nполе от 9 и выше - победа при ряде = 5.\n");
    }

    private static void setSize() {

        boolean isInputValid;
        do {
            while (!in.hasNextInt()) {
                in.next();
                notifyError();
            }
            SIZE = in.nextInt();
            if (SIZE < 3) {
                notifyError();
                isInputValid = false;
            } else isInputValid = true;
        } while (!isInputValid);
    }

    private static void notifyError() {
        System.out.println("Ошибка ввода! Введите корректное число в нужном диапазоне");
    }

    private static void setLine() {
        if (SIZE >= 3 && SIZE <= 5)
            LINE = 3;
        if (SIZE >= 6 && SIZE <= 8)
            LINE = 4;
        if (SIZE >= 9)
            LINE = 5;
    }

    private static void initMap() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();

        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void playGame() {

        do {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        } while (true);
    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;
        boolean isInputValid;

        System.out.println("\nХод человека! Введите номера строки и столбца");
        do {
            rowNumber = -1;
            colNumber = -1;
            isInputValid = true;

            System.out.print("Строка: ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;
            } else {
                in.next();
                notifyError();
                isInputValid = false;
                continue;
            }

            System.out.print("Столбец: ");
            if (in.hasNextInt()) {
                colNumber = in.nextInt() - 1;
            } else {
                in.next();
                notifyError();
                isInputValid = false;
            }
        } while (!(isInputValid && isHumanTurnValid(rowNumber, colNumber)));

        MAP[rowNumber][colNumber] = DOT_HUMAN;
        x = rowNumber;
        y = colNumber;
        turnsCount++;
    }

    private static void aiTurn() {
        int rowNumber;
        int colNumber;

        System.out.println("\nХод ИИ");
        do {
            rowNumber = random.nextInt(SIZE);
            colNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, colNumber));
        MAP[rowNumber][colNumber] = DOT_AI;
        turnsCount++;
    }

    private static boolean isHumanTurnValid(int rowNumber, int colNumber) {
        if (!isNumberValid(rowNumber, colNumber)) {
            System.out.println("\nПроверьте значение строки и столбца");
            return false;
        }
        if (!isCellFree(rowNumber, colNumber)) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }
        return true;
    }

    private static boolean isNumberValid(int rowNumber, int colNumber) {
        return rowNumber < SIZE && rowNumber >= 0 && colNumber < SIZE && colNumber >= 0;
    }

    private static boolean isCellFree(int rowNumber, int colNumber) {
        return MAP[rowNumber][colNumber] == DOT_EMPTY;
    }


    private static boolean checkEnd(char symbol) {

        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Ура! Вы победили!");
            } else {
                System.out.println("Восстание близко... ИИ победил");
            }
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }

        return false;
    }

    private static boolean isMapFull() {
        return turnsCount == SIZE * SIZE;
    }

    private static boolean checkWin(char symbol) {

        int indexOfLastTurn = x + y;
        int indexOfReverseLastTurn = x + (SIZE - 1 - y);
        char[][] mapReverse = reverseArray();
        return checkRows(symbol) ||
                checkColumns(symbol) ||
                checkDiagonals(symbol, MAP, indexOfLastTurn) ||
                checkDiagonals(symbol, mapReverse, indexOfReverseLastTurn);
    }

    private static char[][] reverseArray() {
        char[][] mapReverse = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapReverse[i][j] = MAP[i][SIZE - j - 1];
            }
        }
        return mapReverse;
    }

    private static boolean checkRows(char symbol) {
        numberOfRepeats = 0;
        for (int i = 0; i < SIZE; i++) {
            numberOfRepeats = MAP[x][i] == symbol ? numberOfRepeats + 1 : 0;
            if (numberOfRepeats >= LINE)
                return true;
        }
        return false;
    }

    private static boolean checkColumns(char symbol) {
        numberOfRepeats = 0;
        for (int j = 0; j < SIZE; j++) {
            numberOfRepeats = MAP[j][y] == symbol ? numberOfRepeats + 1 : 0;
            if (numberOfRepeats >= LINE)
                return true;
        }
        return false;
    }

    private static boolean checkDiagonals(char symbol, char[][] array, int indexOfLastTurn) {
        numberOfRepeats = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i + j == indexOfLastTurn)
                    numberOfRepeats = array[i][j] == symbol ? numberOfRepeats + 1 : 0;
            }
            if (numberOfRepeats >= LINE)
                return true;
        }
        return false;
    }

    private static void endGame() {
        System.out.println("Хотите сыграть ещё раз? Наберите \"1\"");
        if ("1".equals(in.next()))
            turnGame();
        System.out.println("Игра завершена");
        System.exit(0);
    }
}
