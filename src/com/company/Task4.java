package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class Task4 {
    Collection<Student> students = Arrays.asList(
            new Student("Дмитрий", 17, Gender.MAN),
            new Student("Максим", 20, Gender.MAN),
            new Student("Екатерина", 20, Gender.WOMAN),
            new Student("Михаил", 28, Gender.MAN)
    );

    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "{" +
                    "name=" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }

    //Необходимо узнать средний возраст студентов мужского пола
    public double task4_1() {
        return students.stream().filter(student -> student.getGender().equals(Gender.MAN))
                .mapToInt(Student::getAge).average().getAsDouble();
    }

    //Кому из студентов грозит получение повестки в этом году при условии,
    //что призывной возраст установлен в диапазоне от 18 до 27 лет
    public String task4_2() {
        Student[] array = students.stream().filter(student -> student.gender == Gender.MAN)
                .filter(student -> student.age >= 18 && student.age <= 27)
                .toArray(Student[]::new);
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].getName();
        }
        return "Получение повестки грозит студентам:" + "\n" + Arrays.toString(result);
    }
}
