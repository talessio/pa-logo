package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

//TODO: add javadoc
public class CanvasIn2D implements Canvas<Double, CoordinateIn2D, StraightLineIn2D, ShapeIn2D> {
    double height;
    double base;

    /**
     * Array List of all the shapes that are on the canvas.
     * Shapes can be of any type: single lines, a concatenation of lines, straight or curved lines, coloured or not, closed or not.
     */
    ArrayList<ShapeIn2D> allShapesInCanvas = new ArrayList<>();

    //TODO
    public void mergeShapes(ShapeIn2D shape1, ShapeIn2D shape2) { //check if void ok

    }

    //TODO
    @Override
    public ArrayList<ShapeIn2D> getAllShapesInCanvas() {
        return null;
    }

    //TODO
    @Override
    public CoordinateIn2D getHome() {
        return null;
    }

    //TODO
    @Override
    public Color getCanvasColor() {
        return null;
    }

    //TODO
    @Override
    public void setCanvasColor(Color color) {
    }

    //TODO
    @Override
    public Double getCanvasSize() {
        return null;
    }

    //TODO
    @Override
    public void setCanvasSize() {

    }
}
