package com.company;

public class Main {
    /*
    Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     */
    public static int myArray(String[][] array) throws MyArrayDataException, MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] strings : array) {
            for (int j = 0; j < strings.length; j++) {
                if (strings.length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
        /*
        Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
        Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
        должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
         */
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("[" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }

    /*
    В методе main() вызвать полученный метод,
    обработать возможные исключения MyArraySizeException и MyArrayDataException
    и вывести результат расчета.
     */
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16", "17"}
        };

        try {
            int sum = myArray(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
