package geekbrains.hm9;

public class MyArrayDataException extends NumberFormatException{

    public MyArrayDataException(int i, int j) {
        super(String.format("Неподходящий тип данных в ячейке массива [%d][%d]\n", i, j));
    }
}
