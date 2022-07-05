package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

public class ShapeIn2DTest {
    ArrayList<StraightLineIn2D> linesInShape1 = new ArrayList<>();
    ArrayList<StraightLineIn2D> linesInShape2 = new ArrayList<>();
    double x1 = 1.0;
    double y1 = 1.0;
    CoordinateIn2D coordinate1 = new CoordinateIn2D(x1, y1);
    double x2 = 2.0;
    double y2 = 3.0;
    CoordinateIn2D coordinate2 = new CoordinateIn2D(x2, y2);
    Color color1 = Color.pink;
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
    double x6 = 1.5;
    double y6 = 1.5;
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

    @Test
    public void addLine() {
        ShapeIn2D shape1 = new ShapeIn2D(linesInShape1, Color.cyan);
        System.out.println(shape1.isClosed());
        shape1.addLine(line1);
        shape1.addLine(line2);
        shape1.addLine(line3);
        ShapeIn2D shape2 = new ShapeIn2D(linesInShape2);
        shape2.addLine(line4);

        Assertions.assertThrows(NullPointerException.class, () -> shape1.addLine(null)); //TODO: cannot add null line
        Assertions.assertThrows(NullPointerException.class, () -> shape2.addLine(null)); //TODO: cannot add null line
        Assertions.assertThrows(IllegalArgumentException.class, () -> shape2.addLine(line1)); //TODO: lines must connect to at least one end of the shape e.g. if(shape.getEnds = at least one coordinate of new line) linesInShape.add(line) else throw exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> shape1.addLine(line1)); //TODO: cannot add same line twice

        ArrayList<StraightLineIn2D> linesInMockShape1 = new ArrayList<>();
        linesInMockShape1.add(line1);
        linesInMockShape1.add(line2);
        linesInMockShape1.add(line3);
        ArrayList<StraightLineIn2D> linesInMockShape2 = new ArrayList<>();
        linesInMockShape2.add(line4);

        Assertions.assertEquals(linesInMockShape1.toString(), shape1.getShapeLines().toString());
        Assertions.assertEquals(linesInMockShape2.toString(), shape2.getShapeLines().toString());
    }
}
