package com.company;

/*
Для хранения данных использовать класс вида:
public class AppData {
   private String[] header;
   private int[][] data;
   // ...
}
 */
public class AppData {
    private String[] header;
    private int[][] data;

    public void setData(int[][] data) {
        this.data = data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public String output() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : header) {
            stringBuilder.append(s);
            stringBuilder.append("; ");
        }
        stringBuilder.append("\n");
        for (int[] datum : data) {
            for (int i : datum) {
                stringBuilder.append(i);
                stringBuilder.append("; ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
