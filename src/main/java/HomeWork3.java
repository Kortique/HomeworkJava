import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class HomeWork3 {

    public static Scanner in = new Scanner(System.in);
    public static String currentWord;
    public static int starLength = 15;
    public static String message = "Выберите действия: 1 - угадывать по буквам дальше, 2 - назвать слово," +
            " 0 - закончить игру";

    public static void main(String[] args) throws IOException {

        System.out.printf("Сегодня %tA %<te %<tB %<tY года.%nВыполняется ДЗ №3.%n%n", new Date());
        startGame();
    }

    //Игра реализовано наподобие виселицы. Создаётся пустой массив под разгадывание, выбирается случайное слово
    //из пула вариантов и запускается цикл игры
    public static void startGame() throws IOException {

        char[] myAnswer = new char[starLength];
        Arrays.fill(myAnswer, '*');
        currentWord = chooseWordForGame();
        char[] guessWord = currentWord.toCharArray();

        while (true) {
            compareWord(myAnswer, guessWord);
            chooseAction();
        }
    }

    public static String chooseWordForGame() {

        String[] array = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int n = (int) (Math.random() * (double) array.length);
        return array[n];
    }

    private static void chooseAction() {

        System.out.println("\n" + message);
        boolean b = false;

        while (!b) {
            switch (in.next()) {
                case "1":
                    b = true;
                    break;
                case "2":
                    b = true;
                    compareAnswer();
                    break;
                case "0":
                    System.out.println("Игра завершена");
                    System.exit(0);
                default:
                    System.out.println(message);
            }
        }
    }

    private static void compareWord(char[] myAnswer, char[] guessWord) throws IOException {

        //Создаётся копия для сравнения в метод result на проверку наличия изменений
        char[] oldMyAnswer = Arrays.copyOf(myAnswer, starLength);
        System.out.println("Введите букву");
        char letter = (char) System.in.read();

        for (int i = 0; i < guessWord.length; ++i) {
            if (letter == guessWord[i]) {
                myAnswer[i] = guessWord[i];
            }
        }
        System.in.skip(System.in.available()); //обнуляется буффер обмена
        result(myAnswer, oldMyAnswer);
    }

    private static void result(char[] myAnswer, char[] oldMyAnswer) {

        boolean res = Arrays.equals(oldMyAnswer, myAnswer);
        if (!res) {
            System.out.println("Есть такая буква! Отроем её");
        } else {
            System.out.println("Такой буквы нет в данном слове. Пробуйте дальше");
        }

        System.out.println(myAnswer);
    }

    private static void compareAnswer() {

        System.out.println("Введите ответ: ");
        String answer = in.next();
        if (answer.equalsIgnoreCase(currentWord)) {
            System.out.println("Верный ответ!\nИгра завершена.");
        } else {
            System.out.printf("Вы не угадали, загадано было слово %s. Игра окончена", currentWord);
        }

        System.exit(0);
    }
}