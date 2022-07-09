package pa.logo.model;

public class Direction {

    public double clockwise(double currentDegrees, double degreesToIncrement) {
        int x = (int) ((currentDegrees + degreesToIncrement) / 360);
        return ((currentDegrees + degreesToIncrement) - (360 * Math.abs(x)));
    }

    public double counterclockwise(double currentDegrees, double degreesToDecrement) {
        int x = (int) ((currentDegrees - degreesToDecrement) / 360);
        return ((currentDegrees - degreesToDecrement) - (360 * Math.abs(x)));
    }
}
