import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Сегодня %tA %<te %<tB %<tY года.%nВыполняется ДЗ №1.%n%n", new Date());
        testVars();
        System.out.println("Задание 3: " + sumArgs(50, 20, 30, 40));
        System.out.println("Задание 4: " + checkSumArgs(12, 3));
        checkNumber(-5);
        System.out.println("Задание 6: " + checkNumberBool(-100));
        sayHello("Сергей");
        checkLeapYear(104);
    }

    public static void testVars() {

        byte varByte = 123;
        short varShort = 32000;
        int varInt = 55;
        long varLong = 8000000L;
        float varFloat = 178f;
        double varDouble = 3.14;
        char varChar = '\u2050';
        boolean varBool = true;
        System.out.printf("Задание 2: -=%c=- %s + %4$d = %3$.0f%n", varChar, varByte, varFloat, varInt);
    }

    public static float sumArgs(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean checkSumArgs(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkNumber(int a) {
        if (a >= 0) {
            System.out.println("Задание 5: передали положительное число");
        } else {
            System.out.println("Задание 5: передали отрицательное число");
        }
    }

    public static boolean checkNumberBool(int a) {
        return !(a >= 0);
    }

    public static void sayHello(String name) {
        System.out.printf("Задание 7: Привет, %s!%n", name);
    }

    public static void checkLeapYear(int a) {
        int LeapYear004 = a % 4;
        int LeapYear100 = a % 100;
        int LeapYear400 = a % 400;
        if (LeapYear400 == 0 || (LeapYear004 == 0 && LeapYear100 != 0)) {
            System.out.printf("Задание 8: %d год - високосный%n", a);
        } else {
            System.out.printf("Задание 8: %d год - невисокосный%n", a);
        }
    }

}