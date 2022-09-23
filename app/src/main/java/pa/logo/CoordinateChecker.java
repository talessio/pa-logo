package pa.logo;

import pa.logo.model.CanvasIn2D;

/**
 * Checks legality of coordinate.
 */
public class CoordinateChecker implements LegalityChecker<Double> {

    private double height;
    private double base;

    /**
     * Checks that the given coordinate is legal.
     * Must set canvas base and height first.
     *
     * @param coordinate the coordinate.
     * @return true if it is, false otherwise.
     */
    @Override
    public boolean isLegal(Double coordinate) {
        return withinCanvasLimits(coordinate);
    }

    /**
     * Sets the height and base sizes that must be equal to the canvas size. Use to compare against.
     *
     * @param h the canvas height size.
     * @param b the canvas base size.
     */
    public void setComparisonSizes(double h, double b) {
        this.height = h;
        this.base = b;
    }

    /**
     * Checks that the coordinates are within the limits of the canvas.
     *
     * @param c the coordinate.
     * @return true if the coordinates are within the limits of the canvas, false otherwise.
     */
    private boolean withinCanvasLimits(double c) {
        if (c > this.base || c > this.height || c < 0.0) {
            return false;
        }
        return true;
    }
}
