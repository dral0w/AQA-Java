package com.company;

import java.io.*;
import java.util.Arrays;

/*
Для хранения данных использовать класс вида:
public class AppData {
   private String[] header;
   private int[][] data;
   // ...
}
 */
public class AppData implements Serializable {
    private String[] header;
    private int[][] data;

    public void setData(int[][] data) {
        this.data = data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    private String[] getHeader() {
        return header;
    }

    //Сохранение данных в файл
    public void write() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.csv"))){
            bufferedWriter.write(String.join(";", getHeader()));
            bufferedWriter.newLine();

            for (int[] datum : data) {
                bufferedWriter.write(String.join(";", intArrayToStringArray(datum)));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Загрузка данных из файла
    public void read() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.csv"))){
            String header = bufferedReader.readLine();
            setHeader(header.split(";"));

            String line;
            int rowCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = stringArrayToIntArray(values);
                addDataRow(rowCount, row);
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int[] stringArrayToIntArray(String[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }

    private static String[] intArrayToStringArray(int[] array) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = String.valueOf(array[i]);
        }
        return result;
    }

    private void addDataRow(int rowIndex, int[] rowData) {
        if (rowIndex >= 0 && rowIndex < data.length) {
            data[rowIndex] = rowData;
        }
    }

    public void getInformation() {
        System.out.println(Arrays.toString(header));
        for (int[] datum : data) {
            System.out.println(Arrays.toString(datum));
        }
    }
}
