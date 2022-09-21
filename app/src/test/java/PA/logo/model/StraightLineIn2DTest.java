package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedHashSet;

public class StraightLineIn2DTest {

    LinkedHashSet<ShapeIn2D> shapesInCanvas = new LinkedHashSet<>();
    CanvasIn2D canvas = new CanvasIn2D(100.0, 100.0, Color.lightGray, shapesInCanvas);
    LogoPointIn2D coordinate1 = new LogoPointIn2D(1.0, 1.0, canvas);
    LogoPointIn2D coordinate2 = new LogoPointIn2D(2.0, 3.0, canvas);
    StraightLineIn2D line1 = new StraightLineIn2D(coordinate1, coordinate2, Color.black);
    LogoPointIn2D coordinate3 = new LogoPointIn2D(2.0, 3.0, canvas);
    LogoPointIn2D coordinate4 = new LogoPointIn2D(6.0, 2.0, canvas);
    StraightLineIn2D line2 = new StraightLineIn2D(coordinate3, coordinate4, Color.yellow);
    LogoPointIn2D coordinate5 = new LogoPointIn2D(6.0, 2.0, canvas);
    LogoPointIn2D coordinate6 = new LogoPointIn2D(1.0, 1.0, canvas);
    StraightLineIn2D line3 = new StraightLineIn2D(coordinate5, coordinate6);
    LogoPointIn2D coordinate7 = new LogoPointIn2D(33.5, 44.0, canvas);
    LogoPointIn2D coordinate8 = new LogoPointIn2D(5.5, 14.7, canvas);
    StraightLineIn2D line4 = new StraightLineIn2D(coordinate7, coordinate8, Color.green);

    @Test
    public void getPointsTest() {
        LinkedHashSet<StraightLineIn2D> linesForShape1 = new LinkedHashSet<>();
        linesForShape1.add(line1);
        linesForShape1.add(line2);
        linesForShape1.add(line3);
        ShapeIn2D shape1 = new ShapeIn2D(linesForShape1, this.canvas, Color.cyan); // shape non risulta chiusa
        LinkedHashSet<StraightLineIn2D> lineForShape2 = new LinkedHashSet<>();
        lineForShape2.add(line4);
        ShapeIn2D shape2 = new ShapeIn2D(lineForShape2, this.canvas);

        Assertions.assertSame(line1.getPoints().get(0), coordinate1);
        Assertions.assertSame(line1.getPoints().get(1), coordinate2);
        Assertions.assertSame(line2.getPoints().get(0), coordinate3);
        Assertions.assertSame(line2.getPoints().get(1), coordinate4);
        Assertions.assertSame(line3.getPoints().get(0), coordinate5);
        Assertions.assertSame(line3.getPoints().get(1), coordinate6);
    }

    @Test
    public void getLineColorTest() {
        LinkedHashSet<StraightLineIn2D> linesForShape1 = new LinkedHashSet<>();
        linesForShape1.add(line1);
        linesForShape1.add(line2);
        linesForShape1.add(line3);
        ShapeIn2D shape1 = new ShapeIn2D(linesForShape1, this.canvas, Color.cyan);
        LinkedHashSet<StraightLineIn2D> lineForShape2 = new LinkedHashSet<>();
        lineForShape2.add(line4);
        ShapeIn2D shape2 = new ShapeIn2D(lineForShape2, this.canvas);

//        LinkedHashSet<StraightLineIn2D> linesToAdd = new LinkedHashSet<>();
//        linesToAdd.add(line1);
//        linesToAdd.add(line2);
//        linesToAdd.add(line3);
//        shape1.addLinesToShape(linesToAdd);
//        LinkedHashSet<StraightLineIn2D> lineToAdd = new LinkedHashSet<>();
//        lineToAdd.add(line4);
//        shape2.addLinesToShape(lineToAdd);

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
