package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * A line. Can be any length, shape or color.
 *
 * @param <C> the coordinate(s) of the shape.
 */
public interface Line<C extends Coordinate> {

    /**
     * Gets the coordinates of the line.
     *
     * @return an ArrayList with the coordinates.
     */
    ArrayList<C> getCoordinates();

    /**
     * Gets the color of the line.
     *
     * @return the color of the line.
     */
    Color getLineColor();
}
