package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

public class CanvasIn2D implements Canvas<Double, CoordinateIn2D, StraightLineIn2D, ShapeIn2D> {
    double height;
    double base;
    /**
     * Array List of all the shapes that are on the canvas.
     * Shapes can be of any type: single lines, a concatenation of lines, straight or curved lines, coloured or not, closed or not.
     */
    ArrayList<ShapeIn2D> allShapesInCanvas = new ArrayList<>();


    @Override
    public ArrayList<ShapeIn2D> getAllShapesInCanvas() {
        return null;
    }

    @Override
    public CoordinateIn2D getHome() {
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
