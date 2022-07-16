package pa.logo.model;

public class CoordinateIn2D implements Coordinate {

    private double x;
    private double y;

    /**
     * Implements the coordinate in two dimensions.
     *
     * @param coordinate1 the x coordinate;
     * @param coordinate2 the y coordinate;
     */
    public CoordinateIn2D(double coordinate1, double coordinate2) {
        this.x = coordinate1;
        this.y = coordinate2;
    }

    /**
     * Gets the x value of the coordinate.
     *
     * @return the x value.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets the y value of the coordinate.
     *
     * @return the y value.
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets the x value of the coordinate.
     *
     * @param x the x value.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the y value of the coordinate.
     *
     * @param y the y value.
     */
    public void setY(double y) {
        this.y = y;
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
