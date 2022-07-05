package com.chrosciu.geometry;

import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper=false)
public class Section extends Polygon {
    Point p1;
    Point p2;

    @Override
    public Set<Point> getVertices() {
        return Set.of(p1, p2);
    }

    @Override
    public double getArea() {
        return 0;
    }
}
