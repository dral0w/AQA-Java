package com.company;

public class Employee {
    public String name;
    public String position;
    public String email;
    public String phoneNumber;
    public int salary;
    public int age;

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void getInformation() {
        System.out.println("ФИО: " + name + "\n" + "Должность: " + position + "\n" + "Email: " + email + "\n" +
                "Телефон: " + phoneNumber + "\n" + "Зарплата: " + salary + "\n" + "Возраст: " + age + "\n");
    }
}
