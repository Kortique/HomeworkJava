package geekbrains.hm9;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{

    public MyArraySizeException(int x, int y) {
        super(String.format("Текущий размер массива [%d][%d] вместо требуемого [4][4]", x, y));
    }
}
