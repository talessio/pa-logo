package pa.logo.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * A line. Can be any length, shape or color.
 *
 * @param <P> the points containing the coordinates of the line. can be 2D, 3D or more.
 */
public interface Line<P extends Point2D> {

    /**
     * Gets the points of the line.
     *
     * @return an ArrayList with the points.
     */
    ArrayList<P> getPoints();

    /**
     * Gets the color of the line.
     *
     * @return the color of the line.
     */
    Color getColor();

    /**
     * Sets the color of the line.
     *
     * @param color the color.
     */
    void setColor(Color color);
}
