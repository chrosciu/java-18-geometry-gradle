package com.chrosciu.geometry;

import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper=false)
public class Square extends Polygon {
    Point corner;
    double length;

    @Override
    public Set<Point> getVertices() {
        return Set.of(
            corner,
            new Point(corner.x() + length, corner.y()),
            new Point(corner.x() + length, corner.y() + length),
            new Point(corner.x(), corner.y() + length));
    }

    @Override
    public double getArea() {
        return Math.pow(length, 2.0);
    }
}
