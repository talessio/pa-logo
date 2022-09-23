package pa.logo.model;

/**
 * Class that handles direction for the cursor.
 */
public class DirectionIn2D implements Direction<Integer> {

    @Override
    public Integer clockwise(Integer currentDegrees, Integer degreesToIncrement) {
        int x = (currentDegrees - degreesToIncrement) / 360;
        int ret = ((currentDegrees - degreesToIncrement) + (360 * Math.abs(x)));
        if (ret < 0) {
            ret += 360;
        }
        return ret;
    }

    @Override
    public Integer counterclockwise(Integer currentDegrees, Integer degreesToDecrement) {
        int x = (currentDegrees + degreesToDecrement) / 360;
        int ret = ((currentDegrees + degreesToDecrement) - (360 * Math.abs(x)));
        if (ret < 0) {
            ret += 360;
        }
        return ret;
    }
}
