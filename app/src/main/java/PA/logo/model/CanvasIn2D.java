package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Implements a canvas in two dimensions to draw upon.
 */
public class CanvasIn2D implements Canvas<CoordinateIn2D, StraightLineIn2D, ShapeIn2D> {
    private final double height;
    private final double base;
    private Color canvasColor = Color.white;

    /**
     * Array List of all the shapes that are on the canvas.
     */
    ArrayList<ShapeIn2D> allShapesInCanvas = new ArrayList<>();

    public CanvasIn2D(double height, double base, ArrayList<ShapeIn2D> shapes) {
        this.height = height;
        this.base = base;
        this.allShapesInCanvas = shapes;
    }

    public CanvasIn2D(double height, double base, Color canvasColor, ArrayList<ShapeIn2D> shapes) {
        this.height = height;
        this.base = base;
        this.canvasColor = canvasColor;
        this.allShapesInCanvas = shapes;
    }

    /**
     * Gets the height of the canvas.
     *
     * @return the height of the canvas.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the base of the canvas.
     *
     * @return the base of the canvas.
     */
    public double getBase() {
        return base;
    }

    /**
     * Gets the area of the canvas.
     *
     * @return the area of the canvas.
     */
    public double getCanvasArea() {
        return this.base * this.height;
    }

    @Override
    public void addShapeToCanvas(ShapeIn2D shape) {
        this.allShapesInCanvas.add(shape);
    }

    @Override
    public void removeShapeFromCanvas(ShapeIn2D shape) {
        this.allShapesInCanvas.remove(shape);
    }

    public ShapeIn2D mergeShapes(ShapeIn2D shape1, ShapeIn2D shape2) {
        ShapeIn2D newShape = new ShapeIn2D(shape1.getShapeLines(), shape1.getShapeColor());
        newShape.addLinesToShape(shape2.getShapeLines());
        this.removeShapeFromCanvas(shape1);
        this.removeShapeFromCanvas(shape2);
        this.addShapeToCanvas(newShape);
        return newShape;
    }

    @Override
    public ArrayList<ShapeIn2D> getAllShapesInCanvas() {
        return allShapesInCanvas;
    }

    @Override
    public CoordinateIn2D getHome() {
        return new CoordinateIn2D(base / 2, height / 2);
    }

    @Override
    public Color getCanvasColor() {
        return this.canvasColor;
    }

    @Override
    public void setCanvasColor(Color color) {
        if (color == null) throw new NullPointerException("Color cannot be null");
        this.canvasColor = color;
    }
}
