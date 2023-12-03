package com.company;

public class Main {

    public static void main(String[] args) {
        AppData data = new AppData();
        data.setHeader(new String[]{"Value 1", "Value 2", "Value 3"});
        data.setData(new int[][]{new int[]{100, 200, 123}, new int[]{300, 400, 500}});
        data.write();
        data.getInformation();
        data.read();
        data.getInformation();
    }
}
