package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.LinkedHashSet;

public class CursorIn2DTest {
    @Test
    public void Test() {

        LinkedHashSet<ShapeIn2D> shapes = new LinkedHashSet<>();
        CanvasIn2D canvas = new CanvasIn2D(100, 100, shapes);
        CursorIn2D cursor = new CursorIn2D(canvas);

        Assertions.assertTrue(cursor.getPenColor() == Color.black);
        cursor.setPenColor(Color.blue);
        Assertions.assertTrue(cursor.getPenColor() == Color.blue);
        LogoPointIn2D mockHome = new LogoPointIn2D(50.0, 50.0, canvas);
        Assertions.assertEquals(canvas.getHome().getX(), mockHome.getX());
        Assertions.assertEquals(canvas.getHome().getY(), mockHome.getY());
        Assertions.assertTrue(cursor.getCurrentDirection() == 0);
        cursor.left(90);
        Assertions.assertTrue(cursor.getCurrentDirection() == 90);
        cursor.right(180);
        Assertions.assertTrue(cursor.getCurrentDirection() == 270);
        cursor.left(270);
        Assertions.assertTrue(cursor.getCurrentDirection() == 180);
        cursor.forward(10.0);
        Assertions.assertTrue(cursor.getCurrentPosition().getX() == 40);
        Assertions.assertTrue(cursor.getCurrentPosition().getY() == 50);
        cursor.left(80);
        cursor.backward(20.0);
        Assertions.assertTrue(cursor.getCurrentPosition().getX() == 60);
        Assertions.assertTrue(cursor.getCurrentPosition().getY() == 70);
        cursor.forward(200.0);
        Assertions.assertEquals(cursor.getCurrentPosition().getX(), 0.0);
        Assertions.assertEquals(cursor.getCurrentPosition().getY(), 0.0);
        cursor.right(260);
        cursor.forward(200.0);
        Assertions.assertEquals(cursor.getCurrentPosition().getX(), canvas.getBase());
        Assertions.assertEquals(cursor.getCurrentPosition().getY(), 0.0);
    }
}
