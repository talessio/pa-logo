package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

public class CanvasIn2DTest {
    ArrayList<StraightLineIn2D> linesInShape1 = new ArrayList<>();
    ArrayList<StraightLineIn2D> linesInShape2 = new ArrayList<>();
    double x1 = 1.0;
    double y1 = 1.0;
    CoordinateIn2D coordinate1 = new CoordinateIn2D(x1, y1);
    double x2 = 2.0;
    double y2 = 3.0;
    CoordinateIn2D coordinate2 = new CoordinateIn2D(x2, y2);
    StraightLineIn2D line1 = new StraightLineIn2D(coordinate1, coordinate2, Color.pink);
    double x3 = 2.0;
    double y3 = 3.0;
    CoordinateIn2D coordinate3 = new CoordinateIn2D(x3, y3);
    double x4 = 6.0;
    double y4 = 2.0;
    CoordinateIn2D coordinate4 = new CoordinateIn2D(x4, y4);
    StraightLineIn2D line2 = new StraightLineIn2D(coordinate3, coordinate4, Color.yellow);
    //    double x5 = 6.0;
//    double y5 = 2.0;
//    CoordinateIn2D coordinate5 = new CoordinateIn2D(x5, y5);
//    double x6 = 1.5;
//    double y6 = 1.5;
//    CoordinateIn2D coordinate6 = new CoordinateIn2D(x6, y6);
//    StraightLineIn2D line3 = new StraightLineIn2D(coordinate5, coordinate6);
    double x7 = 33.5;
    double y7 = 44.0;
    CoordinateIn2D coordinate7 = new CoordinateIn2D(x7, y7);
    double x8 = 5.5;
    double y8 = 14.7;
    CoordinateIn2D coordinate8 = new CoordinateIn2D(x8, y8);
    StraightLineIn2D line4 = new StraightLineIn2D(coordinate7, coordinate8, Color.green);
    double x9 = 6.0;
    double y9 = 2.0;
    CoordinateIn2D coordinate9 = new CoordinateIn2D(x9, y9);
    double x10 = 33.5;
    double y10 = 44.0;
    CoordinateIn2D coordinate10 = new CoordinateIn2D(x10, y10);
    StraightLineIn2D line5 = new StraightLineIn2D(coordinate9, coordinate10, Color.green);
    ShapeIn2D shape1 = new ShapeIn2D(linesInShape1, Color.cyan);
    ShapeIn2D shape2 = new ShapeIn2D(linesInShape2);
    ArrayList<ShapeIn2D> shapesInCanvas = new ArrayList<>();
    CanvasIn2D canvas = new CanvasIn2D(100.0, 100.0, Color.lightGray, shapesInCanvas);

    @Test
    public void Test() {
        this.shape1.addLineToShape(line1);
        this.shape1.addLineToShape(line2);
        this.shape2.addLineToShape(line4);
        this.shape2.addLineToShape(line5);
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
