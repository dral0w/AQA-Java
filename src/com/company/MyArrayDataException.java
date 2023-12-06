package com.company;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(String index) {
        super("Неверные данные в ячейке" + index);
    }
}
