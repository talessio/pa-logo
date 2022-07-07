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

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
