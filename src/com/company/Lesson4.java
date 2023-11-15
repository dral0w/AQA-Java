package com.company;

public class Lesson4 {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("a", "a", "a", "1", 1, 28);
        employees[1] = new Employee("b", "b", "b", "2", 2, 54);
        employees[2] = new Employee("c", "c", "c", "3", 3, 32);
        employees[3] = new Employee("d", "d", "d", "4", 4, 45);
        employees[4] = new Employee("e", "e", "e", "5", 5, 19);

        for (Employee employee : employees) {
            if (employee.age > 40) {
                employee.getInformation();
            }
        }
    }
}
