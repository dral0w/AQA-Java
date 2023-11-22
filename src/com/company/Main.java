package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //Реализовать сохранение данных в csv файл;
        try {
            FileOutputStream file = new FileOutputStream("D://File/file.csv");
            AppData data = new AppData();
            data.setHeader(new String[]{"Value 1", "Value 2", "Value 3"});
            data.setData(new int[][]{new int[]{100, 200, 123}, new int[]{300, 400, 500}});
            file.write(data.output().getBytes());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Реализовать загрузку данных из csv файла. Файл читается целиком.
        try {
            FileInputStream fileInputStream = new FileInputStream("D://File/file.csv");
            byte[] bytes = fileInputStream.readAllBytes();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
