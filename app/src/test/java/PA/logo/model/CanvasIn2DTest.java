package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedHashSet;

public class CanvasIn2DTest {

    LinkedHashSet<ShapeIn2D> shapesInCanvas = new LinkedHashSet<>();
    CanvasIn2D canvas = new CanvasIn2D(100.0, 100.0, Color.lightGray, shapesInCanvas);
    LogoPointIn2D coordinate1 = new LogoPointIn2D(1.0, 1.0, canvas);
    LogoPointIn2D coordinate2 = new LogoPointIn2D(2.0, 3.0, canvas);
    StraightLineIn2D line1 = new StraightLineIn2D(coordinate1, coordinate2, Color.pink);
    LogoPointIn2D coordinate3 = new LogoPointIn2D(2.0, 3.0, canvas);
    LogoPointIn2D coordinate4 = new LogoPointIn2D(6.0, 2.0, canvas);
    StraightLineIn2D line2 = new StraightLineIn2D(coordinate3, coordinate4, Color.yellow);
    LogoPointIn2D coordinate5 = new LogoPointIn2D(6.0, 2.0, canvas);
    LogoPointIn2D coordinate6 = new LogoPointIn2D(33.5, 44.0, canvas);
    StraightLineIn2D line3 = new StraightLineIn2D(coordinate5, coordinate6, Color.green);
    LogoPointIn2D coordinate7 = new LogoPointIn2D(33.5, 44.0, canvas);
    LogoPointIn2D coordinate8 = new LogoPointIn2D(5.5, 14.7, canvas);
    StraightLineIn2D line4 = new StraightLineIn2D(coordinate7, coordinate8, Color.green);
//    LinkedHashSet<StraightLineIn2D> linesInShape1 = new LinkedHashSet<>();
//    LinkedHashSet<StraightLineIn2D> linesInShape2 = new LinkedHashSet<>();

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
        Assertions.assertEquals(canvas.getAllShapesInCanvas().size(), 1);
        ShapeIn2D shape2 = new ShapeIn2D(linesForShape2, this.canvas);
        Assertions.assertEquals(canvas.getAllShapesInCanvas().size(), 2);
        System.out.println(canvas.allShapesInCanvas.stream().filter(x -> x.equals(shape1)).toList().get(0).toString());
        Assertions.assertEquals(canvas.allShapesInCanvas.stream().filter(x -> x.equals(shape1)).toList().get(0).toString(), shape1.toString());
        System.out.println(canvas.allShapesInCanvas.stream().filter(x -> x.equals(shape2)).toList().get(0).toString());
        Assertions.assertEquals(canvas.allShapesInCanvas.stream().filter(x -> x.equals(shape2)).toList().get(0).toString(), shape2.toString());
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(shape1)); //solo questo da errore, wtf
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(shape2));
        canvas.removeShapeFromCanvas(shape1);
        Assertions.assertFalse(canvas.getAllShapesInCanvas().contains(shape1));
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(shape2));
        ShapeIn2D newShape = canvas.mergeShapes(shape1, shape2, Color.yellow);
        Assertions.assertTrue(canvas.getAllShapesInCanvas().contains(newShape));
        Assertions.assertFalse(canvas.getAllShapesInCanvas().contains(shape1));
        Assertions.assertFalse(canvas.getAllShapesInCanvas().contains(shape2));
        System.out.println(canvas.allShapesInCanvas.stream().filter(x -> x.equals(newShape)).toList().get(0).toString());
    }
}
