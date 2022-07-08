package com.chrosciu.geometry;

public record Circle(Point center, double radius) implements Shape {

    public Circle {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2.0);
    }
}
