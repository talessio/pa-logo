package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class StraightLineIn2DTest {

    ArrayList<ShapeIn2D> shapesInCanvas = new ArrayList<>();
    CanvasIn2D canvas = new CanvasIn2D(100.0, 100.0, Color.lightGray, shapesInCanvas);
    LogoPointIn2D point1 = new LogoPointIn2D(1.0, 1.0, canvas);
    LogoPointIn2D point2 = new LogoPointIn2D(2.0, 3.0, canvas);
    LogoPointIn2D point3 = new LogoPointIn2D(6.0, 2.0, canvas);
    LogoPointIn2D point4 = new LogoPointIn2D(33.5, 44.0, canvas);
    LogoPointIn2D point5 = new LogoPointIn2D(5.5, 14.7, canvas);
    StraightLineIn2D line1 = new StraightLineIn2D(point1, point2, Color.black);
    StraightLineIn2D line2 = new StraightLineIn2D(point2, point3, Color.yellow);
    StraightLineIn2D line3 = new StraightLineIn2D(point3, point1);
    StraightLineIn2D line4 = new StraightLineIn2D(point4, point5, Color.green);

    @Test
    public void getPointsTest() {
        LinkedHashSet<StraightLineIn2D> linesForShape1 = new LinkedHashSet<>();
        linesForShape1.add(line1);
        linesForShape1.add(line2);
        linesForShape1.add(line3);
        ShapeIn2D shape1 = new ShapeIn2D(linesForShape1, this.canvas);
        shape1.setShapeColor(Color.cyan);
        LinkedHashSet<StraightLineIn2D> lineForShape2 = new LinkedHashSet<>();
        lineForShape2.add(line4);
        ShapeIn2D shape2 = new ShapeIn2D(lineForShape2, this.canvas);

        Assertions.assertSame(line1.getPoints().get(0), point1);
        Assertions.assertSame(line1.getPoints().get(1), point2);
        Assertions.assertSame(line2.getPoints().get(0), point2);
        Assertions.assertSame(line2.getPoints().get(1), point3);
        Assertions.assertSame(line3.getPoints().get(0), point3);
        Assertions.assertSame(line3.getPoints().get(1), point1);
    }

    @Test
    public void getLineColorTest() {
        LinkedHashSet<StraightLineIn2D> linesForShape1 = new LinkedHashSet<>();
        linesForShape1.add(line1);
        linesForShape1.add(line2);
        linesForShape1.add(line3);
        ShapeIn2D shape1 = new ShapeIn2D(linesForShape1, this.canvas);
        shape1.setShapeColor(Color.cyan);
        LinkedHashSet<StraightLineIn2D> lineForShape2 = new LinkedHashSet<>();
        lineForShape2.add(line4);
        ShapeIn2D shape2 = new ShapeIn2D(lineForShape2, this.canvas);

        Assertions.assertSame(line1.getColor(), Color.black);
        Assertions.assertSame(line2.getColor(), Color.yellow);
        Assertions.assertSame(line3.getColor(), Color.black);
        Assertions.assertSame(line4.getColor(), Color.green);
        Assertions.assertNotSame(line1.getColor(), Color.yellow);
        Assertions.assertNotSame(line2.getColor(), Color.black);
        Assertions.assertNotSame(line3.getColor(), Color.green);
        Assertions.assertNotSame(line4.getColor(), Color.yellow);
    }
}
