package com.company;

import java.util.ArrayList;
import java.util.List;

//Класс Box, в который можно складывать фрукты.
//Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины
public class Box<T extends Fruit> {
    private List<T> list = new ArrayList<>();

//Метод добавления фрукта в коробку
    public void addFruit(T fruit) {
        list.add(fruit);
    }

//Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
//вес яблока – 1.0f, апельсина – 1.5f
    public float getWeight() {
        if (list.isEmpty()) {
            System.out.println("Коробка пустая");
            return 0;
        }

        float weight = 0.0f;
        for (T fruit : list) {
            weight += fruit.getWeight();
        }
        return weight;
    }

//Внутри класса Box сделать метод compare(),
//который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра.
//true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами
    public boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }

//Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой
    public void transportTo(Box<T> box) {
        if (this.list.isEmpty()) {
            System.out.println("Коробка пустая");
        }
        for (T fruit : list) {
            box.addFruit(fruit);
        }
        list.clear();
    }
}
