package pa.logo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedHashSet;

public class CursorIn2DTest {
    @Test
    public void Test() {
        LinkedHashSet<ShapeIn2D> shapes = new LinkedHashSet<>();
        CanvasIn2D c = new CanvasIn2D(100, 100, shapes);
        Assertions.assertTrue(c.getCursor().getPenColor() == Color.black);
        c.getCursor().setPenColor(Color.blue);
        Assertions.assertTrue(c.getCursor().getPenColor() == Color.blue);
        LogoPointIn2D mockHome = new LogoPointIn2D(50.0, 50.0, c);
        Assertions.assertEquals(c.getHome().getX(), mockHome.getX());
        Assertions.assertEquals(c.getHome().getY(), mockHome.getY());
        Assertions.assertTrue(c.getCursor().getCurrentDirection() == 0);
        c.getCursor().left(90);
        Assertions.assertTrue(c.getCursor().getCurrentDirection() == 90);
        c.getCursor().right(180);
        Assertions.assertTrue(c.getCursor().getCurrentDirection() == 270);
        c.getCursor().left(270);
        Assertions.assertTrue(c.getCursor().getCurrentDirection() == 180);
        c.getCursor().forward(10.0);
        Assertions.assertTrue(c.getCursor().getCurrentPosition().getX() == 40);
        Assertions.assertTrue(c.getCursor().getCurrentPosition().getY() == 50);
        c.getCursor().left(80);
        c.getCursor().backward(20.0);
        Assertions.assertTrue(c.getCursor().getCurrentPosition().getX() == 60);
        Assertions.assertTrue(c.getCursor().getCurrentPosition().getY() == 70);
        c.getCursor().forward(200.0);
        Assertions.assertEquals(c.getCursor().getCurrentPosition().getX(), 0.0);
        Assertions.assertEquals(c.getCursor().getCurrentPosition().getY(), 0.0);
        c.getCursor().right(260);
        c.getCursor().forward(200.0);
        Assertions.assertEquals(c.getCursor().getCurrentPosition().getX(), c.getBase());
        Assertions.assertEquals(c.getCursor().getCurrentPosition().getY(), 0.0);
    }
}
