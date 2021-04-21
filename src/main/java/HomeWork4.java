
import java.util.Scanner;

public class HomeWork4 {

    static final Scanner in = new Scanner(System.in);

    static char[][] BOARD;
    static int numberOfRepeats = 0;
    static int SIZE;
    static int LINE;
    static int x;
    static int y;
    static int count = 1;

    static int xAI;
    static int yAI;
    static int score;
    static int countDepth = 2;
    static boolean mark;
    static boolean debugger = false;

    private static final String EMPTY = " ";
    private static final String HEADER_FIRST_SYMBOL = "♥";

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';
    static char lastSymbol;


    public static void main(String[] args) {

        turnGame();
    }

    private static void turnGame() {

        turningDebugger();

        chooseBoardSize();

        do {
            initBoard();

            printBoard();

            playGame();

            endGame();

        } while (false);
    }

    private static void chooseBoardSize() {

        displayMessageOfGameCondition();

        setSize();

        setLine();
    }

    private static void turningDebugger() {
        System.out.println("Включить ловца ошибок? Введите 1");
        if ("1".equals(in.next()))
            debugger = true;
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

    private static void initBoard() {
        BOARD = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                BOARD[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printBoard() {
        printHeaderMap();

        printBodyBoard();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printBoardNumber(i);
        }
        System.out.println();
    }

    private static void printBodyBoard() {
        for (int i = 0; i < SIZE; i++) {
            printBoardNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(BOARD[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void printBoardNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void playGame() {
        do {
            count = 1;
            mark = true;
            humanTurn();
            printBoard();
            lastSymbol = DOT_HUMAN;
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            mark = false;
            findBestAiTurn();
            doTurn();
            printBoard();
            lastSymbol = DOT_AI;
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

        BOARD[rowNumber][colNumber] = DOT_HUMAN;
        x = rowNumber;
        y = colNumber;
    }

    private static int minimax(int indexRow, int indexCol, char symbol, int depth) {
        int best = (symbol == DOT_AI) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        if (depth > countDepth)
            return best;
        x = indexRow;
        y = indexCol;
        if (checkEnd(symbol))
            return score;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (BOARD[i][j] == DOT_EMPTY) {
                    BOARD[i][j] = symbol;
                    lastSymbol = symbol;
                    best = (symbol == DOT_AI) ? Math.max(score, minimax(i, j, DOT_HUMAN, depth + 1)) :
                            Math.min(score, minimax(i, j, DOT_AI, depth + 1));
                    if (debugger)
                        printLogicAi(best, lastSymbol, i, j, depth);
                    BOARD[i][j] = DOT_EMPTY;
                }
            }
        }
        return best;
    }

    private static void findBestAiTurn() {
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (BOARD[i][j] == DOT_EMPTY) {
                    BOARD[i][j] = DOT_AI;
                    lastSymbol = DOT_AI;
                    int depth = 0;
                    int turnScore = minimax(i, j, DOT_HUMAN, 0);
                    if (debugger)
                        printLogicAi(turnScore, lastSymbol, i, j, depth);
                    BOARD[i][j] = DOT_EMPTY;
                    if (turnScore > bestScore) {
                        xAI = i;
                        yAI = j;
                        bestScore = turnScore;
                    }
                }
            }
        }
    }

    private static void printLogicAi(int score, char symbol, int x, int y, int depth) {
        System.out.printf("%d ход ИИ, цена которого %d\n", count, score);
        System.out.printf(depth < 1 ? "Глубина 0\n" : "Глубина %s\n", depth);
        System.out.printf("Это ход %c c координатами %s и %s\n", symbol, x, y);
        printBoard();
        System.out.println();
        count++;
    }

    private static void doTurn() {
        System.out.println("\nХод ИИ");
        BOARD[xAI][yAI] = DOT_AI;
        x = xAI;
        y = yAI;
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
        return BOARD[rowNumber][colNumber] == DOT_EMPTY;
    }

    private static boolean checkEnd(char symbol) {

        if (checkWin(lastSymbol)) {
            if (lastSymbol == DOT_HUMAN) {
                if (mark)
                    System.out.println("Ура! Вы победили!");
                score = -10;
            } else {
                if (mark)
                    System.out.println("Восстание близко... ИИ победил");
                score = 10;
            }
            return true;
        }
        if (isBoardFull()) {
            if (mark)
                System.out.println("Ничья!");
            score = 0;
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (BOARD[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char symbol) {

        int indexOfLastTurn = x + y;
        int indexOfReverseLastTurn = x + (SIZE - 1 - y);
        char[][] mapReverse = reverseArray();
        return checkRows(lastSymbol) ||
                checkColumns(lastSymbol) ||
                checkDiagonals(lastSymbol, BOARD, indexOfLastTurn) ||
                checkDiagonals(lastSymbol, mapReverse, indexOfReverseLastTurn);
    }

    private static char[][] reverseArray() {
        char[][] mapReverse = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapReverse[i][j] = BOARD[i][SIZE - j - 1];
            }
        }
        return mapReverse;
    }

    private static boolean checkRows(char symbol) {
        numberOfRepeats = 0;
        for (int i = 0; i < SIZE; i++) {
            numberOfRepeats = BOARD[x][i] == symbol ? numberOfRepeats + 1 : 0;
            if (numberOfRepeats >= LINE)
                return true;
        }
        return false;
    }

    private static boolean checkColumns(char symbol) {
        numberOfRepeats = 0;
        for (int j = 0; j < SIZE; j++) {
            numberOfRepeats = BOARD[j][y] == symbol ? numberOfRepeats + 1 : 0;
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