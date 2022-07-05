package com.chrosciu.geometry;

public sealed interface Shape permits Polygon, Circle {
    double getArea();

    default double getDiameter() {
        return switch (this) {
            case Circle c -> 2.0 * c.radius();
            case Section s -> s.getP1().distance(s.getP2());
            case Square s -> Math.sqrt(2.0) * s.getLength();
        };
    }
}
