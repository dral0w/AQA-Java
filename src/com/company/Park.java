package com.company;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private List<Attraction> attractions;

    public Park() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String time, double price) {
        Attraction attraction = new Attraction(name, time, price);
        attractions.add(attraction);
    }

    public void displayAttractions() {
        for (Attraction attraction : attractions) {
            System.out.println(attraction);
        }
    }

    private class Attraction {

        private String name;
        private String time;
        private double price;

        public Attraction(String name, String time, double price) {
            this.name = name;
            this.time = time;
            this.price = price;
        }
    }
}
