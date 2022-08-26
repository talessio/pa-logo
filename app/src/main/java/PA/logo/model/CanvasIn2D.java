package pa.logo.model;

import pa.logo.LegalityChecker;

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
        if (height == 0.0 || base == 0.0)
            throw new IllegalArgumentException("Height or base have to be bigger than 0.0");
        this.height = height;
        this.base = base;
        this.allShapesInCanvas = shapes;
    }

    public CanvasIn2D(double height, double base, Color canvasColor, ArrayList<ShapeIn2D> shapes) {
        if (height == 0.0 || base == 0.0)
            throw new IllegalArgumentException("Height or base have to be bigger than 0.0");
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

    /**
     * Merges two shapes into one.
     *
     * @param shape1 the first shape.
     * @param shape2 the second shape.
     * @param color  the new fill color for the merged shape.
     * @return the new shape.
     */
    public ShapeIn2D mergeShapes(ShapeIn2D shape1, ShapeIn2D shape2, Color color) throws NullPointerException, IllegalArgumentException {
        if (shape1 == null || shape2 == null || color == null) {
            throw new NullPointerException();
        }
        ShapeIn2D newShape = new ShapeIn2D(shape1.getShapeLines(), color);
        newShape.addLinesToShape(shape2.getShapeLines());
        LegalityChecker checker = new LegalityChecker();
        if (checker.shapeIsLegal(newShape.getShapeLines())) {
            this.removeShapeFromCanvas(shape1);
            this.removeShapeFromCanvas(shape2);
            this.addShapeToCanvas(newShape);
            return newShape;
        } else {
            throw new IllegalArgumentException("Impossible to merge the two shapes.");
        }
    }

    @Override
    public void addShapeToCanvas(ShapeIn2D shape) {
        if (shape == null) throw new NullPointerException();
        this.allShapesInCanvas.add(shape);
    }

    @Override
    public void removeShapeFromCanvas(ShapeIn2D shape) {
        if (shape == null) throw new NullPointerException();
        this.allShapesInCanvas.remove(shape);
    }

    @Override
    public ArrayList<ShapeIn2D> getAllShapesInCanvas() {
        return allShapesInCanvas;
    }

    @Override
    public Color getCanvasColor() {
        return this.canvasColor;
    }

    @Override
    public void setCanvasColor(Color color) throws NullPointerException {
        if (color == null) throw new NullPointerException("Color cannot be null");
        this.canvasColor = color;
    }

    /**
     * Returns the coordinates for the home.
     *
     * @return the coordinates for the home.
     */
    public CoordinateIn2D getHome() {
        return new CoordinateIn2D(base / 2, height / 2, this);
    }
}
