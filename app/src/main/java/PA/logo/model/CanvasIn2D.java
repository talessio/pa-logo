package pa.logo.model;

import pa.logo.LegalityChecker;

import java.awt.*;
import java.util.LinkedHashSet;

/**
 * Implements a canvas in two dimensions to draw upon.
 */
public class CanvasIn2D implements Canvas<LogoPointIn2D, StraightLineIn2D, ShapeIn2D> {
    private final double height;
    private final double base;
    private Color canvasColor = Color.white;
    private final CursorIn2D cursor;

    /**
     * Linked Hash Set of all the shapes located on the canvas.
     */
    LinkedHashSet<ShapeIn2D> allShapesInCanvas;

    public CanvasIn2D(double height, double base, LinkedHashSet<ShapeIn2D> shapes) {
        if (height == 0.0 || base == 0.0)
            throw new IllegalArgumentException("Height or base have to be bigger than 0.0");
        this.height = height;
        this.base = base;
        this.allShapesInCanvas = shapes;
        this.cursor = new CursorIn2D(this);
    }

    public CanvasIn2D(double height, double base, Color canvasColor, LinkedHashSet<ShapeIn2D> shapes) {
        if (height == 0.0 || base == 0.0)
            throw new IllegalArgumentException("Height or base have to be bigger than 0.0");
        this.height = height;
        this.base = base;
        this.canvasColor = canvasColor;
        this.allShapesInCanvas = shapes;
        this.cursor = new CursorIn2D(this);
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
     * @return the new shape in 2D that merges shape 1 and 2.
     */
    public ShapeIn2D mergeShapes(ShapeIn2D shape1, ShapeIn2D shape2) throws NullPointerException, IllegalArgumentException {
        if (shape1 == null || shape2 == null) {
            throw new NullPointerException();
        }
        LinkedHashSet<StraightLineIn2D> newSet = new LinkedHashSet<>();
        for (StraightLineIn2D l : shape1.getShapeLines()) {
            newSet.add(l);
        }
        for (StraightLineIn2D l : shape2.getShapeLines()) {
            newSet.add(l);
        }
        LegalityChecker checker = new LegalityChecker();
        if (checker.shapeIsLegal(newSet)) {
            ShapeIn2D newShape = new ShapeIn2D(newSet, this);
            this.addShapeToCanvas(newShape);
            this.removeShapeFromCanvas(shape1);
            this.removeShapeFromCanvas(shape2);
            return newShape;
        } else {
            throw new IllegalArgumentException("Impossible to merge the two shapes.");
        }
    }

    public CursorIn2D getCursor() {
        return cursor;
    }

    @Override
    public void addShapeToCanvas(ShapeIn2D shape) {
        if (shape == null) throw new NullPointerException();
        else this.allShapesInCanvas.add(shape);
    }

    @Override
    public void removeShapeFromCanvas(ShapeIn2D shape) {
        if (shape == null) throw new NullPointerException();
        this.allShapesInCanvas.remove(shape);
    }

    @Override
    public LinkedHashSet<ShapeIn2D> getAllShapesInCanvas() {
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
    public LogoPointIn2D getHome() {
        return new LogoPointIn2D(base / 2, height / 2, this);
    }
}
