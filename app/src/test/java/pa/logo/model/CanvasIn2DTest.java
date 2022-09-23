package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class CanvasIn2DTest {

    ArrayList<ShapeIn2D> shapesInCanvas = new ArrayList<>();
    CanvasIn2D canvas = new CanvasIn2D(100.0, 100.0, Color.lightGray, shapesInCanvas);
    LogoPointIn2D point1 = new LogoPointIn2D(1.0, 1.0, canvas);
    LogoPointIn2D point2 = new LogoPointIn2D(2.0, 3.0, canvas);
    LogoPointIn2D point3 = new LogoPointIn2D(6.0, 2.0, canvas);
    LogoPointIn2D point4 = new LogoPointIn2D(33.5, 44.0, canvas);
    LogoPointIn2D point5 = new LogoPointIn2D(5.5, 14.7, canvas);
    StraightLineIn2D line1 = new StraightLineIn2D(point1, point2, Color.pink);
    StraightLineIn2D line2 = new StraightLineIn2D(point2, point3, Color.yellow);
    StraightLineIn2D line3 = new StraightLineIn2D(point3, point4, Color.green);
    StraightLineIn2D line4 = new StraightLineIn2D(point4, point5, Color.green);

    @Test
    public void Test() {
        LinkedHashSet<StraightLineIn2D> linesForShape1 = new LinkedHashSet<>();
        linesForShape1.add(line1);
        ShapeIn2D shape1 = new ShapeIn2D(linesForShape1, this.canvas);
        Assertions.assertFalse(shape1.isClosed());
        Assertions.assertNull(shape1.getShapeColor());
        LinkedHashSet<StraightLineIn2D> moreLinesForShape1 = new LinkedHashSet<>();
        moreLinesForShape1.add(line2);
        shape1.addLinesToShape(moreLinesForShape1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> shape1.setShapeColor(Color.cyan));
        LinkedHashSet<StraightLineIn2D> linesForShape2 = new LinkedHashSet<>();
        linesForShape2.add(line3);
        linesForShape2.add(line4);
        Assertions.assertEquals(1, canvas.getAllShapesInCanvas().size());
        ShapeIn2D shape2 = new ShapeIn2D(linesForShape2, this.canvas);
        Assertions.assertEquals(2, canvas.getAllShapesInCanvas().size());
        Assertions.assertEquals(shape1, canvas.allShapesInCanvas.stream().filter(x -> x.equals(shape1)).toList().get(0));
        Assertions.assertEquals(shape2, canvas.allShapesInCanvas.stream().filter(x -> x.equals(shape2)).toList().get(0));
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(shape2));
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(shape1));
        ShapeIn2D newShape = canvas.mergeShapes(shape1, shape2);
        StraightLineIn2D closingLine = new StraightLineIn2D(point5, point1);
        LinkedHashSet<StraightLineIn2D> closingLHS = new LinkedHashSet<>();
        closingLHS.add(closingLine);
        newShape.addLinesToShape(closingLHS);
        newShape.setShapeColor(Color.yellow);
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(newShape));
        Assertions.assertFalse(canvas.getAllShapesInCanvas().contains(shape1));
        Assertions.assertFalse(canvas.getAllShapesInCanvas().contains(shape2));
        System.out.println(canvas.allShapesInCanvas.stream().filter(x -> x.equals(newShape)).toList().get(0).toString());
        Assertions.assertEquals(1, canvas.getAllShapesInCanvas().size()); //shape1 is not being deleted?
    }
}
