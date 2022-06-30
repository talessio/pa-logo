package PA.Logo.Model;

import java.awt.*;
import java.util.ArrayList;

public class CanvasIn2D implements Canvas<Double> {
    double height;
    double base;
    ArrayList<Shape> allShapesInCanvas = new ArrayList<>();

    @Override
    public Coordinate getHome() {
        return null;
    }

    @Override
    public Color getCanvasColor() {
        return null;
    }

    @Override
    public void setCanvasColor(Color color) {

    }

    @Override
    public Double getCanvasSize() {
        return null;
    }

    @Override
    public void setCanvasSize() {

    }
}
