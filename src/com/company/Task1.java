package com.company;

import java.util.Random;
import java.util.stream.IntStream;

public class Task1 {
    private int[] numbers;
    public Task1(int length) {
        this.numbers = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            numbers[i] = random.nextInt();
        }
    }

    public int findEvenNumbers() {
        return (int)IntStream.of(this.numbers)
                .filter(x -> x % 2 == 0).count();
    }

    public int[] getNumbers() {
        return this.numbers;
    }
}
