package PA.logo.model;

public class CoordinateIn2D implements Coordinate {
    double x;
    double y;

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
