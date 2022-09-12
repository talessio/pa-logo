package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

public class ShapeIn2DTest {
    ArrayList<ShapeIn2D> shapesInCanvas = new ArrayList<>();
    CanvasIn2D canvas = new CanvasIn2D(100.0, 100.0, Color.lightGray, shapesInCanvas);
    ArrayList<StraightLineIn2D> linesInShape1 = new ArrayList<>();
    ArrayList<StraightLineIn2D> linesInShape2 = new ArrayList<>();
    double x1 = 1.0;
    double y1 = 1.0;
    LogoPointIn2D coordinate1 = new LogoPointIn2D(x1, y1, canvas);
    double x2 = 2.0;
    double y2 = 3.0;
    LogoPointIn2D coordinate2 = new LogoPointIn2D(x2, y2, canvas);
    StraightLineIn2D line1 = new StraightLineIn2D(coordinate1, coordinate2, Color.pink);
    double x3 = 2.0;
    double y3 = 3.0;
    LogoPointIn2D coordinate3 = new LogoPointIn2D(x3, y3, canvas);
    double x4 = 6.0;
    double y4 = 2.0;
    LogoPointIn2D coordinate4 = new LogoPointIn2D(x4, y4, canvas);
    StraightLineIn2D line2 = new StraightLineIn2D(coordinate3, coordinate4, Color.yellow);
    double x5 = 6.0;
    double y5 = 2.0;
    LogoPointIn2D coordinate5 = new LogoPointIn2D(x5, y5, canvas);
    double x6 = 1.5;
    double y6 = 1.5;
    LogoPointIn2D coordinate6 = new LogoPointIn2D(x6, y6, canvas);
    StraightLineIn2D line3 = new StraightLineIn2D(coordinate5, coordinate6);
    double x7 = 33.5;
    double y7 = 44.0;
    LogoPointIn2D coordinate7 = new LogoPointIn2D(x7, y7, canvas);
    double x8 = 5.5;
    double y8 = 14.7;
    LogoPointIn2D coordinate8 = new LogoPointIn2D(x8, y8, canvas);
    StraightLineIn2D line4 = new StraightLineIn2D(coordinate7, coordinate8, Color.green);
    ShapeIn2D shape1 = new ShapeIn2D(linesInShape1, Color.cyan);
    ShapeIn2D shape2 = new ShapeIn2D(linesInShape2);



    @Test
    public void addLine() {
        Assertions.assertFalse(shape1.isClosed()); //TODO: everything is always closed?
        this.shape1.addLineToShape(line1);
        Assertions.assertTrue(shape1.getShapeLines().contains(line1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> shape1.addLineToShape(line1));
        Assertions.assertFalse(shape1.isClosed());
//        ArrayList<StraightLineIn2D> otherLines = new ArrayList<>();
//        otherLines.add(line2);
//        otherLines.add(line3);
//        this.shape1.addLinesToShape(otherLines);
        this.shape1.addLineToShape(line2); //TODO: adding single lines works, adding multiple lines doesnt. i must have gotten some iteration wrong in legalitychecker.
        this.shape1.addLineToShape(line3);
        Assertions.assertTrue(shape1.isClosed());
        Assertions.assertFalse(shape2.isClosed());
        this.shape2.addLineToShape(line4);
        Assertions.assertFalse(shape2.isClosed());
        Assertions.assertThrows(NullPointerException.class, () -> shape1.addLineToShape(null));
        Assertions.assertThrows(NullPointerException.class, () -> shape2.addLineToShape(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> shape2.addLineToShape(line1)); //TODO: lines must connect to at least one end of the shape e.g. if(shape.getEnds = at least one coordinate of new line) linesInShape.add(line) else throw exception
    }
}
