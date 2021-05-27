package geekbrains.hm14;

import org.junit.jupiter.api.*;

public class MainTest {

    @DisplayName("1 метод: {4, 4, 8, 7} -> {8, 7}")
    @Test
    public void testFirstMethod1() {
        int[] source = {4, 4, 8, 7};
        int[] excepted = {8, 7};
        Assertions.assertArrayEquals(excepted, Main.firstMethod(source));
    }

    @DisplayName("1 метод: {6, 4, 8, 4} -> {}")
    @Test
    public void testFirstMethod2() {
        int[] source = {6, 4, 8, 4};
        int[] excepted = {};
        Assertions.assertArrayEquals(excepted, Main.firstMethod(source));
    }

    @DisplayName("1 метод: {} return null")
    @Test
    public void testFirstMethod3() {
        int[] source = {};
        Assertions.assertNull(Main.firstMethod(source));
    }

    @DisplayName("1 метод: {1, 12, 1, 0} return null")
    @Test
    public void testFirstMethod4() {
        int[] source = {1, 12, 1, 0, 44, 8, 8, 7, 55, 1, 0};
        Assertions.assertNull(Main.firstMethod(source));
    }

    @DisplayName("2 метод: {1, 1, 1, 1, 1, 4} return true")
    @Test
    public void testSecondMethod1() {
        int[] source = {1, 1, 1, 1, 1, 4};
        Assertions.assertTrue(Main.secondMethod(source));
    }

    @DisplayName("2 метод: {1, 1, 1, 1, 1} return false")
    @Test
    public void testSecondMethod2() {
        int[] source = {1, 1, 1, 1, 1};
        Assertions.assertFalse(Main.secondMethod(source));
    }

    @DisplayName("2 метод: {1, 1, 1, 3, 1, 4} return false")
    @Test
    public void testSecondMethod3() {
        int[] source = {1, 1, 1, 3, 1, 4};
        Assertions.assertFalse(Main.secondMethod(source));
    }

    @DisplayName("2 метод: {} return false")
    @Test
    public void testSecondMethod4() {
        int[] source = {};
        Assertions.assertFalse(Main.secondMethod(source));
    }
}