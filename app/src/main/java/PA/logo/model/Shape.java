package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * A shape of any kind, color or form. Can be open or closed, can have any number of dimensions.
 *
 * @param <C> the coordinate(s).
 * @param <L> the line(s).
 */
public interface Shape<C extends Coordinate, L extends Line<C>> {

    /**
     * Adds a line to the shape.
     *
     * @param lineToAdd the line to be added.
     */
    void addLineToShape(L lineToAdd);

    /**
     * Adds a number of lines to the shape.
     *
     * @param linesToAdd the lines to be added.
     */
    void addLinesToShape(ArrayList<L> linesToAdd);

    /**
     * Get the lines contained in the shape.
     *
     * @return an ArrayList with all the lines in the shape.
     */
    ArrayList<L> getShapeLines();

    /**
     * Get the color of the shape.
     *
     * @return the color of the shape.
     */
    Color getShapeColor();

    /**
     * Set the color of the shape.
     *
     * @param color the chosen color in RGB.
     */
    void setShapeColor(Color color);

    /**
     * Checks if the shape is closed or not.
     *
     * @return true if the shape is closed, false otherwise.
     */
    boolean isClosed();

    /**
     * Sets shape as closed, such that it cannot join other shapes.
     */
    void setClosed();
}
