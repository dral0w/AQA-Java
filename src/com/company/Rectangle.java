package com.company;

public class Rectangle implements Figure {
    private final int side1;
    private final int side2;
    private String color = "black";
    private String borderColor = "black";

    public Rectangle(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getPerimeter() {
        return (side1 + side2) * 2;
    }

    @Override
    public double getSquare() {
        return side1 * side2;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
