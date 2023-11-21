package com.company;

public class Lesson3 {

    public boolean checkSum(int a, int b) {
        return a + b > 10 && a + b <= 20;
    }

    public static void printString(int a, String s) {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    public static void checkNumber(int a) {
        if (a >= 0) {
            System.out.println("Positive number");
        } else {
            System.out.println("Negative number");
        }
    }

    public boolean checkNum(int a) {
        return a < 0;
    }

    public boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void task6() {
        int[] array = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1){
                array[i] = 0;
            }
        }
    }

    public static void task7() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static void task8() {
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    public static void task10() {
        int[][] array = new int[5][5];
        int rows = 0;
        int cols = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
                if (i == rows && j == cols) {
                    array[i][j] = 1;
                    rows++;
                    cols--;
                }
            }
        }
    }

    public int[] task11(int len, int initialValue) {
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void main(String[] args) {

    }
}
