package pa.logo.model;

import pa.logo.LegalityChecker;

import java.awt.geom.Point2D;

/**
 * A point in a canvas with an x and y coordinate.
 */
public class LogoPointIn2D extends Point2D {

    private double x;
    private double y;
    private CanvasIn2D canvas;

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public CanvasIn2D getCanvas() {
        return canvas;
    }

    public void setCanvas(CanvasIn2D canvas) {
        this.canvas = canvas;
    }

    /**
     * Implements the coordinate in two dimensions inside a canvas.
     *
     * @param coordinate1 the x coordinate;
     * @param coordinate2 the y coordinate;
     * @param canvas      the canvas where the coordinate is located;
     */
    public LogoPointIn2D(double coordinate1, double coordinate2, CanvasIn2D canvas) {
        LegalityChecker check = new LegalityChecker();
        if (check.coordinatesAreLegal(coordinate1, coordinate2, canvas)) {
            this.canvas = canvas;
            this.x = coordinate1;
            this.y = coordinate2;
        }
    }

    /**
     * Increases the x value by the specified amount.
     *
     * @param value the amount.
     */
    public void increaseXBy(double value) {
        this.x += value;
    }

    /**
     * Increases the y value by the specified amount.
     *
     * @param value the amount.
     */
    public void increaseYBy(double value) {
        this.y += value;
    }

    /**
     * Decreases the x value by the specified amount.
     *
     * @param value the amount
     */
    public void decreaseXBy(double value) {
        this.x -= value;
    }

    /**
     * Decreases the y value by the specified amount.
     *
     * @param value the amount
     */
    public void decreaseYBy(double value) {
        this.y -= value;
    }
}
