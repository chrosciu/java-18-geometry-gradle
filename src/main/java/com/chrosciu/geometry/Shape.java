package com.chrosciu.geometry;

public sealed interface Shape permits Polygon, Circle {
    double getArea();
}
