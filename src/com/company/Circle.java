package com.company;

public class Circle implements Figure {
    private final int radius;
    private String color = "black";
    private String borderColor = "black";

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public double getSquare() {
        return radius * radius * Math.PI;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }
}
