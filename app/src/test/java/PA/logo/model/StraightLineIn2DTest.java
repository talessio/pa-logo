package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

public class StraightLineIn2DTest {
    double x1 = 1.0;
    double y1 = 1.0;
    CoordinateIn2D coordinate1 = new CoordinateIn2D(x1, y1);
    double x2 = 2.0;
    double y2 = 3.0;
    CoordinateIn2D coordinate2 = new CoordinateIn2D(x2, y2);
    Color color1 = Color.black;
    StraightLineIn2D line1 = new StraightLineIn2D(coordinate1, coordinate2, color1);
    double x3 = 2.0;
    double y3 = 3.0;
    CoordinateIn2D coordinate3 = new CoordinateIn2D(x3, y3);
    double x4 = 6.0;
    double y4 = 2.0;
    CoordinateIn2D coordinate4 = new CoordinateIn2D(x4, y4);
    Color color2 = Color.yellow;
    StraightLineIn2D line2 = new StraightLineIn2D(coordinate3, coordinate4, color2);
    double x5 = 6.0;
    double y5 = 2.0;
    CoordinateIn2D coordinate5 = new CoordinateIn2D(x5, y5);
    double x6 = 1.0;
    double y6 = 1.0;
    CoordinateIn2D coordinate6 = new CoordinateIn2D(x6, y6);
    StraightLineIn2D line3 = new StraightLineIn2D(coordinate5, coordinate6);
    double x7 = 33.5;
    double y7 = 44.0;
    CoordinateIn2D coordinate7 = new CoordinateIn2D(x7, y7);
    double x8 = 5.5;
    double y8 = 14.7;
    CoordinateIn2D coordinate8 = new CoordinateIn2D(x8, y8);
    Color color3 = Color.green;
    StraightLineIn2D line4 = new StraightLineIn2D(coordinate7, coordinate8, color3);
    ArrayList<StraightLineIn2D> linesInShape1 = new ArrayList<>();
    ArrayList<StraightLineIn2D> linesInShape2 = new ArrayList<>();

    @Test
    public void getCoordinatesTest() {
        ShapeIn2D shape1;
        shape1 = new ShapeIn2D(linesInShape1, Color.cyan);
        shape1.addLine(line1);
        shape1.addLine(line2);
        shape1.addLine(line3);
        shape1.setClosed();
        ShapeIn2D shape2 = new ShapeIn2D(linesInShape2);
        shape2.addLine(line4);

        Assertions.assertSame(line1.getCoordinates().get(0), coordinate1);
        Assertions.assertSame(line1.getCoordinates().get(1), coordinate2);
        Assertions.assertSame(line2.getCoordinates().get(0), coordinate3);
        Assertions.assertSame(line2.getCoordinates().get(1), coordinate4);
        Assertions.assertSame(line3.getCoordinates().get(0), coordinate5);
        Assertions.assertSame(line3.getCoordinates().get(1), coordinate6);
    }

    @Test
    public void getLineColorTest() {
        ShapeIn2D shape1 = new ShapeIn2D(linesInShape1, Color.cyan);
        shape1.addLine(line1);
        shape1.addLine(line2);
        shape1.addLine(line3);
        shape1.setClosed();
        ShapeIn2D shape2 = new ShapeIn2D(linesInShape2);
        shape2.addLine(line4);

        Assertions.assertSame(line1.getLineColor(), Color.black);
        Assertions.assertSame(line2.getLineColor(), Color.yellow);
        Assertions.assertSame(line3.getLineColor(), Color.black);
        Assertions.assertSame(line4.getLineColor(), Color.green);
        Assertions.assertNotSame(line1.getLineColor(), Color.yellow);
        Assertions.assertNotSame(line2.getLineColor(), Color.black);
        Assertions.assertNotSame(line3.getLineColor(), Color.green);
        Assertions.assertNotSame(line4.getLineColor(), Color.yellow);
    }
}
