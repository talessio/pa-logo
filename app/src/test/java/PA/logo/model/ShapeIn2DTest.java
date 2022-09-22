package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedHashSet;

public class ShapeIn2DTest {
    LinkedHashSet<ShapeIn2D> shapesInCanvas = new LinkedHashSet<>();
    CanvasIn2D canvas = new CanvasIn2D(100.0, 100.0, Color.lightGray, shapesInCanvas);
    LogoPointIn2D point1 = new LogoPointIn2D(1.0, 1.0, canvas);
    LogoPointIn2D point2 = new LogoPointIn2D(2.0, 3.0, canvas);
    LogoPointIn2D point3 = new LogoPointIn2D(6.0, 2.0, canvas);
    LogoPointIn2D point4 = new LogoPointIn2D(1.0, 1.0, canvas);
    LogoPointIn2D point5 = new LogoPointIn2D(33.5, 44.0, canvas);
    LogoPointIn2D point6 = new LogoPointIn2D(14.7, 5.5, canvas);
    StraightLineIn2D line1 = new StraightLineIn2D(point1, point2, Color.pink);
    StraightLineIn2D line2 = new StraightLineIn2D(point2, point3, Color.yellow);
    StraightLineIn2D line3 = new StraightLineIn2D(point3, point4);
    StraightLineIn2D line4 = new StraightLineIn2D(point5, point6, Color.green);


    @Test
    public void addLinesToShapeTest() {
//        Assertions.assertFalse(shape1.isClosed());
        LinkedHashSet<StraightLineIn2D> line = new LinkedHashSet<>();
        line.add(line1);
        ShapeIn2D shape1 = new ShapeIn2D(line, canvas);
//        shape1.addLinesToShape(line);
        Assertions.assertTrue(shape1.getShapeLines().contains(line1));
        LinkedHashSet<StraightLineIn2D> otherLines = new LinkedHashSet<>();
        otherLines.add(line2);
        otherLines.add(line3);
        shape1.addLinesToShape(otherLines);
        Assertions.assertTrue(shape1.isClosed());
        shape1.setShapeColor(Color.cyan);
        LinkedHashSet<StraightLineIn2D> oneMoreLine = new LinkedHashSet<>();
        oneMoreLine.add(line4);
        ShapeIn2D shape2 = new ShapeIn2D(oneMoreLine, canvas);
//        shape2.addLinesToShape(oneMoreLine);
        Assertions.assertFalse(shape2.isClosed());
        Assertions.assertThrows(NullPointerException.class, () -> shape1.addLinesToShape(null));
        Assertions.assertThrows(NullPointerException.class, () -> shape2.addLinesToShape(null));
        LinkedHashSet<StraightLineIn2D> disconnectedLine = new LinkedHashSet<>();
        disconnectedLine.add(line1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> shape2.addLinesToShape(disconnectedLine)); //TODO: lines must connect to at least one end of the shape e.g. if(shape.getEnds = at least one coordinate of new line) linesInShape.add(line) else throw exception
    }
}
