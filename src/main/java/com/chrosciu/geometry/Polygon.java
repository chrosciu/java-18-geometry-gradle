package com.chrosciu.geometry;

import java.util.Set;

public abstract sealed class Polygon implements Shape permits Section, Square {
    public abstract Set<Point> getVertices();
}
