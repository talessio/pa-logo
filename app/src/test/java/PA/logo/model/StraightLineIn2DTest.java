package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.LinkedHashSet;

public class StraightLineIn2DTest {

    LinkedHashSet<ShapeIn2D> shapesInCanvas = new LinkedHashSet<>();
    CanvasIn2D canvas = new CanvasIn2D(100.0, 100.0, Color.lightGray, shapesInCanvas);
    double x1 = 1.0;
    double y1 = 1.0;
    LogoPointIn2D coordinate1 = new LogoPointIn2D(x1, y1, canvas);
    double x2 = 2.0;
    double y2 = 3.0;
    LogoPointIn2D coordinate2 = new LogoPointIn2D(x2, y2, canvas);
    Color color1 = Color.black;
    StraightLineIn2D line1 = new StraightLineIn2D(coordinate1, coordinate2, color1);
    double x3 = 2.0;
    double y3 = 3.0;
    LogoPointIn2D coordinate3 = new LogoPointIn2D(x3, y3, canvas);
    double x4 = 6.0;
    double y4 = 2.0;
    LogoPointIn2D coordinate4 = new LogoPointIn2D(x4, y4, canvas);
    Color color2 = Color.yellow;
    StraightLineIn2D line2 = new StraightLineIn2D(coordinate3, coordinate4, color2);
    double x5 = 6.0;
    double y5 = 2.0;
    LogoPointIn2D coordinate5 = new LogoPointIn2D(x5, y5, canvas);
    double x6 = 1.0;
    double y6 = 1.0;
    LogoPointIn2D coordinate6 = new LogoPointIn2D(x6, y6, canvas);
    StraightLineIn2D line3 = new StraightLineIn2D(coordinate5, coordinate6);
    double x7 = 33.5;
    double y7 = 44.0;
    LogoPointIn2D coordinate7 = new LogoPointIn2D(x7, y7, canvas);
    double x8 = 5.5;
    double y8 = 14.7;
    LogoPointIn2D coordinate8 = new LogoPointIn2D(x8, y8, canvas);
    Color color3 = Color.green;
    StraightLineIn2D line4 = new StraightLineIn2D(coordinate7, coordinate8, color3);
    LinkedHashSet<StraightLineIn2D> linesInShape1 = new LinkedHashSet<>();
    LinkedHashSet<StraightLineIn2D> linesInShape2 = new LinkedHashSet<>();

    @Test
    public void getCoordinatesTest() {
        ShapeIn2D shape1 = new ShapeIn2D(linesInShape1, Color.cyan, this.canvas);
        LinkedHashSet<StraightLineIn2D> linesForShape1 = new LinkedHashSet<>();
        linesForShape1.add(line1);
        linesForShape1.add(line2);
        linesForShape1.add(line3);
        shape1.addLinesToShape(linesForShape1);
        shape1.setClosed();
        ShapeIn2D shape2 = new ShapeIn2D(linesInShape2, this.canvas);
        LinkedHashSet<StraightLineIn2D> lineForShape2 = new LinkedHashSet<>();
        lineForShape2.add(line4);
        shape2.addLinesToShape(lineForShape2);

//        Assertions.assertSame(line1.getPoints().get(0), coordinate1);
//        Assertions.assertSame(line1.getPoints().get(1), coordinate2);
//        Assertions.assertSame(line2.getPoints().get(0), coordinate3);
//        Assertions.assertSame(line2.getPoints().get(1), coordinate4);
//        Assertions.assertSame(line3.getPoints().get(0), coordinate5);
//        Assertions.assertSame(line3.getPoints().get(1), coordinate6);
    }

    @Test
    public void getLineColorTest() {
        ShapeIn2D shape1 = new ShapeIn2D(linesInShape1, Color.cyan, this.canvas);
        LinkedHashSet<StraightLineIn2D> linesToAdd = new LinkedHashSet<>();
        linesToAdd.add(line1);
        linesToAdd.add(line2);
        linesToAdd.add(line3);
        shape1.addLinesToShape(linesToAdd);
        shape1.setClosed();
        ShapeIn2D shape2 = new ShapeIn2D(linesInShape2, this.canvas);
        LinkedHashSet<StraightLineIn2D> lineToAdd = new LinkedHashSet<>();
        lineToAdd.add(line4);
        shape2.addLinesToShape(lineToAdd);

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
