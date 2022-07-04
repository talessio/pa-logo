package pa.logo.model;

public class CoordinateIn2D implements Coordinate {
    private double x;
    private double y;

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
