package com.chrosciu.geometry;

public record Point(double x, double y) {

    public double distance(Point p) {
        return Math.sqrt(Math.pow((p.x - x), 2.0) + Math.pow((p.y - y), 2.0));
    }
}
