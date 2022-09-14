package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.LinkedHashSet;

public class CanvasIn2DTest {

    LinkedHashSet<ShapeIn2D> shapesInCanvas = new LinkedHashSet<>();
    CanvasIn2D canvas = new CanvasIn2D(100.0, 100.0, Color.lightGray, shapesInCanvas);
    LinkedHashSet<StraightLineIn2D> linesInShape1 = new LinkedHashSet<>();
    LinkedHashSet<StraightLineIn2D> linesInShape2 = new LinkedHashSet<>();
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
    //    double x5 = 6.0;
//    double y5 = 2.0;
//    LogoPointIn2D coordinate5 = new LogoPointIn2D(x5, y5);
//    double x6 = 1.5;
//    double y6 = 1.5;
//    LogoPointIn2D coordinate6 = new LogoPointIn2D(x6, y6);
//    StraightLineIn2D line3 = new StraightLineIn2D(coordinate5, coordinate6);
    double x7 = 33.5;
    double y7 = 44.0;
    LogoPointIn2D coordinate7 = new LogoPointIn2D(x7, y7, canvas);
    double x8 = 5.5;
    double y8 = 14.7;
    LogoPointIn2D coordinate8 = new LogoPointIn2D(x8, y8, canvas);
    StraightLineIn2D line4 = new StraightLineIn2D(coordinate7, coordinate8, Color.green);
    double x9 = 6.0;
    double y9 = 2.0;
    LogoPointIn2D coordinate9 = new LogoPointIn2D(x9, y9, canvas);
    double x10 = 33.5;
    double y10 = 44.0;
    LogoPointIn2D coordinate10 = new LogoPointIn2D(x10, y10, canvas);
    StraightLineIn2D line5 = new StraightLineIn2D(coordinate9, coordinate10, Color.green);
    ShapeIn2D shape1 = new ShapeIn2D(linesInShape1, Color.cyan);
    ShapeIn2D shape2 = new ShapeIn2D(linesInShape2);


    @Test
    public void Test() {
        LinkedHashSet<StraightLineIn2D> linesForShape1 = new LinkedHashSet<>();
        LinkedHashSet<StraightLineIn2D> linesForShape2 = new LinkedHashSet<>();
        linesForShape1.add(line1);
        linesForShape1.add(line2);
        linesForShape2.add(line4);
        linesForShape2.add(line5);
        this.shape1.addLinesToShape(linesForShape1);
        this.shape2.addLinesToShape(linesForShape2);
        canvas.addShapeToCanvas(shape1);
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(shape1));
        Assertions.assertFalse(canvas.getAllShapesInCanvas().contains(shape2));
        canvas.addShapeToCanvas(shape2);
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(shape2));
        canvas.removeShapeFromCanvas(shape1);
        Assertions.assertFalse(canvas.getAllShapesInCanvas().contains(shape1));
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(shape2));
        canvas.addShapeToCanvas(shape1);
        ShapeIn2D newShape = canvas.mergeShapes(shape1, shape2, Color.yellow);
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(newShape));
        Assertions.assertFalse(canvas.getAllShapesInCanvas().contains(shape1));
        Assertions.assertFalse(canvas.getAllShapesInCanvas().contains(shape2));
    }
}
